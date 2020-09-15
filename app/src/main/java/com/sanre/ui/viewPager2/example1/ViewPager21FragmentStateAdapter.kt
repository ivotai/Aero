package com.sanre.ui.viewPager2.example1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sanre.app.Param
import com.sanre.ui.TextFra

class ViewPager21FragmentStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return TextFra().apply {
            val list = listOf("Book", "Spell", "Medical", "Dead")
            val text = list[position]
            val bundle = Bundle()
            bundle.putString(Param, text)
            arguments = bundle
        }
    }

}