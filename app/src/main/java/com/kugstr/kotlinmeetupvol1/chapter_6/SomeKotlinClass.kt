// @file:JvmName("Kotlin")

package com.kugstr.kotlinmeetupvol1.chapter_6

import java.io.IOException

class SomeKotlinClass {

    var firstName: String = "firstName"
    val lastName = "lastName"

    @JvmField val id = "id"

    @JvmOverloads fun func1(a: String, b: Int = 0, c: String = "abc") {  }
    fun func2(a: String, b: Int = 0, c: String = "abc") {  }

    // Hint: try without throws
    @Throws(IOException::class)
    fun dangerousMethod() {
        throw IOException()
    }

    companion object {
        @JvmStatic fun foo() {}
        fun bar() {}
    }
}

fun packageLevelFunc() {  }