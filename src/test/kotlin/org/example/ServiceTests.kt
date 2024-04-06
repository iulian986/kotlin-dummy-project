package org.example

import org.mockito.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.assertj.core.api.Assertions.assertThat

@ExtendWith(MockitoExtension::class)
class ServiceTests {

    private val service = Service()

    @Test
    fun testIsEven() {
        assertThat(service.isEven(2)).isTrue()
        assertThat(service.isEven(3)).isFalse()
    }

    @Test
    fun testHighComplexityMethod() {
        // Test case for a = 0, b > 0, c > 0
        service.highComplexityMethod(0, 1, 1)
        // Add assertions here

        // Test case for a < 0, b <= 0, c <= 0
        service.highComplexityMethod(-1, -1, -1)
        // Add assertions here

        // Test case for a > 0, b > 0, c <= 0
        service.highComplexityMethod(1, 1, -1)
        // Add assertions here
    }
}
