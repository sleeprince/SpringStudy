package com.java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Test {
	
	@Id
	private int no;
	
	private boolean del;
}
