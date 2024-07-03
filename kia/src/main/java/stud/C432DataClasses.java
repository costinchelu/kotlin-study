package stud;

import ch04.ex3_2_1_DataClassCopy.Customer;

public class C432DataClasses {

    public static void main(String[] args) {
        ch04.ex3_2_1_DataClassCopy.Customer bob = new Customer("Bob", 258745);
        System.out.println(bob.getName() + "   " + bob.getPostalCode());
    }
}
