package ro.ccar.java;

interface Expr { }


record Num(int value) implements Expr { }


record Sum(Expr left, Expr right) implements Expr { }


public class SmartCastsJava {

    public static int evalIf(Expr e) {
        if (e instanceof Num n) {
            return n.value();
        } else if (e instanceof Sum s) {
            return evalIf(s.right()) + evalIf(s.left());
        } else {
            throw new IllegalArgumentException("Unknown expression");
        }
    }


    public static void main(String[] args) {
        System.out.println(evalIf(new Sum(new Sum(new Num(1), new Num(2)), new Num(4))));
    }
}