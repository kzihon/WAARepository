package miu.edu.WAA_labs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.WAA_labs.entity.Address;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Person {
    /** ManyToOneUni
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    **/

    //OneToMany uni

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Address> addresses;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Person(String fname, String lname, List<Address> addresses) {
        this.fname = fname;
        this.lname = lname;
        this.addresses = addresses;
    }

    public void addAddress(Address address){
        addresses.add(address);
    }

  //  **/



    /**OneToMany Bi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")//the only place you can drop the 2 uni directional r/n in
    //trying to make bidirectional is in the OneTomany side b/c to drop the r/n s/p we need mapped by
    //mapped by is only exist in oneToMany but ManyToOne does't have mapped by

    private List<Address> addresses;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Person(String fname, String lname, List<Address> addresses) {
        this.fname = fname;
        this.lname = lname;
        this.addresses = addresses;
    }

    public void addAddress(Address address){
        addresses.add(address);
    }
    **/



    /**OneToOne bi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;

   @OneToOne
    private Address address;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Person(String fname, String lname, Address address) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
    }
   **/



    /** OneToMany Bi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Address> addresses;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Person(String fname, String lname, List<Address> addresses) {
        this.fname = fname;
        this.lname = lname;
        this.addresses = addresses;
    }

    public void addAddress(Address address){
        addresses.add(address);
    }
    **/
}