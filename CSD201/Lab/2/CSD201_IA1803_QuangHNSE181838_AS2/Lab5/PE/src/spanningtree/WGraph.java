package spanningtree;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class WGraph {

    private final int[][] weightedMatrix; // Weighted adjacency matrix
    private final int numVertices; // Number of vertices

    // Constructor
    public WGraph(int[][] matrix) {
        this.weightedMatrix = matrix;
        this.numVertices = matrix.length;
    }

    // Prim's algorithm for Minimum Spanning Tree (MST)
    public int[][] primMST() {
        int[][] mst = new int[numVertices][numVertices]; // Initialize MST to store edges
        boolean[] visited = new boolean[numVertices]; // Keep track of visited vertices
        int[] minWeight = new int[numVertices]; // Minimum weight of edges connecting visited vertices
        Arrays.fill(minWeight, Integer.MAX_VALUE); // Initialize minWeight array with max value
        int minVertex = 0; // Starting vertex

        // Start with vertex 0
        minWeight[minVertex] = 0;

        // Loop through all vertices
        for (int i = 0; i < numVertices - 1; i++) {
            visited[minVertex] = true; // Mark vertex as visited

            // Update minWeight and mst for adjacent vertices
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && weightedMatrix[minVertex][j] != 0 && weightedMatrix[minVertex][j] < minWeight[j]) {
                    mst[minVertex][j] = minWeight[j] = weightedMatrix[minVertex][j];
                    mst[j][minVertex] = minWeight[j];
                }
            }

            // Find the next vertex to visit (minimum weight edge)
            minVertex = findMinWeightVertex(minWeight, visited);
        }

        return mst;
    }

    // Helper method to find the vertex with minimum weight edge connecting to visited vertices
    private int findMinWeightVertex(int[] minWeight, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minVertex = -1;
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && minWeight[i] < min) {
                min = minWeight[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        int[][] weightedMatrix = {
            {0, 2, 0, 9, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 1, 7},
            {9, 8, 1, 0, 9},
            {0, 5, 7, 9, 0}
        };

        WGraph graph = new WGraph(weightedMatrix);

        int[][] mst = graph.primMST();

        System.out.println("Minimum Spanning Tree (MST):");
        for (int[] mst1 : mst) {
            for (int j = 0; j < mst1.length; j++) {
                System.out.print(mst1[j] + " ");
            }
            System.out.println();
        }
    }
}
