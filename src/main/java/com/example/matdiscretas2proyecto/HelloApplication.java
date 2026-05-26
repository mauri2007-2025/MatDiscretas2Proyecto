package com.example.matdiscretas2proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        Graph graph = new Graph();

        FileManager.loadGraphFromFile("graph.txt", graph);

        GraphVisualizer visualizer = new GraphVisualizer(graph);

        Scene scene = new Scene(visualizer, 500, 500);

        stage.setTitle("Graph Visualizer");

        stage.setScene(scene);

        stage.show();

    }
}