package com.example.harmonyticket.login


import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.harmonyticket.R
import com.example.harmonyticket.component.fontComic
import com.example.harmonyticket.component.fontPlayground
import com.example.harmonyticket.component.dl

@Composable
fun LoginScreen(loginViewModel: LoginViewModel){

    val isRegisterVisible:Boolean by loginViewModel.isRegisterVisible.observeAsState(initial = false)
    if (isRegisterVisible) {
        RegisterScreen(loginViewModel = loginViewModel)
    } else {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(dl)
            .padding(8.dp)

        ){

            Header(Modifier.align(Alignment.TopEnd))
            Body(Modifier.align(Alignment.Center),loginViewModel)
            Footer(Modifier.align(Alignment.BottomCenter), loginViewModel)

        }
    }
}

@Composable
fun Footer(modifier: Modifier, loginViewModel: LoginViewModel){
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            modifier = Modifier
                .background(Color.Gray)
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp(loginViewModel)
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SignUp(loginViewModel: LoginViewModel) {
    val font = FontFamily(
        Font(R.font.heycomic)
    )

    Row(modifier =
    Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {

        Text(
            text = "Don't have an account?",
            fontFamily = font,
            color = Color.Gray)
        Text(
            text = "Sign Up",
            fontFamily = font,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clickable {
                    loginViewModel.onRegisterVisible(true)
                },
            fontWeight = FontWeight.Bold,
            color = Color(0xFF350080)
        )
    }
}



@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel){

    val email:String by loginViewModel.email.observeAsState(initial = "")
    val password:String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable:Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        //Spacer(modifier = Modifier.size(5.dp))
        Brand(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(18.dp))
        Email(email){

            //email = it
            loginViewModel.onLoginChanged(email=it,password=password)
            //isLoginEnable = enableLogin(email,password)

        }
        Spacer(modifier = Modifier.size(8.dp))
        Password(password){

            loginViewModel.onLoginChanged(email=email,password=it)
            //isLoginEnable = enableLogin(email,password)
        }

        Spacer(modifier = Modifier.size(6.dp))
        ForgetPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable,loginViewModel)
    }
}

@Composable
fun LoginButton(isLoginEnable:Boolean,loginViewModel: LoginViewModel){

    Button(onClick = { loginViewModel.checkLogin()  },
        enabled = isLoginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF350080),
            disabledContainerColor = Color(0xFF675F70)
           // contentColor = Color.Black,
           // disabledContentColor = Color.Black
        )
    ) {
        Text(text = "Log In",
            fontFamily = fontComic,
            color = Color.White)
    }
}

@Composable
fun ForgetPassword(modifier: Modifier){

    Text(
        text = "Forgot your password?",
        modifier = modifier,
        fontFamily = fontComic,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF350080)
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password:String, onTextChange:(String)-> Unit){

    var passwordVisi by rememberSaveable {
        mutableStateOf(false)
    }

    TextField(
        value = password,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email:String, onTextChange:(String)-> Unit){


    TextField(
        value = email,
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

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        //placeholder = { Text(text = "Email")},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent)
    )
}

@Composable
fun Brand(modifier: Modifier){

    Text(text = "Harmony Ticket®",
        fontFamily = fontPlayground,
        fontSize = 25.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}
@Composable
fun ImageLogo(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.newlogo),
        contentDescription = "logo",
        modifier = modifier
            .size(280.dp))

}
@Composable
fun Header(modifier: Modifier){

    val activity = LocalContext.current as Activity

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close",
        modifier = modifier
            .clickable { activity.finish() }
            .size(30.dp)
    )

}