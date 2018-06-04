package cn.leetcode.中级_设计;

import cn.leetcode.中级_树和图.TreeNode;
import cn.leetcode.中级_树和图.TreeNodeUtil;
import org.junit.Test;

/**
 * Created by Laura on 2018/6/1.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/52/design/109/
 * Serialize and Deserialize Binary Tree
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列/反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且这个字符串可以被反序列化得到一个原始的树结构。
 */
public class 反_序列化二叉树 {

    @Test
    public void test(){
        TreeNode root = TreeNodeUtil.createTree();
        System.out.println(deserialize("4,2,1,null,null,3,null,null,6,5,null,null,7,null,8,null,10,null,null,"));
    }

    private final String NULLSTR = "null";
    private final String SPILE = ",";
    int index = -1;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) 	 return "";
        StringBuilder sb = new StringBuilder();
        Serialize2(root, sb);
        return sb.toString();
    }
    private void Serialize2(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULLSTR).append(SPILE);
            return;
        }
        sb.append(root.val);
        sb.append(',');
        Serialize2(root.left, sb);
        Serialize2(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)  return null;
        String[] strs = data.split(SPILE);
        return Deserialize2(strs);
    }
    private TreeNode Deserialize2(String[] strs) {
        index++;
        if(!strs[index].equals(NULLSTR)) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }
        return null;
    }

}
