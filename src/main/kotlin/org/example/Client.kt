package org.example

class Client(private val service: Service) {
    fun greeting(name: String?): String {
        require(!name.isNullOrBlank()) { "'name' must not be null or empty" }

        val even = service.isEven(name.length)
        val greeting = "Hello, $name"
        return if (even) {
            greeting.uppercase()
        } else {
            greeting
        }
    }
}