package pl.shonsu.interfaces;

import java.util.Scanner;

public class App1 {

    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        App1 main = new App1();
        Computation computation;

        if (main.shouldMultiply()) {
            computation = new Multiplication(); // zaimplementuj brakującą klasę
        } else {
            computation = new Addition(); // zaimplementuj brakującą klasę
        }

        double argument1 = main.getArgument();
        double argument2 = main.getArgument();

        double result = computation.compute(argument1, argument2);
        System.out.println("Wynik: " + result);
    }

    private boolean shouldMultiply() {
        System.out.println("Type M for multiply, everything else for addition");

        return scanner.next().equals("M"); // tutaj zapytaj użytkownika co chce zrobić (mnożenie czy dodawanie)
    }

    private double getArgument() {
        System.out.println("Podaj argument:");
        return scanner.nextDouble(); // tutaj pobierz liczbę od użytkownika
    }
}
