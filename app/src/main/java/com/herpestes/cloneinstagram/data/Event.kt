package com.herpestes.cloneinstagram.data

open class Event<out T>(private val content: T){

    var hasBeenHandled = false
        private set

    fun getContentOrHandled(): T?{
        return if(hasBeenHandled){
            null
        }else{
            hasBeenHandled = true
            content
        }
    }
}
