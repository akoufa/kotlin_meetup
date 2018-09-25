package com.kugstr.kotlinmeetupvol1.chapter_5

/**
 * Exceptions
 */

// All exception classes in Kotlin are descendants of the class Throwable.
// Every exception has a message, stack trace and an optional cause.
fun exceptions1(){

    throw Exception("Hi There!")

    try {
        // some code
    }
    catch (e: Exception) {
        // handler
    }
    finally {
        // optional finally block
    }
}

/**
 * Try is an expression
 */

fun exceptions2(input: String){
    val a: Int? = try { input.toInt() } catch (e: NumberFormatException) { null }
}

/**
* Checked Exceptions
*/

// The following is an example interface of the JDK implemented by StringBuilder class:

// Appendable append(CharSequence csq) throws IOException;


/*
What does this signature say? It says that every time I append a string to something (a StringBuilder, some kind of a log, a console, etc.)
I have to catch those IOExceptions. Why? Because it might be performing IO (Writer also implements Appendable)…
So it results into this kind of code all over the place:

try {
    log.append(message)
}
catch (IOException e) {
    // Must be safe
}

And this is no good, see Effective Java, 3rd Edition, Item 77: Don't ignore exceptions.

Bruce Eckel says in Does Java need Checked Exceptions?:

Examination of small programs leads to the conclusion that requiring exception specifications could both enhance
developer productivity and enhance code quality, but experience with large software
projects suggests a different result – decreased productivity and little or no increase in code quality.


Other citations of this sort:

Java's checked exceptions were a mistake (Rod Waldhoff)
The Trouble with Checked Exceptions (Anders Hejlsberg)
 */