package glenn.clappingape.lazywebview.view

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import glenn.clappingape.lazywebview.R
import glenn.clappingape.lazywebview.presenter.LwvPrensenter

class LazyWebviewActivity(val presenter: LwvPrensenter) : LazyWebViewInterface, AppCompatActivity() {

    override fun loadWeb(url: String) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initJavascriptInterface(code: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setInterface() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun triggerJavascrip(script: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedatInstanceSte: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
//        setContentView(R.layout.xx)
    }
}