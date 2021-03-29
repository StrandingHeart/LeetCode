package labuladong;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyong
 * Created on 2021-03-29
 */
public class Q652寻找重复的子树 {
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return res;
    }

    public String find(TreeNode root){
        if (root == null){
            return "#";
        }
        String left = find(root.left);
        String right = find(root.right);
        String sub = root.val + ","+left+","+right;
        Integer orDefault = map.getOrDefault(sub, 0);
        if (orDefault == 1){
            // == 1代表第二次，说明重复了
            res.add(root);
        }
        map.put(sub,orDefault+1);
        return sub;
    }
}
