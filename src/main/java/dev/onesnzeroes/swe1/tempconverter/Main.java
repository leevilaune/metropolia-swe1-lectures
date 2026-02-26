package dev.onesnzeroes.swe1.tempconverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Temperature Converter Test =====");
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = sc.nextDouble();
        double cFromF = converter.fahrenheitToCelsius(f);
        System.out.printf("%.2f °F = %.2f °C%n", f, cFromF);
        System.out.print("Enter temperature in Celsius: ");
        double c = sc.nextDouble();
        double fFromC = converter.celsiusToFahrenheit(c);
        System.out.printf("%.2f °C = %.2f °F%n", c, fFromC);
        System.out.print("Enter temperature in Kelvin: ");
        double k = sc.nextDouble();
        double cFromK = converter.kelvinToCelsius(k);
        System.out.printf("%.2f K = %.2f °C%n", k, cFromK);
        System.out.print("Enter temperature in Celsius to check if extreme: ");
        double temp = sc.nextDouble();
        boolean extreme = converter.isExtreme(temp);
        System.out.printf("%.2f °C is extreme? %b%n", temp, extreme);

        sc.close();
    }
}