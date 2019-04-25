package glenn.clappingape.lazywebview.presenter

import android.content.Context
import android.webkit.CookieManager
import glenn.clappingape.lazywebview.view.LazyWebViewInterface


class LwvPrensenter(
    val view: LazyWebViewInterface,
    val context: Context,
    val interact: LazyWebviewFunctionInterface
) {
    var url = ""
    var sessionString = ""

    init {
        initContent()
    }

    fun initContent() {

    }

    fun initializeWebview(url: String) {
        this.url = url
        view.loadWeb(url)
    }

    fun addCookies(cookieContent: String) {
        var cookieMan = CookieManager.getInstance()
        cookieMan.setAcceptCookie(true)

        var cookies: String? = cookieMan.getCookie(url)
        if (cookies != null)
            cookies += ";$cookieContent"
        else
            cookies = cookieContent

        cookieMan.setCookie(url, cookies)
    }
}