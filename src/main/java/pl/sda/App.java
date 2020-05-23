package pl.sda;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Podaj trzy kolejno liczby całkowite, oddzieloneprzecinkami np. 1, 2, 3");
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();

        double[] abc;
        double a = 0, b = 0, c = 0;

        try {
            abc = cleanAndConvertToDoubleArray(line);
            a = abc[0];
            b = abc[1];
            c = abc[2];

            RootsOfSquareEquation roots = RootsCalculator.calculateRootsOfSquareEquation(a, b, c);

            System.out.println(roots.toString());
        } catch (NegativeDeltaException e) {
            System.out.println("Parametry a: " + a + ", b: " + b + ", c: " + c + " spowodowały ujemną deltę");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("wypadałoby podać dwa argumenty");
        } catch (NumberFormatException e) {
            System.out.println("podaj cyfry");
            return;
        }
        System.out.println("\nPROGRAM SIĘ NIE KOŃCZY! MOŻEMY TUTAJ PROGRAMOWAĆ DALEJ");
    }

    public static double[] cleanAndConvertToDoubleArray(String line) {
        String[] numbersToConvert = line
                .trim()
                .replaceAll(" ", "")
                .split(",");

        double[] abc = new double[numbersToConvert.length];
        for (int i = 0; i < numbersToConvert.length; i++) {
            abc[i] = Double.parseDouble(numbersToConvert[i]);
        }
        return abc;
    }
}