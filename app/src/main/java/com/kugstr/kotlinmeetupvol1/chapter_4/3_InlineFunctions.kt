package com.kugstr.kotlinmeetupvol1.chapter_4

import com.kugstr.kotlinmeetupvol1.helpers.aListOfInts
import java.util.concurrent.locks.Lock

/**
 * Inline
 */

/* Using higher-order functions imposes certain runtime penalties: each function is an object,
   and it captures a closure, i.e. those variables that are accessed in the body of the function.
   Memory allocations (both for function objects and classes) and virtual calls introduce runtime overhead.
 */

fun foo() {}

inline fun lockIt(l: Lock, body: () -> Unit) {
    l.lock()
    try {
        foo()
    } finally {
        l.unlock()
    }
}

fun useLock(l: Lock) {

    // We pass the lock and a lambda
    lockIt(l) { println("super lock") }
}

// Because inline

fun useLockCompiled(l: Lock){
    l.lock()
    try {
        println("super lock")
    }
    finally {
        l.unlock()
    }
}

// Inlining may cause the generated code to grow; however,
// if we do it in a reasonable way (i.e. avoiding inlining large functions),
// it will pay off in performance, especially at "megamorphic" call-sites inside loops.

fun checkLoopFuncs(){
    // Hint go to declaration to show inline
    aListOfInts.filter { it > 5 }
}

/**
 * Non-local returns
 */

fun ordinaryFunction(func: () -> Unit){}

inline fun inlined(func: () -> Unit){}

/*
In Kotlin, we can only use a normal, unqualified return to exit a named function or an anonymous function.
This means that to exit a lambda, we have to use a label, and a bare return is forbidden inside a lambda,
because a lambda cannot make the enclosing function return:
 */

fun nonLocalReturn1() {
    ordinaryFunction {
        // return // ERROR: cannot make `foo` return here
    }
}

// But if the function the lambda is passed to is inlined, the return can be inlined as well, so it is allowed:
fun nonLocalReturn2() {
    inlined {
        return // OK: the lambda is inlined
    }
}

// Such returns (located in a lambda, but exiting the enclosing function) are called non-local returns.
// We are used to this sort of construct in loops, which inline functions often enclose:

fun hasZeros(): Boolean {
    aListOfInts.forEach {
        if (it == 0) return true // returns from hasZeros
    }
    return false
}

/**
 * Reified type parameters
 */

class Test{
    var parent: Test? = null
}

fun <T> Test.findParentOfType(clazz: Class<T>): T? {
    var p = parent
    while (p != null && !clazz.isInstance(p)) {
        p = p.parent
    }
    @Suppress("UNCHECKED_CAST")
    return p as T?
}

// It’s all fine, but the call site is not very pretty:

fun notReifiedCall(test: Test){
    test.findParentOfType(Test::class.java)
}

inline fun <reified T> Test.findParentOfType(): T? {
    var p = parent
    // using instanceof with generic!!
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}

fun reifiedCall(test: Test){
    test.findParentOfType<Test>()
}