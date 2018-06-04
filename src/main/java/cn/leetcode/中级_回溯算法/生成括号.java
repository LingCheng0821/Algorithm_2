package cn.leetcode.中级_回溯算法;

import cn.leetcode.StringUtil;
import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Laura on 2018/5/30.
 */
public class 生成括号 {

    @Test
    public void test(){
        List<String> result = generateParenthesis(3);
        for (String var : result) {
            System.out.println(var + "");
        }
    }

    public List<String> generateParenthesis(int n) {

        if(n == 0) return Collections.emptyList();
        if(n == 1) return Arrays.asList("(",")");

        List<String> result = new ArrayList<>();

        //开始回溯
        huisu(n, n, "", result);

        return result;
    }

    private void huisu(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        huisu(left - 1, right, out + "(", res);
        huisu(left, right - 1, out + ")", res);
    }
}
