package problem968;

import common.TreeNode;
import common.TreeUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution1 {
    private HashSet<TreeNode> watched = new HashSet<>();
    private HashSet<TreeNode> cameraNodes = new HashSet<>();
    private LinkedList<TreeNode> path = new LinkedList<>();
    private int cameraCount = 0;

    private void dfs(TreeNode root) {
        if (root == null) return;
        path.add(root.left);
        dfs(root.left);
        path.remove(path.size() - 1);
        path.add(root.right);
        dfs(root.right);
        path.remove(path.size() - 1);
        // 当前节点已监控,不装
        if (watched.contains(root)) return;
        // 当前节点未监控,且子女已监控,可以在父节点设监控
        if (watched.contains(root.left) && watched.contains(root.right)) {
            // 爷爷节点
            if (path.size() >= 3) watched.add(path.get(path.size() - 3));
            // 父亲节点
            if (path.size() >= 2) watched.add(path.get(path.size() - 2));
            // 当前节点
            watched.add(root);
            // 兄弟节点
            if (path.size() >= 2) {
                watched.add(path.get(path.size() - 2).left);
                watched.add(path.get(path.size() - 2).right);
            }
        }
        // 当前节点未监控,且子女未监控,可以在当前节点设监控
        else {
            // 父亲节点
            if (path.size() >= 2) watched.add(path.get(path.size() - 2));
            // 当前节点
            watched.add(root);
            // 子女节点
            watched.add(root.left);
            watched.add(root.right);
        }
//        System.out.println(Arrays.toString(path.stream().map(x -> x == null ? null : x.val).toArray()));
//        System.out.println(Arrays.toString(watched.stream().map(x -> x == null ? null : x.val).toArray()));
//        System.out.println(Arrays.toString(cameraNodes.stream().map(x -> x == null ? null : x.val).toArray()));
        ++cameraCount;
    }

    public int minCameraCover(TreeNode root) {
        watched.add(null);
        path.push(root);
        dfs(root);
        return cameraCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().minCameraCover(TreeUtil.buildTree(new Integer[]{1,2,null,4,5}))); // 1
        System.out.println(new Solution1().minCameraCover(TreeUtil.buildTree(new Integer[]{
                1,
                2,null,
                4,null,null,null,
                8,null,null,null,null,null,null,null,
                16
        }))); // 2
    }
}
