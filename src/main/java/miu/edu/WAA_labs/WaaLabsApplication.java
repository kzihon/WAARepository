package miu.edu.WAA_labs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import miu.edu.WAA_labs.entity.Address;
import miu.edu.WAA_labs.entity.Person;
import miu.edu.WAA_labs.repository.AddressRepo;
import miu.edu.WAA_labs.repository.PersonRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan
@OpenAPIDefinition
public class WaaLabsApplication implements CommandLineRunner {

	@Autowired
	PersonRepo personRepo;
	@Autowired
	AddressRepo addressRepo;
	public static void main(String[] args) {
		SpringApplication.run(WaaLabsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		//ManyToOne Unidirectional
//		Person person = new Person("John", "Jakob");
//		Person person1 = new Person("Mathew", "Jams");
//
//		Address address = new Address("2000 N", "789", person);
//		Address address1 = new Address("1000 N", "456", person);
//		Address address12 = new Address("567 N", "567", person1);
//
//		personRepo.save(person);
//		personRepo.save(person1);
//		addressRepo.save(address);
//		addressRepo.save(address1);
//		addressRepo.save(address12);

		// /**
		//OneToMany Unidirectional;
		Address address2 = new Address("2000 N", "789");
		Address address3 = new Address("1000 N", "456");
		Address address4 = new Address("567 N", "567");
//
//		addressRepo.save(address2);
//		addressRepo.save(address3);
//		addressRepo.save(address4);

		List<Address> addressList1 = new ArrayList<>();
		List<Address> addressList2 = new ArrayList<>();
		addressList1.add(address2);
		addressList1.add(address3);
		addressList2.add(address4);


		Person person2= new Person("John", "Jakob",addressList1);

		//person2.addAddress(address2); when i try to add same object twice, it gives me error in oneToMany.why?
		Person person3= new Person("Mathew", "Jams", addressList2);
//		person2.addAddress(address2);
//		person2.addAddress(address3);
//		person3.addAddress(address4);
//		person3.addAddress(address3);

		personRepo.save(person2);
		personRepo.save(person3);
		//It is not updated in the database, when will the PC will be closed
		//person2.setFname("David");

   // **/



	/**	//OneToMany Bidirectional;
		Address address2 = new Address("2000 N", "789");
		Address address3 = new Address("1000 N", "456");
		Address address4 = new Address("567 N", "567");
//
//		addressRepo.save(address2);
//		addressRepo.save(address3);
//		addressRepo.save(address4);

		List<Address> addressList1 = new ArrayList<>();
		List<Address> addressList2 = new ArrayList<>();
		addressList1.add(address2);
		addressList1.add(address3);
		addressList2.add(address4);


		Person person2= new Person("John", "Jakob",addressList1);
		address2.setPerson(person2);
		address3.setPerson(person2);

		//person2.addAddress(address2); when i try to add same object twice, it gives me error in oneToMany.why?
		Person person3= new Person("Mathew", "Jams", addressList2);
		address4.setPerson(person3);
//		person2.addAddress(address2);
//		person2.addAddress(address3);
//		person3.addAddress(address4);
//		person3.addAddress(address3);

		personRepo.save(person2);
		personRepo.save(person3);
		//It is not updated in the database, when will the PC will be closed
		//person2.setFname("David");


		**/


	/** //ManyToMany Bi
		Address address2 = new Address("2000 N", "789");
		Address address3 = new Address("1000 N", "456");
		Address address4 = new Address("567 N", "567");
//
//		addressRepo.save(address2);
//		addressRepo.save(address3);
//		addressRepo.save(address4);

		Person person2= new Person("John", "Jakob");
		address2.setPerson(person2);
		address3.setPerson(person2);

		//person2.addAddress(address2); when i try to add same object twice, it gives me error in oneToMany.why?
		Person person3= new Person("Mathew", "Jams");
		address4.setPerson(person3);
//		person2.addAddress(address2);
//		person2.addAddress(address3);
//		person3.addAddress(address4);
//		person3.addAddress(address3);

		personRepo.save(person2);
		personRepo.save(person3);
		//It is not updated in the database, when will the PC will be closed
		//person2.setFname("David");

	 **/
	}

}
