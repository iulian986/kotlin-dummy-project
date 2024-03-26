package org.example.com.example

class Service {
    fun isEven(input: Int): Boolean {
        return input % 2 == 0
    }

    fun highComplexityMethod(a: Int, b: Int, c: Int) {
        if (a == 0) {
            println("a is positive")
            if (b > 0) {
                println("b is positive")
                if (c > 0) {
                    println("c is positive")
                } else {
                    println("c is non-positive")
                }
            } else {
                println("b is non-positive")
                if (c > 0) {
                    println("c is positive")
                } else {
                    println("c is non-positive")
                }
            }
        } else if (a < 0) {
            println("a is non-positive")
            if (b > 0) {
                println("b is positive")
                if (c > 0) {
                    println("c is positive")
                } else {
                    println("c is non-positive")
                }
            } else {
                println("b is non-positive")
                if (c > 0) {
                    println("c is positive")
                } else {
                    println("c is non-positive")
                }
            }
        } else {
            println("a is non-positive")
            if (b > 0) {
                println("b is positive")
                if (c > 0) {
                    println("c is positive")
                } else {
                    println("c is non-positive")
                }
            } else {
                println("b is non-positive")
                if (c > 0) {
                    println("c is positive")
                } else {
                    println("c is non-positive")
                }
            }
        }
    }
}