package com.example.myapp.custom_view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun AnimatedNumberInputScreen() {

    var inputValue by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 1.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomAppBar(
                leftContent = { DefaultLeftSideView(text = "Back", onBackClick = { /* Handle back click */ }) },
                rightContent = { DefaultRightSideView(text = "Close", onCloseClick = { /* Handle close click */ }) }
            )
            AccountCard(inputValue = inputValue)
            BusnessSecondaryView()
        }

        NumberKeyboard(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            onKeyClick = { key ->
                inputValue += key
            }
        )
    }

}
