package com.sanre.ui.example1

import android.graphics.drawable.Drawable
import com.blankj.utilcode.util.ColorUtils
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.utils.colorInt
import com.mikepenz.iconics.utils.sizeDp
import com.sanre.R
import com.sanre.app.removeEdgeEffect
import com.sanre.data.model.Guide
import com.sanre.other.NormalItemView2
import com.sanre.other.icon.Fal
import com.sanre.other.icon.Fas
import com.sanre.ui.base.BaseAct
import com.sanre.ui.base.BaseFra
import kotlinx.android.synthetic.main.fra_example1.*

class Example1Fra : BaseFra(R.layout.fra_example1) {

    override fun initViews() {
        titleBar.setTitle(Guide.Example1.cn)
        initViewPager2()
        initTab()
    }

    private fun initViewPager2() = viewPager2.run {
        removeEdgeEffect()
        isUserInputEnabled = false
        offscreenPageLimit = Example1FragmentStateAdapter.titles.size - 1
        adapter = Example1FragmentStateAdapter(this@Example1Fra)
    }

    private fun initTab() {
        val titles = Example1FragmentStateAdapter.titles
        val navigationController = tab.custom()
            .addItem(
                newItem(
                    Fal.Icon.fal_book,
                    Fas.Icon.fas_book,
                    titles[0]
                )
            )
            .addItem(
                newItem(
                    Fal.Icon.fal_book_spells,
                    Fas.Icon.fas_book_spells,
                    titles[1]
                )
            )
            .addItem(
                newItem(
                    Fal.Icon.fal_book_medical,
                    Fas.Icon.fas_book_medical,
                    titles[2]
                )
            )
            .addItem(
                newItem(
                    Fal.Icon.fal_book_dead,
                    Fas.Icon.fas_book_dead,
                    titles[3]
                )
            )
            .addItem(
                newItem(
                    Fal.Icon.fal_bible,
                    Fas.Icon.fas_bible,
                    titles[4]
                )
            )
            .build()
        navigationController.addSimpleTabItemSelectedListener { index, _ ->
            viewPager2.setCurrentItem(index, false)
        }
    }

    private fun newItem(defaultIIcon: IIcon, checkedIIcon: IIcon, text: String) = newItem(
        IconicsDrawable(requireContext(), defaultIIcon).apply {
            colorInt = defaultColor
            sizeDp = 24
        },
        IconicsDrawable(requireContext(), checkedIIcon).apply {
            colorInt = checkedColor
            sizeDp = 24
        },
        text
    )

    private fun newItem(
        defaultDrawable: Drawable,
        checkedDrawable: Drawable,
        text: String
    ) = NormalItemView2(context).apply {
        initialize(defaultDrawable, checkedDrawable, text)
        setTextDefaultColor(defaultColor)
        setTextCheckedColor(checkedColor)
    }

    private val defaultColor = ColorUtils.getColor(R.color.grey_700)
    private val checkedColor = ColorUtils.getColor(R.color.blue_500)

}

class Example1Act : BaseAct() {

    override fun createFragment() = Example1Fra()

}