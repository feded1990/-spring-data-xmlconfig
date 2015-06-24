package com.spr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.model.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    List<Shop> findByName(String name);

    @Query(value = "SELECT * FROM shops WHERE name LIKE %:searchTerm%", nativeQuery = true)
    List<Shop> searchByName(@Param("searchTerm") String name);

    List<Shop> findByNameAndEmployeeId(String name, Integer employeeId);
}
