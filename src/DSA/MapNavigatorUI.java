package DSA;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MapNavigatorUI extends Application {
    private Map<String, Map<String, Integer>> graph;
    private Set<String> visited;
    private Map<String, Integer> distances;
    private Map<String, String> previous;
    private TextArea pathTextArea;

    public MapNavigatorUI() {
        this.graph = new HashMap<>();
    }

    public void addEdge(String source, String destination, int weight) {
        graph.computeIfAbsent(source, k -> new HashMap<>()).put(destination, weight);
        graph.computeIfAbsent(destination, k -> new HashMap<>()).put(source, weight);
    }

    public List<String> shortestPath(String start, String end) {
        visited = new HashSet<>();
        distances = new HashMap<>();
        previous = new HashMap<>();

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        queue.add(new Node(start, 0));
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String currentName = current.name;

            if (visited.contains(currentName)) {
                continue;
            }

            visited.add(currentName);

            if (currentName.equals(end)) {
                break;
            }

            Map<String, Integer> neighbors = graph.get(currentName);

            if (neighbors == null) {
                continue;
            }

            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                String neighborName = neighbor.getKey();
                int distance = neighbor.getValue();
                int totalDistance = distances.get(currentName) + distance;

                if (!distances.containsKey(neighborName) || totalDistance < distances.get(neighborName)) {
                    distances.put(neighborName, totalDistance);
                    previous.put(neighborName, currentName);
                    queue.add(new Node(neighborName, totalDistance));
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        return path;
    }

    private class Node {
        private String name;
        private int distance;

        private Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Map Navigator");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label startLabel = new Label("Start Location:");
        ComboBox<String> startComboBox = new ComboBox<>();
        startComboBox.getItems().addAll(graph.keySet());

        Label endLabel = new Label("End Location:");
        ComboBox<String> endComboBox = new ComboBox<>();
        endComboBox.getItems().addAll(graph.keySet());

        Button findPathButton = new Button("Find Shortest Path");
        findPathButton.setOnAction(e -> {
            String start = startComboBox.getValue();
            String end = endComboBox.getValue();

            if (start != null && end != null) {
                List<String> path = shortestPath(start, end);
                pathTextArea.setText("Shortest Path: " + String.join(" -> ", path));
            } else {
                pathTextArea.setText("Please select start and end locations.");
            }
        });

        pathTextArea = new TextArea();
        pathTextArea.setEditable(false);

        gridPane.add(startLabel, 0, 0);
        gridPane.add(startComboBox, 1, 0);
        gridPane.add(endLabel, 0, 1);
        gridPane.add(endComboBox, 1, 1);
        gridPane.add(findPathButton, 0, 2);
        gridPane.add(pathTextArea, 0, 3, 2, 1);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        MapNavigatorUI navigator = new MapNavigatorUI();

        // Add edges (roads) between locations with corresponding weights (distances)
        navigator.addEdge("A", "B", 5);
        navigator.addEdge("A", "C", 2);
        navigator.addEdge("B", "D", 4);
        navigator.addEdge("C", "D", 1);
        navigator.addEdge("C", "E", 6);
        navigator.addEdge("D", "E", 3);

        launch(args);
    }
}
