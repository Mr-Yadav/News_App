package com.example.again

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class detail_activity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var pro : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        webView = findViewById(R.id.webb)
        pro = findViewById(R.id.progressBar)




            webView.settings.javaScriptEnabled = true
            webView.settings.userAgentString =
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.190 Safari/537.36"

            val url = intent.getStringExtra("URL")
            if (url != null) {

                webView.webViewClient = object : WebViewClient() {

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        pro.visibility = View.GONE
                        webView.visibility = View.VISIBLE

                    }


                }

                webView.loadUrl(url)


            }


        }



}