package com.blz.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "firstName is invalid")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "lastName is invalid")
    private String lastName;
    @NotBlank(message = "address can not empty")
    private String address;
    @NotBlank(message = "city can not empty")
    private String city;
    @NotBlank(message = "state can not empty")
    private String state;
    @NotBlank(message = "phoneNumber can not empty")
    @Pattern(regexp = "^[1-9]{2}\\s{1}[1-9]{1}[0-9]{9}$",message = "Invalid phonenumber")
    private Long phoneNumber;
    @NotBlank(message = "zipcode can not empty")
    @Pattern(regexp = "^[0-9]{1}[0-9]{5}$",message = "Invalid zipcode")
    private Long zipCode;
    @NotBlank(message = " mail not empty")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid EmailId")
    private String emailId;
    @NotBlank(message = "password can not empty")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%!]).{8,}$", message = "Invalid Password")
    private String password;
}
