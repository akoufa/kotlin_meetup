package com.kugstr.kotlinmeetupvol1.chapter_1

/**
Type	Bit width
Double	64
Float	32
Long	64
Int	    32
Short	16
Byte	8
 **/

val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010

fun explicitConversions() {
    val a: Int = 1

    //val b: Long = a // implicit conversion not allowed

    val c: Long = a.toLong()
}
