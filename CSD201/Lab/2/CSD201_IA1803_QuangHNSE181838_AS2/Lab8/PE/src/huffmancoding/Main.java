package huffmancoding;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        String str = "thíisateststring!";
        System.out.println("Source: " + str);
        HuffmanCoding h = new HuffmanCoding().process(str);
        String encoded = h.encode();
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + h.decode(encoded));

    }
}
