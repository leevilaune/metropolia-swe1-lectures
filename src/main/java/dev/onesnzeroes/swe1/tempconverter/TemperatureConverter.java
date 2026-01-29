package dev.onesnzeroes.swe1.tempconverter;

public class TemperatureConverter {

    public double fahrenheitToCelsius(double f){
        return (f - 32)*((double) 5 / 9);
    }
    public double celsiusToFahrenheit(double c){
        return (c*((double) 9 /5)+32);
    }
    public boolean isExtreme(double c){
        if(c > 50){
            return true;
        } else return c < -40;
    }
}
