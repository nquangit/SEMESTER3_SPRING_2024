/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q12;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int size = calculateSize(root);
        System.out.println("Size of the binary tree: " + size);
    }

    // Recursive method to calculate the size of a binary tree
    static int calculateSize(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate the size of the left and right subtrees
        int leftSize = calculateSize(root.left);
        int rightSize = calculateSize(root.right);

        // Return the total size of the tree, which is the sum of left and right subtrees plus 1 (for the current node)
        return leftSize + rightSize + 1;
    }
}
