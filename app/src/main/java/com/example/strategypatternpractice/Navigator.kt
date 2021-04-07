package com.example.strategypatternpractice

class Navigator {
    private var strategy: RouteStrategy = WalkingStarategy()

    public fun setRouteStrategy(strategy: RouteStrategy) {
        this.strategy = strategy
    }

    public fun getRouteMode(): String = strategy.getRouteMode()
}