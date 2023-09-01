package genericsSetMap.generics;

public class MyGenericClass<T extends String, V extends Number> {
    private T prop1;
    private V prop2;
    public MyGenericClass(T prop1, V prop2) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }

    public void showPropType() {
        System.out.println("Prop1 = " + prop1.getClass().getName());
        System.out.println("Prop2 = " + prop2.getClass().getName());
    }

    public static <T, V> void shout(T objToShout, V otherObjToShout) { // metodo generico
        System.out.println(objToShout + "!!!");
        System.out.println(otherObjToShout + "!!!");
    }

}
/*
public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        MyGenericClass<String, Integer> myGenericClass = new MyGenericClass<>("Eduardo", 25);
        myGenericClass.showPropType();

        sc.close();

    }
}
* */
