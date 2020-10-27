package tree;

import java.util.ArrayList;

/**
 * Binary tree 二叉树
 *
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 *
 * 中序遍历：左子树---> 根结点 ---> 右子树
 *
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 *
 * 层次遍历：仅仅需按层次遍历就可以
 *
 * void Traverse(TreeNode root){
 *      前序遍历
 *      preTraverse(root.left);
 *      中序遍历
 *      preTraverse(root.right);
 *      后序遍历
 * }
 */
public class Tree01 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(8);
        node.left.left.left.left = new TreeNode(8);

        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.print("前序遍历\t");
        node.preTraverse(node);
        System.out.println();
        System.out.print("中序遍历\t");
        node.inTraverse(node);
        System.out.println();
        System.out.print("后序遍历\t");
        node.postTraverse(node);
        System.out.println();
        System.out.print("层序遍历\t");
        node.levelTraverse(node);
        System.out.println();
        System.out.print("左子树高\t");
        System.out.println(node.height(node.left,0));
        System.out.println();
        System.out.print("右子树高\t");
        System.out.println(node.height(node.right,0));
        System.out.println();
        System.out.print("树高差\t");
        System.out.print(Math.abs(node.height(node.left, 0) - node.height(node.right, 0)));
    }
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}

        public int height(TreeNode root,int height){
            if (root == null){
                return height;
            }
            int current = Math.max(height(root.left,height+1),height);
            current = Math.max(height(root.right,height+1),current);
            return current;
        }
        public void preTraverse(TreeNode root){
            if (root == null) {return ;}
            System.out.print(root.val);
            preTraverse(root.left);
            preTraverse(root.right);
        }
        public void inTraverse(TreeNode root){
            if (root == null) {return ;}
            inTraverse(root.left);
            System.out.print(root.val);
            inTraverse(root.right);
        }
        public void postTraverse(TreeNode root){
            if (root == null) {return ;}
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.print(root.val);
        }

        public void levelTraverse(TreeNode root){
            ArrayList<TreeNode> list = new ArrayList<>();

            if (root!=null){
                list.add(root);
            }

            while (!list.isEmpty()){
                if(list.get(0).left!=null){
                    list.add(list.get(0).left);
                }
                if (list.get(0).right!=null){
                    list.add(list.get(0).right);
                }
                System.out.print(list.get(0).val);
                list.remove(0);
            }
        }
    }
}
