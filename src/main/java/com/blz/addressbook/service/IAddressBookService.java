package com.blz.addressbook.service;

import com.blz.addressbook.dto.AddressBookDTO;
import com.blz.addressbook.model.AddressBookModel;
import com.blz.addressbook.util.ResponseUtil;

import java.util.List;

public interface IAddressBookService {

    AddressBookModel addaddress(AddressBookDTO addressBookDTO);

    AddressBookModel updateAddress(Long id, AddressBookDTO addressBookDTO, String token);

    List<AddressBookModel> getdata(String token);

    AddressBookModel delete(Long id, String token);

    ResponseUtil login(String emailId, String password);
}
