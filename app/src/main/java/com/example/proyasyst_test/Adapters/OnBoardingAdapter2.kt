package com.example.proyasyst_test.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.proyasyst_test.MainActivity
import com.example.proyasyst_test.R

class OnBoardingAdapter2(mainActivity: MainActivity) : PagerAdapter() {

    val context: Context? = null
    var layoutInflater: LayoutInflater? = null

    /*fun OnBoardingAdapter2(context: Context) {
        this.context = context
    }*/

    private val titles = intArrayOf(
        R.string.titulo1,
        R.string.titulo2,
        R.string.titulo3,
        R.string.titulo4
    )

    private val subtitles = intArrayOf(
        R.string.subtitulo1,
        R.string.subtitulo2,
        R.string.subtitulo3,
        R.string.subtitulo4
    )

    private val images = intArrayOf(
        R.drawable.img_logoc,
        R.drawable.alarma1,
        R.drawable.img_abeja,
        R.drawable.asyst_icon12
    )

    val bg = intArrayOf(
        R.drawable.bg2,
        R.drawable.bg3,
        R.drawable.bg1,
        R.drawable.bg4
    )

    override fun getCount(): Int {
        return titles.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = layoutInflater!!.inflate(R.layout.slide, container, false)
        val image = v.findViewById<ImageView>(R.id.slideImg)
        val title = v.findViewById<TextView>(R.id.slidesubTitle)
        val subtitle = v.findViewById<TextView>(R.id.slidesubTitle)
        val layout = v.findViewById<ConstraintLayout>(R.id.slideLayout)
        image.setImageResource(images[position])
        title.setText(titles[position])
        subtitle.setText(subtitles[position])
        layout.setBackgroundResource(position)
        container.addView(v)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}