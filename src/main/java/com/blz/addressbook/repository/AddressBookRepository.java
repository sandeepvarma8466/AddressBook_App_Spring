package com.blz.addressbook.repository;

import com.blz.addressbook.model.AddressBookModel;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AddressBookRepository extends JpaRepository<AddressBookModel,Long>  {
    Optional<AddressBookModel> findByemailId(String emailId);
}
