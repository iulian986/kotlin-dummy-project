package org.example

import org.mockito.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

@ExtendWith(MockitoExtension::class)
class ClientTests {

    @Mock
    private lateinit var service: Service

    private lateinit var client: Client

    @Test
    fun greeting_withValidName_evenLength_shouldReturnUppercaseGreeting() {
        // Arrange
        client = Client(service)
        val name = "Alice"
        val expectedGreeting = "Hello, Alice".uppercase()
        Mockito.`when`(service.isEven(name.length)).thenReturn(true)

        // Act
        val result = client.greeting(name)

        // Assert
        assertThat(result).isEqualTo(expectedGreeting)
    }

    @Test
    fun greeting_withValidName_oddLength_shouldReturnGreeting() {
        // Arrange
        client = Client(service)
        val name = "Bob"
        val expectedGreeting = "Hello, Bob"
        Mockito.`when`(service.isEven(name.length)).thenReturn(false)

        // Act
        val result = client.greeting(name)

        // Assert
        assertThat(result).isEqualTo(expectedGreeting)
    }

    @Test
    fun greeting_withNullName_shouldThrowIllegalArgumentException() {
        // Arrange
        client = Client(service)
        val name: String? = null

        // Act & Assert
        assertThrows<IllegalArgumentException> {
            client.greeting(name)
        }
    }

    @Test
    fun greeting_withEmptyName_shouldThrowIllegalArgumentException() {
        // Arrange
        client = Client(service)
        val name = ""

        // Act & Assert
        assertThrows<IllegalArgumentException> {
            client.greeting(name)
        }
    }
}
