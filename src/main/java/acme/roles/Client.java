
package acme.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client extends AbstractRole {

	// Serialisation identifier ----------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "CLI-[0-9]{4}")
	protected String			identification;

	@NotBlank
	@Length(max = 75)
	protected String			companyName;

	@NotNull
	protected ClientType		clientType;

	@Email
	@NotBlank
	protected String			email;

	@URL
	protected String			link;
}
