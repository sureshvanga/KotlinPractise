package utils

/*
Note:
By Using this class, we can control the API call when rotate the screen, It will call only once
and stored that content.

*/

class Events<out T>(private val content: T) {


    var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if (!hasBeenHandled) {
            hasBeenHandled = true
            content

        } else {
            null
        }
    }

    fun peekContent(): T = content
}