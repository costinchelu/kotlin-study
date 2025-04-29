package ro.ccar.java;

public class BasicClass2J {

    private String name;

    private int age;

    private BasicClassJ parent;

    public BasicClass2J(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public BasicClass2J(String name, int age, BasicClassJ parent) {
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

    public BasicClassJ getParent() {
        return parent;
    }

    public void setParent(BasicClassJ parent) {
        this.parent = parent;
    }
}
