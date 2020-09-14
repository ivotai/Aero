package com.sanre.ui.guide

import androidx.recyclerview.widget.LinearLayoutManager
import com.rxjava.rxlife.lifeOnMain
import com.sanre.R
import com.sanre.app.Globals.logined
import com.sanre.app.RxBus
import com.sanre.app.startAct
import com.sanre.data.event.LogoutEvent
import com.sanre.ui.base.BaseFra
import com.sanre.ui.login.LoginAct
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Consumer
import kotlinx.android.synthetic.main.ui_title_recycler.*
import java.util.concurrent.TimeUnit

class GuideFra : BaseFra(R.layout.ui_title_recycler) {

    override fun initViews() {
        titleBar.setTitle(title = "导航", allowBack = false)
        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = GuideAdapter()
        }

//        fetchData()
    }

    override fun initEvents() {
        RxBus.registerEvent(this, LogoutEvent::class.java, Consumer {
            logined = false
            startAct(cls = LoginAct::class.java, finishAct = true)
        })
    }

    private fun fetchData() {
        // 模拟网络耗时操作
        Observable.interval(1, TimeUnit.SECONDS)
//            .observeOn(AndroidSchedulers.mainThread())
            .lifeOnMain(this)
            .subscribe {
                titleBar.setTitle(it.toString())
            }
    }

}