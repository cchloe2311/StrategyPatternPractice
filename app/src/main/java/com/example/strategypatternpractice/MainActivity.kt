package com.example.strategypatternpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // clinet 에서 적절한 전략을 Context에 전달
    fun setWalkingMode(v: View) {
        navigator.setRouteStrategy(WalkingStarategy())
    }

    fun setPublicTransportMode(v: View) {
        navigator.setRouteStrategy(PublicTransportStrategy())
    }

    fun setRoadMode(v: View) {
        navigator.setRouteStrategy(RoadStrategy())
    }

    fun printMode(v: View) {
        tv_mode.text = navigator.getRouteMode()
    }
}