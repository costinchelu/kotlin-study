package ro.ccar.java;



sealed class ExprSealed
        permits ConstPermitted, SumPermitted, NotANumber {}


final class ConstPermitted extends ExprSealed {

    public final double number;

    public ConstPermitted(double number) {
        this.number = number;
    }
}

final class SumPermitted extends ExprSealed {

    public final ExprSealed e1, e2;

    public SumPermitted(ExprSealed e1, ExprSealed e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
}

final class NotANumber extends ExprSealed {}




public class ClassSealedJ {
}
