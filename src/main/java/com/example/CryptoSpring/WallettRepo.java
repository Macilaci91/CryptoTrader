package com.example.CryptoSpring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WallettRepo extends CrudRepository<Wallett,String> {

    Iterable<Wallett> findAll();
    @Query("SELECT w FROM Wallett w WHERE w.name = ?1")
    Wallett selectAmount(String cryptoName);
    @Query("SELECT w FROM Wallett w WHERE w.name = ?1")
    Wallett selectName(String cryptoName);
    @Query("SELECT COUNT(w) FROM Wallett w WHERE w.name = ?1")
    int countName(String cryptoName);

}
