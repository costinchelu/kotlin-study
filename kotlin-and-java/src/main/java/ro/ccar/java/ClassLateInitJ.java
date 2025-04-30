package ro.ccar.java;

import org.jetbrains.annotations.NotNull;

// in java we don't have non nullable fields and the annotation is used only for analysis
public final class ClassLateInitJ {

    @NotNull public String name;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String string) {
        this.name = string;
    }
}
