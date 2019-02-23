package jre.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象的基本用法
 * */
public class Test01 {
    public static void main(String[] args){
        String s="asfsdf2&&23323";

        Pattern p = Pattern.compile("\\w+");

        Matcher m = p.matcher(s);

        //boolean y= m.matches(); //尝试将整个字符序列与该模式匹配

        //boolean y1 = m.find(); //该方法扫描输入的序列，查找与该模式匹配的下一个子序列

        while (m.find()) {
            System.out.println(m.group()); // group()、group(0)匹配整个表达式的子字符串
            System.out.println(m.group(0));
        }
    }
}
