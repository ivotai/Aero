package com.sanre.ui.base

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.rxjava.rxlife.lifeOnMain
import com.sanre.R
import com.sanre.app.toast
import com.sanre.data.model.Page
import com.sanre.data.model.Response
import com.sanre.other.KotlinViewHolder
import io.reactivex.rxjava3.core.Single
import kotlinx.android.synthetic.main.ui_swipe_recycler.*

abstract class PageFra<T>(@LayoutRes contentLayoutId: Int = R.layout.ui_swipe_recycler) :
    BaseFra(contentLayoutId = contentLayoutId) {

    abstract fun initPageAdapter()

    abstract fun loadPage(page: Int): Single<Response<Page<T>>>

    protected lateinit var pageAdapter: BaseQuickAdapter<T, KotlinViewHolder>

    private val loadMoreModule get() = pageAdapter.loadMoreModule

    private val startPage = 1

    protected open val pageSize = 5

    private val size
        get() = pageAdapter.data.size

    private val nextPage
        get() = size / pageSize + startPage

    override fun initViews() {
        initSwipeRefreshLayout()
        initRecyclerView()
        initLoadMoreModule()
    }

    private fun initSwipeRefreshLayout() {
        mSwipeRefreshLayout.run {
            setColorSchemeResources(R.color.white)
            setProgressBackgroundColorSchemeResource(R.color.blue_500)
        }
    }

    private fun initRecyclerView() {
        mRecyclerView.run {
            layoutManager = LinearLayoutManager(context)
            initPageAdapter()
            adapter = pageAdapter
        }
    }

    private fun initLoadMoreModule() {
        loadMoreModule.run {
            // do nothing
        }
    }

    override fun initBindings() {
        mSwipeRefreshLayout.setOnRefreshListener { loadStartPage() }
        loadMoreModule.setOnLoadMoreListener { loadNextPage() }
        loadStartPage()
    }

    private fun loadStartPage() {
        mSwipeRefreshLayout.isRefreshing = true
        loadPage(startPage)
            .lifeOnMain(this)
            .subscribe({
                mSwipeRefreshLayout.isRefreshing = false
                if (it.failed) return@subscribe
                pageAdapter.setList(it.data.content)
                checkIsLoadAll(it.data)
            }, {
                mSwipeRefreshLayout.isRefreshing = false
                it.message?.toast()
            })
    }

    private fun loadNextPage() {
        loadPage(nextPage)
            .lifeOnMain(this)
            .subscribe({
                if (it.failed) return@subscribe
                pageAdapter.addData(it.data.content)
                loadMoreModule.loadMoreComplete()
                checkIsLoadAll(it.data)
            }, {
                loadMoreModule.loadMoreFail()
                it.message?.toast()
            })
    }

    private fun checkIsLoadAll(pageResponse: Page<T>) {
        val isLoadAll = size == pageResponse.totalElements.toInt()
        if (isLoadAll) loadMoreModule.loadMoreEnd()
    }

    protected open val mRecyclerView: RecyclerView get() = recyclerView

    protected open val mSwipeRefreshLayout: SwipeRefreshLayout get() = swipeRefreshLayout

}