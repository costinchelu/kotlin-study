package ro.ccar.java;


interface GenericsJExample<T> {
    public T nextT();
}






public class GenericsJ {

    public static void main(String[] args) {
        GenericsJExample<Integer> intGenerator = () -> 1;

        System.out.println(intGenerator.nextT());
    }
}
