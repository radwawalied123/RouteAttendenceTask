package com.example.routeattendencetask.api

import com.google.gson.annotations.SerializedName

data class ProductsItem(

	@field:SerializedName("images")
	val images: List<String?>? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("minimumOrderQuantity")
	val minimumOrderQuantity: Int? = null,

	@field:SerializedName("rating")
	val rating: Any? = null,

	@field:SerializedName("returnPolicy")
	val returnPolicy: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("weight")
	val weight: Int? = null,

	@field:SerializedName("warrantyInformation")
	val warrantyInformation: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("discountPercentage")
	val discountPercentage: Any? = null,

	@field:SerializedName("reviews")
	val reviews: List<ReviewsItem?>? = null,

	@field:SerializedName("price")
	val price: Any? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("shippingInformation")
	val shippingInformation: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("availabilityStatus")
	val availabilityStatus: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("stock")
	val stock: Int? = null,

	@field:SerializedName("sku")
	val sku: String? = null,

	@field:SerializedName("dimensions")
	val dimensions: Dimensions? = null,

	@field:SerializedName("brand")
	val brand: String? = null
)