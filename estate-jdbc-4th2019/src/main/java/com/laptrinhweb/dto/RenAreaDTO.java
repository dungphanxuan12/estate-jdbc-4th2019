package com.laptrinhweb.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author dungphan
 *
 */
@Getter
@Setter
public class RenAreaDTO extends AbstractDTO<RenAreaDTO> {

	private String value;
	private Long buildingId;
}
