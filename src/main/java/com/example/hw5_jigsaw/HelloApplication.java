package com.example.hw5_jigsaw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    public static final double TILE_LENGTH = 50 + 0.3;
    public static final int PADDING = 20;
    public static Rectangle[][] all_cells;

    Random rand = new Random();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Hello!");

        stage.setTitle("JigSaw");

        all_cells = new Rectangle[9][9];
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

        HBox gridField = new HBox(0.3);
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

        int first_index = Math.abs(rand.nextInt() % 31);
        //Creating a Polygon
        Polygon polygon = Figures.allFigures[first_index];

        DraggableMaker draggableMaker = new DraggableMaker();
        draggableMaker.initializeRandom(first_index);
        draggableMaker.makeDraggable(polygon);

        polygon.setLayoutX(-30);
        polygon.setLayoutY(200);
        HBox root = new HBox(10, gridField , polygon);
        Scene finalScene = scene;


        scene = new Scene(root, 810, 500);
        Scene s = polygon.getScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}