package com.krotos;

//Utworzenie obiektu oceny z liczbą gwiazdek =0
//stawienie oceny na zadaną liczbę gwiazdek 0-5
//Pobranie aktualnej liczby gwiazdek


public class Main {
    public static void main(String[] args) {
        ProductScore productScore = new ProductScore();
        System.out.println("Liczba gwiazdek przed ustawieniem oceny: " + productScore.getScore());
        productScore.setScore((short) 5);
        System.out.println("Liczba gwiazdek po ustawieniu: " + productScore.getScore());

        Clock clock = new Clock();
        System.out.println(clock.getTime());
    }


}
