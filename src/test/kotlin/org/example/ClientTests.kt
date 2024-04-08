package org.example

import org.assertj.core.api.Assertions.assertThatThrownBy

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach

import org.mockito.Mockito.`when`
import org.mockito.Mockito

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.assertj.core.api.Assertions.assertThat

@ExtendWith(MockitoExtension::class)
class ClientTests {

    @Mock
    private lateinit var service: Service

    private lateinit var client: Client

    @Test
    fun greeting_withValidName_shouldReturnGreeting() {
        // Arrange
        client = Client(service)
        val name = "Alice"
        
        // Act
        val result = client.greeting(name)
        
        // Assert
        assertThat(result).isEqualTo("Hello, Alice")
    }

    @Test
    fun greeting_withEmptyName_shouldThrowIllegalArgumentException() {
        // Arrange
        client = Client(service)
        val name = ""
        
        // Act & Assert
        assertThatThrownBy { client.greeting(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("'name' must not be null or empty")
    }

    @Test
    fun greeting_withEvenLengthName_shouldReturnUppercaseGreeting() {
        // Arrange
        client = Client(service)
        val name = "Bob"
        
        // Mock
        `when`(service.isEven(name.length)).thenReturn(true)
        
        // Act
        val result = client.greeting(name)
        
        // Assert
        assertThat(result).isEqualTo("HELLO, BOB")
    }

    @Test
    fun greeting_withOddLengthName_shouldReturnGreeting() {
        // Arrange
        client = Client(service)
        val name = "Charlie"
        
        // Mock
        `when`(service.isEven(name.length)).thenReturn(false)
        
        // Act
        val result = client.greeting(name)
        
        // Assert
        assertThat(result).isEqualTo("Hello, Charlie")
    }
}