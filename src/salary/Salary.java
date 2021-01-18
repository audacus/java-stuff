package salary;

public class Salary implements Comparable<Salary> {

	enum Type {
		Salary,
		Fee
	}

	private int currentSalary;
	private Type salaryType;

	public Salary(int initial, Type type) {
		this.currentSalary = initial;
		this.salaryType = type;
	}

	public int getSalary() {
		return this.currentSalary;
	}

	public String toString() {
		return this.salaryType + ": " + this.currentSalary;
	}

	@Override
	public int compareTo(Salary a) {
		return this.currentSalary - a.getSalary();
		
		
		// return -1, 0, 1
		// return (int) Math.signum(this.currentSalary - a.getSalary());
	}
}
