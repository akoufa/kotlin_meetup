package com.kugstr.kotlinmeetupvol1.chapter_6;

import java.util.Map;

import static com.kugstr.kotlinmeetupvol1.chapter_6._4_NothingKt.reportError;

public class Nothing_Java {

    int i = 0;
    void exampleOne() {
        reportError(); // throws RuntimeException
        i = 1; // This is unreachable code. But there is no warning.
    }

    /*
    void exampleTwo(Map<String, String> map) {

        // Won't compile - 'Incompatible types' error.
        String data = map.containsKey("key") ? map.get("key") : reportError();
    }
    */


    /*
    String exampleThree(int n) {
        if (n > 5) {
            return "Ok";
        }
        reportError();
        // Won't compile - 'Missing return statement' error.
    }
     */
}
