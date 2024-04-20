/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

public class Node {

    int info;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(int info) {
        this(info, null, null);
    }
}
