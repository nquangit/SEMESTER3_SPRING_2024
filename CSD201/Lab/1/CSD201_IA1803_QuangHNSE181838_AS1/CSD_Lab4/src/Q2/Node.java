/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

public class Node {

    String info;
    Node left;
    Node right;

    public Node() {
    }

    public Node(String info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(String info) {
        this(info, null, null);
    }
}
