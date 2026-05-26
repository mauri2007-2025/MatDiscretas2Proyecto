package com.example.matdiscretas2proyecto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class FileManager {

        public static void loadGraphFromFile(String path, Graph graph) {

            try {

                BufferedReader reader = new BufferedReader(new FileReader(path));

                String line;

                while ((line = reader.readLine()) != null) {

                    String[] parts = line.split(",");

                    int source = Integer.parseInt(parts[0]);

                    int target = Integer.parseInt(parts[1]);

                    int weight = Integer.parseInt(parts[2]);

                    graph.addEdge(source, target, weight);

                }

                reader.close();

                System.out.println("Graph loaded successfully.");

            } catch (IOException e) {

                System.out.println("Error reading file.");

                e.printStackTrace();

            }

        }

}
