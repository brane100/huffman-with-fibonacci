package huffman;

import java.util.Map;

public class CompressionAnalyzer {

    public static void analyze(int symbolCount, String encodedBits, Map<Character, String> codes) {
        int uncodedBits = symbolCount * 3; // 8 simbolov = 3 biti na simbol
        int encodedSize = encodedBits.length();
        double ratio = (double) uncodedBits / encodedSize;
        double saving = (1.0 - (double) encodedSize / uncodedBits) * 100;

        System.out.println("\n=== Kompresijsko razmerje (single-symbol) ===");
        System.out.printf("  Nekodirana velikost : %d bitov%n", uncodedBits);
        System.out.printf("  Kodirana velikost   : %d bitov%n", encodedSize);
        System.out.printf("  Kompresijsko razmerje: %.4f%n", ratio);
        System.out.printf("  Prihranjeno         : %.2f%%%n", saving);

        System.out.println("\n=== Huffman kode ===");
        codes.forEach((sym, code) ->
            System.out.printf("  %c -> %s (%d bitov)%n", sym, code, code.length()));
    }
}