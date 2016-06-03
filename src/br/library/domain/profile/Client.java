package br.library.domain.profile;

public class Client {
	private int id;
	private String name;
	private int registration;
	private String phone;
	private int totalCounter;
	private int counterMaxRent;

	public Client(int id, String name, int registration, String phone) {

		this.id = id;
		this.name = name;
		this.registration = registration;
		this.phone = phone;
	}

	public Client(String name, int registration, String phone) {

		this.name = name;
		this.registration = registration;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTotalCounter() {
		return totalCounter;
	}

	public void setTotalCounter(int totalCounter) {
		this.totalCounter = totalCounter;
	}

	public int getCounterMaxRent() {
		return counterMaxRent;
	}

	public void setCounterMaxRent(int counterMaxRent) {
		this.counterMaxRent = counterMaxRent;
	}

	public void countMaxRentUP() {
		this.counterMaxRent = this.counterMaxRent + 1;
	}

	public void countMaxRentDOWN() {
		this.counterMaxRent = this.counterMaxRent - 1;
	}

	public void countUPForReport() {
		this.totalCounter = this.totalCounter + 1;
	}

	public void countDOWNForReport() {
		this.totalCounter = this.totalCounter - 1;
	}
}
