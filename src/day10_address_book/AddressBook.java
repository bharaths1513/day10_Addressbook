package day10_address_book;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	Scanner scanner = new Scanner(System.in);
	ArrayList<Person> personList = new ArrayList<Person>();

	// Uc2: Ability to add a new contact to Address Book

	public void add() {

		System.out.println("Enter the number of address book ");
		int books = scanner.nextInt();
		for (int j = 1; j <= books; j++) { // ability to add multiple address books
			System.out.println("Enter Address Book Unique Name"); // Adding Unique Name for Each address book
			String unique = scanner.next();
			System.out.println("Enter your first name");
			String firstName = scanner.next();
			System.out.println("Enter your last name");
			String lastName = scanner.next();
			System.out.println("Enter your address");
			String address = scanner.next();
			System.out.println("Enter your city");
			String city = scanner.next();
			System.out.println("Enter your state");
			String state = scanner.next();
			System.out.println("Enter your zip code");
			int zip = scanner.nextInt();
			System.out.println("Enter your phone");
			long mobileNo = scanner.nextLong();

			Person person1 = new Person(unique, firstName, lastName, address, city, state, mobileNo, zip);
			personList.add(person1);
			System.out.println("Contact added successfully");
			System.out.println("\n");
		}

	}

	public void display() { // for Display the address book list
		for (int i = 0; i < personList.size(); i++) {
			Person person = personList.get(i);
			System.out.println("unique name:" + person.getunique() + "\n" + "FirstName" + person.getFirstName() + "\n"
					+ "LastName:" + person.getLastName() + "\n" + "Adress:" + person.getAddress() + "\n" + "City:"
					+ person.getCity() + "\n" + "State:" + person.getCity() + "\n" + "Phone-Number:"
					+ person.getMobileNo() + "\n" + "Pin-code:" + person.getPincode() + "\n");
		}
	}

	// Uc3: Ability to edit existing contact person using their name

	public void edit(String firstName) {
		for (int i = 0; i < personList.size(); i++) {
			Person person = personList.get(i);

			System.out.println("Hi " + person.getFirstName() + " please enter your  new Address");
			String address = scanner.next();
			person.setAddress(address);

			System.out.println("Hi " + person.getFirstName() + " please enter your  new city");
			String city = scanner.next();
			person.setCity(city);

			System.out.println("Hi " + person.getFirstName() + " please enter your  new state");
			String state = scanner.next();
			person.setState(state);

			System.out.println("Hi " + person.getFirstName() + " please enter your  new Zip Code");
			int zip = scanner.nextInt();
			person.setPincode(zip);

			System.out.println("Hi " + person.getFirstName() + " please enter your  new Phone No");
			int PhoneNo = scanner.nextInt();
			person.setMobileNo(PhoneNo);

			System.out.println("Hi " + person.getFirstName() + " you have sucessfully updated");

		}

	}

	// Uc4: Ability to delete a person using persons name

	public void delete(String name) {
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(name)) {
				Person person = personList.get(i);
				personList.remove(person);
			}
		}
	}

	// Uc5: Ability to add multiple person to Address Book

	public void addMultiplePerson() {
		System.out.println("Enter a person Name:");
		String firstName = scanner.nextLine();
		for (int i = 0; i < personList.size(); i++) {
			Person person = personList.get(i);

			if (personList.get(i).getFirstName().equals(firstName)) {
				System.out.println("Duplicate");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Problem");
		AddressBook adressBookImplementation = new AddressBook();
		boolean condition = true;

		while (condition == true) { // switch condition for add,display,edit,delete address book
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"1.add" + "\n" + "2.Display" + "\n" + "3.Edit" + "\n" + "4.Delete" + "\n" + "5.Add MultiplePerson");
			// Scanner option = new Scanner(System.in);

			switch (scanner.nextInt()) {
			case 1:
				adressBookImplementation.add();
				break;
			case 2:
				System.out.println("\n");
				adressBookImplementation.display();

				break;
			case 3:
				System.out.println("Enter the firstName:");
				String firstName = scanner.nextLine();
				adressBookImplementation.edit(firstName);
				break;
			case 4:
				System.out.println("Enter the Name of the person do you wants to delete");
				String name = scanner.nextLine();
				adressBookImplementation.delete(name);
				break;
			case 5:
				adressBookImplementation.addMultiplePerson();
				break;
			default:
				System.out.println();
			}
		}
	}
}
