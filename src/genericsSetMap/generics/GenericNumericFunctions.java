package genericsSetMap.generics;

public class GenericNumericFunctions<T extends Number> {

    T num;

    public GenericNumericFunctions(T num) {
        this.num = num;
    }

    public double square() {
        return num.intValue() * num.doubleValue();
    }

    public boolean absEqual(GenericNumericFunctions<?> otherNum) { // <?> WILD CARD
        if (Math.abs(num.doubleValue()) == Math.abs(otherNum.num.doubleValue()))
            return true;
        return false;
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        GenericNumericFunctions<Integer> obj1 = new GenericNumericFunctions<>(15);
        GenericNumericFunctions<Double> obj2 = new GenericNumericFunctions<>(-15.0);

        obj1.absEqual(obj2);

        sc.close();

    }
}
* */
