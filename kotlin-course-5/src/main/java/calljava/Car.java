package calljava;

import org.jetbrains.annotations.Nullable;

public class Car {

    public static int x = 5;
    private String color;
    private String model;
    private int year;
    private Object obj;

    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public void variableMethod(int num, String... strings) {
        for (String string: strings) {
            System.out.println(string);
        }
    }

    public void wantsIntArray(int[] theArray) {
        for (int i: theArray) {
            System.out.println("Here is the int: " + i);
        }
    }

    public static String xString() {
        return "This is x: " + x++;
    }

    public void demoMethod(Runnable r) {
        new Thread(r).start();
    }

    public String getColor() {
        return color;
    }

    public void setColor(@Nullable String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "calljava.Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
