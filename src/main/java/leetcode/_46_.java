package leetcode;

import java.util.*;

/**
 * @author liaowm5
 * @version 1.0
 * @description TODO
 * @date 2019-02-24 00:59
 **/
public class _46_ {

    List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums,0);
        return lists;
    }

    public void permute(int[] nums,int i) {
        if(i>nums.length){
            return;
        }

        Integer[] numInts = new Integer[nums.length];
        for (int j=0;j<nums.length;j++){
            numInts[j]=nums[j];
        }
        lists.add(Arrays.asList(numInts));

        int tmp;
        for(int j=i+1;j<nums.length-1;j++){
            tmp=nums[j];
            nums[j]=nums[j+1];
            nums[j+1]=tmp;
            permute(nums,i+1);
        }
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for(char c:s.toCharArray()){
            stack.push(c);
        }
        int c=0;
        while (!stack.empty()){
            c=0;
            if(stack.peek().equals('[')){
                stack.pop();
                c=stack.pop();
                while (c>0){
                    sb.append(tmp);
                }
            }if(stack.peek().equals(']')){

            }
//            Character.isDigit()
        }

        return sb.reverse().toString();
    }
}
