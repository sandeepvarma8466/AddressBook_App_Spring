package com.blz.addressbook.service;

import com.blz.addressbook.dto.AddressBookDTO;
import com.blz.addressbook.exception.AddressBookNotFoundException;
import com.blz.addressbook.model.AddressBookModel;
import com.blz.addressbook.repository.AddressBookRepository;
import com.blz.addressbook.util.ResponseUtil;
import com.blz.addressbook.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    TokenUtil tokenUtil1;

    @Autowired
    MailService mailService;


    @Override
    public AddressBookModel addaddress(AddressBookDTO addressBookDTO) {
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDTO);
        addressBookRepository.save(addressBookModel);
        String body = "Contact added successfully with contact id is " + addressBookModel.getId();
        String suvject = "Contact added Successfully";
        mailService.send(addressBookModel.getEmailId(), body, suvject);
        return addressBookModel;
    }

    @Override
    public AddressBookModel updateAddress(Long id, AddressBookDTO addressBookDTO, String token) {
        Long contactId = tokenUtil1.decodeToken(token);
        Optional<AddressBookModel> datapresent = addressBookRepository.findById(contactId);
        if (datapresent.isPresent()) {
            Optional<AddressBookModel> optional = addressBookRepository.findById(id);
            if (datapresent.isPresent()) {
                datapresent.get().setFirstName(addressBookDTO.getFirstName());
                datapresent.get().setLastName(addressBookDTO.getLastName());
                datapresent.get().setPhoneNumber(addressBookDTO.getPhoneNumber());
                datapresent.get().setAddress(addressBookDTO.getAddress());
                datapresent.get().setCity(addressBookDTO.getCity());
                datapresent.get().setState(addressBookDTO.getState());
                datapresent.get().setZipCode(addressBookDTO.getZipCode());
                datapresent.get().setEmailId(addressBookDTO.getEmailId());
                datapresent.get().setPassword(addressBookDTO.getPassword());
                addressBookRepository.save(datapresent.get());
                String body = "Contact updated successfully with contact id is " + datapresent.get().getId();
                String suvject = "Contact updated Successfully";
                mailService.send(datapresent.get().getEmailId(), body, suvject);
                return datapresent.get();
            }
            throw new AddressBookNotFoundException("AddressBookNotFound", 500);
        }
        throw new AddressBookNotFoundException("AddressBookNotFound", 500);
    }

    @Override
    public List<AddressBookModel> getdata(String token) {
        Long decodeToken = tokenUtil1.decodeToken(token);
        Optional<AddressBookModel> optional = addressBookRepository.findById(decodeToken);
        if (optional.isPresent()) {
            List<AddressBookModel> datapresent = addressBookRepository.findAll();
            if (datapresent.size() > 0) {
                return datapresent;
            }
            throw new AddressBookNotFoundException("AddressBookNotFound", 500);
        }
        throw new AddressBookNotFoundException("AddressBookNotFound", 500);
    }

    @Override
    public AddressBookModel delete(Long id, String token) {
        Long decodeToken = tokenUtil1.decodeToken(token);
        Optional<AddressBookModel> optional1 = addressBookRepository.findById(decodeToken);
        if (optional1.isPresent()) {
            Optional<AddressBookModel> optional = addressBookRepository.findById(id);
            if (optional.isPresent()) {
                addressBookRepository.delete(optional.get());
                String body = "Contact deleted successfully with contact id is " + optional.get().getId();
                String suvject = "Contact deleted Successfully";
                mailService.send(optional.get().getEmailId(), body, suvject);
                return optional.get();
            }
            throw new AddressBookNotFoundException("AddressBookNotFound", 500);
        }
        throw new AddressBookNotFoundException("AddressBookNotFound", 500);
    }

    @Override
    public ResponseUtil login(String emailId, String password) {
        Optional<AddressBookModel> optional = addressBookRepository.findByemailId(emailId);
        if (optional.isPresent()) {
            if (optional.get().getPassword().equals(password)) {
                String token = tokenUtil1.createToken(optional.get().getId());
                return new ResponseUtil(200, "Login successful", token);
            }
            throw new AddressBookNotFoundException("AddressBookNotFound", 500);
        }
        throw new AddressBookNotFoundException("AddressBookNotFound", 500);
    }
}