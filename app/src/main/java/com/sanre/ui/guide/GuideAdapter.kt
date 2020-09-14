package com.sanre.ui.guide

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ruffian.library.widget.RConstraintLayout
import com.sanre.R
import com.sanre.app.safeClicks
import com.sanre.app.toast
import com.sanre.data.model.Guide

class GuideAdapter : BaseQuickAdapter<Guide, BaseViewHolder>(R.layout.item_guide, Guide.all) {

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val viewHolder = super.onCreateDefViewHolder(parent, viewType)
        viewHolder.getView<RConstraintLayout>(R.id.root).safeClicks().subscribe {
            var position = viewHolder.adapterPosition
            if (position == RecyclerView.NO_POSITION) return@subscribe
            position -= headerLayoutCount
            val item = data[position]
            item.cn.toast()
        }
        return viewHolder
    }

    override fun convert(holder: BaseViewHolder, item: Guide) {
        holder.setText(R.id.tvCn, item.cn)
    }

}