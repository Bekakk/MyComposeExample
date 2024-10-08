package com.example.myapp.intro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MultiIntroPage(){
    val pagerState = rememberPagerState { 3 }

    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager  (
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> IntroScreenOne()
                1 -> IntroScreenTwo()
                2 -> IntroScreenThree()
            }
        }

        PageIndicator(currentPage = pagerState.currentPage, totalPages = 3)

        Button (
            onClick = {
                if (pagerState.currentPage < 2) {
                    coroutineScope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                } else {
                    // Navigate to the main app screen
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(if (pagerState.currentPage < 2) "Next" else "Get Started")
        }
    }
}


@Composable
fun IntroScreenOne() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is the first screen", style = MaterialTheme.typography.bodyMedium)
        // Add more elements specific to this screen
    }
}

@Composable
fun IntroScreenTwo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .background(Color.Blue)
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Discover", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is the second screen", style = MaterialTheme.typography.bodyMedium)
        // Add more elements specific to this screen
    }
}

@Composable
fun IntroScreenThree() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Get Started", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is the last screen", style = MaterialTheme.typography.bodyMedium)
        // Add more elements specific to this screen
    }
}

@Composable
fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        repeat(totalPages) { index ->
            val color = if (index == currentPage) Color.Blue else Color.Gray
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(color, shape = CircleShape)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}