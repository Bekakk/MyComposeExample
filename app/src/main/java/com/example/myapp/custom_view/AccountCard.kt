package com.example.myapp.custom_view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R

@Composable
fun AccountCard(
    inputValue: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 10.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF119CAE) // Set the background color to #119CAE
        )
    ) {
        // Use a Box to position the arrow-down image in the top-right corner
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Top text (Account type and balance)
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Business Main Account",
                        style = TextStyle(
                            color = Color.LightGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Horizontal scrolling balance number
                    Text(
                        text = "10 000 000 000.00 UZS",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .horizontalScroll(rememberScrollState()) // Enable horizontal scrolling for balance
                    )
                }


                Spacer(modifier = Modifier.height(8.dp)) // Space between TextField and Fee

                HintTextField(inputValue)
                Spacer(modifier = Modifier.height(8.dp)) // Space between TextField and Fee

                // Fee and currency symbol
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Fee: 0.9 UZS",
                        style = TextStyle(
                            color = Color.LightGray,
                            fontSize = 14.sp
                        )
                    )
                }


                Spacer(modifier = Modifier.height(24.dp))

                // Scrollable bottom buttons or chips with rounded shape
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()), // Enable horizontal scrolling here
                    horizontalArrangement = Arrangement.spacedBy(16.dp) // Space between chips
                ) {
                    val amounts =
                        listOf(100_000, 200_000, 300_000, 400_000, 500_000, 600_000, 700_000)
                    amounts.forEach { amount ->
                        ChipItem(amount)
                    }
                }
            }

            // Arrow-down image in the top-right corner
            Image(
                painter = painterResource(id = R.drawable.arrow_down), // Replace with your arrow-down icon
                contentDescription = "Arrow Down",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.TopEnd) // Align the image to the top-right corner
                    .padding(end = 16.dp, top = 16.dp) // Add right margin and top padding
                    .size(24.dp) // Set size of the arrow icon
            )
        }
    }
}

@Composable
fun HintTextField(inputValue: String) {
    Text(
        text = inputValue,
        style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
        color = Color.White,
        textAlign = TextAlign.End,
        modifier = Modifier
            .padding(16.dp) // Add padding around the text
            .background(Color.Transparent) // Add a background color
            .fillMaxWidth() // Make the text fill the available width
            .clickable { /* Handle click action */ } // Optional: Add click action
    )
}


@Composable
fun ChipItem(amount: Int) {
    // Single chip button
    Box(
        modifier = Modifier
            .size(80.dp, 40.dp)
            .border(
                width = 0.5.dp, // Set the width of the white border
                color = Color.White, // White border
                shape = RoundedCornerShape(30.dp) // Rounded corners for the border
            )
            .background(
                Color.Transparent,
                shape = RoundedCornerShape(30.dp)
            ), // Transparent background with same shape
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = amount.toString(),
            style = TextStyle(
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AccountCardPreview() {
    AccountCard( inputValue = "dfdf")
}
