package huffmancoding;


import huffmancoding.HuffmanCoding;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        String str = "thanhlong!";
        /*
            t   0.1
            h   0.2
            a   0.1
            n   0.2
            l   0.1
            o   0.1
            g   0.1
            !   0.1
        
            h     n     t     a     l     o     g     !
           0.2   0.2   0.1   0.1   0.1   0.1   0.1   0.1
                                                        
                       
        
        
        
         */

        System.out.println("Source: " + str);
        HuffmanCoding h = new HuffmanCoding().process(str);
        String encoded = h.encode();
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + h.decode(encoded));

    }
}
