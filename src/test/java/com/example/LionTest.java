package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline mockFeline;

    @Test
    public void lionConstructorWithInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неопознанный пол", mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        lion = Mockito.spy(lion);
        int expectedKittens = 1;
        when(mockFeline.getKittens()).thenReturn(expectedKittens);
        int kittens = lion.getKittens();
        assertEquals("Метод getKittens должен вернуть значение из Feline", expectedKittens, kittens);
        verify(mockFeline).getKittens();
    }

    @Test
    public void getFoodReturnsFelineFood() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        lion = Mockito.spy(lion);

        List<String> mockFood = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(mockFood);

        List<String> food = lion.getFood();
        assertEquals("Метод getFood должен вернуть список еды от Feline", mockFood, food);
        verify(mockFeline).getFood("Хищник");
    }
}
