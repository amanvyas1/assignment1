package com.aman.service;

import java.util.List;

import com.aman.dto.EntryDTO;
import com.aman.entity.Entry;
import com.aman.exception.EntryException;

public interface EntryService {
	
	List<EntryDTO> getAllEntrybyCategory(String category) throws EntryException;
	
	List<Entry> getAllEntries() throws EntryException;
	
	Entry saveEntry(Entry entry);

}
