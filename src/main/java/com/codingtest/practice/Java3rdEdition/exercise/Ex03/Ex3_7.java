package com.codingtest.practice.Java3rdEdition.exercise.Ex03;

public class Ex3_7 {
    public static void main(String[] args) {
        int fahrenheit = 100;
        float celcius = 0.0f;
        celcius = (float)(fahrenheit - 32) * 5/9F;
        celcius += 0.005;
        celcius = (int) (celcius*100f) / 100f;

        System.out.println("Fahrenheit:"+fahrenheit);
        System.out.println("Celcius : "+celcius);
    }
}
