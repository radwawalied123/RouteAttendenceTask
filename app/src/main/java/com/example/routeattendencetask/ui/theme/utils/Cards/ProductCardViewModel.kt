package com.example.routeattendencetask.ui.theme.utils.Cards



import androidx.lifecycle.ViewModel
import com.example.routeattendencetask.api.ProductsItem

class ProductCardViewModel : ViewModel() {
    var product: ProductsItem? = null

    fun getProductTitle(): String = product?.title ?: ""

    fun getProductDescription(): String = product?.description ?: ""

    fun getDiscount(): String = product?.discountPercentage.toString()

    fun getPrice(): String = product?.price.toString()

    fun getRating(): String = product?.rating.toString()

    fun getProductImageUrl(): String = product?.images?.firstOrNull() ?: ""
}