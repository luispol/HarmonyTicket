package com.example.harmonyticket.login

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.rememberAsyncImagePainter
import com.example.harmonyticket.R
import com.example.harmonyticket.component.fontComic
import com.example.harmonyticket.ui.theme.dl
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects


@Composable
fun RegisterScreen(loginViewModel: LoginViewModel){
    val userName:String by loginViewModel.userName.observeAsState(initial = "")
    val passworUser:String by loginViewModel.passwordUser.observeAsState(initial = "")
    val names:String by loginViewModel.names.observeAsState(initial = "")
    val lastnames:String by loginViewModel.lastnames.observeAsState(initial = "")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(dl)
            .padding(20.dp)
            .padding(top = 40.dp)
        
    ){
        TitleRegister()
        Spacer(modifier = Modifier.size(20.dp))
        ImageProfile(loginViewModel)
        Spacer(modifier = Modifier.size(20.dp))
        UserName(userName){
            loginViewModel.onRegisterChanged(it, passworUser,names, lastnames)
        }
        Spacer(modifier = Modifier.size(10.dp))
        UserPassword(passworUser){
            loginViewModel.onRegisterChanged(userName, it,names, lastnames)
        }
        Spacer(modifier = Modifier.size(10.dp))
        TextData(data = names, textLabel = "Name") {
            loginViewModel.onRegisterChanged(userName,passworUser,it,lastnames)
        }
        Spacer(modifier = Modifier.size(10.dp))
        TextData(data = lastnames, textLabel = "Lastname") {
            loginViewModel.onRegisterChanged(userName,passworUser,names,it)
        }
        Spacer(modifier = Modifier.size(15.dp))
        ButtonSave(loginViewModel)
    }
}

@Composable
fun ImageProfile(loginViewModel: LoginViewModel){
    val image:Int by loginViewModel.image.observeAsState(initial = R.drawable.camera)
    val imageUri by loginViewModel.imageUri.observeAsState(initial = Uri.EMPTY)
    val file = loginViewModel.context.createImageFile()

    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(loginViewModel.context),
        loginViewModel.context.packageName+".provider",
        file
    )
    val permissionCheckResult = ContextCompat.checkSelfPermission(
        loginViewModel.context,
        android.Manifest.permission.CAMERA
    )

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()

    ) {
        loginViewModel.setImageUri(uri)
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) {
        try {
            Toast.makeText(
                loginViewModel.context,
                "Permission granted!!",
                Toast.LENGTH_LONG)
                .show()
                cameraLauncher.launch(uri)
        } catch (e: Exception){
            Toast.makeText(
                loginViewModel.context,
                "Permission denied!!",
                Toast.LENGTH_LONG)
                .show()
        }

    }

    Image(
        painter = rememberAsyncImagePainter(if (imageUri.path?.isNotEmpty() == true) imageUri else image),
        contentDescription = "profile",
        modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
            .clickable {
                if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                    cameraLauncher.launch(uri)
                } else {
                    permissionLauncher.launch(android.Manifest.permission.CAMERA)
                }
            }
    )
}

fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyyMMdd HHmmss").format(Date())
    val imageFileName = "JPEG_${timeStamp}_"

    return File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )
}



@Composable
fun ButtonSave(loginViewModel: LoginViewModel){
    Button(onClick = {
        loginViewModel.registerUser()
    },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1E162B),
            disabledContainerColor = Color(0xFF2D2536),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
        ) {
        Text(text = "Save",
            fontFamily = fontComic,
            fontWeight = FontWeight.Bold
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextData(data:String,textLabel:String, onTextChange: (String) -> Unit){
    TextField(
        value = data,
        onValueChange = {onTextChange(it)},
        modifier = Modifier.fillMaxWidth(),
        shape = CircleShape,
        textStyle = LocalTextStyle.current.copy(color = Color(0xFF4600A7), fontFamily = fontComic),
        label = { Text(text = textLabel,
            fontFamily = fontComic)},
        maxLines = 1,
        singleLine = true,
        trailingIcon = {
            Icon(imageVector = Icons.Filled.PersonAddAlt1, contentDescription = "")
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent)
    )
}


@Composable
fun TitleRegister(){
    Text(
        text = "Register your account",
        fontFamily = fontComic,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = Modifier.fillMaxWidth()

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserName(userName:String, onTextChange:(String)-> Unit){
    TextField(
        value = userName,
        onValueChange = {onTextChange(it)},
        modifier = Modifier.fillMaxWidth(),
        shape = CircleShape,
        textStyle = LocalTextStyle.current.copy(color = Color(0xFF4600A7), fontFamily = fontComic),
        label = { Text(text = "Email",
            fontFamily = fontComic)},
        maxLines = 1,
        singleLine = true,
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Email, contentDescription = "")
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserPassword(passwordUser:String, onTextChange: (String) -> Unit){
    var passwordVisi by rememberSaveable {
        mutableStateOf(false)
    }
    TextField(
        value = passwordUser,
        onValueChange = {onTextChange(it)},
        modifier = Modifier.fillMaxWidth(),
        shape = CircleShape,
        label = { Text(text = "Password", fontFamily = fontComic)},
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {

            val image = if (passwordVisi){
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisi = !passwordVisi }) {
                Icon(imageVector = image, contentDescription = "")

            }
        },
        visualTransformation =
        if (passwordVisi) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },

        textStyle = LocalTextStyle.current.copy(color = Color(0xFF4600A7), fontFamily = fontComic),
        //placeholder = { Text(text = "Password")},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent)
    )
}