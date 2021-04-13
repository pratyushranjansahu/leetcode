package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

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

	static class Pair implements Comparable<Pair> {
		int wsf;
		String psf;

		Pair(int wsf, String psf) {
			this.wsf = wsf;
			this.psf = psf;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.wsf - o.wsf;
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

		// drawTree And generate Comp
		boolean[] visited = new boolean[vertices];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<ArrayList<Integer>>();
		for (int v = 0; v < vertices; v++) {
			if (visited[v] == false) {
				ArrayList<Integer> comp = new ArrayList<Integer>();
				drawTreeAndGenerateComp(graph, v, comp, visited);
				comps.add(comp);
			}
		}
		// for is Graph connected
		if (comps.size() == 1) {
			System.out.println("Graph is connected.");
		}

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

	static String spath = "";
	static int spathwt = Integer.MAX_VALUE;
	static String lpath = "";
	static int lpathwt = Integer.MIN_VALUE;
	static String cpath = "";
	static int cpathwt = Integer.MAX_VALUE;
	static String fpath = "";
	static int fpathwt = Integer.MIN_VALUE;
	static PriorityQueue<Pair> pq = new PriorityQueue();

	private static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k,
			String psf, int wsf) {
		if (src == dest) {
			if (wsf < spathwt) {
				spathwt = wsf;
				spath = psf;
			}
			if (wsf > lpathwt) {
				lpathwt = wsf;
				lpath = psf;
			}
			if (wsf > criteria && wsf < cpathwt) {
				cpathwt = wsf;
				cpath = psf;
			}
			if (wsf < criteria && wsf > fpathwt) {
				fpathwt = wsf;
				fpath = psf;
			}

			if (pq.size() < k) {
				pq.add(new Pair(wsf, psf));
			} else {
				if (wsf > pq.peek().wsf) {
					pq.remove();
					pq.add(new Pair(wsf, psf));
				}
			}

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

	private static void drawTreeAndGenerateComp(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp,
			boolean[] visited) {
		visited[src] = true;
		comp.add(src);
		for (Edge edge : graph[src]) {
			if (visited[edge.nbr] == false) {
				drawTreeAndGenerateComp(graph, edge.nbr, comp, visited);

			}
		}

	}

}
