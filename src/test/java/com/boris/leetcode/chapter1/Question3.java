package com.boris.leetcode.chapter1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: boris
 * @Data: Created on 2020/10/23
 * @Description:
 */
public class Question3 {
    /*
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        示例 1:

        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    */

    @Test
    public void test() {
//        String str = "abcad";
        String str = "ababcabcdab";
        System.out.println(this.getMaxDiffrentLength(str));
    }

    public int getMaxDiffrentLength(String str) {
        Set<Character> set = new HashSet<>();
        int maxLenth = 0;
        int range;
        for (int i = 0; i < str.length(); i++) {
            if (str.length()-i<=maxLenth) {
                System.out.println("break;");
                break;
            }

            if (i > 0) {
                set.remove(str.charAt(i-1));
            } else {
                set.add(str.charAt(i));
            }

            range = i + 1;
            while (range<str.length() && !set.contains(str.charAt(range))) {
                set.add(str.charAt(range));
                range++;
            }

            maxLenth = Math.max(maxLenth, range-i);
        }
        return maxLenth;
    }

}
