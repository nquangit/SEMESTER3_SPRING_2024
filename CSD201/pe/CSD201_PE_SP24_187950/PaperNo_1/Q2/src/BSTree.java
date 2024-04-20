/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xPlace, int xWeight, int xColor) {
        //You should insert here statements to complete this function
        //---------------------------------------
		
        if (xPlace.charAt(0) == 'X') {
            return;
        }
        
	Bird newBird = new Bird(xPlace, xWeight, xColor);
        Node newNode = new Node(newBird);
        
        if (root == null) {
            root = newNode;
            return;
        }
        
        Node p = root;
        while (p != null) {
            if (newNode.info.weight == p.info.weight) {
                return;
            }
            if (newNode.info.weight < p.info.weight) {
                if (p.left == null) {
                    p.left = newNode;
                } else { 
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = newNode;
                } else { 
                    p = p.right;
                }
            }
        }
		
		//---------------------------------------        
    }

//Do not edit this function. 
//Your task is to complete the insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.color > 4) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder(p.right, f);
    }
    
//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        
        Node p = root.left;
	preOrder2(p, f);
		
		

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//=============================================================

    void reverseInOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        reverseInOrder(p.right, f);
        fvisit(p, f);
        reverseInOrder(p.left, f);
    }
    
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        Node p = root;
        reverseInOrder(p, f);
		

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================

    void preOrderInternal(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.left != null || p.right != null) {
            fvisit(p, f);
        }
        preOrderInternal(p.left, f);
        preOrderInternal(p.right, f);
    }
    
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        Node p = root;
	preOrderInternal(p, f);


        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//=============================================================

    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        
        Node p = root;
        int leafCount = 0;
        if (p == null) {
            f.writeBytes(Integer.toString(leafCount));
            f.writeBytes("\r\n");
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left == null && r.right == null) {
                leafCount++;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
	
        f.writeBytes(Integer.toString(leafCount));
        f.writeBytes("\r\n");
		
		
        //------------------------------------------------------------------------------------
        f.close();
    }
}
