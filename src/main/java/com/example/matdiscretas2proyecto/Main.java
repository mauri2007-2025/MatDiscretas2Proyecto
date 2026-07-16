package com.example.matdiscretas2proyecto;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        FileManager.loadGraphFromFile("graph.txt", graph);

        graph.displayGraph();

        System.out.println();

        System.out.println("Is Tree? " + graph.isTree());

        System.out.println("Has Euler Path? " + graph.hasEulerPath());

        System.out.println("Has Euler Circuit? " + graph.hasEulerCircuit());

        System.out.println();

        System.out.println("Shortest distances from vertex 0:");

        System.out.println(graph.dijkstra(0));

        System.out.println();

        System.out.println("Degree of vertex 0: " + graph.getVertexDegree(0));

        System.out.println("Degree of vertex 1: " + graph.getVertexDegree(1));

        System.out.println("Degree of vertex 2: " + graph.getVertexDegree(2));

        System.out.println();

        System.out.println("Is simple graph? " + graph.isSimpleGraph());

        System.out.println();

        System.out.println("Is complete graph? " + graph.isCompleteGraph());

    }

}