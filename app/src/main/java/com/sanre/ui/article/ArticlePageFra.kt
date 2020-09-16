package com.sanre.ui.article

import com.sanre.app.Param
import com.sanre.data.model.Article
import com.sanre.ui.base.PageFra

class ArticlePageFra : PageFra<Article>() {

    override fun initPageAdapter() {
        pageAdapter = ArticleAdapter()
    }

    override val pageSize = 10

    override fun loadPage(page: Int) =
        api.getArticle(page = page, pageSize = pageSize, category = arguments?.getString(Param))

}