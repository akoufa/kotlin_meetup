package com.kugstr.kotlinmeetupvol1.chapter_5

/**
 * Collections
 */

/* Unlike many languages, Kotlin distinguishes between mutable and immutable collections (lists, sets, maps, etc).
   Precise control over exactly when collections can be edited is useful for eliminating bugs,
   and for designing good APIs.
 */

val numbers: MutableList<Int> = mutableListOf(1, 2, 3)

// Just a subset of the methods available in MutableList interface
val immutableNumber: List<Int> = listOf(4,5,6)

fun useCollection(){

    println(numbers.get(2))

    // same as

    println(numbers[2])

    numbers.add(10)

    numbers.set(0, 100)
    numbers[0] = 100

    // method not available
    // immutableNumber.add(10)
}

val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)