package com.example.movielibrary.ui.library

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movielibrary.R
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToLibrary:() -> Unit
) {

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = .3f,
            animationSpec = tween(
                500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navigateToLibrary()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
    }
}