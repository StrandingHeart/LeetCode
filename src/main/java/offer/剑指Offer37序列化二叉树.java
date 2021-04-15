package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyong
 * Created on 2021-04-15
 */
public class 剑指Offer37序列化二叉树 {
    //请实现两个函数，分别用来序列化和反序列化二叉树。
    //
    //示例: 
    //
    //你可以将以下二叉树：
    //
    //    1
    //   / \
    //  2   3
    //     / \
    //    4   5
    //
    //序列化为 "[1,2,3,null,null,4,5]"
}
class Codec {
    private final String NULL = "#";
    private final String SPLIT = ",";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialStr(root,sb);
        return sb.toString();
    }

    public StringBuilder serialStr(TreeNode root,StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SPLIT);
            return sb;
        }
        sb.append(root.val).append(SPLIT);
        serialStr(root.left,sb);
        serialStr(root.right,sb);
        return sb;
    }


    // Decodes your encoded data to tree.
    List<String> list = new ArrayList<>();
    public TreeNode deserialize(String data) {
        String[] split = data.split(SPLIT);
        this.list = new ArrayList<>(Arrays.asList(split));
        return deserializeStr();
    }

    public TreeNode deserializeStr(){
        if (list.isEmpty() || NULL.equals(list.get(0))){
            list.remove(0);
            return null;
        }
        String remove = list.remove(0);
        TreeNode root = new TreeNode(Integer.parseInt(remove));
        root.left = deserializeStr();
        root.right = deserializeStr();
        return root;
    }


}