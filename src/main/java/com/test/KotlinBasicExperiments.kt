package com.test

fun main(args : Array<String>) {

    val myArray = arrayOf(1, 1.23, "Doug")

    myArray.iterator().forEach {
        elem-> print (elem);
        print("\n");
    }

    print("\n");

    val squireArray = Array(5,{x->x*x})
    squireArray.iterator().forEach {
        elem ->
        print(elem);
        print("\n");
    }

    print("\n");

    val specificArray:Array<Int> = arrayOf(1,2,3);
    print(specificArray[2]);

    print("\n");

    val status = "R" in "Rest";
    print(status);

    print("\n");


    val rangeArr:Array<Int> = arrayOf(1,2,3,4,5,6);
    for ((index, value) in rangeArr.withIndex()){
        println("Index : $index & Value : $value")
    }

    print("\n");



}