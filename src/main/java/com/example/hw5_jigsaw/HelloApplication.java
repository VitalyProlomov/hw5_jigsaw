package com.example.hw5_jigsaw;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static final double TILE_LENGTH = 50 + 0.5;

    public static Label label;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Hello!");

        stage.setTitle("PRolomov");

        Rectangle[][] all_cells = new Rectangle[9][9];
        for (int row = 0; row < all_cells.length; ++row) {
            for (int column = 0; column < all_cells[0].length; ++column) {
                Rectangle cur_rectangle = new Rectangle();
                cur_rectangle.setWidth(50);
                cur_rectangle.setHeight(50);
                cur_rectangle.setFill(Color.LIGHTGRAY);
                all_cells[row][column] = cur_rectangle;
            }
        }

        VBox[] all_vboxes = new VBox[all_cells.length];
        for (int i = 0; i < all_vboxes.length; ++i) {
            VBox cur_vbox = new VBox();
            for (int cell_index = 0; cell_index < all_cells[0].length; ++cell_index) {
                cur_vbox.getChildren().add(all_cells[i][cell_index]);
            }
            all_vboxes[i] = cur_vbox;
        }

        HBox gridField = new HBox(1);
        gridField.setOnDragOver(e -> {
            gridField.setSpacing(10);
        });

        for (int i = 0; i < all_vboxes.length; ++i) {
            gridField.getChildren().add(all_vboxes[i]);
        }
        gridField.setStyle("-fx-padding: 20;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 0;");
        gridField.setAlignment(Pos.CENTER);


        Figures.initializeAllFigures();

        //Creating a Polygon
        Polygon polygon = Figures.allFigures[16];

        // gridField.getChildren().add(polygon);

        // polygon.setFill(Paint.valueOf(C));
        DraggableMaker draggableMaker = new DraggableMaker();
        draggableMaker.makeDraggable(polygon);

        //root.getChildren().add(polygon);
        //Creating a Group object

        // Label label = new Label("label");
        label = new Label("LABEL");

        HBox root = new HBox(100, gridField , polygon, label);
        Scene finalScene = scene;
//        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                label.setText("getScene Coords: " + mouseEvent.getSceneX() + ", " + mouseEvent.getSceneY() +
//                        '\n' + "getX Coords: " + mouseEvent.getX() + ", " + mouseEvent.getY() +
//                        "\n" + "Polygon getScene: " + polygon.getScene() +
//                        "\n" + "window coords?" + finalScene.getX() + " " + finalScene.getY()
//                + "\n" + "Layout Coords: " + polygon.getLayoutX() + " " + polygon.getLayoutY());
//
//            }
//        });
//        root.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
//            @Override
//            public void handle(MouseDragEvent mouseEvent) {
//                label.setText("DRAGgetScene Coords: " + mouseEvent.getSceneX() + ", " + mouseEvent.getSceneY() +
//                        '\n' + "getX Coords: " + mouseEvent.getX() + ", " + mouseEvent.getY());
//            }
//        });

        scene = new Scene(root, 810, 500);
        Scene s = polygon.getScene();
        stage.setScene(scene);
        stage.show();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}