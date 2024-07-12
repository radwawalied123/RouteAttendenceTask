package com.example.routeattendencetask.api

import com.google.gson.annotations.SerializedName

data class ReviewsItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("reviewerName")
	val reviewerName: String? = null,

	@field:SerializedName("reviewerEmail")
	val reviewerEmail: String? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("comment")
	val comment: String? = null
)