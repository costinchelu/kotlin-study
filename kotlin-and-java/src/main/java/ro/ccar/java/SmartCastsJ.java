package ro.ccar.java;

interface Expr { }


record Num(int value) implements Expr { }


record Sum(Expr left, Expr right) implements Expr { }


public class SmartCastsJ {

    public static void main(String[] args) {
        System.out.println(evalIf(new Sum(new Sum(new Num(1), new Num(2)), new Num(4))));
    }

    private static int evalIf(Expr e) {

         if (e instanceof Num n) {
            return n.value();
        } else if (e instanceof Sum s) {
            return evalIf(s.right()) + evalIf(s.left());
        } else {
            throw new IllegalArgumentException("Unknown expression");
        }
/*
FOR RECORDS, we can use record patterns:
        if (e instanceof Num(int value)) {
            return value;
        } else if (e instanceof Sum(Expr left, Expr right)) {
            return evalIf(right) + evalIf(left);
        } else {
            throw new IllegalArgumentException("Unknown expression");
        }
 */
    }
}


/*
We can choose classes over records, but this would be more verbose:


record:

record Sum(Expr left, Expr right) implements Expr { }


class:

class Sum implements Expr {
    private final Expr left;
    private final Expr right;

    // Constructor and getters:
    public Sum(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }

    // Override equals, hashCode and toString:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sum sum = (Sum) o;
        return left.equals(sum.left) && right.equals(sum.right);
    }

    @Override
    public int hashCode() {
        return 31 * left.hashCode() + right.hashCode();
    }

    @Override
    public String toString() {
        return "Sum{left=" + left + ", right=" + right + "}";
    }
}


 */