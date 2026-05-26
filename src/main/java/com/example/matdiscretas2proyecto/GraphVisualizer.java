
package com.example.matdiscretas2proyecto;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import java.util.HashMap;

public class GraphVisualizer extends Pane {

    private Graph graph;

    public GraphVisualizer(Graph graph) {

        this.graph = graph;

        drawGraph();

    }

    private void drawGraph() {

        HashMap<Integer, double[]> positions = new HashMap<>();

        positions.put(0, new double[]{200, 100});

        positions.put(1, new double[]{100, 250});

        positions.put(2, new double[]{300, 250});

        for (Integer source : graph.getAdjacencyList().keySet()) {

            double x1 = positions.get(source)[0];

            double y1 = positions.get(source)[1];

            for (Edge edge : graph.getAdjacencyList().get(source)) {

                if (source > edge.target) {

                    continue;

                }

                int target = edge.target;

                double x2 = positions.get(target)[0];

                double y2 = positions.get(target)[1];

                Line line = new Line(x1, y1, x2, y2);

                getChildren().add(line);

                double midX = (x1 + x2) / 2;

                double midY = (y1 + y2) / 2;

                Text weightText = new Text(midX +3, midY, String.valueOf(edge.weight));

                getChildren().add(weightText);

            }

        }


        for (Integer vertex : graph.getAdjacencyList().keySet()) {

            double x = positions.get(vertex)[0];

            double y = positions.get(vertex)[1];

            Circle circle = new Circle(x, y, 20);

            circle.setFill(Color.LIGHTBLUE);

            Text text = new Text(x - 5, y + 5, String.valueOf(vertex));

            getChildren().addAll(circle, text);

        }

    }

}