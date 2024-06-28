package com.example.eas_ppb.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TopUpPaymentPage(navController: NavHostController){
    val metodeBayar by rememberSaveable { mutableStateOf("BNI") }
    val nominal by rememberSaveable { mutableStateOf("150000") }
    val formattedNominal = formatCurrency(nominal)

    val gradientColors = listOf(
        Color(0xFFFAE197), // merah EC2134
        Color(0xFFFFD700)  // merah tua 86131E
    )

    Scaffold (
        topBar = {
            TopAppBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                ElevatedCard(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(Brush.verticalGradient(gradientColors))
                            .padding(horizontal = 28.dp, vertical = 20.dp)
                            .fillMaxWidth(),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Nomor Virtual Account $metodeBayar",
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "26747415196496",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0XFF1D61B1),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { /* Copy VA Number */ },
                                border = BorderStroke(width = 1.dp, color = Color.Black),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = Color.Transparent, // Transparent background
                                    contentColor = Color.Black // Text and icon color
                                ),
                                shape = RoundedCornerShape(5.dp)
                            ) {
                                Icon(imageVector = Icons.Default.ContentCopy, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "Copy Nomor VA") // Set text color to black
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Waktu Top-up Tersisa",
                            fontSize = 14.sp,
                            color = Color(0XFF1D61B1)
                        )

                        Text(
                            text = "59:55",
                            fontSize = 18.sp,
                            color = Color.Red
                        )
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "Nominal Top-up",
                            fontSize = 14.sp,
                            color = Color(0XFF1D61B1)
                        )

                        Text(
                            text = "Rp $formattedNominal",
                            fontSize = 18.sp,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Pastikan jumlah transfer untuk top-up sesuai dengan nominal top-up di atas",
                    fontSize = 14.sp,
                    color = Color(0XFF1D61B1),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Instruksi Top-up CIMB NIAGA",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(8.dp))

                InstructionRow(text = "Melalui ATM")
                InstructionRow(text = "Melalui Mobile Banking")
                InstructionRow(text = "Melalui Internet Banking")

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Catatan",
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFEC2134)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Column(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 10.dp)
                ) {
                    ListItem("- Minimum jumlah top-up adalah Rp 10.000")
                    ListItem("- Biaya admin Rp 500 dipotong dari nominal top-up")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { navController.navigate("beranda") {
                        popUpTo("topUpPayment") { inclusive = true }
                    } },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFEC2134), shape = RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(Color(0xFFEC2134))
                ) {
                    Text(text = "Kembali", color = Color.White)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { navController.navigate("successPayment") {
                        popUpTo("topUpPayment") { inclusive = true }
                    } },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0XFF1D61B1), shape = RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(Color(0XFF1D61B1))
                ) {
                    Text(text = "Cek Status", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

// Utility function to format the nominal value
fun formatCurrency(nominal: String): String {
    return try {
        val number = nominal.toLong()
        val format = NumberFormat.getNumberInstance(Locale("id", "ID"))
        format.format(number)
    } catch (e: NumberFormatException) {
        nominal
    }
}

@Composable
fun InstructionRow(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.Black
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Dropdown Arrow"
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
    Divider(thickness = 1.dp)
}

@Composable
fun ListItem(text: String) {
    Row(modifier = Modifier.padding(vertical = 2.dp)) {
        Text(text = text, fontSize = 14.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar(navController: NavHostController) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF155E9F),
            titleContentColor = Color.White,
        ),
        title = { Text(text = "Rincian Top-Up") },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Arrow Back",
                    tint = Color.White
                )
            }
        }
    )
}