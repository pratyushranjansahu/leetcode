package graph;

import java.util.ArrayList;

public class GraphNode {
	static class Edge {
		int src, nbr, wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}

		@Override
		public String toString() {
			return "Edge [src=" + src + ", nbr=" + nbr + ", wt=" + wt + "]";
		}

	}

	public static void main(String[] args) {
		int vertices = 7;
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		ArrayList<Edge> e1 = graph[0];
		graph[0].add(new Edge(0, 3, 40));
		graph[0].add(new Edge(0, 1, 10));

		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 2, 10));

		graph[2].add(new Edge(2, 3, 10));
		graph[2].add(new Edge(2, 1, 10));

		graph[3].add(new Edge(3, 0, 40));
		graph[3].add(new Edge(3, 2, 10));
		graph[3].add(new Edge(3, 4, 2));

		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 3));
		graph[4].add(new Edge(4, 6, 3));

		graph[5].add(new Edge(5, 4, 3));
		graph[5].add(new Edge(5, 6, 3));

		graph[6].add(new Edge(6, 5, 3));
		graph[6].add(new Edge(6, 4, 8));

	}

	private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
		if (src == dest) {
			return true;
		}
		visited[src] = true;
		for (Edge edge : graph[src]) {
			if (visited[edge.nbr] == false) {
				boolean hasPath = hasPath(graph, edge.nbr, dest, visited);
				if (hasPath == true)
					return true;
			}
		}

		return false;

	}

	private static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
		if (src == dest) {
			System.out.println(psf);
			return;
		}
		visited[src] = true;
		for (Edge edge : graph[src]) {
			if (visited[edge.nbr] == false) {
				printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);

			}
		}

	}

}
