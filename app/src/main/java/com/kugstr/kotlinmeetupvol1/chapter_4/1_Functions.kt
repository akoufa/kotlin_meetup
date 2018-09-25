package com.kugstr.kotlinmeetupvol1.chapter_4

/**
 * Default Arguments
 */

// Function parameters can have default values,
// which are used when a corresponding argument is omitted.

fun read1(b: Array<Byte>, off: Int = 0) {}

// You can even use a parameter value as a default argument for another parameter!!!
fun read2(b: Array<Byte>, off: Int = 0, len: Int = b.size) {}

// When overriding a method with default parameters values,
// the default parameter values must be omitted from the signature

/**
 * Named Arguments
 */

fun reformat(
        str: String,
        normalizeCase: Boolean = true,
        upperCaseFirstLetter: Boolean = true,
        divideByCamelHumps: Boolean = false,
        wordSeparator: Char = ' '
) {
}

fun useReformat(str: String) {

    // we could call this using default arguments:
    reformat(str)

    // However, when calling it with non-default, the call would look something like
    // Yes IDEs can help but try to read this line of code in github
    reformat(str, true, true, false, '_')

    // With named arguments we can make the code much more readable
    reformat(
            str,
            normalizeCase = true,
            upperCaseFirstLetter = true,
            wordSeparator = '_',
            divideByCamelHumps = false
    )

    // Can you spot it?! :)
}

/**
 * Single-Expression functions
 */

fun double(x: Int): Int {
    return x * 2
}

fun double1(x: Int): Int = x * 2

// Explicitly declaring the return type is optional when this can be inferred by the compiler:

fun double2(x: Int) = x * 2

/**
 * Infix notation
 */

/*
Functions marked with the infix keyword can also be called using the infix notation
- They must be member functions or extension functions;
- They must have a single parameter;
- The parameter must not accept variable number of arguments and must have no default value.
 */

infix fun Int.shl(x: Int): Int {
    return 10
}

fun useInfix() {

    // calling the function using the infix notation
    1 shl 2

    // is the same as
    1.shl(2)
}