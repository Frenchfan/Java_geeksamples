package Algorhythm.S3HashTree;


/**
 * Создаем класс хэш-таблицы, а также вложенный класс Entity,
 * описывающий пары ключ-значение и связный список
 * для хранения этих пар
 * 2) Добавить массив связанных списков с фиксированным размером
 * (массив бакетов), либо передаваемым в конструкторе,
 * а также реализуем метод вычисления индекса на
 * основании хэш-кода ключа
 * 3) Реализуем метод поиска данных по ключу в хэш-таблице
 * 4) Реализуем методы добавления и удаления элементов
 * в связном списке по ключу
 * 5) Реализуем алгоритм добавления и удаления элементов
 * из хэш-таблицы по ключу
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> {

    private static final int INIT_BASKET_COUNT = 16;

    private Basket[] baskets;

    public HashTable() {
        this(INIT_BASKET_COUNT);
    }

    public boolean put (K key, V value) {
        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        if (basket == null) {
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.add(entity);
    }

    public boolean remove(K key) {
        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        return basket.remove(key);
    }

    public HashTable(int initSize) {
        baskets = (Basket[]) new Object[initSize];
    }

    private int calculateBasketIndex(K key) {
        return key.hashCode() % baskets.length;
    }

    public V get(K key) {
        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.get(key);
        }
        return null;
    }

    private class Entity {
        private K key;
        private V value;
    }

    private class Basket {
        private Node head;

        public boolean remove(K key) {
            if (head.value.key.equals(key)) {
                head = head.next;
            } else {
                Node node = head;
                while (node.next != null) {
                    if (node.next.value.key.equals(key)) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
            }
            return false;
        }

        public boolean add(Entity entity) {
            Node node = new Node();
            node.value = entity;
            if (head != null) {
                Node current = head;
                while (true) {
                    if (current.value.key.equals(entity.key)) {
                        return false;
                    }
                    if (current.next == null) {
                        current.next = node;
                        return true;
                    }
                }
            } else {
                head = node;
                return true;
        }
    }

    public V get(K key) {
        Node node = head;
        while (node != null) {
            if (node.value.key.equals(key)) {
                return node.value.value;
            }
            node = node.next;
        }
        return null;
    }

    private class Node {
        private Node next;
        private Entity value;
    }
}
}


