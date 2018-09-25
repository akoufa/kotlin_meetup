package com.kugstr.kotlinmeetupvol1.chapter_6

/**
 * Nothing
 */

// Nothing is a type in Kotlin that represents “a value that never exists”,
// that means just “no value at all”.


// Hint show reportError in Nothing_Java

// reportError() in Kotlin:

fun reportError(): Nothing {
    throw RuntimeException()
}

var i = 0
fun exampleOne() {
    reportError() // throws RuntimeException
    i = 1 // We will get an 'Unreachable code' warning here.
}

fun exampleTwo(map: Map<String, String>) {

    val data: String = map["key"] ?: reportError() // Compiles! Note the type is String.
}

fun exampleThree(n: Int): String {
    if (n > 5) {
        return "Ok"
    }
    reportError() // throws RuntimeException
    // Compiles!
}