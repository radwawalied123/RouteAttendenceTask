package com.example.routeattendencetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.routeattendencetask.api.ApiManager
import com.example.routeattendencetask.api.ListResponse
import com.example.routeattendencetask.api.ProductsItem
import com.example.routeattendencetask.ui.theme.RouteAttendenceTaskTheme
import com.example.routeattendencetask.ui.theme.utils.ProductCard
import com.example.routeattendencetask.ui.theme.utils.SearchBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
    var productsList by remember { mutableStateOf<List<ProductsItem?>>(emptyList()) }

    LaunchedEffect(Unit) {
        ApiManager.getListServices().getList().enqueue(object : Callback<ListResponse> {
            override fun onResponse(call: Call<ListResponse>, response: Response<ListResponse>) {
                if (response.isSuccessful) {
                    productsList = response.body()?.products ?: emptyList()
                }
            }

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }

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
        ProductList(productList = productsList)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}

@Composable
fun ProductList(productList: List<ProductsItem?>) {
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
