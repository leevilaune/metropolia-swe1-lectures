package dev.onesnzeroes.swe1.tempconverter;

public class Main {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("=== Temperature Converter Test ===");
        System.out.println("100°F -> " + converter.fahrenheitToCelsius(100) + "°C");
        System.out.println("0°C -> " + converter.celsiusToFahrenheit(0) + "°F");
        System.out.println("300 K -> " + converter.kelvinToCelsius(300) + "°C");
        System.out.println("Is 55°C extreme? " + converter.isExtreme(55));
    }
}