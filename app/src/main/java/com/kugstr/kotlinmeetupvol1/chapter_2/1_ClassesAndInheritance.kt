package com.kugstr.kotlinmeetupvol1.chapter_2

import com.kugstr.kotlinmeetupvol1.helpers.Inject

/**
 * Classes
 */
class Invoice {}

class Empty

/**
 * Constructors
 */

// A class in Kotlin can have a primary constructor and one or more secondary constructors.
// The primary constructor is part of the class header: it goes after
// the class name (and optional type parameters).

class Person constructor(val firstName: String, var lastName: String) {

}

// class construction

fun person1() {
    val person = Person("Jake", "Wharton")

    println(person.firstName) // Jake

    // Error val
    //person.firstName = "Some Jake"

    person.lastName = "Not Wharton"

    println(person.lastName) // Not Wharton
}

// Primary constructor cannot have a body, use init blocks

class InitDemo(val name: String) {
    init {
        println("Do something with $name")
    }
}

// Note that parameters of the primary constructor can be used in the initializer blocks.
// They can also be used in property initializers declared in the class body:

class Customer(name: String) {
    val customerKey = name.toUpperCase()
}

// If the constructor has annotations or visibility modifiers,
// the constructor keyword is required, and the modifiers go before it:

class Customer2 @Inject private constructor(name: String) {
    val customerKey = name.toUpperCase()
}

/**
 * Secondary Constructors
 */

class Person2 {
    constructor(parent: Person) {
        // Do something
    }
}

// If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor,
// either directly or indirectly through another secondary constructor(s).

// Delegation to the primary constructor happens as the first statement of a secondary constructor

class Person3(val name: String) {
    constructor(name: String, parent: Person) : this(name) {
        // Do something
    }
}

/**
 * Inheritance
 */

// Kotlin was designed with Java Best Practices in mind.

// The open annotation on a class is the opposite of Java's final:
// It allows others to inherit from this class. By default, all classes in Kotlin are final,
// which corresponds to Effective Java, 3rd Edition, Item 19: Design and document
// for inheritance or else prohibit it.

open class Base(val p: Int)

class Derived(p: Int) : Base(p)

/**
 * Overriding Methods
 */

// Kotlin requires explicit annotations for overridable members
// (we call them open) and for overrides:

open class Base2 {
    open fun v() {}
    fun nv() {}
}

class Derived2() : Base2() {
    override fun v() {}
    // override fun nv() { } // final
}

/**
 * Overriding Properties
 */

open class Foo {
    open var x: Int = 10
}

class Bar1 : Foo() {
    override var x: Int = 20
    // override val x: Int = 20 // It's not possible restrict to val
}

/**
 * Calling the superclass implementation
 */

open class Foo2 {
    open fun f() {
        println("Foo.f()")
    }

    open val x: Int = 10
}

class Bar2 : Foo2() {
    override fun f() {
        super.f()
        println("Bar.f()")
    }

    override val x = super.x + 1
}