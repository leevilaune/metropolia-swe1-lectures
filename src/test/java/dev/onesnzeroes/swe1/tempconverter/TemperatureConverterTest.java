package dev.onesnzeroes.swe1.tempconverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {


    @Test
    public void fahrenheitToCelsiusTest(){
        TemperatureConverter converter = new TemperatureConverter();

        assertEquals(37.77,converter.fahrenheitToCelsius(100),0.01);
        assertEquals(0,converter.fahrenheitToCelsius(32),0.01);
        assertEquals(-17.78,converter.fahrenheitToCelsius(0),0.01);
        assertEquals(-73.33,converter.fahrenheitToCelsius(-100),0.01);

    }

    @Test
    public void celsiusToFahrenheitTest(){
        TemperatureConverter converter = new TemperatureConverter();

        assertEquals(212,converter.celsiusToFahrenheit(100),0.01);
        assertEquals(89.6,converter.celsiusToFahrenheit(32),0.01);
        assertEquals(32,converter.celsiusToFahrenheit(0),0.01);
        assertEquals(-148,converter.celsiusToFahrenheit(-100),0.01);

    }
    @Test
    public void isExtremeTest(){
        TemperatureConverter converter = new TemperatureConverter();

        assertTrue(converter.isExtreme(51));
        assertTrue(converter.isExtreme(-41));
        assertFalse(converter.isExtreme(0));
        assertFalse(converter.isExtreme(-24));
        assertFalse(converter.isExtreme(34));
    }

}