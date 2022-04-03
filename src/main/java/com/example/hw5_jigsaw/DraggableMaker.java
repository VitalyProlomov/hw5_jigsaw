package com.example.hw5_jigsaw;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class DraggableMaker {
    public final int TILE_LENGTH = 50;
    public final int HITBOX_LENGTH = 40;
    private double mouseCoordX;
    private double mouseCoordY;


    public void makeDraggable(Node node) {
        // node.setOnMousePressed();
        node.setOnMousePressed(mouseEvent -> {
//            mouseCoordX = mouseEvent.getSceneX() - mouseEvent.getX();
//            mouseCoordY = mouseEvent.getSceneY() - mouseEvent.getY();
            mouseCoordX = mouseEvent.getSceneX() - node.getTranslateX();
            mouseCoordY = mouseEvent.getSceneY() - node.getTranslateY();
            ((Polygon) node).setFill(Color.BLACK);
        });

        node.setOnMouseDragged(mouseEvent -> {
            node.setTranslateX(mouseEvent.getSceneX() - mouseCoordX);
            node.setTranslateY(mouseEvent.getSceneY() - mouseCoordY);
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Figures fig = new Figures();
                Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());
                HelloApplication.label.setText("Coords: " + mouseEvent.getSceneX() + " " + mouseEvent.getSceneY() + "\n" +
                        "Top-Left Coords: " + screenPositionOf(node).getX() + " " + screenPositionOf(node).getY() + "\n" +
                        "Bounds Coords: " + boundsInScene.getMinX() + " " + (boundsInScene.getMinY()) + "\n" +
                        "Translate coords: " + node.getTranslateX() + " " + node.getTranslateY() + "\n" +
                        "");

                if ((boundsInScene.getMinX() - (TILE_LENGTH - HITBOX_LENGTH / 2)) % TILE_LENGTH < HITBOX_LENGTH &&
                        (boundsInScene.getMinY() - (TILE_LENGTH - HITBOX_LENGTH / 2)) % TILE_LENGTH < HITBOX_LENGTH) {
                    ((Polygon) node).setFill(Color.RED);
                    ((Polygon) node).setTranslateX(60);
                    ((Polygon) node).setTranslateY(150);
                    ((Polygon) node).getPoints().clear();
                    ((Polygon) node).getPoints().addAll(
                            Figures.allFigures[16].getPoints()
//                            0.0, 0.0,
//                            100.0, 0.0,
//                            100.0, 100.0
                    );
                }
            }
        });

        if (node.getClass() == Polygon.class) {
            node.setOnDragDropped(mouseEvent -> {
                ((Polygon) node).setFill(Color.RED);
            });
        }

    }

    public static Point2D screenPositionOf(Node control) {
        Point2D center = control.localToScene(0, 0);

        return new Point2D(center.getX() + control.getTranslateX(), center.getY()
                + control.getTranslateY());
    }
}
