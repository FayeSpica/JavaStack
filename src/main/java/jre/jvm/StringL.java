package jre.jvm;

import java.util.Arrays;

public class StringL {
    private final char[] value;

    public StringL() {
        this.value = "".toCharArray();
    }

    public StringL(char value[]) {
        this.value = Arrays.copyOf(value, value.length);
    }
    public StringL(StringL original) {
        this.value = original.value;
    }

    public static void main(String[] args){
        System.out.println("Hello StringL");
    }
}
