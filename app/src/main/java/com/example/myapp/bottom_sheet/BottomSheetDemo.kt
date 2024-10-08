package com.example.myapp.bottom_sheet

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.custom_view.DefaultLeftSideView
import com.example.myapp.custom_view.DefaultRightSideView
import kotlinx.coroutines.launch


@Composable
fun BottomSheetDemo() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Blue),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DefaultLeftSideView(text = "Open Dialog", onBackClick = {
                scope.launch {
                    showBottomSheet = true
                }
            })
            DefaultRightSideView(text = "Close Dialog", onCloseClick = {
                showBottomSheet = false
            })
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            AnimatedBottomSheet(
                visible = showBottomSheet,
                onDismiss = {
                    scope.launch {
                        showBottomSheet = false
                    }
                }
            )
        }
    }
}

@Composable
fun AnimatedBottomSheet(
    visible: Boolean,
    onDismiss: () -> Unit
) {
    val transition = updateTransition(targetState = visible, label = "BottomSheetTransition")

    // Animate the vertical position of the bottom sheet
    val offsetY by transition.animateDp(
        transitionSpec = {
            if (targetState) {
                tween(durationMillis = 500)
            } else {
                tween(durationMillis = 300)
            }
        },
        label = "OffsetAnimation"
    ) { isVisible ->
        if (isVisible) 0.dp else 300.dp // Animate from bottom to top
    }

    if (visible || transition.currentState) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = offsetY)
                .height(200.dp),
            shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp),
            color = Color.White,
            shadowElevation = 2.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("Bottom Sheet Content", fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = { onDismiss() }) {
                    Text("Close Sheet")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomAppBar() {
    BottomSheetDemo()
}
