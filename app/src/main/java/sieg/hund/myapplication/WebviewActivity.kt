package sieg.hund.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.*
import android.webkit.WebSettings.LOAD_DEFAULT
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {

    companion object {
        private val JAVASCRIPT_OBJ = "javascript_obj"
        //        private val BASE_URL = "https://www.google.com/"
        private val BASE_URL = "file:///android_asset/web/test.html"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        initContent()
    }

    fun initContent() {
        webview.settings.javaScriptEnabled = true
        webview.settings.domStorageEnabled = true
        webview.settings.cacheMode = LOAD_DEFAULT
        webview.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progress_bar.progress = newProgress
                if (newProgress == 100)
                    progress_bar.visibility = View.GONE
            }
        }
        webview.addJavascriptInterface(JavaScriptInterface(), JAVASCRIPT_OBJ)

        webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
//                if (url == BASE_URL)
                injectJavaScriptFunction()
            }
        }
        webview.loadUrl(BASE_URL)
    }

    private fun injectJavaScriptFunction() {
        webview?.loadUrl(
            "javascript: " +
                    "window.androidObj.textToAndroid = function(message) { " +
                    JAVASCRIPT_OBJ + ".textFromWeb(message) }"
        )
    }

    override fun onDestroy() {
        webview.removeJavascriptInterface(JAVASCRIPT_OBJ)
        super.onDestroy()
    }

    private inner class JavaScriptInterface {
        @JavascriptInterface
        fun textFromWeb(fromWeb: String) {
            Toast.makeText(this@WebviewActivity, fromWeb, Toast.LENGTH_SHORT).show()
        }
    }

}