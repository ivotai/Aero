package com.sanre.ui.vp2.article

import com.sanre.app.Param
import com.sanre.app.di.ComponentHolder
import com.sanre.data.model.Article
import com.sanre.ui.base.PageFra

class ArticleFra : PageFra<Article>() {

    override val pageSize = 10

    override fun initPageAdapter() {
        pageAdapter = ArticleAdapter()
    }

    override fun loadPage(page: Int) =
        ComponentHolder.appComponent.api()
            .getArticle(page = page, pageSize = pageSize, category = category)

    private val category by lazy { arguments?.getString(Param) }

}