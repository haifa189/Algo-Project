package quickSort;

public class Randomized {
	// Randomized

	public static void RandomizedQuickSort(int[] severity, int start, int end) {
		if (start < end) {
			int p = RandomizedPartition(severity, start, end);
			System.out.println("Pivot chosen: " + severity[p]);
			RandomizedQuickSort(severity, start, p - 1);
			RandomizedQuickSort(severity, p + 1, end);
		}
	}

	// Randomized Partition

	public static int RandomizedPartition(int[] severity, int start, int end) {
		int rand = start + (int) (Math.random() * (end - start));

		int temp = severity[rand];
		severity[rand] = severity[end];
		severity[end] = temp;

		return Partition(severity, start, end);
	}

	// Partition

	public static int Partition(int[] severity, int start, int end) {
		int pivot = end;
		int pointer = start - 1;

		for (int i = start; i < end; i++) {
			if (severity[i] < severity[pivot]) {
				pointer++;
				int temp = severity[pointer];
				severity[pointer] = severity[i];
				severity[i] = temp;
			}

		}

		int temp = severity[pointer + 1];
		severity[pointer + 1] = severity[pivot];
		severity[pivot] = temp;

		return (pointer + 1);
	}

}
