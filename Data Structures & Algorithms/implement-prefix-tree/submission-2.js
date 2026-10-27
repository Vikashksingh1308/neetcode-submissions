class TrieNode{
    constructor() {
        this.children = {};
        this.isEnd = false;
    }
}
class PrefixTree {
    constructor() {
        this.root = new TrieNode();
    }

    /**
     * @param {string} word
     * @return {void}
     */
    insert(word) {
        let node = this.root;
        for(const char of word){
            if(!node.children[char]){
                node.children[char] = new TrieNode();
            }

            node = node.children[char];
        }
        node.isEnd = true;
    }

    /**
     * @param {string} word
     * @return {boolean}
     */
    search(word) {
        const node = this._traverse(word);
        return node !== null && node.isEnd;
    }

    /**
     * @param {string} prefix
     * @return {boolean}
     */
    startsWith(prefix) {
        return this._traverse(prefix) !== null;
    }

    _traverse(str){
        let node = this.root;
        for(const char of str){
            if(!node.children[char]) return null;
            node = node.children[char];
        }
        return node;
    }
}
