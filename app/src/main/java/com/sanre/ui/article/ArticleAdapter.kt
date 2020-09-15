package com.sanre.ui.article

import com.chad.library.adapter.base.BaseQuickAdapter
import com.sanre.R
import com.sanre.app.toDisplayFormat
import com.sanre.data.model.Article
import com.sanre.other.KotlinViewHolder
import kotlinx.android.synthetic.main.item_article.*

class ArticleAdapter : BaseQuickAdapter<Article, KotlinViewHolder>(R.layout.item_article) {

//    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): KotlinViewHolder {
//        val viewHolder = super.onCreateDefViewHolder(parent, viewType)
//        viewHolder.root.safeClicks().subscribe {
//            var position = viewHolder.adapterPosition
//            if (position == RecyclerView.NO_POSITION) return@subscribe
//            position -= headerLayoutCount
//            val item = data[position]
//            when (item) {
//                Guide.ViewPager21 -> context.startAct(item.cls)
//                Guide.Logout -> RxBus.post(LogoutEvent())
//            }
//        }
//        return viewHolder
//    }

    override fun convert(holder: KotlinViewHolder, item: Article) {
        holder.run {
            tvTitle.text = item.title
            tvPublishTime.text = item.publishTime.toDisplayFormat()
        }
    }

}