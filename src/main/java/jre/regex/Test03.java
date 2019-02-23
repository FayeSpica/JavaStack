package jre.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象的替换、分割
 * */
public class Test03 {
    public static void main(String[] args){

        testReplace();
        testSplit();
    }

    public static void testReplace(){
        Pattern p = Pattern.compile("[0-9]");

        Matcher m = p.matcher("aa232**ssd445*sds223");

        //替换
        String str = m.replaceAll("#");
        System.out.println(str);
    }

    public static void testSplit(){
        String str = "a,b,c";
        String[] arrs = str.split(",");
        System.out.println(Arrays.toString(arrs));
    }
}

