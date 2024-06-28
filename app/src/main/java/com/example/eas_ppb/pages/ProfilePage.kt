package com.example.eas_ppb.pages

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.eas_ppb.R

@Composable
fun ProfilePage(navController: NavHostController, modifier: Modifier = Modifier) {

    val gradientColors = listOf(
        Color(0xFFEC2134), // merah EC2134
        Color(0xFF86131E)  // merah tua 86131E
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 65.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Profil",
                    fontSize = 24.sp,
                )
                Text(text = "Data diri Anda", fontSize = 16.sp)
            }
            Image(
                painter = painterResource(id = R.drawable.alfamind_logo),
                contentDescription = "Alfamind Logo",
                modifier = Modifier.size(75.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        ElevatedCard(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Brush.verticalGradient(gradientColors))
                    .padding(horizontal = 28.dp, vertical = 20.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Column {
                    Text(
                        text = "Saldo",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Rp 123.350,00",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "2505 **** **** 0003",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFD700),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "06/25",
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xFFFFD700),
                            modifier = Modifier.align(Alignment.Bottom)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate("topUp") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF1D61B1))
        ) {
            Icon(
                imageVector = Icons.Filled.Paid,
                contentDescription = "Payment Icon",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Top up Saldo",
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        ProfileItem(label = "Nama", value = "Helsa Nesta Dhaifullah", icon = Icons.Filled.AccountCircle)
        ProfileItem(label = "No. KTP", value = "2505 **** **** 0003", icon = Icons.Filled.CreditCard)
        ProfileItem(label = "Email", value = "helsanesta14@gmail.com", icon = Icons.Filled.Email)
        ProfileItem(label = "No. Telepon", value = "081252724160", icon = Icons.Filled.Phone)
        ProfileItem(label = "Nama Toko", value = "Toko Matahari", icon = Icons.Filled.Store)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ProfileItem(label: String, value: String, icon: ImageVector) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            label = { Text(label) },
            value = value,
            onValueChange = {},
            readOnly = true,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = icon, contentDescription = "Logo data diri")
            }
        )
    }
}
