package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnsCorrectFoodList() throws Exception {
        List<String> mockFood = List.of("Животные", "Птицы", "Рыба");
        doReturn(mockFood).when(feline).getFood("Хищник");
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
        doReturn(mockData).when(feline).getKittens(mockData);
        assertEquals("Метод getKittens без параметров должен возвращать 1", mockData, feline.getKittens());
    }
}
