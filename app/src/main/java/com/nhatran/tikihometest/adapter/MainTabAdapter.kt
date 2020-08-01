package com.nhatran.tikihometest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainTabAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private var fragmentList: ArrayList<Fragment> = arrayListOf()

    override fun getCount(): Int  = fragmentList.size

    override fun getItem(i: Int): Fragment {
        return fragmentList[i]
    }

    fun addTabItem(fragment: Fragment) {
        fragmentList.add(fragment)
    }
}
