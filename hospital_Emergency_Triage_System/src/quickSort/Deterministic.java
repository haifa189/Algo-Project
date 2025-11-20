package quickSort;
import general.*;

public class Deterministic {

	// Deterministic

	public static void DeterministicQuickSort(Patient[] patients, int start, int end) {
		if (start < end) {
			int p = Partition(patients, start, end);
			//System.out.println("Pivot chosen: " + patients[p]);
			DeterministicQuickSort(patients, start, p - 1);
			DeterministicQuickSort(patients, p + 1, end);
		}
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
