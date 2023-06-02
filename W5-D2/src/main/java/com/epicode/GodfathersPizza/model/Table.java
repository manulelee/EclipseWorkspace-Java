package com.epicode.GodfathersPizza.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Table {
	
	private int id;
	private int numeroMax;
	private boolean disponibile;
}
