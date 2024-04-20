/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

public class Main {

    public static void main(String[] args) {
        String[] x = {"60", "90", "80", "100", "50", "55", "40"};
        BSTree tree = new BSTree();
        for (String x1 : x) {
            tree.insert(x1);
        }
        tree.preOrder(tree.root);//60 50 40 55 90 80 100
        System.out.println("");
        tree.inOrder(tree.root);//40 50 55 60 80 90 100
        System.out.println("");
        tree.breadth(tree.root);
        System.out.println("");

        System.out.println(tree.min(tree.root));
        System.out.println(tree.max(tree.root));

        System.out.println(tree.isAVL());

        /*Part 2___________________________________________________________________*/
//        int [] x = {44, 17, 78, 32, 50, 88, 48, 62, 54};
//        BSTree tree = new BSTree();
//        for(int i = 0; i < x.length; i++) tree.insert(x[i]);
//        tree.BFT(tree.root);
//        System.out.println("");
//        tree.balance(tree.root);
//        tree.BFT(tree.root);
//        System.out.println("");

        /*Part 3___________________________________________________________________*/
// TODO code application logic here
    }
}
