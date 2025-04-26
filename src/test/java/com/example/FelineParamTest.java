package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int data;
    private final int expected;

    public FelineParamTest(int data, int expected) {
        this.data = data;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {5, 5},
                {10, 10}
        });
    }

    @Test
    public void getKittensReturnsPassedValue() {
        Feline feline = new Feline();
        assertEquals("Метод getKittens(int) должен возвращать переданное значение", expected, feline.getKittens(data));
    }
}
