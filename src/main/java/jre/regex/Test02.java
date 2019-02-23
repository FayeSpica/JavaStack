package jre.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象的分组用法
 * */
public class Test02 {
    public static void main(String[] args){

        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");

        Matcher m = p.matcher("aa232**ssd445*sds223");

        while (m.find()) {
            System.out.println(m.group()); // group()、group(0)匹配整个表达式的子字符串
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }
}

