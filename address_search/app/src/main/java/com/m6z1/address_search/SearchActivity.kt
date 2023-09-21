package com.m6z1.address_search

import android.content.Intent
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.m6z1.address_search.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView : WebView = binding.webView

        webView.settings.javaScriptEnabled = true

        webView.addJavascriptInterface(BridgeInterface(),"Android")
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                webView.loadUrl("javascript:sample2_execDaumPostcode();")
            }
        }

        webView.loadUrl("http://addresssearch-7850f.web.app")
    }

    inner class BridgeInterface() {
        @JavascriptInterface
        fun processDATA(data: String?) {
            val intent = Intent()
            intent.putExtra("data", data)
            setResult(RESULT_OK, intent)
            finish()
        }

    }

}