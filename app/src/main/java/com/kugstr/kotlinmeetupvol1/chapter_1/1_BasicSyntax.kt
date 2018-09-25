package com.kugstr.kotlinmeetupvol1.chapter_1

/**
 * Basic Syntax
 */

// Defining functions

// YES KOTLIN IS FUN therefore fun for function!!
fun sum(a: Int, b: Int): Int {
    return a + b
}

// Defining variables

fun variables() {

    val a: Int = 1

    val b = 2

    // val not reassignable but not really immutable
    //b = 3

    var c = 3

    c = 5

}

// Nullable types

var d: Int? = null

fun nullable(str: String?) {
    // Error nullable
    //println(str.length)

    // Smart cast
    if (str != null) {
        str.length
    }

    // safe call operator
    str?.length
}

// void ~= Unit

fun printSum(a: Int, b: Int): Unit {
    println("sum of " + a + " and " + b + " is " + (a + b))
}

fun printSum2(a: Int, b: Int) {
    println("sum of " + a + " and " + b + " is " + (a + b))
}

// String interpolation

fun stringInterpolation() {

    val number = 10

    val str1 = "I want to eat " + number + " pizzas"

    val str1Interpolated = "I want to eat $number pizzas"

    val str2 = "pizzzzzzas"

    val str2Interpolated = "I want to eat ${str2.length} $str2"
}


