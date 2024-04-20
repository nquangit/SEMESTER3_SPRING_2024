/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequentialcoloring;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class Graph {

    private final int[][] adjacencyMatrix; // Adjacency matrix
    private final int numVertices; // Number of vertices

    // Constructor
    public Graph(int[][] matrix) {
        this.adjacencyMatrix = matrix;
        this.numVertices = matrix.length;
    }

    // Sequential coloring algorithm
    public int[] colorVertices() {
        int[] colors = new int[numVertices]; // Array to store colors assigned to vertices
        Arrays.fill(colors, -1); // Initialize all colors to -1 (unassigned)

        for (int vertex = 0; vertex < numVertices; vertex++) {
            boolean[] availableColors = new boolean[numVertices]; // Array to keep track of available colors

            // Mark all colors as available
            Arrays.fill(availableColors, true);

            // Check colors of adjacent vertices and mark them as unavailable
            for (int adjacentVertex = 0; adjacentVertex < numVertices; adjacentVertex++) {
                if (adjacencyMatrix[vertex][adjacentVertex] == 1 && colors[adjacentVertex] != -1) {
                    availableColors[colors[adjacentVertex]] = false;
                }
            }

            // Find the first available color
            int chosenColor;
            for (chosenColor = 0; chosenColor < numVertices; chosenColor++) {
                if (availableColors[chosenColor]) {
                    break;
                }
            }

            // Assign the chosen color to the current vertex
            colors[vertex] = chosenColor;
        }

        return colors;
    }

    public static void main(String[] args) {
        // Sample adjacency matrix
        int[][] sampleAdjacencyMatrix = {
            {0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };

        Graph graph = new Graph(sampleAdjacencyMatrix);

        // Assign colors to vertices
        int[] colors = graph.colorVertices();

        // Display colors assigned to vertices
        System.out.println("Colors assigned to vertices:");
        for (int i = 0; i < colors.length; i++) {
            System.out.println("Vertex " + i + ": Color " + colors[i]);
        }
    }
}
