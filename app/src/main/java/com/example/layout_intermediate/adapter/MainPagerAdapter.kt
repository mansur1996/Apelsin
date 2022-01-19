package com.example.layout_intermediate.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.layout_intermediate.R
import com.example.layout_intermediate.model.Page

class MainPagerAdapter(val pages : List<Page>, val mcontext: Context) : PagerAdapter(){


    @SuppressLint("ServiceCast")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.item_pager, container, false)

        view.findViewById<TextView>(R.id.tv_title).text = pages[position].title
        view.findViewById<TextView>(R.id.tv_description).text = pages[position].description

        (container as ViewPager).addView(view)
        return view
    }

    override fun getCount(): Int = pages.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }

}