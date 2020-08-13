package com.laptrinhweb.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author dungphan
 *
 */
@Getter
@Setter
public class UserDTO extends AbstractDTO<UserDTO> {

	@NotNull(message = "Username cannot be null")
	private String userName;

	@NotNull(message = "FullName cannot be null")
	private String fullName;

	@NotNull(message = "Password cannot be null")
	private String password;

	@NotNull(message = "Status cannot be null")
	private int status;

	@NotNull(message = "RoleId cannot be null")
	private Long roleId;

	@Email(message = "Email should be valid")
	private String email;
}
