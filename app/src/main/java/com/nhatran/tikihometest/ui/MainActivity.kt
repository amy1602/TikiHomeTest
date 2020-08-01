package com.nhatran.tikihometest.ui

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nhatran.tikihometest.R
import com.nhatran.tikihometest.adapter.MainTabAdapter

class MainActivity : AppCompatActivity() {

    var tabLayout: TabLayout ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager:ViewPager = findViewById(R.id.view_pager)
        val adapter = MainTabAdapter(supportFragmentManager)
        tabLayout = findViewById(R.id.tab_container)

        adapter.addTabItem(HomeFragment())
        adapter.addTabItem(Fragment())
        adapter.addTabItem(Fragment())
        adapter.addTabItem(Fragment())
        adapter.addTabItem(Fragment())

        viewPager.adapter = adapter
        tabLayout?.setupWithViewPager(viewPager)

        addTabView(0, R.drawable.ic_home, getString(R.string.str_home))
        addTabView(1, R.drawable.ic_dashboard, getString(R.string.str_items))
        addTabView(2, R.drawable.ic_search, getString(R.string.str_search))
        addTabView(3, R.drawable.ic_notification,  getString(R.string.str_noti))
        addTabView(4, R.drawable.ic_profile, getString(R.string.str_profile))

        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {}

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                (p0?.customView as TabItemView).onTabUnselected()
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                (p0?.customView as TabItemView).onTabSelected()
            }
        })

        (tabLayout?.getTabAt(0)?.customView as TabItemView).onTabSelected()
    }

    private fun addTabView(index: Int, icon : Int, title: String) {
        tabLayout?.let {
            val tabCustomView = TabItemView(baseContext, icon = icon, title = title)
            tabLayout!!.getTabAt(index)?.customView = tabCustomView
        }
    }
}