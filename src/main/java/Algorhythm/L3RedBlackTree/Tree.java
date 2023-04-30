package Algorhythm.L3RedBlackTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Обход обычно односторонний - сверху-вниз
 * Рассматриваем вариант без повторяющихся элементов
 */
public class Tree {

    Node root;

    /**
     * Это публичная часть функции find - начинает обход с root node
     * Рекурсия в дереве не слишком ресурсно затратна
     * При этом не нужны доп. ссылки на все объекты
     *
     * @param value
     * @return
     */
    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Приватная процедура для поиска значения в дереве
     * ОБХОД В ГЛУБИНУ
     * проверяем текущую ноду - если она содержит интересующее нас
     * занчение, возвращаем её.
     * Если не находим значение - рекурсивно запускаем
     * поиск по всем детям
     *
     * @param node
     * @param value
     * @return
     */
    private Node find(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) {
                Node result = find(child, value);
                if (result != null) {
                    return result;

                }
            }
        }
        return null;
    }

    /**
     * ОБХОД В ШИРИНУ - без рекурсии, второй вариант find
     * Применяется чаще для анализа, для отрисовки дерева
     * Но есть и минусы - нужно помнить про все
     * элементы одной линии
     * То есть тут больше затрачивается ресурсов скорее всего
     *
     * @return
     */
    private Node find2(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }


    public class Node {
        int value;
        List<Node> children;
    }
}
