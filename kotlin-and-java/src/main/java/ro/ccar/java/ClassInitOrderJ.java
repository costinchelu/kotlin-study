package ro.ccar.java;

class Base4J {
    protected final String name;
    protected int size;

    // instance initializer block
    static {
        System.out.println("Initializing Base");
    }

    public Base4J(String name) {
        this.name = name;
        this.size = name.length();
        System.out.println("Initializing size in Base: " + this.size + " characters");
    }
}

class Derived4J extends Base4J {

    private final String lastName;

    static {
        System.out.println("Initializing Derived");
    }

    public Derived4J(String name, String lastName) {
        super(modifyName(name));
        System.out.println("Argument for Base: " + this.name);

        this.lastName = lastName;
        this.size = super.size + lastName.length();

        System.out.println("Initializing size in Derived: " + this.size);
    }

    // Method to modify name as per Kotlin's replaceFirstChar behavior
    private static String modifyName(String name) {
        if (name.isEmpty()) {
            return name;
        }
        char firstChar = name.charAt(0);
        if (Character.isLowerCase(firstChar)) {
            return Character.toTitleCase(firstChar) + name.substring(1);
        }
        return name;
    }
}


public class ClassInitOrderJ {

    public static void main(String[] args) {
        Derived4J obj = new Derived4J("john", "Doe");
    }
}


