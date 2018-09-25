package com.kugstr.kotlinmeetupvol1.chapter_4

import com.kugstr.kotlinmeetupvol1.helpers.aListOfInts

// Kotlin functions are first-class, which means that they can be stored in variables and data structures,
// passed as arguments to and returned from other higher-order functions.

/**
 * Function types
 */

lateinit var func1: (Int, String) -> String

lateinit var func2: () -> Unit

lateinit var func3: () -> String?

lateinit var func4: (Int?) -> Int

// The whole function type is nullable so I can
var func5: ((Int?) -> String)? = null

/**
 * Invoking a function type instance
 */

fun testFuncTypes1(func: (Int, String) -> String) {

    func(10, "some string")

    // actually the above is this:
    func.invoke(10, "some string")

}

fun testFuncTypes2(func: ((Int, String) -> String)?) {

    // we must use the ? . If func is null then the whole expression evaluates to null
    func?.invoke(10, "some string")

}

/**
 * Instantiating a function type
 */

val func6: (Int) -> String = { anInt: Int -> "This is a cool number $anInt" }

// anonymous function
val func7: (Int) -> String = fun(anInt: Int): String { return "This is a cool number $anInt" }

/**
 * Lambdas
 */

fun lambdas1() {

    aListOfInts.filter({ anInt -> anInt > 5 })

    // If lambdas is last argument it can be placed outside
    aListOfInts.filter() { anInt -> anInt > 5 }

    // But it is the only argument too so just removing the unneeded parenthesis
    aListOfInts.filter { anInt -> anInt > 5 }

    // it: implicit name of a single parameter

    aListOfInts.filter { it > 5 }
}

/**
 * Returning a value from a lambda expression
 */

fun lambdas2() {

    aListOfInts.filter {
        val shouldFilter = it > 0
        shouldFilter
    }

    aListOfInts.filter {
        val shouldFilter = it > 0
        return@filter shouldFilter
    }
}

/**
 * Closures
 */

/*
    A lambda expression or anonymous function (as well as a local function and an object expression)
    can access its closure, i.e. the variables declared in the outer scope.
    Unlike Java, the variables captured in the closure can be modified:
 */

fun lambdas3() {

    var sum = 0
    aListOfInts
            .filter { it > 0 }
            .forEach {
                sum += it
            }

    print(sum)
}

