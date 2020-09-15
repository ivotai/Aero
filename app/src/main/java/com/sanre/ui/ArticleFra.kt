package com.sanre.ui

import com.rxjava.rxlife.lifeOnMain
import com.sanre.R
import com.sanre.app.di.ComponentHolder
import com.sanre.ui.base.BaseFra

class ArticleFra : BaseFra(R.layout.ui_swipe_recycler) {

    override fun initViews() {
        super.initViews()

        ComponentHolder.appComponent.api()
            .getArticle(page = 1, pageSize = 5)
            .lifeOnMain(this)
            .subscribe({

            }, {

            })
    }

}