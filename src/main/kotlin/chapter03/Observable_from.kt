package chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

fun main() {
    val observer: Observer<String> = object:Observer<String> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }

        override fun onNext(t: String) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }
    }

    val list = listOf("String 1", "String 2", "String 3", "String 4")
    val observableFromIterable = Observable.fromIterable(list)
    observableFromIterable.subscribe(observer)

    val callable = Callable<String> { "From Callable" }

    val observableFromCallable = Observable.fromCallable(callable)
    observableFromCallable.subscribe(observer)

    val future = object:Future<String> {
        override fun isDone(): Boolean  = true
        override fun get(): String = "Hello From Future"

        override fun get(timeout: Long, unit: TimeUnit?): String = "Hello From Future"

        override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false

        override fun isCancelled(): Boolean = false
    }

    val observerFromFuture = Observable.fromFuture(future)
    observerFromFuture.subscribe(observer)
}