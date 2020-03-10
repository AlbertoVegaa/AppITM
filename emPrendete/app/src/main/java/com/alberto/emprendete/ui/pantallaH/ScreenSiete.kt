package com.alberto.emprendete.ui.pantallaH
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
var url = "https://mystifying-nightingale-9c518c.netlify.com/00patrocinadores/"
class ScreenSiete : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.pantalla_h, container, false)
        val web=root.findViewById<WebView>(R.id.pagina)
        web.settings.javaScriptEnabled=true
        web.settings.setSupportZoom(false)
        web.webViewClient=object:WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
            }
        }
        web.loadUrl(url)
        return root
    }
}