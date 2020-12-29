package com.sample.kotlinpractise

//https://www.youtube.com/watch?v=uRyvNKRkwbs&t=13339s

//For run Ctr+shift+F10
fun main(){
    println("Hello kotlin")


    var name = "Suresh"
    println("Hii "+name)

    name = "Demo"
    println("Hii "+name)


    val test = "Test"
    //Note: val is a constant variable and can not be assigned multiple times and can be Initialized only single time and is known as the immutable variable
    // test = "Test"

    println("Hii "+test)


    var isSunny: Boolean = true
    isSunny = false
    println("isSunny : "+isSunny)




}