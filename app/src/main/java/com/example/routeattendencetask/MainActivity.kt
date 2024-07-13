@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.routeattendencetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.routeattendencetask.ui.theme.RouteAttendenceTaskTheme
import com.example.routeattendencetask.ui.theme.borderBlue
import com.example.routeattendencetask.ui.theme.lightBlue
import com.example.routeattendencetask.ui.theme.royalBlue
import com.example.routeattendencetask.ui.theme.searchBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RouteAttendenceTaskTheme {
                ProductScreen()
            }
        }
    }
}


@Composable
fun ProductScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.route_ic), contentDescription = "Route sign",
            modifier = Modifier.padding(16.dp)
        )

        SearchBar()

        ProductList()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val isFocused = searchQuery.text.isNotEmpty()

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        Alignment.CenterVertically


    ) {

        TextField(
            shape = RoundedCornerShape(64.dp),
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = {
                if (!isFocused) {
                    Text("what do you search for?")
                }
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_ic),
                    contentDescription = "Search Icon", modifier = Modifier.size(30.dp)

                )
            },
            singleLine = true,
            modifier = Modifier
                .border(1.dp, searchBlue, RoundedCornerShape(64.dp))
                .background(Color.White, shape = CircleShape)
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Image(

            painter = painterResource(id = R.drawable.shopping_cart_ic),
            contentDescription = "Route sign",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}


@Composable
fun ProductList() {
    val productList = listOf(
        ProductList(
            "Air Jordan",
            "sxdhferhyfuryhuhfruefhy",
            "Preview",
            "4.6",
            "EGP 2000",
            "EGP 1200",
            R.drawable.test
        ),
        ProductList(
            "Air Jordan",
            "sxdhferhyfuryhuhfruefhy",
            "Preview",
            "4.6",
            "EGP 2000",
            "EGP 1200",
            R.drawable.test
        ),
        ProductList(
            "Air Jordan",
            "sxdhferhyfuryhuhfruefhy",
            "Preview",
            "4.6",
            "EGP 2000",
            "EGP 1200",
            R.drawable.test
        ),
        ProductList(
            "Air Jordan",
            "sxdhferhyfuryhuhfruefhy",
            "Preview",
            "4.6",
            "EGP 2000",
            "EGP 1200",
            R.drawable.test
        ),
        ProductList(
            "Air Jordan",
            "sxdhferhyfuryhuhfruefhy",
            "Preview",
            "4.6",
            "EGP 2000",
            "EGP 1200",
            R.drawable.test
        ),
        ProductList(
            "Air Jordan",
            "sxdhferhyfuryhuhfruefhy",
            "Preview",
            "4.6",
            "EGP 2000",
            "EGP 1200",
            R.drawable.test
        ),
        ProductList(
            "Air Jordan",
            "sxdhferhyfuryhuhfruefhy",
            "Preview",
            "4.6",
            "EGP 2000",
            "EGP 1200",
            R.drawable.test
        ),
        ProductList(
            "Air Jordan",
            "sxdhferhyfuryhuhfruefhy",
            "Preview",
            "4.6",
            "EGP 2000",
            "EGP 1200",
            R.drawable.test
        )
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(productList) { product ->
            ProductCard(product = product, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductListPreview() {
    ProductList()
}

@Composable
fun ProductCard(product: ProductList, modifier: Modifier = Modifier) {
    val customFontFamily = FontFamily(Font(R.font.poppins_regular))
    Card(
        modifier = modifier.border(2.dp, color = borderBlue, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = product.image ?: R.drawable.test),
                    contentDescription = "Product image",
                    modifier = Modifier

                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(id = R.drawable.fav_ic),
                    contentDescription = "Favourite icon",
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.TopEnd)

                )
            }

            Text(
                text = product.title ?: "",
                color = royalBlue,
                modifier = Modifier.padding(horizontal = 4.dp), fontFamily = customFontFamily
            )
            Text(
                text = product.description ?: "",
                color = royalBlue,
                modifier = Modifier.padding(horizontal = 4.dp), fontFamily = customFontFamily
            )
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp), Alignment.CenterVertically
            ) {
                Text(
                    text = product.discountPercentage ?: "",

                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal, fontFamily = customFontFamily
                    ), color = royalBlue
                )
                Text(
                    text = product.price ?: "",

                    style = TextStyle(
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal, fontFamily = customFontFamily,
                        textDecoration = TextDecoration.LineThrough
                    ), color = lightBlue
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp), Alignment.CenterVertically
            ) {
                Text(
                    text = product.preview ?: "",

                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal, fontFamily = customFontFamily
                    ), color = royalBlue
                )
                Text(
                    text = product.rating ?: "",

                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal, fontFamily = customFontFamily
                    ), color = royalBlue
                )
                Image(
                    painter = painterResource(id = R.drawable.star_ic),
                    contentDescription = "Rating Icon",
                    Modifier.size(width = 15.dp, height = 15.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.plus_ic),
                    contentDescription = "Rating Icon",
                    Modifier
                        .size(40.dp)
                        .padding(horizontal = 4.dp),


                    )
            }


        }
    }
}

