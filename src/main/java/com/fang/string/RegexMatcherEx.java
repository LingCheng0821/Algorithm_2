package com.fang.string;

/**
 * ������19��������ʽƥ��
 * ��Ŀ����ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
 * ģʽ�е��ַ�'.'����ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ���0�Σ���
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"
 * ��"ab*ac*a"ƥ�䣬����"aa.a"��"ab*a"����ƥ�䡣
 */
public class RegexMatcherEx {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int s, char[] pattern, int p) {
        if (str.length <= s && pattern.length <= p)
            return true;//��ƥ������
        if (str.length > s && pattern.length <= p)
            return false;//ģʽ���ˣ��ַ�������

        //ģʽ��a*aû������ƥ�䴮�ɽ����ɲ�����

        if (p + 1 < pattern.length && pattern[p + 1] == '*') {//��ǰpattern����һ����*��ʱ

            //�ַ�������
            if (s >= str.length) return matchCore(str, s, pattern, p + 2);
            else {

                if (pattern[p] == str[s] || pattern[p] == '.') {
                    //��ǰλ��ƥ����ɣ��ƶ�����һ��ģʽ��
                    return matchCore(str, s + 1, pattern, p + 2)
                            || matchCore(str, s + 1, pattern, p)
                            || matchCore(str, s, pattern, p + 2);
                } else
                    return matchCore(str, s, pattern, p + 2);
            }
        }
        //��ǰpattern����һ������*ʱ��
        if (s >= str.length) return false;

        else {
            if (str[s] == pattern[p] || pattern[p] == '.')
                return matchCore(str, s + 1, pattern, p + 1);
        }
        return false;
    }
}
