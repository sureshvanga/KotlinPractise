package com.sample.kotlinpractise

fun main(){
    myFunction()

    var sum =  addUp(10,20)
    println("Sum of two values :$sum")

    var avg = avg(10f, 30)
    println("Avg is :$avg")


    nullableFunction()

    var classname = Person("Suresh kumar", "vanga")
    var test = Demo("Suresh kumar", "vanga").mainOne("test", "android")
}

fun avg(a: Float, b: Int): Any {


    return a*b;
}

fun myFunction(){
    println("called from my function")
}

fun addUp(a: Int, b:Int) : Int{

    return a+b
}

//Nullable

fun nullableFunction(){
    var name:String = "suresh"
  //name = null //compile time error

    var nullableName : String?= "suresh"
    nullableName = null  // comment for test

    //Note : Here nullableName is "null" then print "kumar" else prints "suresh".
    //  ?: Elvis operator
    val myname = nullableName ?: "Kumar"
    println("myName : $myname")

}

class Person(firstname: String, lastname: String){
    init{
        println("first name:  $firstname and last name:  $lastname")

    }


}
class Demo(strone: String, strtwo: String){

    fun mainOne(strone: String, strtwo: String){
        println(" $strone $strtwo")
    }

}