package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    Feline feline;

    @Test
    public void lionConstructorWithInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неопознанный пол", feline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedKittens = 1;
        int kittens = lion.getKittens();
        assertEquals("Метод getKittens должен вернуть значение из Feline", expectedKittens, kittens);
    }

    @Test
    public void getFoodReturnsFelineFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> food = lion.getFood();
        assertEquals("Метод getFood должен вернуть список еды от Feline", expectedFood, food);
    }
}
