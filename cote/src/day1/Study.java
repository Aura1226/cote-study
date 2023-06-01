package day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Study {
	
	public static void main(String args[]) {
		
		  Person person1 = new Person("홍길동"); 
		  person1.addPhoneNumber(new PhoneNumber("010-1234-5678")); 
		  person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));
		  
		  Person person2 = new Person("김철수"); 
		  person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));
		  
		  Person person3 = new Person("김영희"); 
		  person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));
		  
		  PhoneBook phoneBook = new PhoneBook(); 
		  phoneBook.addPerson(person1);
		  phoneBook.addPerson(person2); 
		  phoneBook.addPerson(person3);
		  
		  System.out.println(phoneBook.search(new PhoneNumber("01023456789")));
		  System.out.println(phoneBook.search(new PhoneNumber("01024680246")));
		  System.out.println(phoneBook.search(new PhoneNumber("01013579135")));
		  System.out.println(phoneBook.search(new PhoneNumber("01000000000")));
		 
//		Person person = new Person("홍길동");
//		person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
		
//		PhoneBook phoneBook = new PhoneBook();
//		phoneBook.addPerson(person);
//		phoneBook.addPerson(person);
		
//		System.out.println(phoneBook);
	}
	
	private static class PhoneNumber {
		public final String phoneNumber;
		
		public PhoneNumber(String rawPhoneNumber) {
			this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
		}
		
		@Override
		public String toString() {
			return "PhoneNumber{" + "phoneNumber='" + phoneNumber + "'" + "}\n";
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof PhoneNumber))
				return false;
			return phoneNumber.equals(((PhoneNumber) o).phoneNumber);
		}
		
	}
	
	private static class Person {
		public final String name;
		private final List<PhoneNumber> numbers;
		
		public Person(String name) {
			this.name = name;
			
			numbers = new ArrayList<>();
		}
		
		public void addPhoneNumber(PhoneNumber number) {
			numbers.add(number);
			
		}
		
		@Override
		public String toString() {
			return "Person{" + 
					"name='" + name + "'" +
					",\n numbers=" + numbers +
					"}";
		}
		
		public boolean hasPhoneNumber(PhoneNumber number) {
			return numbers.contains(number);
		}
		
	}
	
	private static class PhoneBook {
		private final Set<Person> people;
		
		private PhoneBook() {
			people = new HashSet<>();
		}
		
		public void addPerson(Person person) {
			people.add(person);
		}
		
		@Override
		public String toString() {
			return "PhoneBook{" + "people=\n" + people + "}";
		}
		
		public Person search(PhoneNumber number) {
			return people.stream()
					.filter(p -> p.hasPhoneNumber(number))
					.findFirst()
					.orElse(null);
		}
	}
	

}
