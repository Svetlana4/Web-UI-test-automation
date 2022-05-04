package com.geekbrains.lesson4.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    Triangle triangle = new Triangle();

    @Test
    void givenThreeIntsResultIsCorrect() {
        Assertions.assertEquals( 2, triangle.calculateArea(2, 3, 4));
    }

    @Test
    void givenOneNumberIsZeroResultIsZero() {
       Assertions.assertEquals( 0, triangle.calculateArea(0, 3, 4));
    }

    @Test
    void throwsExceptionOnNegativeArguments() {
        Executable executable = () -> triangle.calculateArea(-6, 3, 4);

        Assertions.assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void givenDegenerateTriangleOnNegativeArguments() {
        Executable executable = () -> triangle.calculateArea(3, 2,5);

        Assertions.assertThrows(TriangleException.class, executable);
    }


    @ParameterizedTest
    @CsvSource({"2, 3, 4, 2", "0, 3, 4, 0"})
    void CalculateAreaTest(int a, int b, int c, int s) {
        Assertions.assertEquals(s, triangle.calculateArea(a, b, c));
    }

}