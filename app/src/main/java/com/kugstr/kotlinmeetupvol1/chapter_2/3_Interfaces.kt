package com.kugstr.kotlinmeetupvol1.chapter_2

/**
 * Interface declaration
 */

interface MyInterface {
    fun bar()
    fun foo() {
        // optional body
    }
}

/**
 * Properties in Interfaces
 */

interface MyInterface2 {
    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface2 {
    override val prop: Int = 29
}