package huffman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Character, Integer> frequencies = new HashMap<>();
        frequencies.put('a', 1);
        frequencies.put('b', 1);
        frequencies.put('c', 2);

        // Build the Huffman tree
        HuffmanCodec codec = new HuffmanCodec();
        codec.build(frequencies);

        // Verify the tree was built
        Node root = codec.getRoot();
        System.out.println("Huffman tree built.");
        System.out.println("Root frequency = " + root.frequency);
    }
}