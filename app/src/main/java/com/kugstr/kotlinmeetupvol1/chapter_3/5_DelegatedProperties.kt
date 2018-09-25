package com.kugstr.kotlinmeetupvol1.chapter_3

import kotlin.properties.Delegates

/**
 * Standard Delegates
 */

/**
 * Lazy
 */

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

fun lazyDelegate() {
    // Question
    // What will be printed here?
    println(lazyValue)
    println(lazyValue)
}

/**
 * Observable
 */

class SomeUser {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("$old -> $new")
    }
}

// If you want to be able to intercept an assignment and "veto" it, use vetoable() instead of observable().