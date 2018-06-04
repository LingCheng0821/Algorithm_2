package cn.leetcode;

import org.junit.Test;

/**
 * Created by Laura on 2018/6/1.
 */
public class TestDemo {
    @Test
    public void test(){
        final String STRKEY = "f02a83d8"; //bi加密秘钥

        final String STRKEYFOROAID = "40c0b601"; //oaId解密秘钥

        String[] src = {"T14963","T181659"};

        for (String var : src){
           String oaid = DES3Util.encryptForDES(var, STRKEY, "utf-8"); // 加密oaid
            System.out.println(var + "加密之后为：" + oaid);
        }

        String s = "57F9758F8F6DD5E6";
        System.out.println(DES3Util.decryptStr(s, STRKEY, "utf-8"));

    }
}
