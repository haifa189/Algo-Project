package quickSelect;

import general.Patient;

public class Randomized {
	// K-Select

	public static Patient RandomizedkSelect(Patient[] A, int k) {
		int n = A.length;

		if (n <= 50) {
			mergeSort(A);
			return A[k - 1];
		}

		Patient p = RandomizedPivot(A);

		int ll = 0;
		int le = 0;
		for (int i = 0; i < n; i++) {
			if (A[i].getSeverity() < p.getSeverity())
				ll++;
			if (A[i].getSeverity() == p.getSeverity())
				le++;
		}

		int lr = n - ll - le;
		Patient[] L = new Patient[ll];
		Patient[] R = new Patient[lr];

		int l = 0, r = 0;
		for (int i = 0; i < n; i++) {
			if (A[i].getSeverity() < p.getSeverity()) {
				L[l] = A[i];
				l++;

			} else if (A[i].getSeverity() > p.getSeverity()) {
				R[r] = A[i];
				r++;
			}
		}

		if (k <= ll)
			return RandomizedkSelect(L, k);
		if (k <= (ll + le))
			return p;

		return RandomizedkSelect(R, (k - ll - le));
	}

	// Median of Medians

	public static Patient RandomizedPivot(Patient[] A) {
		return A[(int) (Math.random() * A.length)];

	}

	// merge sort

	public static void mergeSort(Patient[] arr) {
		int n = arr.length;
		Patient[] b = new Patient[n];
		ms(arr, 0, n - 1, b);
	}

	public static void ms(Patient[] a, int left, int right, Patient[] b) {
		if (left >= right)
			return;
		int mid = left + (right - left) / 2;
		ms(a, left, mid, b);
		ms(a, mid + 1, right, b);
		merge(a, left, mid, right, b);
	}

	public static void merge(Patient[] a, int left, int mid, int right, Patient[] b) {
		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (a[i].getSeverity() <= a[j].getSeverity()) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			b[k] = a[i];
			i++;
			k++;
		}
		while (j <= right) {
			b[k] = a[j];
			j++;
			k++;
		}
		for (i = left; i <= right; i++)
			a[i] = b[i];
	}

}
