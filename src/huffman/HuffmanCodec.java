package huffman;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCodec {

    private Node root;   // tree root

    public void build(Map<Character, Integer> frequencies) {
        if (frequencies == null || frequencies.isEmpty()) {
            throw new IllegalArgumentException("Frequencies must not be null or empty");
        }

        // Priority queue sorted by frequency
        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator.comparingInt(n -> n.frequency)
        );

        // Insert all leaf nodes
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            char symbol = entry.getKey();
            int freq = entry.getValue();

            if (freq < 0) {
                throw new IllegalArgumentException("Frequency must be >= 0");
            }
            if (freq == 0) continue;

            pq.add(new Node(symbol, freq));
        }

        if (pq.isEmpty()) {
            throw new IllegalArgumentException("All frequencies are zero");
        }

        // only one symbol (edge case)
        if (pq.size() == 1) {
            Node only = pq.poll();
            root = new Node(only, null);
            return;
        }

        // Build the Huffman tree
        while (pq.size() > 1) {
            Node a = pq.poll();   // smallest
            Node b = pq.poll();   // second smallest

            Node parent = new Node(a, b);
            pq.add(parent);
        }

        // Final root
        root = pq.poll();
    }

    /**
     * Getter for Student A testing and Student B usage.
     */
    public Node getRoot() {
        return root;
    }
}