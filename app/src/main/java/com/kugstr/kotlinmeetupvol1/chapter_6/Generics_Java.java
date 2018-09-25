package com.kugstr.kotlinmeetupvol1.chapter_6;


/*
1)
First, let's think about why Java needs those mysterious wildcards.
The problem is explained in Effective Java, 3rd Edition, Item 31: Use bounded wildcards
to increase API flexibility.
First, generic types in Java are invariant, meaning that List<String> is not a subtype of List<Object>.
Why so? If List was not invariant, it would have been no better than Java's arrays, since the following code
would have compiled and caused an exception at runtime:
 */

import java.util.ArrayList;
import java.util.List;

public class Generics_Java {

    /**
     * Variance
     */

   public void generics1(){

       List<String> strs = new ArrayList<String>();
       // List<Object> objs = strs; // !!! The cause of the upcoming problem sits here. Java prohibits this!
       // objs.add(1); // Here we put an Integer into a list of Strings
       // String s = strs.get(0); // !!! ClassCastException: Cannot cast Integer to String
   }

   /*
    2) So, Java prohibits such things in order to guarantee run-time safety.
       The addAll() method from Collection interface.
       What's the signature of this method? Intuitively, we'd put it this way:
    */

    interface Collection<E> {
        void addAll(Collection<E> items);
    }


    void copyAll(Collection<Object> to, Collection<String> from) {
        // to.addAll(from);
        // !!! Would not compile with the naive declaration of addAll:
        // Collection<String> is not a subtype of Collection<Object>
    }

    // That's why the actual signature of addAll() is the following:

    /**
     * Covariance
     */

    interface Collection2<E> {
        void addAll(Collection2<? extends E> items);
    }

    // The wildcard type argument ? extends E indicates that this method accepts a collection of objects of E
    // or some subtype of E, not just E itself.

    /**
     * Contravariance
     */

    /*
    in Java we have List<? super String> a supertype of List<Object>.

    You can only call methods that take String as an argument
    on List<? super String> (e.g., you can call add(String) or set(int, String)), while if you call something
    that returns T in List<T>, you don't get a String, but an Object.
    */

    /**
     * Declaration site variance
     */
    interface Source<T> {
        T nextT();
    }

    void demo(Source<String> strs) {
        // Source<Object> objects = strs; // !!! Not allowed in Java
        // ...
    }

    /*
    To fix this, we have to declare objects of type Source<? extends Object>, which is sort of meaningless,
    because we can call all the same methods on such a variable as before, so there's no value added by the more
    complex type.
     */

    void demo2(Source<String> strs) {
        Source<? extends Object> objects = strs;
    }

    // Hint: go back to Kotlin 1_Generics file
}




