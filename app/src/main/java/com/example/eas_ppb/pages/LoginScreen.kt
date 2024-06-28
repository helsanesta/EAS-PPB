package com.example.eas_ppb.pages

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.eas_ppb.R

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.alfamind_logo),
                contentDescription = "Logo SignIn Page",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Fit
            )

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Sign In",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 25.dp)
                        .align(Alignment.Start)
                )

                Text(
                    text = "Jika sudah punya akun, Silahkan login untuk menikmati fitur Alfamind",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 16.dp, end = 50.dp)
                )

                OutlinedTextField(
                    value =email,
                    onValueChange = { email = it},
                    label = { Text("Email") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisibility)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                            Icon(imageVector = image, "")
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = "Forgot password?",
                    color = Color(0XFF1D61B1),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.End)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate("beranda"){
                        popUpTo("login") { inclusive = true }
                    } },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0XFF1D61B1), shape = RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(Color(0XFF1D61B1))
                ) {
                    Text(text = "Submit", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(modifier = Modifier.weight(1f))
                    Text(text = "OR", modifier = Modifier.padding(horizontal = 8.dp))
                    Divider(modifier = Modifier.weight(1f))
                }

                Button(
                    onClick = { /* Handle Google login */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0XFFBABABA), shape = RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(Color(0XFFBABABA))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_google), // replace with your Facebook logo resource id
                        contentDescription = "Google Logo",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Login with Google", color = Color.Gray)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /* Handle Facebook login */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF569CF8), shape = RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(Color(0xFF569CF8))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook), // replace with your Facebook logo resource id
                        contentDescription = "Facebook Logo",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Login with Facebook", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    Text(
                        text = "Belum punya akun? ",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(top = 8.dp)
                    )
                    Text(
                        text = "Sign Up",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0XFF1D61B1),
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable { navController.navigate("register") }
                    )
                }
            }
        }
    }
}