package com.example.myapp.custom_view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    leftContent: @Composable (() -> Unit)? = null,
    rightContent: @Composable (() -> Unit)? = null,
    containerColor: Color = Color(0xFF119CAE),
    contentColor: Color = Color.White
) {
    TopAppBar(
        title = {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                leftContent?.invoke()
                Spacer(modifier = Modifier.weight(1f))
                rightContent?.invoke()
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            contentColor
        )
    )
}

@Composable
fun DefaultLeftSideView(
    text: String,
    onBackClick: () -> Unit
) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 16.dp)
            .wrapContentWidth()
            .clickable {
                onBackClick.invoke()
            }
    )
}

data class TextStyleOptions(
    val textColor: Color = Color.White,
    val textSize: TextUnit = 18.sp,
    val fontWeight: FontWeight = FontWeight.Bold,
    val textAlign: TextAlign = TextAlign.Center
)

@Composable
fun DefaultRightSideView(
    text: String,
    textStyle: TextStyleOptions = TextStyleOptions(),
    onCloseClick: () -> Unit
) {
    Text(
        text = text,
        fontSize = textStyle.textSize,
        color = textStyle.textColor,
        fontWeight = textStyle.fontWeight,
        textAlign = textStyle.textAlign,
        modifier = Modifier
            .padding(end = 16.dp)
            .wrapContentWidth()
            .clickable { onCloseClick() }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomAppBar() {
    CustomAppBar(
        leftContent = { DefaultLeftSideView(text = "Back", onBackClick = { /* Handle back click */ }) },
        rightContent = { DefaultRightSideView(text = "Close", onCloseClick = { /* Handle close click */ }) }
    )
}
