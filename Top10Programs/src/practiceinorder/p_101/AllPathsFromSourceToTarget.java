package practiceinorder.p_101;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		int[][] graph= {{1,2},{3},{3},{}};
		System.out.println(findPath(graph));

	}
	
	private static List<List<Integer>> findPath(int[][] graph){
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> path=new ArrayList();
		dfs(graph,result,path,0);
		return result;
	}
	private static void dfs(int[][] graph,List<List<Integer>> result,List<Integer> path,int u) {
		path.add(u);
		if(u==graph.length-1)
			result.add(new ArrayList<>(path));
		else 
			for(int v : graph[u])
				dfs(graph, result, path, v);
		path.remove(path.size()-1);
	}
}
