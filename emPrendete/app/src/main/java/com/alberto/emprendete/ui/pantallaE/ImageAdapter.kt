package com.alberto.emprendete.ui.pantallaE

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.alberto.emprendete.R


class ImageAdapter (private val mContext:Context):PagerAdapter(){
    companion object{
        val mImageArray = arrayOf(R.drawable.icon_proyectos, R.drawable.icon_equipos, R.drawable.icon_instituciones)
    }
    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == any
    }
    override fun getCount(): Int {
        return mImageArray.size
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mImageView=ImageView(mContext)
        mImageView.scaleType=ImageView.ScaleType.CENTER_CROP
        mImageView.setImageResource(mImageArray[position])
        container.addView(mImageView,0)
        return mImageView
    }
    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView(any as View?)
    }
}