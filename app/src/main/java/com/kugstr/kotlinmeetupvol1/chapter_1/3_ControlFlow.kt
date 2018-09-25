package com.kugstr.kotlinmeetupvol1.chapter_1

import com.kugstr.kotlinmeetupvol1.helpers.aListOfInts

/**
 * If
 */

fun if1(a: Int, b: Int) {

    // Traditional usage
    var max = a
    if (a < b) {
        max = b
    }
}

fun if2(a: Int, b: Int) {

    // With else
    val max: Int
    if (a > b) {
        max = a
    } else {
        max = b
    }
}

fun if3Expression(a: Int, b: Int) {
    // As expression
    val max = if (a > b) {
        println(a)
        a
    } else {
        println(b)
        // the last expression is the value of a block
        b
    }
}

/**
 * When, wait no switch???
 */

// When matches its argument against all branches sequentially until some branch condition is satisfied.
// No fallthrough, hence no break needed.
fun when1(x: Int) {
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }
}

// We can also check a value for being in or !in a range or a collection.
fun when2(x: Any) {
    when (x) {
        in 1..10 -> print("x is in the range")
        !in 10..20 -> print("x is outside the range")
        is String -> print("x is string")
        else -> print("none of the above")
    }
}

// Note: Any is not java.lang.Object; in particular, it does not have any members
// other than equals(), hashCode() and toString()

/**
 * For Loops
 */

fun forLoop() {
    for (item: Int in aListOfInts) {
        print(item)
    }

    // Iterate ranges

    // closed range
    for (i in 1..3) {
        println(i) // 1 2 3
    }

    // half open
    for (i in 1 until 3) {
        println(i)  // 1 2
    }

    // until is infix function if someone asks

    // step
    for (i in 1..10 step 2) {
        println(i) // 1 3 5 7 9
    }

    // downTo, also infix function
    for (i in 10 downTo 1 step 3) {
        println(i) // 10 7 4 1
    }
}




