package com.sanre.ui.guide

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sanre.R
import com.sanre.data.model.Guide

class GuideAdapter : BaseQuickAdapter<Guide, BaseViewHolder>(R.layout.item_guide, Guide.all) {

    override fun convert(holder: BaseViewHolder, item: Guide) {
        holder.setText(R.id.tvCn, item.cn)
    }

}