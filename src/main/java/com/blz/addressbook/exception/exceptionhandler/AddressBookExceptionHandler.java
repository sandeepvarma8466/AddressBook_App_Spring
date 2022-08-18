package com.blz.addressbook.exception.exceptionhandler;

import com.blz.addressbook.exception.AddressBookNotFoundException;
import com.blz.addressbook.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AddressBookExceptionHandler {
    @ExceptionHandler(AddressBookNotFoundException.class)
    public ResponseEntity<ResponseUtil> response(AddressBookNotFoundException addressBookNotFoundException){
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setErrorcode(400);
        responseUtil.setMessage(addressBookNotFoundException.getMessage());
        return new ResponseEntity<>(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseUtil> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setErrorcode(400);
        responseUtil.setMessage(e.getMessage());
        return new ResponseEntity<ResponseUtil>(responseUtil, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
