# StrategyPatternPractice
전략패턴을 구현했다.

사실 각 전략이 다른 알고리즘을 구현해야하지만 편의상 그 모드만 출력하는 형식으로 구현했다.

# 패턴 설명
## 배경(Why)
지도앱을 구현하고 있다. 처음엔 출발지부터 도착지까지의 경로를 "걸어서"가는 요구사항만 있었다. 그 후에 **"대중교통", "자동차" 이런 선택지가 추가**되었다. 처음부터 switch case문을 이용해 Navigator 클래스에 모든 알고리즘을 구현했다면 어떻게 될까?

한 알고리즘의 수정은 곧 Navigator 클래스 수정을 의미하게 되고 에러를 발생하기 쉬워진다.(Navigator는 여러 행위를 구현하게 되어 _SRP를 위배_)

이렇게 한 클래스가 여러 방법을 제공하는 경우엔 어떻게 구현하는 게 좋을까?
## How
경로를 찾는 **알고리즘을** Navigator 클래스에서 **뽑아내 별도의 클래스**들(a.k.a. strategies)로 만들자! Strategy라는 Interface를 구현하고 Navigator 클래스는 뽑아낸 클래스에 대한 참조를 가져 **알고리즘 연산을 Strategy에 위임**하는 방법을 사용하자.

다만, Navigator가 참조할 전략 클래스는 Navigator 클래스가 고르는게 아니라 클라이언트가 적절한 전략 클래스를 전달해주는 방식이다. 따라서, Navigator(a.k.a. Context)는 strategies에 대해 많이 알지 않아도 된다! **즉, Context는 Concrete strategies로부터 독립이게 되어 새로운 알고리즘을 추가하거나 기존 알고리즘을 수정하는 것이 Context에 영향을 주지 않게 된다. 👉 _OCP 만족_**
## What
위와 같이 동작하는 Strategy Pattern 이란,
> 행위를 클래스로 캡슐화해 동적으로 행위를 자유롭게 바꿀 수 있게 하는 패턴이다.

![](https://images.velog.io/images/cchloe2311/post/506866d7-5692-4072-a428-2365df9d4685/image.png)
![](https://images.velog.io/images/cchloe2311/post/5b73e87d-f445-4030-b1ac-8afb63dc4a0e/image.png)

1. **Context**
Concrete Strategies 중 한 개에 대한 참조를 갖고 있으며 _Strategy Interface를 통해 그 객체와 communicate_
2. **Strategy**
Concrete Strategies의 _generic interface_로, Context에서 사용할 함수를 선언한다
3. **Concrete Strategies**
Context에서 사용하는 여러 _알고리즘(행위)을 구현_한다
4. Client가 Concrete Strategies 중 하나를 Context에 전달하므로 Context는 그에 대한 자세한 정보를 알고 있지 않다
5. **Client**
특정 전략을 객체를 Context에 전달해준다. _따라서, Context는 전략 객체 setter 클래스를 제공해야한다._
# ref.
https://refactoring.guru/design-patterns/strategy
