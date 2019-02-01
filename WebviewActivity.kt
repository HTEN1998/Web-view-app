package com.example.webview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val getStr=intent.getStringExtra("url_str")
        prgressB.max = 100
        webview.webViewClient = HelpClient()
        webview.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                prgressB.progress = newProgress
                title = "Loading....."
                if (newProgress == 100) {
                    title = getStr
                    prgressB.visibility = View.GONE
                }
                super.onProgressChanged(view, newProgress)

            }
        }
        val webSetting = webview.settings
        prgressB.progress = 0
        webSetting.javaScriptEnabled = true










        webSetting.builtInZoomControls = true
        webview.loadUrl("https://$getStr/")
    }

    private inner class HelpClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view!!.loadUrl(url)

            return super.shouldOverrideUrlLoading(view, url)

        }
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }


    }
}