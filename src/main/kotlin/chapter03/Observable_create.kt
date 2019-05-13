package chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {
    val observer: Observer<String> = object: Observer<String> {
        override fun onComplete() {
            println("All completed")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }

        override fun onNext(t: String) {
            println("Nest $t")
        }

        override fun onError(e: Throwable) {
            println("Error occured ${e.message}")
        }
    }

    val observable:Observable<String> = Observable.create {
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onComplete()
    }

    observable.subscribe(observer)


    val observable2:Observable<String> = Observable.create<String>{
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onError(Exception("My Custom Exception"))
    }
    observable2.subscribe(observer)
}