package com.example.hw5_jigsaw;

import javafx.scene.shape.Polygon;
import javafx.util.Pair;

import java.util.Vector;

public class Figures {

    public static final int FIGURES_AMOUNT = 31;
    // Contains all fihures that will be genreated randomly.
    public static Polygon[] allFigures = new Polygon[FIGURES_AMOUNT];

    public static double[] topToLeftCoordinatesShifts = new double[FIGURES_AMOUNT];

    // Contains all shifts (coordinates) of all figures in the coordinate system of each figure.
    public static Vector<Pair<Integer, Integer>>[] allShifts;

    public Figures() {
        initializeAllFigures();
        createRoutesShifts();
        createShifts();
    }

    private static void createRoutesShifts() {
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
        shifts[30] = -1;

        topToLeftCoordinatesShifts = shifts;
    }

    static Vector<Pair<Integer, Integer>> createVectorOfShifts(int[] shifts) {
        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(shifts[0], shifts[1]);
        Vector<Pair<Integer, Integer>> vec = new Vector<>();
        for (int i = 0; i < shifts.length; i += 2) {
            pair = new Pair<>(shifts[i], shifts[i + 1]);
            vec.add(pair);
        }
        return vec;
    }

    private static void createShifts() {
        allShifts = new Vector[FIGURES_AMOUNT];
        for (int i = 0; i < allShifts.length; ++i) {
            allShifts[i] = new Vector<Pair<Integer, Integer>>();
        }

        allShifts[0] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                0, 1,
                0, 2
        });
        allShifts[1] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                1, 1,
                2, 1
        });
        allShifts[2] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                1, -1,
                1, -2
        });
        allShifts[3] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                2, 1
        });
        allShifts[4] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                1, 1,
                1, 2
        });
        allShifts[5] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                2, -1
        });
        allShifts[6] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                0, 2,
                1, 2
        });
        allShifts[7] = createVectorOfShifts(new int[]{
                0, 0,
                0, -1,
                1, -1,
                2, -1
        });
        allShifts[8] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                1, 1,
                1, 2
        });
        allShifts[9] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                1, -1,
                2, -1
        });
        allShifts[10] = createVectorOfShifts(new int[]{
                0, 0,
                0, -1,
                1, -1,
                1, -2
        });
        allShifts[11] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                1, 1,
                2, 1
        });
        allShifts[12] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                2, -1,
                2, -2
        });
        allShifts[13] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                0, 2,
                1, 2,
                2, 2
        });
        allShifts[14] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                0, 1,
                0, 2
        });
        allShifts[15] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                2, 1,
                2, 2
        });
        allShifts[16] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                1, -1,
                1, -2
        });
        allShifts[17] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                1, 1,
                1, 2
        });
        allShifts[18] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                0, 2,
                1, 1,
                1, 2
        });
        allShifts[19] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                0, 2,
                -1, 1,
                -2, 1
        });
        allShifts[20] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0
        });
        allShifts[21] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                0, 2
        });
        allShifts[22] = createVectorOfShifts(new int[]{
                0, 0
        });
        allShifts[23] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                1, 0
        });
        allShifts[24] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                1, 1
        });
        allShifts[25] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                -1, 1
        });
        allShifts[26] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                1, 1
        });
        allShifts[27] = createVectorOfShifts(new int[]{
                0, 0,
                0, 1,
                0, 2,
                1, 1
        });
        allShifts[28] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                1, 1
        });
        allShifts[29] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                1, -1,
                1, 1
        });
        allShifts[30] = createVectorOfShifts(new int[]{
                0, 0,
                1, 0,
                2, 0,
                1, -1
        });
    }


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
                len, 0.0
        );
        allFigures[2] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, 2 * len,
                -len, 2 * len,
                -len, len,
                0, len
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
                len, 2 * len,
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
                len, 3 * len,
                len, 2 * len,
                0.0, 2 * len
        );
        allFigures[9] = new Polygon(
                0.0, 0.0,
                2 * len, 0.0,
                2 * len, len,
                len, len,
                len, 2 * len,
                -1 * len, 2 * len,
                -1 * len, len,
                0.0, len
        );

        allFigures[10] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, -1 * len,
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
                -2 * len, 3 * len,
                -2 * len, 2 * len,
                0.0, 2 * len
        );
        allFigures[13] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, 2 * len,
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
                3 * len, 0.0,
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
                0.0, 0.0,
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
                len, 0.0,
                len, 3 * len,
                0.0, 3 * len,
                0.0, 2 *len,
                -2 * len, 2 *len,
                -2 * len, len,
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
        allFigures[27] = new Polygon(
                0.0, 0.0,
                len, 0.0,
                len, len,
                2 * len, len,
                2 * len, 2 * len,
                len, 2 * len,
                len, 3 * len,
                0.0, 3 * len
        );
        allFigures[28] = new Polygon(
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
    }
}
