package pl.sda;

public class RootsCalculator {

    public static RootsOfSquareEquation calculateRootsOfSquareEquation(double a, double b, double c) throws NegativeDeltaException {

        double delta = Math.pow(b, 2) - (4 * a * c);

        if (delta < 0) {
            throw new NegativeDeltaException("delta ujemna");

        }

        double x1 = (-b - Math.sqrt(delta)) / (2 * a);

        double x2 = (-b + Math.sqrt(delta)) / (2 * a);

        return new RootsOfSquareEquation(x1, x2);
    }

    private static double[] converArrays(String[] numbersToConvert) {
        double[] abc = new double[numbersToConvert.length];
        for (int i = 0; i < numbersToConvert.length; i++) {
            try {
                abc[i] = Double.parseDouble(numbersToConvert[i]);
            } catch (NumberFormatException e) {
                System.out.println("podaj cyfry! nie litery");
                return null;
            }

        }
        return abc;
    }
}
