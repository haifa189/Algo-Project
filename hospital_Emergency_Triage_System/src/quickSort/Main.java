package quickSort;

import general.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Patient[] patients = new Patient[100];
		for (int i = 0; i < 100; i++) {
			patients[i] = new Patient("", (int)(Math.random() * 10) + 1);
		}
		System.out.println();
	}

}
