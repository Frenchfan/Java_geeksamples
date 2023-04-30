package Algorhythm.S3HashTree;

/**
 * реализация бинарного дерева
 * @param <V>
 */
public class BinaryTree<V extends Comparable<V>> {

    private Node root;

    private class Node {
        private V value;

        private Node left;

        private Node right;
    }

    /**
     * Поиск в глубину по бинарному дереву
     * @param value
     * @return
     */
    public boolean contains (V value) {
        Node node  = root;
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            if (node.value.compareTo(value) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }
}
