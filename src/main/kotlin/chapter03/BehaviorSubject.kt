package chapter03

import io.reactivex.subjects.BehaviorSubject

fun main() {
    val subject = BehaviorSubject.create<Int>()
    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)
    subject.onNext(4)

    subject.subscribe(
        { println("S1 Received $it") },
        { println("S1 Error occured ${it.message}") },
        { println("S1 Completed") }
    )

    subject.onNext(5)

    subject.subscribe(
        { println("S2 Received $it") },
        { println("S2 Error occured ${it.message}") },
        { println("S2 Completed") }
    )

    subject.onComplete()
}