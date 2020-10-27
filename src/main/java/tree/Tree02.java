package tree;

import java.util.ArrayList;

public class Tree02 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);

        Tree02 tree02 = new Tree02();
        ListNode[] listNodes = tree02.listOfDepth(treeNode);
        for (ListNode listNode : listNodes) {
            System.out.println(listNode.val);
            if(listNode.next!=null){
                System.out.println(listNode.next.val);
            }
        }
    }
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return null;
        // 根节点入队
        ArrayList<TreeNode> list = new ArrayList();
        list.add(tree);

        // 结果链表
        ArrayList<ListNode> resultList = new ArrayList();

        while(!list.isEmpty()){
            ArrayList<TreeNode> tempList = new ArrayList();
            ListNode listNode = null;
            for (TreeNode treeNode : list){
                if(treeNode.left != null){
                    tempList.add(treeNode.left);
                }
                if(treeNode.right != null){
                    tempList.add(treeNode.right);
                }
                if(listNode == null){
                    listNode = new ListNode(treeNode.val);
                }else{
                    listNode.next = new ListNode(treeNode.val);
                }
            }
            resultList.add(listNode);
            list.clear();
            list.addAll(tempList);
        }
        return resultList.toArray(new ListNode[]{});
    }

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
   public static class ListNode {
        int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
