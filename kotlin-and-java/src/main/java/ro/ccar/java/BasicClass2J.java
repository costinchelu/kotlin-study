package ro.ccar.java;

public class BasicClass2J {

    private String name;

    private int age;

    private BasicClass1J parent;

    public BasicClass2J(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public BasicClass2J(String name, int age, BasicClass1J parent) {
        this.name = name;
        this.age = age;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BasicClass1J getParent() {
        return parent;
    }

    public void setParent(BasicClass1J parent) {
        this.parent = parent;
    }
}
