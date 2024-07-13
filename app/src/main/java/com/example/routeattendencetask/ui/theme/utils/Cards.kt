package com.example.routeattendencetask.ui.theme.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.routeattendencetask.R
import com.example.routeattendencetask.api.ProductsItem
import com.example.routeattendencetask.ui.theme.borderBlue
import com.example.routeattendencetask.ui.theme.lightBlue
import com.example.routeattendencetask.ui.theme.royalBlue

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductCard(product: ProductsItem?, modifier: Modifier = Modifier) {
    val customFontFamily = FontFamily(Font(R.font.poppins_regular))
    val discount = product?.discountPercentage.toString()
    val price = product?.price.toString()
    val rating = product?.rating.toString()
    val imageUrl = product?.images?.firstOrNull() ?: ""

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, color = borderBlue, shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                GlideImage(
                    model = imageUrl,
                    contentDescription = "Product image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
                Image(
                    painter = painterResource(id = R.drawable.fav_ic),
                    contentDescription = "Favourite icon",
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }

            Text(
                text = product?.title ?: "",
                color = royalBlue,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 4.dp),
                fontFamily = customFontFamily
            )
            Text(
                text = product?.description ?: "",
                color = royalBlue,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 4.dp),
                fontFamily = customFontFamily
            )
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "EGP $discount",
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = customFontFamily
                    ),
                    color = royalBlue
                )
                Text(
                    text = "$price EGP",
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = customFontFamily,
                        textDecoration = TextDecoration.LineThrough
                    ),
                    color = lightBlue
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Reviews",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = customFontFamily
                    ),
                    color = royalBlue
                )
                Text(
                    text = " ($rating)",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = customFontFamily
                    ),
                    color = royalBlue
                )
                Image(
                    painter = painterResource(id = R.drawable.star_ic),
                    contentDescription = "Rating Icon",
                )


            }
            Image(
                painter = painterResource(id = R.drawable.plus_ic),
                contentDescription = "Plus Icon",
                modifier=Modifier.align(Alignment.End).padding(4.dp))
        }
        }
    }

