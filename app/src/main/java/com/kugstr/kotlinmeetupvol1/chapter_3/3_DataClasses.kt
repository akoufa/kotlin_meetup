package com.kugstr.kotlinmeetupvol1.chapter_3

/**
 * Data Classes
 */

data class User(val name: String, val age: Int)

/*
The compiler automatically derives the following members from all properties declared in the primary constructor:

equals()/hashCode() pair;
toString() of the form "User(name=John, age=42)";
componentN() functions corresponding to the properties in their order of declaration;
copy() function
*/


/**
 * Data Classes and Destructuring Declarations
 */

fun destructuring() {
    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age") // prints "Jane, 35 years of age"
}

// There is no magic it just uses conventions

fun destructuring2() {
    val jane = User("Jane", 35)

    val name = jane.component1()
    val age = jane.component2()
}

/**
 * Equals and reference equality
 */

class DummyClass

fun equalsInKotlin(user1: User, user2: User) {
    // equals if implemented
    println(user1 == user2)

    // reference equality
    println(user1 === user2)
}

fun equalsInKotlin2(d1: DummyClass, d2: DummyClass) {
    // equals if implemented or default implementation
    println(d1 == d2)

    // reference equality
    println(d1 === d2)
}

