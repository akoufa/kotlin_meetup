package com.kugstr.kotlinmeetupvol1.chapter_5

/**
 * is and !is Operators
 */

fun isAndIsNotOperator(obj: Any) {
    if (obj is String) {
        print(obj.length)
    }

    if (obj !is String) { // same as !(obj is String)
        print("Not a String")
    } else {
        print(obj.length)
    }
}

/**
 * Smart Casts
 */

fun demo(x: Any?) {
    if (x is String) {
        print(x.length) // x is automatically cast to String
    }

    if (x is String?) {
        // print(x.length) // Error x is automatically cast to String?
        if (x != null) {
            print(x.length) // x is automatically cast to String
        }
    }
}

/**
 * "Unsafe" and "Safe" cast operator
 */

fun unsafeCast(y: Any) {
    val x: String = y as String
}

fun safeCast(y: Any) {
    // Question
    // What is the type of x?
    val x = y as? String
}

/**
 * Null Safety or avoiding The Billion Dollar Mistake
 */

/*
Kotlin's type system is aimed at eliminating the danger of null references from code,
also known as the The Billion Dollar Mistake.
One of the most common pitfalls in many programming languages, including Java,
is that accessing a member of a null reference will result in a null reference exception.
In Java this would be the equivalent of a NullPointerException or NPE for short.
 */

fun nullSafety() {

    var a: String = "abc"
    // a = null // compilation error

    var b: String? = "abc"
    b = null // ok
    print(b)

    val l1 = a.length

    // val l2 = b.length // error: variable 'b' can be null

    val l2 = b?.length

    // But is length null useful??? NO!!

    // ELVIS OPERATOR ( looks like Elvis hair )

    val l3 = b?.length ?: 0


    // DANGER !! Operator

    val l4 = b!!.length
}