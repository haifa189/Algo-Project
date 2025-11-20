package quickSort;
import general.*;

public class Randomized {
	// Randomized

	public static void RandomizedQuickSort(Patient[] patients, int start, int end) {
		if (start < end) {
			int p = RandomizedPartition(patients, start, end);
			//System.out.println("Pivot chosen: " + patients[p]);
			RandomizedQuickSort(patients, start, p - 1);
			RandomizedQuickSort(patients, p + 1, end);
		}
	}

	// Randomized Partition

	public static int RandomizedPartition(Patient[] patients, int start, int end) {
		int rand = start + (int) (Math.random() * (end - start + 1));

		Patient temp = patients[rand];
		patients[rand] = patients[end];
		patients[end] = temp;

		return Partition(patients, start, end);
	}

	// Partition

	public static int Partition(Patient[] patients, int start, int end) {
		int pivot = end;
		int pointer = start - 1;

		for (int i = start; i < end; i++) {
			if (patients[i].getSeverity() < patients[pivot].getSeverity()) {
				pointer++;
				Patient temp = patients[pointer];
				patients[pointer] = patients[i];
				patients[i] = temp;
			}

		}

		Patient temp = patients[pointer + 1];
		patients[pointer + 1] = patients[pivot];
		patients[pivot] = temp;

		return (pointer + 1);
	}

}
