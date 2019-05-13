package chapter01

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable


fun main(args: Array<String>) {
    val list = listOf<Any>("one", 2, "Three", "Four", 4.5, "Five", 6.0f)

    println("---------pull mechanism --------------")
    //pull mechanism
    var iterator = list.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("---------push mechanism with rxJava --------------")
    Observable.fromIterable(list)
            .subscribe(
                    { println(it) }, //onNext
                    { println(it.printStackTrace()) }, //onError
                    { println("Done") } //onComplete
            )
    println("---------push mechanism with rxKotlin --------------")
    list.toObservable()
            .subscribeBy(
                    onNext = { println(it) },
                    onError = { it.printStackTrace() },
                    onComplete = { "Done" }
            )


}
