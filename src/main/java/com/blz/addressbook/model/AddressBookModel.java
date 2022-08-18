package com.blz.addressbook.model;

import com.blz.addressbook.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AddressBook")
@NoArgsConstructor
public class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private Long phoneNumber;
    private Long zipCode;
    private String emailId;
    private String password;

    public AddressBookModel(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.getFirstName();
        this.lastName= addressBookDTO.getLastName();
        this.address=addressBookDTO.getAddress();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.phoneNumber= addressBookDTO.getPhoneNumber();
        this.zipCode= addressBookDTO.getZipCode();
        this.emailId=addressBookDTO.getEmailId();
        this.password=addressBookDTO.getPassword();

    }
}
