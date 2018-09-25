package com.kugstr.kotlinmeetupvol1.chapter_2

/**
 * Visibility Modifiers
 */

// Classes, objects, interfaces, constructors, functions, properties and their setters can have
// visibility modifiers. (Getters always have the same visibility as the property.)
// There are four visibility modifiers in Kotlin: private, protected, internal and public.

/**
 * Visibility Rules
 */

// If you do not specify any visibility modifier, public is used by default,
// If you mark a declaration private, it will only be visible inside the file containing the declaration;
// If you mark it internal, it is visible everywhere in the same module;

/**
 * Examples
 */

// file name: example.kt

private fun foo() {  } // visible inside example.kt

public var bar: Int = 5 // property is visible everywhere
    private set         // setter is visible only in example.kt

internal val baz = 6    // visible inside the same module


/**
 * Modules
 */

// The internal visibility modifier means that the member is visible within the same module.
// - A module is a set of Kotlin files compiled together:
// - an IntelliJ IDEA module;
// - a Maven project;
// - a Gradle source set (with the exception that the test source set can access the internal declarations of main);