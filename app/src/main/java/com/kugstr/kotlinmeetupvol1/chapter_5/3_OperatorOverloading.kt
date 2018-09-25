package com.kugstr.kotlinmeetupvol1.chapter_5

/**
 * Operator Overloading
 */

/*
Kotlin allows us to provide implementations for a PREDEFINED set of operators on our types.
These operators have fixed symbolic representation (like + or *) and fixed precedence.
 */

/*
Binary operations

Arithmetic operators

Expression	Translated to
a + b	a.plus(b)
a - b	a.minus(b)
a * b	a.times(b)
a / b	a.div(b)
a % b	a.rem(b), a.mod(b) (deprecated)
a..b	a.rangeTo(b)
 */

data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}

fun useCounter(c1: Counter): Counter{
    return c1 + 10
}