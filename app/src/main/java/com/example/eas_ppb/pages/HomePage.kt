package com.example.eas_ppb.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.eas_ppb.NavItem
import com.example.eas_ppb.R

@Composable
fun HomePage(navController: NavHostController){

    val navItemList = listOf(
        NavItem("Beranda", Icons.Default.Home),
        NavItem("Transaksi", Icons.Default.Payments),
        NavItem("Toko Saya", Icons.Default.Storefront),
        NavItem("Profil", Icons.Default.AccountCircle),
    )

    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = { Icon(imageVector = navItem.icon, contentDescription = "icon navbar") },
                        label = { Text(text = navItem.label) }
                    )
                }
            }
        }
    ) {
            innerPadding ->
        ContentScreen(navController, modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(navController: NavHostController, modifier: Modifier = Modifier, selectedIndex : Int){
    when(selectedIndex){
        0 -> MainContent(modifier)
        3 -> ProfilePage(navController, modifier)
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
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
                    text = "Welcome 👋",
                    fontSize = 24.sp,
                )
                Text(text = "Let's find your needs now", fontSize = 16.sp)
            }
            Image(
                painter = painterResource(id = R.drawable.alfamind_logo),
                contentDescription = "Alfamind Logo",
                modifier = Modifier.size(75.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        CategoryTabs()
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            repeat(10) { // Creates 10 rows with 2 products each, total 20 products
                Row {
                    repeat(2) {
                        ProductCard()
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun SearchBar() {
    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Gray.copy(alpha = 0.1f), shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            if (searchQuery.value.text.isEmpty()) {
                Text(
                    text = "Cari barang",
                    color = Color.Gray
                )
            }
            BasicTextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.FilterAlt,
            contentDescription = "Filter Icon",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun CategoryTabs() {
    val categories = listOf("Sembako", "Perabotan", "Elektronik", "Fashion")
    val selectedCategory = remember { mutableStateOf("Sembako") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Fixed Best Seller text
        Box(
            modifier = Modifier
                .background(Color(0xFF1D61B1), RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "Best Seller",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown Arrow",
                    tint = Color.White,
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Scrollable categories
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            categories.forEach { category ->
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { selectedCategory.value = category },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(if (selectedCategory.value == category) Color(0xFFFBBC04) else Color.Gray.copy(alpha = 0.1f)
                    )
                ) {
                    Text(
                        text = category,
                        color = if (selectedCategory.value == category) Color.White else Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun ProductCard() {
    Card(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.minyak_goreng),
                contentDescription = "Gambar Item",
                modifier = Modifier.size(70.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Minyak Goreng 2L",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Rp 37.500,00",
                fontSize = 12.sp
            )
        }
    }
}