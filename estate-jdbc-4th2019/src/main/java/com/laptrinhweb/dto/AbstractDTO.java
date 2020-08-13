package com.laptrinhweb.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author dungp
 *
 * @param <T>
 */
@Getter
@Setter
public class AbstractDTO<T> {

	@NotNull(message = "id cannot be null")
	private Long id;

	private String createdBy;
	private String modifiedBy;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private int maxPageItem;
	private int page;
	private int totalItem = 0;
	private int totalPage = 0;
	private String action;
	List<T> listResults = new ArrayList<T>();
	private Long[] ids;

}
