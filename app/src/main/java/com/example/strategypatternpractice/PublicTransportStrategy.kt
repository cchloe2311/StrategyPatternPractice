package com.example.strategypatternpractice

// 각 ConcreteStrategy 클래스는 generic interface 내 메소드를 그에 맞게 구현함
class PublicTransportStrategy: RouteStrategy {

    override fun getRouteMode(): String = "public transport"
}