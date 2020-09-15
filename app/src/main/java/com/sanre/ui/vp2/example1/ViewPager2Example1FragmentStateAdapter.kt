package com.sanre.ui.vp2.example1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sanre.app.Param
import com.sanre.ui.TextFra

class ViewPager2Example1FragmentStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return TextFra().apply {
            val bundle = Bundle()
            bundle.putString(Param, titles[position])
            arguments = bundle
        }
    }

    companion object {
        val titles = listOf("Book", "Spell", "Medical", "Dead")
    }

}