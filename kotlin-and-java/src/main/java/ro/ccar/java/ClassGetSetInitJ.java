package ro.ccar.java;


import org.jetbrains.annotations.NotNull;

class UsingValAndNoInitJ {
    @NotNull private final String name;

    public UsingValAndNoInitJ(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}


class UsingVarAndNoInitJ {
    @NotNull private String name;

    public UsingVarAndNoInitJ(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void setName(@NotNull String string) {
        this.name = string;
    }
}

class UsingValAndInitJ {
    @NotNull private final String name;

    public UsingValAndInitJ() {
        name = "";
    }

    public UsingValAndInitJ(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}

class UsingVarAndInitJ {
    @NotNull private String name;

    public UsingVarAndInitJ() {
        name = "";
    }

    public UsingVarAndInitJ(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void setName(@NotNull String string) {
        this.name = string;
    }
}


class PropertyWorkingOnExistingFieldJ {
    private int size;

    public PropertyWorkingOnExistingFieldJ(int size) {
        this.size = size;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int n) {
        this.size = n;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final void setEmpty(boolean value) {
        if (value) {
            this.size = 0;
        }
    }
}

class AccessFieldJ {
    private int counter;
    private int counterWithoutField;

    public final int getCounter() {
        return this.counter;
    }

    public final void setCounter(int value) {
        if (value >= 0) {
            this.counter = value;
        }
    }

    public final int getCounterWithoutField() {
        return this.counterWithoutField;
    }

    public final void setCounterWithoutField(int value) {
        if (value >= 0) {
            this.setCounter(value);
        }
    }
}

class FunctionAndPropertyJ {
    private int size;

    public FunctionAndPropertyJ(int size) {
        this.size = size;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int n) {
        this.size = n;
    }

    public final boolean isEmptyVal() {
        return this.size == 0;
    }

    public final boolean isEmptyFun() {
        return this.size == 0;
    }
}








public class ClassGetSetInitJ {
}
