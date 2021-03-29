package labuladong;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyong
 * Created on 2021-03-29
 */
public class Q297二叉树的序列号与反序列化 {

}
class Codec {

    public final String NULL = "#";
    public final String SPLIT = ",";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeStr(root,sb);
        return sb.toString();
    }

    public StringBuilder serializeStr(TreeNode root,StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SPLIT);
            return sb;
        }
        sb.append(root.val).append(SPLIT);
        serializeStr(root.left,sb);
        serializeStr(root.right,sb);
        return sb;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0){
            return null;
        }
        String[] split = data.split(SPLIT);
        List<String> list = new LinkedList<>();
        for (String s : split) {
            list.add(s);
        }
        return deserializeStr(list);
    }


    public TreeNode deserializeStr(List<String> list) {
        if (list.size() == 0){
            return null;
        }
        String remove = list.remove(0);
        if (NULL.equals(remove)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(remove));
        root.left = deserializeStr(list);
        root.right = deserializeStr(list);
        return root;
    }

}
