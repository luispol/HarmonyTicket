package com.example.harmonyticket.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harmonyticket.DashBoardActivity

class LoginViewModel(val context: Context): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password:LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable:LiveData<Boolean> = _isLoginEnable

    fun onLoginChanged(email:String,password:String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email,password)
    }

    private fun enableLogin(email: String, password: String):Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length>=6
    }

    fun checkLogin(){
        if (_email.value == "hi@gmail.com" && _password.value == "123456"){
            context.startActivity(Intent(context,DashBoardActivity::class.java))
            (context as Activity).finish()
        } else {
            Toast.makeText(
                context,
                "The usernanme ${_email.value} or password, is not valid",
                Toast.LENGTH_LONG
            ).show()
        }
    }



}