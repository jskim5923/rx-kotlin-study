package chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    runBlocking {
        val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
        val observer = object: Observer<Long> {
            private lateinit var disposable:Disposable
            override fun onComplete() {
                println("All Complete")
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(t: Long) {
                println("Received $t")
                if (t >= 10 && !disposable.isDisposed) {
                    disposable.dispose()
                    println("Disposed")
                }
            }

            override fun onError(e: Throwable) {
                println("Error Occured ${e.message}")
            }
        }

        observable.subscribe(observer)
        delay(1500)
    }
}