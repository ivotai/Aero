package com.sanre.ui.viewPager2.example1

import android.graphics.drawable.Drawable
import com.blankj.utilcode.util.ColorUtils
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.utils.colorRes
import com.mikepenz.iconics.utils.sizeDp
import com.sanre.R
import com.sanre.other.NormalItemView2
import com.sanre.other.icon.Fal
import com.sanre.other.icon.Fas
import com.sanre.ui.base.BaseFra
import kotlinx.android.synthetic.main.fra_viewpager21.*
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem


class ViewPager21Fra : BaseFra(R.layout.fra_viewpager21) {

    override fun initViews() {
        viewPager2.adapter = ViewPager21FragmentStateAdapter(this)

        val navigationController = tab.custom()
            .addItem(
                newItem(
                    Fal.Icon.fal_book,
                    Fas.Icon.fas_book,
                    "Book"
                )
            )
            .addItem(
                newItem(
                    Fal.Icon.fal_book_spells,
                    Fas.Icon.fas_book_spells,
                    "Spell"
                )
            )
            .addItem(
                newItem(
                    Fal.Icon.fal_book_medical,
                    Fas.Icon.fas_book_medical,
                    "Medical"
                )
            )
            .addItem(
                newItem(
                    Fal.Icon.fal_book_dead,
                    Fas.Icon.fas_book_dead,
                    "Dead"
                )
            )
            .build()
    }

    private fun newItem(iIcon: IIcon, checkedIIcon: IIcon, text: String): BaseTabItem {
        return newItem(
            IconicsDrawable(requireContext(), iIcon).apply {
                colorRes = R.color.grey_500
                sizeDp = 24
            },
            IconicsDrawable(requireContext(), checkedIIcon).apply {
                colorRes = R.color.blue_500
                sizeDp = 24
            },
            text
        )
    }

    private fun newItem(drawable: Drawable, checkedDrawable: Drawable, text: String): BaseTabItem {
        return NormalItemView2(context).apply {
            initialize(drawable, checkedDrawable, text)
            setTextDefaultColor(ColorUtils.getColor(R.color.grey_500))
            setTextCheckedColor(ColorUtils.getColor(R.color.blue_500))
        }
    }

}