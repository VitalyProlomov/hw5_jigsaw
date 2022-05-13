package com.example.hw5_jigsaw;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.util.Pair;

import java.util.Objects;
import java.util.Random;
import java.util.Vector;

/*
Class that makes an object draggable.
ALso sets the action when it is released (dropped).
 */
public class DraggableMaker {
    public final int TILE_LENGTH = 50;
    public final int HITBOX_LENGTH = 30;
    private double mouseCoordX;
    private double mouseCoordY;
    private static final Random rand = new Random();

    int currentFigureIndex;


    void initializeRandom(int value) {
        currentFigureIndex = value;
    }

    /**
     * checks if the hitbox of any rectangle was triggerred by coordinates.
     *
     * @param x
     * @param y
     * @return
     */
    boolean isInHitBox(double x, double y) {
        return (((x - HelloApplication.PADDING) + HITBOX_LENGTH / 2) % TILE_LENGTH <= HITBOX_LENGTH) &&
                (((y - HelloApplication.PADDING) + HITBOX_LENGTH / 2) % TILE_LENGTH <= HITBOX_LENGTH);
    }

    /**
     * Returns true, if the figure was successfully inserted into the field.
     * Also checks itself if the cells are occupied or not.
     *
     * @param figureIndex index in all figures array.
     * @param rowIndex    reffering to the table of rectangles
     * @param columnIndex reffering to the table of rectangles
     * @return
     */
    public boolean tryInsert(int figureIndex, int rowIndex, int columnIndex) {
        boolean canInsert = true;
        if (rowIndex < 0 || rowIndex > 9 || columnIndex < 0 || columnIndex > 9) {
            return false;
        }
        for (Pair<Integer, Integer> cell_shift : Figures.allShifts[figureIndex]) {
            if (rowIndex + cell_shift.getKey() < 0 || rowIndex + cell_shift.getKey() > 9 ||
                    columnIndex + cell_shift.getValue() < 0 || columnIndex + cell_shift.getValue() > 9) {
                return false;
            }
            if (Objects.equals(HelloApplication.all_cells[rowIndex + cell_shift.getKey()][columnIndex + cell_shift.getValue()].getFill(), Color.GREEN)) {
                // HelloApplication.all_cells[rowIndex + cell_shift.getKey()][columnIndex + cell_shift.getValue()].setFill(Color.RED);
                return false;
            }
        }
        for (Pair<Integer, Integer> cell_shift : Figures.allShifts[figureIndex]) {
            HelloApplication.all_cells[rowIndex + cell_shift.getKey()][columnIndex + cell_shift.getValue()].setAccessibleText("occupied");
            HelloApplication.all_cells[rowIndex + cell_shift.getKey()][columnIndex + cell_shift.getValue()].setFill(Color.GREEN);
        }
        return true;
    }


    /**
     * Makes the node draggable.
     *
     * @param node
     */
    public void makeDraggable(Node node) {
        // node.setOnMousePressed();
        node.setOnMousePressed(mouseEvent -> {
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

                int row_index = ((int) (boundsInScene.getMinX() - HelloApplication.PADDING) + HITBOX_LENGTH / 2) / TILE_LENGTH;
                int column_index = ((int) (boundsInScene.getMinY() - HelloApplication.PADDING - Figures.topToLeftCoordinatesShifts[currentFigureIndex] * TILE_LENGTH) + HITBOX_LENGTH / 2) / TILE_LENGTH;

                if (boundsInScene.getMinX() - HelloApplication.PADDING < TILE_LENGTH * 9 &&
                        boundsInScene.getMinY() - HelloApplication.PADDING - Figures.topToLeftCoordinatesShifts[currentFigureIndex] * TILE_LENGTH < TILE_LENGTH * 9 &&
                        isInHitBox(boundsInScene.getMinX(), boundsInScene.getMinY() - Figures.topToLeftCoordinatesShifts[currentFigureIndex] * TILE_LENGTH)) {
                    ((Polygon) node).setFill(Color.GREEN);
                }

                ((Polygon) node).setTranslateX(100);
                ((Polygon) node).setTranslateY(100);

                if (tryInsert(currentFigureIndex, row_index, column_index)) {
                    currentFigureIndex = Math.abs(rand.nextInt() % 31);
                    ((Polygon) node).getPoints().clear();

                    ((Polygon) node).getPoints().addAll(
                            Figures.allFigures[Math.abs(currentFigureIndex)].getPoints()
                    );
                }

            }
        });
    }
}
