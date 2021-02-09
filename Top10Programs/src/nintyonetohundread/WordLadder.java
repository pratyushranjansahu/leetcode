package nintyonetohundread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	public static void main(String[] args) {
		String beginWord = "hit";
		String	endWord = "cog";
		List<String> wordList = new ArrayList<String>();
				wordList.add("hot");
				wordList.add("dot");
				wordList.add("dog");
				wordList.add("lot");
				wordList.add("log");
				wordList.add("cog");
				System.out.println(ladderLength(beginWord, endWord, wordList));

	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
       HashMap<String, Boolean> Vmap = new HashMap<String, Boolean>();
      for(int i = 0; i <wordList.size(); i++)
           Vmap.put(wordList.get(i), false);
      
       Queue<String> q = new LinkedList<String>();
       int length = 1;
       q.add(beginWord);
       Vmap.put(beginWord, true);
       while (!q.isEmpty()) {
           int size = q.size();
           for (int i = 0; i < size; i++) {
               String w = q.poll();
               if (w.equals(endWord)) 
                    return length;
               wordMatch(w, Vmap, q);
           }
           length++;
       }
       return 0;
   }
   public static void wordMatch(String w, HashMap<String, Boolean> Vmap, Queue<String> q) {
	  // StringBuffer sb=new StringBuffer(w);
	   for(int i=0;i<w.length();i++) {
			StringBuffer sb=new StringBuffer(w);
			for(char c='a';c<='z';c++) {
				sb.setCharAt(i, c);
				String sn=sb.toString();
              // String s = String.valueOf(word);
               if (Vmap.containsKey(sn) && Vmap.get(sn) == false) {
                   q.add(sn);
                   Vmap.put(sn, true);
               }
           }
       }
   }

}
