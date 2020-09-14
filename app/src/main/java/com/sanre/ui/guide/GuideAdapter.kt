package com.sanre.ui.guide

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ruffian.library.widget.RConstraintLayout
import com.sanre.R
import com.sanre.app.safeClicks
import com.sanre.app.toast
import com.sanre.data.model.Guide
import com.sanre.other.KotlinViewHolder
import kotlinx.android.synthetic.main.item_guide.*

class GuideAdapter : BaseQuickAdapter<Guide, KotlinViewHolder>(R.layout.item_guide, Guide.all) {

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): KotlinViewHolder =
        super.onCreateDefViewHolder(parent, viewType).apply {
            getView<RConstraintLayout>(R.id.root).safeClicks().subscribe {
                var position = adapterPosition
                if (position == RecyclerView.NO_POSITION) return@subscribe
                position -= headerLayoutCount
                val item = data[position]

                // real
                when(item){
                }
                item.cn.toast()
            }
        }

    override fun convert(holder: KotlinViewHolder, item: Guide) {
        holder.tvCn.text = item.cn
    }

}