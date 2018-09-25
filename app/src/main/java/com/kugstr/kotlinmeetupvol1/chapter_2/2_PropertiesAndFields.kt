package com.kugstr.kotlinmeetupvol1.chapter_2

/**
 * Properties
 */

class Properties {

    val size = 1000

    val isEmpty: Boolean
        get() = this.size == 0

    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            doSomeThing(value)
        }

    fun doSomeThing(str: String) {}
}

/**
 * Backing Fields
 */

// The field identifier can only be used in the accessors of the property.
class BackingFields {

    var counter = 0 // Note: the initializer assigns the backing field directly
        set(value) {
            if (value >= 0) field = value
        }
}

/**
 * Compile time constants
 */

// Properties the value of which is known at compile time can be marked
// as compile time constants using the const modifier.

// Top-level or member of an object
// Initialized with a value of type String or a primitive type
// No custom getter

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

/**
 * Late-Initialized Properties and Variables
 */

// Normally, properties declared as having a non-null type must be initialized in the constructor.
// However, fairly often this is not convenient.
// For example, properties can be initialized through dependency injection, or in the setup method of a unit test.

class SomeClass

class LateInitClass {
    lateinit var anObject: SomeClass
}

// Accessing a lateinit property before it has been initialized throws a special exception
// that clearly identifies the property being accessed and the fact that it hasn't been initialized.

// Checking whether a lateinit var is initialized (since 1.2)

/*
fun check(){
    if (foo::bar.isInitialized) {
        println(foo.bar)
    }
}
*/