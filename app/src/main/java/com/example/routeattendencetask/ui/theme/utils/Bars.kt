package com.example.routeattendencetask.ui.theme.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.routeattendencetask.R
import com.example.routeattendencetask.ui.theme.searchBlue

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
                Image(
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