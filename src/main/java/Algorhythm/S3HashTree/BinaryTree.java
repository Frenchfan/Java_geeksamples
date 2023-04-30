package Algorhythm.S3HashTree;


/**
 * реализация бинарного дерева - превращаем его в красно-черное
 * @param <V>
 */
public class BinaryTree<V extends Comparable<V>> {

    private Node root;

    private class Node {
        private V value;

        private Node left;

        private Node right;

        private Color color;
    }

    /**
     * Enum-класс - цвет ноды
     */
    private enum Color {
        RED, BLACK
    }

    /**
     * Color swap
     * @param node
     */
    private void swapColor (Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftRotate(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }
    private Node rightRotate(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }
    private Node reBalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rightRotate(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED) {
                needRebalance = true;
                result = leftRotate(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                swapColor(result);
            }
        } while (needRebalance);
        return result;
    }
    public boolean add(V value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = reBalance(root);
            root.color = Color.BLACK;
            return result;
        }
        else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
    private boolean addNode(Node node, V value) {
        if (node.value == value) {
            return false;
        }
        else {
            if (node.value.compareTo(value) > 0) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = reBalance(node.left);
                    return result;
                }
                else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            }
            else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = reBalance(node.right);
                    return result;
                }
                else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
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
