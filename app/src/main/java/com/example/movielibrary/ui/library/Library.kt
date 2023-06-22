package com.example.movielibrary.ui.library

import android.graphics.Bitmap
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MovieLibraryScreen() {
    var backEnabled by remember {
        mutableStateOf(false)
    }
    var webView: WebView? = null

    Box(modifier = Modifier.systemBarsPadding()) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = object : WebViewClient() {
                        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                            view?.let {
                                backEnabled = it.canGoBack()
                            }
                        }
                    }
                    settings.javaScriptEnabled = true
                    loadUrl("https://dlib2a.000webhostapp.com/")
                    webView = this
                }
            },
            update = {
                webView = it
            }
        )

        BackHandler(enabled = backEnabled) {
            webView?.goBack()
        }
    }
}