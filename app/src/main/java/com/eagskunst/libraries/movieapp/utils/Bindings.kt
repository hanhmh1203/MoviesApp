package com.eagskunst.libraries.movieapp.utils

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.eagskunst.libraries.movieapp.app.models.CategoryCard
import com.eagskunst.libraries.movieapp.utils.enums.Grid
import com.eagskunst.libraries.movieapp.utils.enums.LayoutManagerTypes
import com.eagskunst.libraries.movieapp.utils.enums.Linear
import com.google.android.material.card.MaterialCardView
import com.skydoves.rainbow.Rainbow
import com.skydoves.rainbow.RainbowOrientation
import com.skydoves.rainbow.contextColor

/**
 * Created by eagskunst in 30/11/2019.
 */

@BindingAdapter("app:cardGradient")
fun applyRainbowGradient(view: MaterialCardView, model: CategoryCard){
    Log.d("Check", "Radius: ${view.radius.toInt() / 2}")
    Rainbow(view).palette {
        model.colors.forEach { +contextColor(it) }
    }.background(
        orientation = RainbowOrientation.LEFT_RIGHT,
        radius = view.radius.toInt() / 2
    )
}

@BindingAdapter("app:loadImage")
fun loadImageWithGlide(view: ImageView, url: String?) = view.loadImageWithGlide(url)

@BindingAdapter("app:attachEpoxyController")
fun attachEpoxyController(epoxyRv: EpoxyRecyclerView, controller: EpoxyController) =
    epoxyRv.setController(controller)

@BindingAdapter("app:epoxyLayoutManager")
fun setLayoutManager(epoxyRv: EpoxyRecyclerView, layoutType: LayoutManagerTypes) {
    when (layoutType) {
        Grid -> epoxyRv.layoutManager = GridLayoutManager(epoxyRv.context, 2)
        Linear -> {//Default already is Linear}
        }
    }
}
