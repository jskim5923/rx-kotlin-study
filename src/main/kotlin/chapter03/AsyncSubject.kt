package chapter03

import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject

fun main() {
    val observable = Observable.just(1, 2, 3, 4)
    val subject = AsyncSubject.create<Int>()
    observable.subscribe(subject)

    subject.subscribe(
        //onNext
        { println("Received $it") },

        //onError
        { println("Error Occured ${it.message}") },

        //onComplete
        { println("All Complete") }
    )

    subject.onComplete()
}