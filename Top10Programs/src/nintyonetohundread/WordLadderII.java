package nintyonetohundread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//https://www.youtube.com/watch?v=Tlq4x5ln9Rg&t=933s
public class WordLadderII {

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
				List<List<String>> lt=findLadder(beginWord, endWord, wordList);
				System.out.println(lt);

	}

	static List<List<String>> findLadder(String beignWord, String endWord, List<String> wordList) {
	
		
		Map<String,List<String>> m=new HashMap<>();
		Map<String,Integer> ladder=new HashMap<>();
		
		for (int i = 0; i < wordList.size(); i++) {
			ladder.put(wordList.get(i), Integer.MAX_VALUE);
		}
		ladder.put(beignWord, 0);
		Queue<String> q=new LinkedList<String>();
		q.add(beignWord);
		int min=Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			String s=q.poll();
			int step=ladder.get(s)+1;
			System.out.println("Step Value : "+step);
			System.out.println("Min Value : "+min);
			if(step>min) continue;
			for(int i=0;i<s.length();i++) {
				StringBuffer sb=new StringBuffer(s);
				for(char c='a';c<='z';c++) {
					sb.setCharAt(i, c);
					String sn=sb.toString();
					if(ladder.containsKey(sn)) {
						if(ladder.get(sn)<step) continue;
						else if (ladder.get(sn)>step) {
							ladder.put(sn, step);
							q.offer(sn);
						}
						if(m.containsKey(s))
							m.get(s).add(sn);
						else {
							List<String> l=new ArrayList<String>();
							l.add(sn);
							m.put(s, l);
						}
						if(sn.equals(endWord))
							min=step;
					}
				}
			}
			
		}
		List<String> l = new ArrayList<String>();
		List<List<String>> res = new ArrayList<List<String>>();
		l.add(beignWord);
		helper(m,res,l,beignWord,endWord);
		
		return res;
	}
	
	private static void helper(Map<String,List<String>> m,List<List<String>> res,List<String> l,String beginWord,String endWord ) {
		if(beginWord.equals(endWord))
			res.add(new ArrayList<String>(l));
		if(m.get(beginWord)!=null) {
			for(String s:m.get(beginWord)) {
				l.add(s);
				helper(m, res, l, s, endWord);
				l.remove(l.size()-1);
			}
		}
	}

}
