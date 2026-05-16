package huffman;

import java.util.*;

public class BlockEncoder {

    public static void analyze(char[] dataset) {
        List<String> blocks = new ArrayList<>();
        for (int i = 0; i + 1 < dataset.length; i += 2) {
            blocks.add("" + dataset[i] + dataset[i + 1]);
        }

        Map<String, Integer> freq = new LinkedHashMap<>();
        for (String b : blocks) {
            freq.put(b, freq.getOrDefault(b, 0) + 1);
        }

        System.out.println("\n=== Block Encoding (2-simbolni bloki) ===");
        System.out.println("Število blokov: " + blocks.size());
        System.out.println("Unikatnih blokov: " + freq.size());

        double avgBitsPerBlock = Math.ceil(Math.log(freq.size()) / Math.log(2));
        int encodedBits = (int)(blocks.size() * avgBitsPerBlock);
        int uncodedBits = dataset.length * 3;
        double ratio = (double) uncodedBits / encodedBits;

        System.out.printf("Nekodirana velikost : %d bitov%n", uncodedBits);
        System.out.printf("Ocenjena kodirana   : %d bitov%n", encodedBits);
        System.out.printf("Kompresijsko razmerje: %.4f%n", ratio);
    }
}