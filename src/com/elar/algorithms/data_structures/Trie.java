package com.elar.algorithms.data_structures;


import java.util.HashMap;
import java.util.Map;

public class Trie {

    /**
     * Root of the tree.
     */
    private Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * Inserts the given word into the trie.
     * Iterative approach.
     *
     * @param word the word to be inserted
     */
    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = current.children.get(c);
            if (node == null) {
                node = new Node();
                current.children.put(c, node);
            }
            current = node;
        }
        current.isCompleteWord = true;
    }

    /**
     * Inserts the given word into the trie.
     * Recursive approach.
     *
     * @param word the word to be inserted
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    /**
     * Helper method to recursively insert a word into the trie.
     */
    private void insertRecursive(Node current, String word, int index) {
        if (word.length() == index) {
            current.isCompleteWord = true;
            return;
        }
        char c = word.charAt(index);
        Node node = current.children.computeIfAbsent(c, k -> new Node());
        insertRecursive(node, word, index + 1);
    }

    /**
     * Returns true if the trie contains the given word.
     * Iterative approach.
     *
     * @param word the word to be searched for
     * @return true if the trie contains the give word
     */
    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node next = current.children.get(c);
            if (next == null) {
                return false;
            }
            current = next;
        }
        return true;
    }

    /**
     * Returns true if the trie contains the given word.
     * Recursive approach.
     *
     * @param word the word to be searched for
     * @return true if the trie contains the given word
     */
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(Node current, String word, int index) {
        if (word.length() == index) {
            return true;
        }
        char c = word.charAt(index);
        Node next = current.children.get(c);
        if (next == null) {
            return false;
        }
        return searchRecursive(next, word, index + 1);
    }

    /**
     * Deletes the given word from the trie.
     * Recursive approach.
     *
     * @param word word to be deleted
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(Node current, String word, int index) {
        if (index == word.length()) {
            if (!current.isCompleteWord) {
                return false;
            }
            current.isCompleteWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char c = word.charAt(index);
        Node next = current.children.get(c);
        if (next == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(next, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(c);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

    /**
     * Returns the number of complete words in the trie.
     *
     * @return the number of complete words in the trie
     */
    public int size() {
        return size(root);
    }

    /**
     * Number of complete words contained in the sub-trie with node as root.
     *
     * @param node root of the sub-trie
     * @return number of complete words contained in the sub-trie
     */
    private int size(Node node) {
        int count = 0;
        if (node.isCompleteWord)
            count += 1;

        if (node.children.isEmpty())
            return count;

        for (Node child : node.children.values()) {
            count += size(child);
        }
        return count;
    }

    public int countWithPrefix(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node next = current.children.get(c);
            if (next == null) {
                return 0;
            }
            current = next;
        }
        // `current` should now be the sub-tree containing words starting with `prefix`
        return size(current);
    }

    /**
     * Class that represents a trie-node.
     */
    private static class Node {
        Map<Character, Node> children;
        boolean isCompleteWord;

        Node() {
            children = new HashMap<>();
            isCompleteWord = false;
        }
    }

}