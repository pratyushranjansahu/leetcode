package seventyonetoeighty;
class Trie {
	public Trie children[];
	public boolean isEndOfWord;

	public Trie() {
		isEndOfWord = false;
		children = new Trie[26];
		for (int i = 0; i < 26; ++i)
			children[i] = null;
	}


	 public boolean search(String word) {
	        Trie curr = this;
	        for(int i = 0; i < word.length(); ++i){
	            char c = word.charAt(i);
	            if(c == '.'){
	                for(Trie ch: curr.children)
	                    if(ch != null && ch.search(word.substring(i+1))) return true;
	                return false;
	            }
	            if(curr.children[c - 'a'] == null) return false;
	            curr = curr.children[c - 'a'];
	        }
	        return curr != null && curr.isEndOfWord;
	    }
	 public void addWord(String word) {
	        Trie curr = this;
	        for(char c: word.toCharArray()){
	            if(curr.children[c - 'a'] == null)
	                curr.children[c - 'a'] = new Trie();
	            curr = curr.children[c - 'a'];
	        }
	        curr.isEndOfWord = true;
	    }
}
public class AddAndSearchWord {

	public static void main(String[] args) {
		Trie obj = new Trie();
		  obj.addWord("pad");
		  obj.addWord("mad");
		  obj.addWord("bad");
		  obj.addWord("ad");
		  boolean param_2 = obj.search(".ad");
		  System.out.println(param_2);

	}

}
