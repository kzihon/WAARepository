package miu.edu.WAA_labs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Address {
    /** OneToManyUni
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipcode;
    @ManyToOne
    @JoinTable(name = "Person_Address",
            joinColumns={@JoinColumn(name = "Address_id")},
            inverseJoinColumns={@JoinColumn(name = "Person_id")}
    )
    private Person person;

    public Address(String street, String zipcode, Person person) {
        this.street = street;
        this.zipcode = zipcode;
        this.person = person;
    }

    **/

    /// OneToManyUni
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipcode;


    public Address(String street, String zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }

    //**/


    /**OneToMany Bi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipcode;
    @ManyToOne
    //if you wanna use join table force it to be jointable instead of joincolum here
    //and don't touch anything, mapped by should be still on the onetomany side
    @JoinTable(name = "Person_Address",
            joinColumns={@JoinColumn(name = "Address_id")},
            inverseJoinColumns={@JoinColumn(name = "Person_id")}
    )
    private Person person;


    public Address(String street, String zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }



    **/
    /**oneToOneBi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipcode;
    @OneToOne(mappedBy = "address")
    //use mapped by on the week one, give the mapping for the strongest entity
    //if you add mapped by don't put joincolom or jointable b/t mapped by means give
    //my control to the other side , don't do anything on my side, but those two are
    //tring to customize the clolom or table or stg which really doesn't make sense.
    //you will get exception if you do so
    private Person person;


    public Address(String street, String zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }


    **/
    /** ManyToMany Bi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipcode;
    @ManyToMany(mappedBy = "addresses")
    private List<Person> personList;


    public Address(String street, String zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }
    **/

}