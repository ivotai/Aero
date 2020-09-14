package com.sanre.ui.guide

import androidx.recyclerview.widget.LinearLayoutManager
import com.sanre.R
import com.sanre.ui.base.BaseFra
import kotlinx.android.synthetic.main.ui_title_recycler.*

class GuideFra : BaseFra(R.layout.ui_title_recycler) {

    override fun initViews() {
        titleBar.setTitle(title = "导航", allowBack = false)
        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = GuideAdapter()
        }

    }

}