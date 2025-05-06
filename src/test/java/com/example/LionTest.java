package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionConstructorWithInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неопознанный пол", feline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Lion lionSpy = Mockito.spy(lion);
        int expectedKittens = 1;
        when(feline.getKittens()).thenReturn(expectedKittens);
        int kittens = lionSpy.getKittens();
        assertEquals("Метод getKittens должен вернуть значение из Feline", expectedKittens, kittens);
    }

    @Test
    public void getFoodReturnsFelineFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Lion lionSpy = Mockito.spy(lion);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> food = lionSpy.getFood();
        assertEquals("Метод getFood должен вернуть список еды от Feline", expectedFood, food);
    }
}
