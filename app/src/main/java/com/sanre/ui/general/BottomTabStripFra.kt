package com.sanre.ui.general

import com.sanre.R
import com.sanre.ui.base.BaseFra
import kotlinx.android.synthetic.main.fra_bottom_tab_strip.*

class BottomTabStripFra :BaseFra(R.layout.fra_bottom_tab_strip){

    override fun initViews() {
        viewPager2.adapter = BottomTabStripPagerAdapter(this)
    }

}