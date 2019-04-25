package glenn.clappingape.lazywebview.view

interface LazyWebViewInterface {

    fun loadWeb(url: String)
    fun initJavascriptInterface(code: String)
    fun setInterface()
    fun triggerJavascrip(script: String)
}