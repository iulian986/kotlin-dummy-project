package org.example

import org.example.com.example.Client
import org.example.com.example.Service

fun main() {
    println("Hello World!")
    val service = Service()
    val client = Client(service)
    val greeting = client.greeting("John")
    println(greeting)
}