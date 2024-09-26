package com.example.myapp.custom_view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.min

@Composable
fun NumberKeyboard(
    onKeyClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val buttonSize = calculateButtonSize(screenWidth)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(), // Add this line to wrap the height
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val keys = listOf(
            listOf("7", "8", "9", "000"),
            listOf("4", "5", "6", "00"),
            listOf("1", "2", "3", "FULL"),
            listOf("0", ".", "⌫", ">")
        )

        keys.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { key ->
                    val isLastKey = key == ">"

                    KeyboardButton(
                        key = key,
                        isLastKey = isLastKey,
                        onButtonClick = { clickedKey -> onKeyClick(clickedKey) },
                        onNextAction = {}
                    )
                }
            }
        }
    }
}

@Composable
fun KeyboardButton(
    key: String,
    isLastKey: Boolean = false,
    onButtonClick: (String) -> Unit,
    onNextAction: () -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(8.dp) // Adjust padding for smaller devices
            .size(64.dp) // Use dynamic size if required
            .let {
                if (isLastKey) {
                    it.background(
                        color = Color(0xFF00E599),
                        shape = RoundedCornerShape(12.dp)
                    )
                } else it
            }
            .clickable(
                onClick = {
                    if (isLastKey) {
                        Toast
                            .makeText(context, "Go next", Toast.LENGTH_SHORT)
                            .show()
                        onNextAction()
                    } else {
                        onButtonClick(key)
                    }
                },
                indication = null,
                interactionSource = remember { MutableInteractionSource() } // Required for indication
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = key,
            color = if (isLastKey) Color.White else Color.Black,
            fontSize = 24.sp
        )
    }
}

//@Composable
//fun NumberInputScreen(modifier: Modifier,
//                      onKeyClick: (String) -> Unit) {
//    var input by remember { mutableStateOf("") }
//
//    Column(
//        modifier = modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Bottom
//    ) {
//        Text(
//            text = input,
//            fontSize = 32.sp,
//            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
//            modifier = Modifier.padding(16.dp)
//        )
//        NumberKeyboard(onKeyClick = { key ->
//            onKeyClick.invoke(key)
//            when (key) {
//                "⌫" -> if (input.isNotEmpty()) input = input.dropLast(1)
//                "." -> if (!input.contains(".")) input += key
//                else -> input += key
//            }
//        })
//    }
//}

@Composable
fun calculateButtonSize(screenWidth: Dp): Dp {
    // Define a base button size
    val baseSize = 64.dp
    val maxButtonsPerRow = 4 // Maximum buttons per row

    // Convert screenWidth to pixels and then back to Dp for comparison
    val screenWidthInPixels = with(LocalDensity.current) { screenWidth.toPx() }
    val buttonSizeInPixels = with(LocalDensity.current) { baseSize.toPx() }

    // Calculate the maximum allowed size for buttons in pixels
    val calculatedButtonSizeInPixels = screenWidthInPixels / maxButtonsPerRow

    // Return the smaller of the two sizes in Dp
    return (min(calculatedButtonSizeInPixels, buttonSizeInPixels) / LocalDensity.current.density).dp
}

//@Composable
//@Preview(showBackground = true)
//fun MyApp() {
//    MaterialTheme {
//        NumberInputScreen(modifier)
//    }
//}
