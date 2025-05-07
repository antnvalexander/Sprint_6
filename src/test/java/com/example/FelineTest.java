package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline = new Feline();
    Feline felineSpy = Mockito.spy(feline);

    @Test
    public void eatMeatReturnsCorrectFoodList() throws Exception {
        List<String> mockFood = List.of("Животные", "Птицы", "Рыба");
        List<String> result = feline.eatMeat();
        assertEquals("Метод eatMeat должен возвращать список еды для хищника", mockFood, result);
    }

    @Test
    public void getFamilyReturnsFelineFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals("Метод getFamily должен возвращать 'Кошачьи'", expected, actual);
    }

    @Test
    public void getKittensReturnsDefaultOne() {
        int mockData = 1;
        assertEquals("Метод getKittens без параметров должен возвращать 1", mockData, felineSpy.getKittens());
    }
}
