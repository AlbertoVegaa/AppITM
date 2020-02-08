package com.alberto.frontend
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
private val URL="https://mystifying-nightingale-9c518c.netlify.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val refresh=findViewById<Button>(R.id.efe5) as Button
        refresh.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View) {
                webView.reload()
            }
        })
        //webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(false)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
            }
        }
    webView.loadUrl(URL)
    }

    override fun onBackPressed() {
        if (webView != null && webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}