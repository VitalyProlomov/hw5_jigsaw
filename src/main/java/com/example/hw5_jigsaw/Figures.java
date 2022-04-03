package com.example.hw5_jigsaw;

import javafx.scene.shape.Polygon;

public class Figures {

    public static final int FIGURES_AMOUNT = 31;
    public static Polygon[] allFigures = new Polygon[FIGURES_AMOUNT];
    public static double[] topToLeftCoordinatesShifts = new double[FIGURES_AMOUNT];
    public Figures() {
        initializeAllFigures();
    }

//    static Polygon makeMirrorPolygon(Polygon polygon) {
//        Polygon mirroredPolygon = new Polygon();
//        mirroredPolygon.getPoints().addAll(polygon.getPoints());
//        double temp;
//        for (int i = 0; i < mirroredPolygon.getPoints().size(); i += 2) {
//            temp = mirroredPolygon.getPoints().get(i);
//            mirroredPolygon.getPoints().set(i, mirroredPolygon.getPoints().get(i + 1));
//            mirroredPolygon.getPoints().set(i + 1, temp);
//        }
//        return mirroredPolygon;
//    }

    static void initializeAllFigures() {
        double len = HelloApplication.TILE_LENGTH;
        // Г letter.
        allFigures[0] = new Polygon(
        0.0, 0.0,
                3 * len, 0.0,
                3 * len, len,
                len, len,
                2 * len, len,
                2 * len, 0
                );
        allFigures[1] = new Polygon(
        0.0, 0.0,
                0.0, 2 * len,
                3 * len, 2 * len,
                3 * len, len,
                len, len,
                len , 0.0
        );
        allFigures[2] = new Polygon(
        0.0, 0.0,
                0.0, len,
                2 * len, len,
                2 * len, -1 * len,
                len, -1 * len,
                len, len
        );
        allFigures[3] = new Polygon(
                0.0, 0.0,
                3 * len, 0.0,
                3 * len, 2 * len,
                2 * len, 2 * len,
                2 * len, len,
                0.0, len
        );

        allFigures[4] = new Polygon(
                0.0, 0.0,
                2 * len, 0.0,
                2 * len, 3 * len,
                len, 3 * len,
                len, len,
                0.0, len
        );
        allFigures[5] = new Polygon(
                0.0, 0.0,
                2 * len, 0.0,
                2 * len, -1 * len,
                3 * len, -1 * len,
                3 * len, len,
                0.0, len
        );
        allFigures[6] = new Polygon(
                0.0, 0.0,
                0.0, 3 * len,
                2 * len, 3 * len,
                2 * len, 2 * len,
                len , 2 * len,
                len, 0.0
        );
        allFigures[7] = new Polygon(
                0.0, 0.0,
                3 * len, 0.0,
                3 * len, len,
                len, len,
                len, 2 * len,
                0.0, 2 * len
        );

        // Zigzags.
        allFigures[8] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, len,
                2 * len, len,
                2 * len, 3 * len,
                len , 3 * len,
                len, 2 * len,
                0.0, 2 * len
        );
        allFigures[9] = new Polygon(
                0.0, 0.0,
                2 * len, 0.0,
                2 * len, len,
                len , len,
                len, 2 * len,
                -1 * len, 2 * len,
                -1 * len, len,
                0.0, len
        );

        allFigures[10] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, -1 *len,
                2 * len, -1 * len,
                2 * len, len,
                len, len,
                len, 2 * len,
                0.0, 2 * len
        );
        allFigures[11] = new Polygon(
                0.0, 0.0,
                2 * len, 0.0,
                2 * len, len,
                3 * len, len,
                3 * len, 2 * len,
                len, 2 * len,
                len, len,
                0.0, len
        );
        // L letters.
        allFigures[12] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, 3 * len,
                -2 * len, 3 *len,
                -2 * len, 2 * len,
                0.0, 2 * len
        );
        allFigures[13] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, 2 *len,
                3 * len, 2 * len,
                3 * len, 3 * len,
                0.0, 3 * len
                );
        allFigures[14] = new Polygon(
                0.0, 0.0,
                3 * len, 0.0,
                3 * len, len,
                len, len,
                len, 3 * len,
                0.0, 3 * len
        );
        allFigures[15] = new Polygon(
                0.0, 0.0,
                3 * len,0.0,
                3 * len, 3 * len,
                2 * len, 3 * len,
                2 * len, len,
                0.0, len
        );
        // T letters.
        allFigures[16] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, 2 * len,
                 2 * len, 2 * len,
                2 * len, 3 * len,
                -1 * len, 3 * len,
                -1 * len, 2 * len,
                0.0, 2 * len
        );
        allFigures[17] = new Polygon(
                0.0,  0.0,
                3 * len, 0.0,
                3 * len, len,
                2 * len, len,
                2 * len, 3 * len,
                len, 3 * len,
                len, len,
                0.0, len
        );
        allFigures[18] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, len,
                3 * len, len,
                3 * len, 2 * len,
                len, 2 * len,
                len, 3 * len,
                0.0, 3 * len
        );
        allFigures[19] = new Polygon(
                0.0, 0.0,
                2 * len, 0.0,
                2 * len, -1 * len,
                3 * len, -1 * len,
                3 * len, 2 * len,
                2 * len, 2 * len,
                2 * len, len,
                0.0, len
                );
        // Lines.
        allFigures[20] = new Polygon(
                0.0, 0.0,
                3 * len, 0.0,
                3 * len, len,
                0.0, len
        );
        allFigures[21] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, 3 * len,
                0.0, 3 * len
        );
        // Dot.
        allFigures[22] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, len,
                0.0, len
        );
        // г Letters.
        allFigures[23] = new Polygon(
                0.0, 0.0,
                2 * len, 0.0,
                2 * len, len,
                len, len,
                len, 2 * len,
                0.0, 2 * len
        );
        allFigures[24] = new Polygon(
        0.0, 0.0,
                2 * len, 0.0,
                2 * len, 2 * len,
                len, 2 * len,
                len, len,
                0.0, len
                );
        allFigures[25] = new Polygon(
        0.0, 0.0,
                len, 0.0,
                len, -1 * len,
                2 * len, -1 * len,
                2 * len, len,
                0.0, len
                );
        allFigures[26] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, len,
                2 * len, len,
                2 * len, 2 * len,
                0.0, 2 * len
        );
        // Tetris piece figure.
        allFigures[27]=  new Polygon(
        0.0, 0.0,
                len, 0.0,
                len, len,
                2 * len, len,
                2 * len, 2 * len,
                len, 2 * len,
                len, 3 * len,
                0.0, 3 * len
        );
        allFigures[28]=  new Polygon(
                0.0, 0.0,
                 3 * len, 0.0,
                3 * len, len,
                2 * len, len,
                2 * len, 2 * len,
                len, 2 * len,
                len, len,
                0.0, len
        );
        allFigures[29] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, -1 * len,
                2 * len, -1 * len,
                2 * len, 2 * len,
                len, 2 * len,
                len, len,
                0.0, len
        );
        allFigures[30] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, -1 * len,
                2 * len, -1 * len,
                2 * len, 0,
                3 * len, 0,
                3 * len, len,
                0.0, len
        );

        double[] shifts = new double[FIGURES_AMOUNT];
        shifts[2] = -2;
        shifts[5] = -1;
        shifts[9] = -1;
        shifts[10] = -1;
        shifts[12] = -2;
        shifts[16] = -2;
        shifts[19] = -1;
        shifts[25] = -1;
        shifts[29] = -1;

        topToLeftCoordinatesShifts = shifts;
    }
}
