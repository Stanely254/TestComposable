package com.stanley.testcomposable

object CounterHelper {
    fun processInput(editText: String): String {
        return try {
            val counterValue = editText.toInt()
            "Counter = $counterValue"
        } catch (e: NumberFormatException){
            "Invalid Entry"
        }
    }
}