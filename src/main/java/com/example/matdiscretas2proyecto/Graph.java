package com.example.matdiscretas2proyecto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Graph {

    private static class NodeDistance implements Comparable<NodeDistance> {

        int vertex;
        int distance;

        public NodeDistance(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(NodeDistance other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
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

    private void dfs(int vertex, HashSet<Integer> visited) {

        visited.add(vertex);

        for (Edge edge : adjacencyList.get(vertex)) {

            if (!visited.contains(edge.target)) {

                dfs(edge.target, visited);

            }

        }

    }

    public boolean isTree() {

        int vertices = adjacencyList.size();

        int edges = 0;

        for (Integer vertex : adjacencyList.keySet()) {

            edges += adjacencyList.get(vertex).size();

        }

        edges /= 2;

        if (edges != vertices - 1) {

            return false;

        }

        HashSet<Integer> visited = new HashSet<>();

        Integer start = adjacencyList.keySet().iterator().next();

        dfs(start, visited);

        return visited.size() == vertices;

    }

    public boolean hasEulerPath() {

        int odd = 0;

        for (Integer vertex : adjacencyList.keySet()) {

            if (getVertexDegree(vertex) % 2 != 0) {

                odd++;

            }

        }

        return odd == 0 || odd == 2;

    }

    public boolean hasEulerCircuit() {

        for (Integer vertex : adjacencyList.keySet()) {

            if (getVertexDegree(vertex) % 2 != 0) {

                return false;

            }

        }

        return true;

    }

    public HashMap<Integer, Integer> dijkstra(int source) {

        HashMap<Integer, Integer> distance = new HashMap<>();

        PriorityQueue<NodeDistance> queue = new PriorityQueue<>();

        for (Integer vertex : adjacencyList.keySet()) {

            distance.put(vertex, Integer.MAX_VALUE);

        }

        distance.put(source, 0);

        queue.add(new NodeDistance(source, 0));

        while (!queue.isEmpty()) {

            NodeDistance current = queue.poll();

            for (Edge edge : adjacencyList.get(current.vertex)) {

                int newDistance = distance.get(current.vertex) + edge.weight;

                if (newDistance < distance.get(edge.target)) {

                    distance.put(edge.target, newDistance);

                    queue.add(new NodeDistance(edge.target, newDistance));

                }

            }

        }

        return distance;

    }
    public HashMap<Integer, ArrayList<Edge>> getAdjacencyList() {

        return adjacencyList;

    }
}
