package general;

public class Patient {
	private String id;
	private String name;
	private int severity;
	private static int users = 0;

	public Patient(String name, int severity) {
		this.id = "PAT" + String.format("%04d", users++);
		this.name = name;
		this.severity = severity;
	}

	public String getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getSeverity() {
		return this.severity;
	}
	
	public String toString() {
		return ("ID: " + this.id + ", Name: " + this.name + ", Severity: " + this.severity);
	}
}
