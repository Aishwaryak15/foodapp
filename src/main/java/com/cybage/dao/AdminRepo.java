package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.cybage.model.Restaurant;

@Repository
public interface AdminRepo extends JpaRepository<Restaurant, Integer> 
{
}
