/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q11;

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

        int height = calculateHeight(root);
        System.out.println("Height of the binary tree: " + height);
    }

    // Recursive method to calculate the height of a binary tree
    static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        // Return the maximum height of the left and right subtrees plus 1 (for the current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
