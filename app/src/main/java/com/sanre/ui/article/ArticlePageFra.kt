package com.sanre.ui.article

import com.sanre.app.Param
import com.sanre.data.model.Article
import com.sanre.data.model.Page
import com.sanre.data.model.Response
import com.sanre.ui.base.PageFra
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class ArticlePageFra : PageFra<Article>() {

    override fun initPageAdapter() {
        pageAdapter = ArticleAdapter()
    }

    override val pageSize = 5

    override fun loadPage(page: Int): Single<Response<Page<Article>>> =
        api.getArticle(page = page, pageSize = pageSize, category = arguments?.getString(Param))
            .delay(2, TimeUnit.SECONDS)

}