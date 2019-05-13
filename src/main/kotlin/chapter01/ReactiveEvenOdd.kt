package chapter01

import io.reactivex.subjects.PublishSubject

fun main(args: Array<String>) {
    val subject: PublishSubject<Int> = PublishSubject.create()

    subject.map {
        isEven(it)
    }.subscribe {
        println("The number is ${if (it) {
            "Even"
        } else {
            "Odd"
        }}")
    }

    subject.onNext(4)
    subject.onNext(9)

}

fun isEven(number: Int): Boolean = (number % 2) == 0