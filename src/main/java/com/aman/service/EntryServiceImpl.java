package com.aman.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.dto.EntryDTO;
import com.aman.entity.Entry;
import com.aman.exception.EntryException;
import com.aman.repo.EntryRepo;

@Service
public class EntryServiceImpl implements EntryService{
	
	@Autowired
	EntryRepo entryRepo;
	

	@Override
	public List<EntryDTO> getAllEntrybyCategory(String category) throws EntryException {
		List<Entry> allEntry = entryRepo.findByCategory(category);
		if(allEntry.size()==0) throw new EntryException("Category is invalid");
		List<EntryDTO> dtos= new ArrayList<>();
		for(Entry e:allEntry) {
			EntryDTO dto = new EntryDTO();
			dto.setDescription(e.getDescription());
			dto.setId(e.getId());
			dto.setTitle(e.getTitle());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<Entry> getAllEntries() throws EntryException {
		List<Entry> allEntry = entryRepo.findAll();
		if(allEntry.size()==0) throw new EntryException("No entry found");
		return allEntry;
	}

	@Override
	public Entry saveEntry(Entry entry) {
		return entryRepo.save(entry);
	}

}
