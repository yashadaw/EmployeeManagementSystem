package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.empdata;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface emprepo extends JpaRepository<empdata, Integer> {

}
