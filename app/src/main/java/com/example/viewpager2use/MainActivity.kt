package com.example.viewpager2use

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
    }

    private fun setAdapter() {
        //设置滑动方向，可为横向和纵向
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //设置滑动事件监听
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

        //设置adapter
        viewpager.adapter = ViewPager2Adapter(this, datas)

        viewpager.offscreenPageLimit = 1
        var recyclerView = viewpager.getChildAt(0) as RecyclerView
        var padding = 80
        recyclerView.setPadding(padding, 0, padding, 0)
        recyclerView.clipToPadding = false

//        //设置页面间距
        viewpager.setPageTransformer(MarginPageTransformer(20))
//
//        //禁止滑动
//        viewpager.setUserInputEnabled(false)
//
//        //模拟拖拽
//        viewpager.beginFakeDrag()
    }
}