package com.blz.addressbook.controller;

import com.blz.addressbook.dto.AddressBookDTO;
import com.blz.addressbook.model.AddressBookModel;
import com.blz.addressbook.service.IAddressBookService;
import com.blz.addressbook.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    IAddressBookService addressBookService;

    @PostMapping("/addaddress")
    public AddressBookModel addaddress(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.addaddress(addressBookDTO);
    }

    @PutMapping("/updateaddress/{id}")
    public AddressBookModel updateAddress(@PathVariable("id") Long id, @RequestBody AddressBookDTO addressBookDTO,@RequestHeader String token) {
        return addressBookService.updateAddress(id, addressBookDTO, token);
    }

    @GetMapping("/getdata")
    public List<AddressBookModel> getdata(@RequestHeader String token) {
        return addressBookService.getdata(token);
    }

    @DeleteMapping("/delete/{id}")
    public AddressBookModel delete(@PathVariable("id") Long id,@RequestHeader String token) {
        return addressBookService.delete(id,token);
    }

    @PostMapping("/login")
    public ResponseUtil login(@RequestParam String emailId, @RequestParam String password) {
        return addressBookService.login(emailId,password);
    }
}
