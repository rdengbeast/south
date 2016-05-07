package exercise13_6;

public class WorkerTester {

	public static void main(String[] args) {

		Worker someworker1 = new HourlyWorker("joe", 20);
		Worker someworker2 = new SalariedWorker("Billy", 20);
		
		System.out.println("hourly worker: " + someworker1.computePay(50));
		System.out.println("Salary worker: " + someworker2.computePay(50));
	}

}
