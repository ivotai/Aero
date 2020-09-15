package com.sanre.ui.guide

import androidx.recyclerview.widget.LinearLayoutManager
import com.sanre.R
import com.sanre.app.Globals.logined
import com.sanre.app.RxBus
import com.sanre.app.startAct
import com.sanre.data.event.LogoutEvent
import com.sanre.ui.base.BaseFra
import com.sanre.ui.login.LoginAct
import kotlinx.android.synthetic.main.ui_title_recycler.*

class GuideFra : BaseFra(R.layout.ui_title_recycler) {

    private val guideAdapter = GuideAdapter()
    override fun initViews() {
        titleBar.setTitle(title = "导航", allowBack = false)
        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = guideAdapter
        }
    }

    override fun initEvents() {
        RxBus.registerEvent(this, LogoutEvent::class.java, {
            logined = false
            startAct(cls = LoginAct::class.java, finishSelf = true)
        })
    }

}