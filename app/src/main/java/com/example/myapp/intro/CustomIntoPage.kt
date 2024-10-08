package com.example.myapp.intro

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R
import kotlinx.coroutines.delay

@Composable
fun CustomIntoPage() {
    var isTextVisible by remember { mutableStateOf(false) }
    var visibleTextLengthWelcome by remember { mutableStateOf(0) }
    var visibleTextLengthBody by remember { mutableStateOf(0) }

    // Start the animation with a 2-second delay
    LaunchedEffect(Unit) {
        delay(300)
        isTextVisible = true

        // Animate the "Welcome" text first
        val welcomeText = "Welcome"
        for (i in welcomeText.indices) {
            visibleTextLengthWelcome = i + 1
            delay(50) // Speed of text writing effect for "Welcome"
        }

        // After "Welcome", animate the second text
        val bodyText = "To your TBC bank.\nWe are happy to see\nYou as our client."
        for (i in bodyText.indices) {
            visibleTextLengthBody = i + 1
            delay(50) // Speed of text writing effect for the body
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF119CAE)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.tbc_logo), // replace with your image resource
            contentDescription = "Example Image",
            modifier = Modifier
                .size(46.dp)
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp)) // Adds space between Image and Text

        // Use AnimatedVisibility to handle the fade-in effect
        AnimatedVisibility(
            visible = isTextVisible,
            enter = fadeIn(), // Optional: Fade-in effect when the text becomes visible
            exit = fadeOut()
        ) {

            Column(
                modifier = Modifier.wrapContentWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // First text: "Welcome" with the writing effect
                val welcomeText = "Welcome"
                Text(
                    text = welcomeText.take(visibleTextLengthWelcome), // Show "Welcome" gradually
                    color = Color.Gray,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(16.dp)) // Space between the texts

                // Second text: Body text with the writing effect
                val bodyText = "To your TBC bank.\nWe are happy to see\nYou as our client."
                Text(
                    text = bodyText.take(visibleTextLengthBody), // Show body text gradually
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewAnimatedPage() {
    CustomIntoPage()
}