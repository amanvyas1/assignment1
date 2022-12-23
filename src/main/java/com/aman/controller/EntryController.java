package com.aman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.dto.EntryDTO;
import com.aman.entity.Entry;
import com.aman.exception.EntryException;
import com.aman.service.EntryService;

@RestController
public class EntryController {
	
	@Autowired
	EntryService entryService;
	
	@GetMapping("/entries/{category}")
    public ResponseEntity<List<EntryDTO>> getAllEntrybyCategory(@PathVariable("category") String category) throws EntryException{
    	List<EntryDTO> entrydtos = entryService.getAllEntrybyCategory(category);
    	return new ResponseEntity<List<EntryDTO>>(entrydtos, HttpStatus.OK);
    }
	
	@GetMapping("/entries")
	public ResponseEntity<List<Entry>> getAllEntries() throws EntryException{
		List<Entry> entries = entryService.getAllEntries();
		return new ResponseEntity<List<Entry>>(entries, HttpStatus.OK);
	}
	
	@PostMapping("/entry")
	public ResponseEntity<Entry> saveEntry(Entry entry){
		Entry saved = entryService.saveEntry(entry);
		return new ResponseEntity<Entry>(saved, HttpStatus.CREATED);
	}

}
