package com.test;

/**
 * Created by Laura on 2018/4/12.
 */
public class Test {
    public static void main(String[] args) {
        String s = "^";
        if (s != null && !s.equals("none")) {
            String liveArea = s.split("\\^")[0]; //substring_index(liveArea, '^', 1)
            System.out.println(liveArea);
        }

    }
}
