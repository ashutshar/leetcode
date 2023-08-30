package org.example;

class Trie {

    Trie[] children;
    boolean endOfWord;

    public Trie() {
        children = new Trie[26];
        endOfWord = false;
    }

    public void insert(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                Trie child = new Trie();
                current.children[index] = child;
            }
            current = current.children[index];
        }
        current.endOfWord = true;

    }

    public boolean search(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
            } else {
                return false;
            }
        }
        return current == null ? false : current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("app");
        obj.insert("apple");
        System.out.println(obj.search("app"));

    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */