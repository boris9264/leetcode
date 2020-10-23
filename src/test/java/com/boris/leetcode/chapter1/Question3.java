package com.boris.leetcode.chapter1;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
        String str = "pwawkew";

        System.out.println(this.getMaxDiffrentLength(str));
    }

    public int getMaxDiffrentLength(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }

        if (str.length()==1) {
            return 1;
        }

        String[] strArr = str.split("");
        int maxDiffrentLength = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr.length - i < maxDiffrentLength) {
                break;
            }
            List<String> strList = new ArrayList<>();
            strList.add(strArr[i]);
            for (int j = i+1; j < strArr.length; j++) {
                if (!strList.contains(strArr[j])) {
                    strList.add(strArr[j]);
                } else {
                    if (strList.size() > maxDiffrentLength) {
                        maxDiffrentLength = strList.size();
                    }
                    break;
                }
            }
        }
        return maxDiffrentLength;
    }

}
