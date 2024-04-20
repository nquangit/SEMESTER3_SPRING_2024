/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xType,int xCapacity, int xPrice) {
        //You should write here appropriate statements to complete this function. 
        if(xPrice>=1000){
            Plane newPlane = new Plane(xType, xCapacity, xPrice);
            Node newNode = new Node(newPlane);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Plane x= new Plane("Boeing747",400,1500);
        Plane y = new Plane("AirbusA300",300,2000);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/   
        Node headNode = new Node(y);
        Node beforeTailNode = new Node(x);
        
        headNode.next = head;
        head = headNode;
        
        Node iter = head;
        while (iter.next != tail) {
            iter = iter.next;
        }
        
        iter.next = beforeTailNode;
        beforeTailNode.next = tail;

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }    

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/     
        
        Node firstNode = head;
        Node secondNode = null;
        
        Node iter = head;
        int index = 0;
        while (iter.next != null) {
            iter = iter.next;
            index++;
            if (index == 3) {
                secondNode = iter;
                break;
            }
        }
        
        Node after4Node = secondNode.next.next;
        Node newHeadNode = secondNode.next;
        newHeadNode.next = head.next;
        secondNode.next = head;
        secondNode.next.next = after4Node;
        head = newHeadNode;
        
        
        
        
		
		
		
		
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        int size = 1;
        Node iter = head;
        while (iter.next != null) {
            iter = iter.next;
            size++;
        }
        
        Node tmpHead = null;
        iter = head;
        int count = 1;
        while (iter.next != null) {
            iter = iter.next;
            count++;
            if (size - count == 5) {
                tmpHead = iter;
            }
        }
        
        iter = tmpHead;
        while (iter.next != null) {
            
        }
		
		
		
		
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
   
}
