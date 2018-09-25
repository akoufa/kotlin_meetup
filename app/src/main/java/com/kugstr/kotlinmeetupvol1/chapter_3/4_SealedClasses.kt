package com.kugstr.kotlinmeetupvol1.chapter_3

/**
 * Sealed Classes
 */

// Sealed classes are used for representing restricted class hierarchies,
// when a value can have one of the types from a limited set, but cannot have any other type.
// They are, in a sense, an extension of enum classes: the set of values for an enum type is also restricted,
// but each enum constant exists only as a single instance, whereas a subclass of a sealed class
// can have multiple instances which can contain state.

class Data

// State Modeling

sealed class ScreenState

class Error(val error: String) : ScreenState()
object Loading : ScreenState()
data class Success(val someData: Data) : ScreenState()

fun setScreenState(screenState: ScreenState) {
    when (screenState) {
        is Error -> {
            /* set error state in the view */
            // errorView.text = screenState.error
        }
        is Loading -> { /* set loading state in the view */
        }
        is Success -> {
            print(screenState.someData)
            /* hide loading or error states in the view and display data*/
            // sometextView.text = screenState.someData.name
        }
    }
}