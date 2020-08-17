package fiftyonetosixty;

import java.util.PriorityQueue;

class Point implements Comparable<Point> {
	public int x, y;

	public Point(int[] points) {
		x = points[0];
		y = points[1];
	}

	@Override
	public int compareTo(Point point) {

		return (point.x * point.x + point.y * point.y) - (x * x + y * y);
	}
}

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int K = 2;
		System.out.println(kClosest(points, K));
	}

	private static int[][] kClosest(int[][] points, int K) {
		int[][] result = new int[K][2];
		PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < points.length; i++) {
			if (priorityQueue.size() < K) {
				priorityQueue.offer(new Point(points[i]));
			} else {
				Point p = priorityQueue.peek();
				if ((p.x * p.x + p.y * p.y) > (points[i][0] * points[i][0] + points[i][1] * points[i][1])) {
					priorityQueue.poll();
					priorityQueue.add(new Point(points[i]));
				}
			}
		}

		for (int i = 0; i < K; i++) {
			Point p = priorityQueue.poll();
			result[i][0] = p.x;
			result[i][1] = p.y;
		}

		return result;
	}

}
