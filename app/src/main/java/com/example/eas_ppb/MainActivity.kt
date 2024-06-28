package com.example.eas_ppb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eas_ppb.pages.HomePage
import com.example.eas_ppb.pages.IntroScreen
import com.example.eas_ppb.pages.LoginScreen
import com.example.eas_ppb.pages.ProfilePage
import com.example.eas_ppb.pages.RegisterScreen
import com.example.eas_ppb.pages.SplashScreen
import com.example.eas_ppb.pages.SuccessPaymentPage
import com.example.eas_ppb.pages.TopUpPage
import androidx.compose.runtime.Composable
import com.example.eas_ppb.pages.TopUpPaymentPage
import com.example.eas_ppb.ui.theme.EAS_PPBTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EAS_PPBTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") { SplashScreen(navController) }
                    composable("intro") { IntroScreen(navController) }
                    composable("login") { LoginScreen(navController) }
                    composable("register") { RegisterScreen(navController) }
                    composable("beranda") { HomePage(navController) }
                    composable("profil") { ProfilePage(navController) }
                    composable("topUp") { TopUpPage(navController) }
                    composable("topUpPayment") { TopUpPaymentPage(navController) }
                    composable("successPayment") { SuccessPaymentPage(navController) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EAS_PPBTheme {
//        TopUpPage()
    }
}