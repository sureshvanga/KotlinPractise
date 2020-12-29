package com.sample.kotlinpractise

fun main(){
    var mynum = 5==3
    println("My Num is $mynum")

    println("Is5greater3 ${5>3}")

    println("Is3greater5 ${3>5}")

    //var season = 2;
    var season = 3;
    when(season){
        1 -> println("Spring")
        2 -> {
            println("winter")
            println("falls")
        }
        3 -> println("summer")
    }

    var month = 3;
    when(month){
        in 1..2 -> println("month summer")
        in 3..5 -> println("month winter")
        in 6..8 -> println("month Spring");
    }

//While

   // var x: Any = 10f
    var x: Any = 10f
    when(x){
        is Int -> println("$x is a Interger" )
        //!is Int -> println("$x is a not an Interger" )
        is Double -> println("$x is a Double")
        is String -> println("$x is a String")
        else -> println("non of the above")
    }


    //Do-while
    var y = 15
    do{
        println("value of y : $y")
        y++;

    }while(y==16)
        println("do while loop is completed.")


//For loop
    for (num in 1..10){
        print("$num ")
    }

    println("")
    for (i in 1 until 10){
        print("$i ")
    }

    println("")
    for (i in 10 downTo  1){
        print("$i ")
    }

    println("")
    for (i in 10 downTo  1 step  2){
        print("$i ")
    }


}