package chapter03

import io.reactivex.rxkotlin.toObservable

fun main() {
    val observable = listOf("String 1", "String 2", "String 3").toObservable()

    observable.subscribe(
            { println("Received $it") },
            { println("Error ${it.message}") },
            { println("Done") }
    )

    observable.subscribe(
            { println("Received $it") },
            { println("Error ${it.message}") },
            { println("Done") }
    )
}