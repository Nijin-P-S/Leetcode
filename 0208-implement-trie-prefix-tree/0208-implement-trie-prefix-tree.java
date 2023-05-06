class Node{
    char val;
    Node[] arr;
    boolean terminal;
    
    Node(char val, boolean terminal){
        this.val = val;
        this.terminal = terminal;
        arr = new Node[26];
    }
}

class Trie {
    Node[] prefix;
    
    public Trie() {
        prefix = new Node[26];
    }
    
    public void insert(String word) {
        Node[] curArray = prefix;
        for(int i=0; i<word.length(); i++){
            char curChar = Character.toLowerCase(word.charAt(i));
            if(curArray[curChar-'a'] == null){
                Node cur = new Node(curChar, false);
                curArray[curChar-'a'] = cur;
            }
            if(i == word.length()-1){
                curArray[curChar-'a'].terminal = true;
            }
            curArray = curArray[curChar-'a'].arr;
        }
    }
    
    public boolean search(String word) {
        Node[] curArray = prefix;
        for(int i=0; i<word.length(); i++){
            char curChar = Character.toLowerCase(word.charAt(i));
            if(curArray[curChar-'a'] == null)
                return false;
            else if(i == word.length()-1 && !curArray[curChar-'a'].terminal)
                return false;
            curArray = curArray[curChar-'a'].arr;
        }
        return true;
    }
    
    public boolean startsWith(String word) {
        Node[] curArray = prefix;
        for(int i=0; i<word.length(); i++){
            if(curArray[word.charAt(i)-'a'] == null)
                return false;
            curArray = curArray[word.charAt(i)-'a'].arr;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */