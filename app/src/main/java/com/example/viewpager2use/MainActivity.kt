package com.example.viewpager2use

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
    }

    private fun setAdapter() {
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                Toast.makeText(applicationContext, "切换到 $position 页", Toast.LENGTH_SHORT).show()
            }
        })
        var datas = ArrayList<Int>()
        datas.add(R.mipmap.page1)
        datas.add(R.mipmap.page2)
        datas.add(R.mipmap.page3)
        viewpager.adapter = ViewPager2Adapter(this, datas)
    }
}