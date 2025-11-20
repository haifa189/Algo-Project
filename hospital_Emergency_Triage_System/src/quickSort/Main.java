package quickSort;

import general.*;
import com.github.javafaker.Faker;
import org.yaml.snakeyaml.Yaml;
import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faker faker = new Faker();

		Patient[] patients1 = new Patient[20];
		Patient[] patients2 = new Patient[20];

		int n = patients1.length;

		for (int i = 0; i < n; i++) {
			patients1[i] = new Patient(faker.name().fullName(), (int) (Math.random() * 10) + 1);
			patients2[i] = patients1[i];
		}

		Deterministic.DeterministicQuickSort(patients1, 0, n - 1);
		Randomized.RandomizedQuickSort(patients2, 0, n -1);

		for (int i = 0; i < n; i++) {
			System.out.println(patients1[i]);
			System.out.println(patients2[i]);
			System.out.println("_".repeat(55));
		}

	}

}
