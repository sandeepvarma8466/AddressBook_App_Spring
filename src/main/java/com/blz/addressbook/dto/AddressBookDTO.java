package com.blz.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,8}$",message = "firstName is invalid")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,8}$",message = "lastName is invalid")
    private String lastName;
    @NotBlank(message = "address can not empty")
    private String address;
    @NotBlank(message = "city can not empty")
    private String city;
    @NotBlank(message = "state can not empty")
    private String state;
    @NotBlank(message = "phoneNumber can not empty")
    private Long phoneNumber;
    @NotBlank(message = "zipcode can not empty")
    private Long zipCode;
    @NotBlank(message = " mail not empty")
    private String emailId;
    @NotBlank(message = "password can not empty")
    private String password;
}
