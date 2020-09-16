package com.sanre.ui.example1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sanre.app.Param
import com.sanre.ui.article.ArticlePageFra

class Example1FragmentStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = titles.size

    override fun createFragment(position: Int): Fragment = ArticlePageFra().apply {
        val bundle = Bundle()
        bundle.putString(Param, categories[position])
        arguments = bundle
    }

    companion object {
        val titles = listOf("政策规定", "工作动态", "学习资料", "专题研究", "技术标准")
        val categories = listOf("zcgd", "gzdt", "xxzl", "ztyj", "jsbz")
    }

}