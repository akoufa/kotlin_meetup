package com.kugstr.kotlinmeetupvol1.chapter_3

/**
 * Object expression aka Anonymous "Class"
 */

/*
window.addMouseListener(object : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) { ... }

    override fun mouseEntered(e: MouseEvent) { ... }
})
 */

/**
 * Object Declarations the Singleton
 */

// Singleton may be useful in several cases, and Kotlin (after Scala)
// makes it easy to declare singletons:

// Lazy initialization
// Thread Safety

object BestSingletonEver {

    fun doSomehing(){}
}

fun useObject(){

    // As a "static" method in Java cause it's a Singleton
    BestSingletonEver.doSomehing()
}

// https://android.jlelse.eu/not-so-singletons-in-kotlin-f5a635c19d