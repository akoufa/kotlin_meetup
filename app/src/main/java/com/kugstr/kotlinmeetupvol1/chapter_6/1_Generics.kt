package com.kugstr.kotlinmeetupvol1.chapter_6

/**
 * Generics
 */

class Box<T>(t: T) {
    var value = t
}

fun generics1(){
    val box: Box<Int> = Box<Int>(1)
    // But if the parameters may be inferred

    val box2 = Box(1) // 1 has type Int, so the compiler figures out that we are talking about Box<Int>
}

/**
 * Variance
 */

// declaration-site variance and type projections

// Hint go to Java file Generics_Java


// The general rule is: when a type parameter T of a class C is declared out, it may occur only in out-position
interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // This is OK, since T is an out-parameter
    // ...
}

/**
 * Use-site variance: Type projections
 */

// Array<T> is invariant in T (no out or in)

fun badCopy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices){
        to[i] = from[i]
    }
}

// This function is supposed to copy items from one array to another.
// Let's try to apply it in practice:

fun generics2(){
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    // badCopy(ints, any) // Error does not compile type is Array<Int> but Array<Any> was expected
}

fun goodCopy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices){
        to[i] = from[i]
    }
}

fun generics3(){
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    goodCopy(ints, any)
}

/**
 * Generic functions
 */

fun <T> singletonList(item: T): List<T> {
    // ...

    return listOf()
}

fun <T> T.basicToString() : String {  // extension function
    // ...
    return ""
}

/**
 * Generic constraints
 */

fun <T : Comparable<T>> sort(list: List<T>) { }

fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }.toList()
}