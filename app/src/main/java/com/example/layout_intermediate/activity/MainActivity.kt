package com.example.layout_intermediate.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import com.example.layout_intermediate.R
import com.example.layout_intermediate.adapter.MainPagerAdapter
import com.example.layout_intermediate.model.Page
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager
    private lateinit var pages : ArrayList<Page>
    private lateinit var mainPagerAdapter : MainPagerAdapter
    private lateinit var mainTab : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pages = addPages()

        initViews()
    }

    private fun initViews(){
        viewPager = findViewById(R.id.vp_main)
        mainTab = findViewById(R.id.tab_main)

        mainPagerAdapter = MainPagerAdapter(pages, this)

        viewPager.adapter = mainPagerAdapter
        mainTab.setupWithViewPager(viewPager)
    }

    private fun  addPages() : ArrayList<Page>{
        return ArrayList<Page>().apply {
            for(i in 0..5){
                this.add(Page("Title", "Description"))
            }
        }
    }
}