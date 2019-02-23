package jre;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test extends Thread{
    private int a=10;
    int b=20;
    static int c=1;

    public Test(){
        List<Integer> list=new ArrayList<>();

    }


    private static void test(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] % 2 == 0) {
                    throw new NullPointerException();
                } else {
                    System.out.print(i);
                }
            } finally {
                System.out.print("e");
            }
        }
    }
    private float f = 1.0f;
    int m = 12;
    static int n = 1;
    public static void main(String[]args) {
        try {
            test(new int[] {0, 1, 2, 3, 4, 5});
        } catch (Exception e) {
            System.out.print("E");
        }
        System.out.println(10%3*2);

        Test t = new Test();
        int j=1;
        System.out.println(~j);

    }

    public final void t1(){

    }

    public void t1(int a){

    }

    @Override
    public void start(){
        for(int i=0;i<10;i++){
            System.out.println("Value of i = "+i);
        }
    }


}

interface Run{
    void start();
}

abstract class A implements Run{
    public abstract void start();
}

class Glass{
    void setColor(){

    }
}

class BlueGlass extends Glass{
    @Override
    public void setColor() {
        super.setColor();
    }
}
