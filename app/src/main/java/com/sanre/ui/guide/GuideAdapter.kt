package com.sanre.ui.guide

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.sanre.R
import com.sanre.app.RxBus
import com.sanre.app.safeClicks
import com.sanre.app.startAct
import com.sanre.data.event.LogoutEvent
import com.sanre.data.model.Guide
import com.sanre.other.KotlinViewHolder
import kotlinx.android.synthetic.main.item_guide.*

class GuideAdapter : BaseQuickAdapter<Guide, KotlinViewHolder>(R.layout.item_guide, Guide.all) {

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): KotlinViewHolder {
        val viewHolder = super.onCreateDefViewHolder(parent, viewType)
        viewHolder.root.safeClicks().subscribe {
            var position = viewHolder.adapterPosition
            if (position == RecyclerView.NO_POSITION) return@subscribe
            position -= headerLayoutCount
            val item = data[position]
            when (item) {
                Guide.ViewPager21 -> context.startAct(item.cls)
                Guide.Logout -> RxBus.post(LogoutEvent())
            }
        }
        return viewHolder
    }

    override fun convert(holder: KotlinViewHolder, item: Guide) {
        holder.tvCn.text = item.cn
    }

}