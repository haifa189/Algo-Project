package quickSelect;

import java.util.Arrays;

import general.*;

public class Deterministic {
	// K-Select

	public static Patient DeterministicKSelect(Patient[] A, int k) {
		int n = A.length;

		if (n <= 50) {
			mergeSort(A);
			return A[k - 1];
		}

		Patient p = medianOfMedians(A);

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
		Patient[] E = new Patient[le];

		int l = 0, r = 0, e = 0;
		for (int i = 0; i < n; i++) {
			if (A[i].getSeverity() < p.getSeverity()) {
				L[l] = A[i];
				l++;
			} else if (A[i].getSeverity() == p.getSeverity()) {
				E[e] = A[i];
				e++;
			} else {
				R[r] = A[i];
				r++;
			}
		}

		if (k <= ll)
			return DeterministicKSelect(L, k);
		if (k <= (ll + le))
			return p;

		return DeterministicKSelect(R, (k - ll - le));
	}

	// Median of Medians

	public static Patient medianOfMedians(Patient[] A) {
		int n = A.length;

		int g = (int) Math.ceil(1.0 * n / 5);

		Patient[] a = new Patient[5];

		Patient[] M = new Patient[g];

		for (int i = 0; i < g; i++) {
			int start = i * 5;
		    int end = Math.min(start + 5, n);
		    Patient[] group = Arrays.copyOfRange(A, start, end);
		    mergeSort(group);
		    M[i] = group[group.length / 2];
		}

		if (g <= 50) {
			mergeSort(M);
			return M[(g - 1) / 2];
		}

		return DeterministicKSelect(M, (g - 1) / 2);

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
