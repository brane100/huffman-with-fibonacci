package huffman;

import java.util.Map;

public class Encoder {

    public static String encode(char[] dataset, Map<Character, String> codes) {
        StringBuilder sb = new StringBuilder();
        for (char c : dataset) {
            String code = codes.get(c);
            if (code == null) throw new IllegalArgumentException("Ni kode za simbol: " + c);
            sb.append(code);
        }
        return sb.toString();
    }

    public static void printResult(char[] dataset, String encoded) {
        System.out.println("=== Encoding ===");
        System.out.println("Število simbolov : " + dataset.length);
        System.out.println("Dolžina bitstringa: " + encoded.length() + " bitov");
        System.out.println("Bitstring (prvih 80): " + encoded.substring(0, Math.min(80, encoded.length())) + "...");
    }
}