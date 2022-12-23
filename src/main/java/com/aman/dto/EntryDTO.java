package com.aman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryDTO {
	
	private Integer id;
	
	private String title;
	
	private String description;

}
