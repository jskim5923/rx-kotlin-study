package chapter03

import io.reactivex.rxkotlin.toObservable

fun main() {
    val connectableObservable = listOf("String 1", "String 2", "String 3", "String 4", "String 5")
            .toObservable()
            .publish()

    connectableObservable
}