/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author ASUS
 */
public class Graph {

    private int[][] adjacencyMatrix;
    private String[] label;
    private int n;

    // Constructor
    public Graph() {
    }

    // Set adjacency matrix
    public void setAMatrix(int[][] b, int m) {
        n = m;
        adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(b[i], 0, adjacencyMatrix[i], 0, n);
        }
    }

    // Set labels for vertices
    public void setLabel(String[] c) {
        label = new String[n];
        System.arraycopy(c, 0, label, 0, n);
    }

    // Breadth-first traverse
    public void breadthFirstTraverse() {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(label[i] + " ");
                queue.add(i);
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (adjacencyMatrix[v][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            System.out.print(label[j] + " ");
                            queue.add(j);
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    // Depth-first traverse
    public void depthFirstTraverse() {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(label[i] + " ");
                stack.push(i);
                while (!stack.isEmpty()) {
                    int v = stack.pop();
                    for (int j = 0; j < n; j++) {
                        if (adjacencyMatrix[v][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            System.out.print(label[j] + " ");
                            stack.push(j);
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            // Read adjacency matrix from file 1
            Scanner scanner1 = new Scanner(new File("adjacency_matrix.txt"));
            int n1 = 6; // Number of vertices for file 1
            int[][] matrix1 = new int[n1][n1];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n1; j++) {
                    matrix1[i][j] = scanner1.nextInt();
                }
            }

            // Read vertex labels from file 1
            Scanner labelScanner1 = new Scanner(new File("vertex_labels.txt"));
            String[] labels1 = new String[n1];
            for (int i = 0; i < n1; i++) {
                labels1[i] = labelScanner1.next();
            }

            // Create and configure the graph for file 1
            Graph graph1 = new Graph();
            graph1.setAMatrix(matrix1, n1);
            graph1.setLabel(labels1);

            // Perform breadth-first and depth-first traversals for file 1
            System.out.println("Breadth-first traverse for file 1:");
            graph1.breadthFirstTraverse();
            System.out.println("Depth-first traverse for file 1:");
            graph1.depthFirstTraverse();

            // Read adjacency matrix from file 2
            Scanner scanner2 = new Scanner(new File("adjacency_matrix2.txt"));
            int n2 = 3; // Number of vertices for file 2
            int[][] matrix2 = new int[n2][n2];
            for (int i = 0; i < n2; i++) {
                for (int j = 0; j < n2; j++) {
                    matrix2[i][j] = scanner2.nextInt();
                }
            }

            // Read vertex labels from file 2
            Scanner labelScanner2 = new Scanner(new File("vertex_labels2.txt"));
            String[] labels2 = new String[n2];
            for (int i = 0; i < n2; i++) {
                labels2[i] = labelScanner2.next();
            }

            // Create and configure the graph for file 2
            Graph graph2 = new Graph();
            graph2.setAMatrix(matrix2, n2);
            graph2.setLabel(labels2);

            // Perform breadth-first and depth-first traversals for file 2
            System.out.println("Breadth-first traverse for file 2:");
            graph2.breadthFirstTraverse();
            System.out.println("Depth-first traverse for file 2:");
            graph2.depthFirstTraverse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
