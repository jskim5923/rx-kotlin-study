package chapter03

import io.reactivex.rxkotlin.toObservable

fun main() {
    val connectableObservable = listOf("String 1", "String 2", "String 3", "String 4", "String 5")
        .toObservable()
        .publish()

    connectableObservable.subscribe { println("Subscription 1: $it") }

    connectableObservable.map(String::reversed)
        .subscribe { println("Subscription 2: $it") }

    connectableObservable.connect()
    connectableObservable.subscribe { println("Subscription #3: $it") }
}