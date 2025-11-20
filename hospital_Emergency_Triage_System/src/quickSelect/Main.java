package quickSelect;

import general.*;
import com.github.javafaker.Faker;
import org.yaml.snakeyaml.Yaml;
import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faker faker = new Faker();

		Patient[] patients = new Patient[100];

		for (int i = 0; i < 100; i++) {
			patients[i] = new Patient(faker.name().fullName(), (int) (Math.random() * 10) + 1);
		}
		/*
		 * System.out.println(Deterministic.DeterministicKSelect(patients,
		 * 50).toString()); System.out.println(Randomized.RandomizedkSelect(patients,
		 * 50).toString());
		 * 
		 * 
		 * System.out.println(Deterministic.DeterministicKSelect(patients,
		 * 60).toString()); System.out.println(Randomized.RandomizedkSelect(patients,
		 * 60).toString());
		 * 
		 * System.out.println(Deterministic.DeterministicKSelect(patients,
		 * 70).toString()); System.out.println(Randomized.RandomizedkSelect(patients,
		 * 70).toString());
		 * 
		 * System.out.println(Deterministic.DeterministicKSelect(patients,
		 * 80).toString()); System.out.println(Randomized.RandomizedkSelect(patients,
		 * 80).toString());
		 * 
		 * 
		 * System.out.println(Deterministic.DeterministicKSelect(patients,
		 * 90).toString()); System.out.println(Randomized.RandomizedkSelect(patients,
		 * 90).toString());
		 * 
		 * System.out.println(Deterministic.DeterministicKSelect(patients,
		 * 100).toString()); System.out.println(Randomized.RandomizedkSelect(patients,
		 * 100).toString());
		 * 
		 * System.out.println(); for (Patient patient : patients) {
		 * System.out.println(patient + "\n"); }
		 */

	}

}
