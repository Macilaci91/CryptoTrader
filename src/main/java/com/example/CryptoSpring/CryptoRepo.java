package com.example.CryptoSpring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CryptoRepo extends CrudRepository<Crypto,String> {

    Iterable<Crypto> findAll();
    @Query("SELECT c FROM Crypto c WHERE c.name = ?1")
    Crypto selectValue(String cryptoName);
}
