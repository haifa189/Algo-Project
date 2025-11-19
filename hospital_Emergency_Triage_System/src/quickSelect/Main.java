package quickSelect;
import general.*;
import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Patient[] patients = new Patient[100];
		for (int i = 0; i < 100; i++) {
			patients[i] = new Patient("", (int)(Math.random() * 10) + 1);
		}
		System.out.println(Deterministic.DeterministicKSelect(patients, 80).toString());
		System.out.println(Randomized.RandomizedkSelect(patients, 80).toString());
		
		
		System.out.println(Deterministic.DeterministicKSelect(patients, 70).toString());
		System.out.println(Randomized.RandomizedkSelect(patients, 70).toString());
		
		System.out.println(Deterministic.DeterministicKSelect(patients, 100).toString());
		System.out.println(Randomized.RandomizedkSelect(patients, 100).toString());
	}
	
}
