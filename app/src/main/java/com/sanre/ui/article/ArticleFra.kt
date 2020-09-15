package com.sanre.ui.article

import androidx.recyclerview.widget.LinearLayoutManager
import com.rxjava.rxlife.lifeOnMain
import com.sanre.R
import com.sanre.app.di.ComponentHolder
import com.sanre.ui.base.BaseFra
import kotlinx.android.synthetic.main.ui_title_recycler.*

class ArticleFra : BaseFra(R.layout.ui_swipe_recycler) {

    private val articleAdapter = ArticleAdapter()

    override fun initViews() {
        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            hasFixedSize()
            adapter = articleAdapter
        }

        ComponentHolder.appComponent.api()
            .getArticle(page = 1, pageSize = 5)
            .lifeOnMain(this)
            .subscribe({
                    articleAdapter.setList(it.data.content)
            }, {

            })
    }

}