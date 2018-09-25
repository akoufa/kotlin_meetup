package com.kugstr.kotlinmeetupvol1.chapter_6

import java.util.*

/**
 * Java interop
 */

fun demo(source: List<Int>) {
    val list = ArrayList<Int>()
    // 'for'-loops work for Java collections:
    for (item in source) {
        list.add(item)
    }

    // Operator conventions work as well:
    for (i in 0..source.size - 1) {
        list[i] = source[i] // get and set are called
    }
}

/**
 * Getters and Setters
 */

fun calendarDemo() {
    val calendar = Calendar.getInstance()
    if (calendar.firstDayOfWeek == Calendar.SUNDAY) {  // call getFirstDayOfWeek()
        calendar.firstDayOfWeek = Calendar.MONDAY      // call setFirstDayOfWeek()
    }
    if (!calendar.isLenient) {                         // call isLenient()
        calendar.isLenient = true                      // call setLenient()
    }
}

/**
 * Null-Safety and Platform Types
 */

/*
  Any reference in Java may be null, which makes Kotlin's requirements of strict null-safety
  impractical for objects coming from Java.
  Types of Java declarations are treated specially in Kotlin and called platform types.
 */

class A

fun platformTypes(){

    val someJavaClass = SomeJavaClass()

    // Question
    // What is the type of str1 ?
    val str1 = someJavaClass.getString()


    val someJavaClass2 = SomeJavaClass2()
    val str2 = someJavaClass2.friendlyGetString()

    val str3 = someJavaClass2.friendlyGetString2()
}