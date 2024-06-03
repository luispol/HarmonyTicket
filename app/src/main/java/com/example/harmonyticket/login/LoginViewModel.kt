package com.example.harmonyticket.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harmonyticket.DashBoardActivity
import com.example.harmonyticket.login.domain.LoginUseCase
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class LoginViewModel(val context: Context): ViewModel() {

    val dataStore = StoreToken(context)

    val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password:LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable:LiveData<Boolean> = _isLoginEnable

    private val _isRegisterVisible = MutableLiveData<Boolean>()
    val isRegisterVisible:LiveData<Boolean> = _isRegisterVisible

    private val _userName = MutableLiveData<String>()
    val userName:LiveData<String> = _userName

    private val _passwordUser = MutableLiveData<String>()
    val passwordUser:LiveData<String> = _passwordUser

    private val _names = MutableLiveData<String>()
    val names :LiveData<String> = _names

    private val _lastnames = MutableLiveData<String>()
    val lastnames :LiveData<String> = _lastnames

    private val _image = MutableLiveData<Int>()
    val image:LiveData<Int> = _image

    private val _imageUri = MutableLiveData<Uri>()
    val imageUri:LiveData<Uri> = _imageUri

    fun onRegisterChanged(
        userName:String,
        passwordUser:String,
        names:String,
        lastName:String){

        _userName.value = userName
        _passwordUser.value = passwordUser
        _names.value = names
        _lastnames.value = lastName
    }

    fun onRegisterVisible(value:Boolean){
        _isRegisterVisible.value = value
    }

    fun onLoginChanged(email:String,password:String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email,password)
    }

    private fun enableLogin(email: String, password: String):Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length>=6
    }

    fun checkLogin(){
        viewModelScope.launch {
           val result = loginUseCase(_email.value!!, _password.value!!)
            if (result.success){
                dataStore.saveToken(result.token)

                context.startActivity(Intent(context,DashBoardActivity::class.java))
                (context as Activity).finish()
            } else {
                Toast.makeText(
                    context,
                    result.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun setImageUri(uri: Uri) {
        _imageUri.value = uri
    }

    fun registerUser(){
        viewModelScope.launch {
//            val result = loginUseCase.register(
//                _userName.value!!,
//                _passwordUser.value!!,
//                _names.value!!,
//                _lastnames.value!!)

            val userNamePart = _userName.value!!.toRequestBody("text/plain".toMediaTypeOrNull())
            val userPassPart = _passwordUser.value!!.toRequestBody("text/plain".toMediaTypeOrNull())
            val namePart = _names.value!!.toRequestBody("text/plain".toMediaTypeOrNull())
            val lastNamePart = _lastnames.value!!.toRequestBody("text/plain".toMediaTypeOrNull())

            val result = if (_imageUri.value?.path?.isNotEmpty() == true)  {

                val path = "${context.externalCacheDir}/${_imageUri.value!!.pathSegments[1]}"
                val file = File(path)
                val photo:MultipartBody.Part = MultipartBody.Part.createFormData(
                    "photo",
                    file.name,
                    file.asRequestBody("image/jpeg".toMediaTypeOrNull())
                )
                loginUseCase.register(userNamePart, userPassPart, namePart, lastNamePart, photo)
            } else {
                loginUseCase.register(userNamePart, userPassPart, namePart, lastNamePart)
            }

            if (result.success){
                Toast.makeText(
                    context,
                    result.msg,
                    Toast.LENGTH_LONG).show()
                onRegisterVisible(false)
            } else {
                Toast.makeText(
                    context,
                    result.msg,
                    Toast.LENGTH_LONG).show()
            }

        }
    }


}