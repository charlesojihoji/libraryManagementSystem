package com.app.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.*;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

}

