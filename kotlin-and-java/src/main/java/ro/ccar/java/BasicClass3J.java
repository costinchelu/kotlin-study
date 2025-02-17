package ro.ccar.java;


// property with default value
public class BasicClass3J {

    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Test {
    public static void main(String[] args) {
        BasicClass3J basicClass3J = new BasicClass3J();
        String name = basicClass3J.getName();
        basicClass3J.setName("name");
    }
}
