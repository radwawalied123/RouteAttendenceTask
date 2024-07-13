package com.example.routeattendencetask.ui.theme.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.routeattendencetask.api.ProductsItem
import com.example.routeattendencetask.ui.theme.utils.Cards.ProductCard

@Composable
fun ProductList(productList: List<ProductsItem?>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(productList) { product ->
            ProductCard(product = product,modifier=Modifier)
        }
    }
}