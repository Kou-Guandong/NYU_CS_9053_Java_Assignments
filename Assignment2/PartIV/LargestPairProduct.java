import java.util.PriorityQueue;

public class LargestPairProduct {

	public static void main(String[] args) {

		int[] intArray = { 17, 1, 3, 12, 39, 4, 76, 4, 31, 87 };
		// to make it more generally robust and efficient, max heap (priority queue) is
		// used here; the time complexity is O(n), lower than using nested for loops of
		// O(n^2); considering potential negative values, a min heap should also be used
		int k = 2;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
		for (int value : intArray) {
			maxHeap.offer(value);
			minHeap.offer(-value);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		int product = Math.max(maxHeap.poll() * maxHeap.poll(), minHeap.poll() * minHeap.poll());
		System.out.println("Maximum product of all pairs in the array: " + product);
	}
}
