package huffman;

import java.util.Random;

public class DatasetGenerator {

    // Simboli in njihove Fibonacci uteži
    private static final char[]   SYMBOLS = {'a','b','c','d','e','f','g','h'};
    private static final int[]    WEIGHTS = { 1,  1,  2,  3,  5,  8, 13, 21};
    private static final int      TOTAL   = 54; // vsota uteži

    public static char[] generate(int count) {
        char[] dataset = new char[count];
        Random rng = new Random();

        for (int i = 0; i < count; i++) {
            int r = rng.nextInt(TOTAL);
            int cumulative = 0;
            for (int j = 0; j < WEIGHTS.length; j++) {
                cumulative += WEIGHTS[j];
                if (r < cumulative) {
                    dataset[i] = SYMBOLS[j];
                    break;
                }
            }
        }
        return dataset;
    }

    // Preveri porazdelitev
    public static void printDistribution(char[] dataset) {
        int[] counts = new int[SYMBOLS.length];
        for (char c : dataset) {
            for (int i = 0; i < SYMBOLS.length; i++) {
                if (c == SYMBOLS[i]) counts[i]++;
            }
        }
        System.out.println("=== Porazdelitev dataseta ===");
        for (int i = 0; i < SYMBOLS.length; i++) {
            System.out.printf("  %c : %3d krat%n", SYMBOLS[i], counts[i]);
        }
    }
}