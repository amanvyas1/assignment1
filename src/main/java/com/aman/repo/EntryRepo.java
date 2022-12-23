package com.aman.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aman.entity.Entry;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Integer>{
	
	List<Entry> findByCategory(String category);

}
