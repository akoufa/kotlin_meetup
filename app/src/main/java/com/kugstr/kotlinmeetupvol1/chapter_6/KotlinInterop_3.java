package com.kugstr.kotlinmeetupvol1.chapter_6;

import java.io.IOException;

/**
 * Kotlin interop
 */


public class KotlinInterop_3 {

    /**
     * Use Kotlin class
     */
    void interop1(){
        SomeKotlinClass kotlinClass = new SomeKotlinClass();
        kotlinClass.getFirstName();
        kotlinClass.setFirstName("Alex");

        // kotlinClass.setLastName("") Error does not compile
        kotlinClass.getLastName();

        // access directly
        String id = kotlinClass.id;

        SomeKotlinClass.foo();
        SomeKotlinClass.Companion.bar();

        try {
            kotlinClass.dangerousMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Use Kotlin top level func
     */

    // Hint: @file:JvmName("Kotlin")

    void interop2(){

        SomeKotlinClassKt.packageLevelFunc();
    }

}
