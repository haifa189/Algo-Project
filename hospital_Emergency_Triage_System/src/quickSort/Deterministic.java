package quickSort;

public class Deterministic {

	// Deterministic

	public static void DeterministicQuickSort(int[] scores, int start, int end) {
		if (start < end) {
			int p = Partition(scores, start, end);
			System.out.println("Pivot chosen: " + scores[p]);
			DeterministicQuickSort(scores, start, p - 1);
			DeterministicQuickSort(scores, p + 1, end);
		}
	}

	// Partition

	public static int Partition(int[] scores, int start, int end) {
		int pivot = end;
		int pointer = start - 1;

		for (int i = start; i < end; i++) {
			if (scores[i] < scores[pivot]) {
				pointer++;
				int temp = scores[pointer];
				scores[pointer] = scores[i];
				scores[i] = temp;
			}

		}

		int temp = scores[pointer + 1];
		scores[pointer + 1] = scores[pivot];
		scores[pivot] = temp;

		return (pointer + 1);
	}

}
