package introPOO.exercicioStaticMembers.utils;

public class CurrencyConverter {
    public static final double IOF = 0.06;

    public static double dollarToReais(double dollarPrice, double amount) {
        return amount * dollarPrice * (1 + IOF);
    }
}