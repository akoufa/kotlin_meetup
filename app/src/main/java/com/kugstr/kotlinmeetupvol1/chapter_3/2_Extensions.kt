package com.kugstr.kotlinmeetupvol1.chapter_3

import com.kugstr.kotlinmeetupvol1.helpers.veryCoolExtensionFunction

/**
 * Extension Functions
 */

// To declare an extension function, we need to prefix its name with a receiver type

class Person {
    val firstName = "Kotlin"
    val lastName = "Kotlinopoulos"
}

fun Person.fullName(): String {
    return "$firstName $lastName"
}

fun useExtension() {

    val person = Person()

    // Hint: IDE autocompletion
    person.fullName()
}

/**
 * Extensions are resolved statically
 */

// Extensions do not actually modify classes they extend

open class C

class D : C()

fun C.foo() = "c"

fun D.foo() = "d"

fun printFoo(c: C) {
    println(c.foo())
}

fun useExtension2() {

    val d = D()

    // Question:
    // What will be printed here?
    printFoo(d)
}

fun useExtension3() {

    val x = 3
    3.veryCoolExtensionFunction()
    x.veryCoolExtensionFunction()
}

/**
 * Member always wins
 */

class SomeClass {
    fun foo() {
        println("member")
    }
}

fun SomeClass.foo() {
    println("extension")
}

// If we call c.foo() of any c of type C, it will print "member", not "extension".

/**
 * Nullable Receiver
 */

fun Any?.toString(): String {
    if (this == null) return "null"

    // same as this.toString()
    return toString()
}