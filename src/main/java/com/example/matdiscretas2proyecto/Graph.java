package com.example.matdiscretas2proyecto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    private HashMap<Integer, ArrayList<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {

        if (!adjacencyList.containsKey(vertex)) {

            adjacencyList.put(vertex, new ArrayList<>());

        }

    }
    public void addEdge(int source, int target, int weight) {

        addVertex(source);
        addVertex(target);

        adjacencyList.get(source).add(new Edge(target, weight));

        adjacencyList.get(target).add(new Edge(source, weight));

    }
    public void displayGraph() {

        for (Integer vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (Edge edge : adjacencyList.get(vertex)) {

                System.out.print("(" + edge.target + ", " + edge.weight + ") ");

            }

            System.out.println();
        }
    }
        public int getVertexDegree ( int vertex){

            if (!adjacencyList.containsKey(vertex)) {

                return -1;

            }

            return adjacencyList.get(vertex).size();

        }
    public boolean isSimpleGraph() {

        for (Integer vertex : adjacencyList.keySet()) {

            ArrayList<Edge> edges = adjacencyList.get(vertex);

            HashSet<Integer> connectedVertices = new HashSet<>();

            for (Edge edge : edges) {

                // Verificar lazos
                if (vertex == edge.target) {

                    return false;

                }

                // Verificar aristas repetidas
                if (connectedVertices.contains(edge.target)) {

                    return false;

                }

                connectedVertices.add(edge.target);

            }

        }

        return true;

    }

    public boolean isCompleteGraph() {

        int numberOfVertices = adjacencyList.size();

        for (Integer vertex : adjacencyList.keySet()) {

            int degree = adjacencyList.get(vertex).size();

            if (degree != numberOfVertices - 1) {

                return false;

            }

        }

        return true;

    }
}
