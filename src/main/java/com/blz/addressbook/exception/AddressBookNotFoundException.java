package com.blz.addressbook.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Data
public class AddressBookNotFoundException extends RuntimeException{
    private int statuscode;
    private String message;

    public AddressBookNotFoundException(String message, int statuscode) {
        super(message);
        this.statuscode = statuscode;
        this.message = message;
    }

}
