class TreeNode{
    public Map<Character, TreeNode> children = new HashMap<>();
    public boolean isWord = false;
}

class PrefixTree {
    private TreeNode root;

    //Initialise data structure 
    public PrefixTree() {
         root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode currNode = root;
        char[] arr = word.toCharArray();

        for(char c : arr){
            if(currNode.children.containsKey(c) == false){
                currNode.children.put(c, new TreeNode());
            }
            currNode = currNode.children.get(c);
        }
        currNode.isWord = true;
    }

    public boolean search(String word) {
        TreeNode currNode = root;
        char[] arr = word.toCharArray();

        for(char c : arr){
            if(currNode.children.containsKey(c) == false){
                return false;
            }
            currNode = currNode.children.get(c);
        }
        return currNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode currNode = root;
        char[] arr = prefix.toCharArray();

        for(char c : arr){
            if(currNode.children.containsKey(c) == false){
                return false;
            }
            currNode = currNode.children.get(c);
        }
        return true;
    }
}
