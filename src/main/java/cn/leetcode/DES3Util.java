package cn.leetcode;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES3Util {

    /**
     * 加密 默认编码utf-8
     *
     * @param input    待加密的字符串
     * @param password 加密的密码（只能为8位长）
     * @param encoding 编码
     * @return 加密之后的文本（返回16进制编码后的加密串）
     */
    public static String encryptForDES(String input, String password, String encoding) {
        return byteArr2HexStr(encryptByte(input, password, encoding));
    }

    /**
     * 私有构造
     */
    private DES3Util() {
    }

    /**
     * des加密 自定义编码
     *
     * @param strIn       要加密的字符串
     * @param strKey      密钥
     * @param encodingStr encodingStr
     * @return 加密后的字符串
     */
    public static byte[] encryptByte(String strIn, String strKey, String encodingStr) {
        try {
            return desOperate(strIn.getBytes(encodingStr), strKey, encodingStr, "encrypt");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * des解码,与方法encryptForDES为对称方法
     *
     * @param strIn       要解密的字符串
     * @param strKey      密钥
     * @param encodingStr encodingStr
     * @return 解密后的字符串
     */
    public static String decryptStr(String strIn, String strKey, String encodingStr) {
        try {
            return new String(desOperate(hexStr2ByteArr(strIn), strKey, encodingStr, "decrypt"), encodingStr);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 如果失败返回null
     *
     * @param bytesrc     bytesrc
     * @param strKey      strKey
     * @param encodingStr encodingStr
     * @param crypttype   crypttype
     * @return byte[]
     */
    private static byte[] desOperate(byte[] bytesrc, String strKey, String encodingStr, String crypttype) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(strKey.getBytes(encodingStr)); // 创建一个DESKeySpec对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES"); // 创建一个密匙工厂
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec); // 将desKeySpec对象转换成SecretKey对象
            IvParameterSpec iv = new IvParameterSpec(strKey.getBytes(encodingStr));
            cipher.init(crypttype == "encrypt" ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, secretKey, iv); // 用密匙初始化Cipher对象
            byte[] retByte = cipher.doFinal(bytesrc); // 真正开始加密或解密,取决于Cipher初始化时选择的模式
            return retByte;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将byte数组转换为表示16进制值的字符串
     *
     * @param arrB 需要转换的byte数组
     * @return 转换后的字符串
     */
    public static String byteArr2HexStr(byte[] arrB) {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            byte b = arrB[i];
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 将16进制值的字符串转化为数组
     *
     * @param hexStr 需要转化的16进制值的字符串
     * @return 返回的byte数组
     */
    public static byte[] hexStr2ByteArr(String hexStr) {
        if (hexStr != null && hexStr.length() % 2 == 0) {
            int strLen = hexStr.length();
            byte[] byteArr = new byte[strLen / 2];
            for (int i = 0, k = 0; i < byteArr.length; i++, k += 2) {
                int h = Character.digit(hexStr.charAt(k), 16);
                int l = Character.digit(hexStr.charAt(k + 1), 16);
                if (h == -1 || l == -1) {
                    throw new IllegalArgumentException("请传入16进制格式字符串");
                }
                byte high = (byte) (h & 0xff);
                byte low = (byte) (l & 0xff);
                byteArr[i] = (byte) (high << 4 | low);
            }
            return byteArr;
        }
        throw new IllegalArgumentException("请传入16进制格式字符串");
    }
}
