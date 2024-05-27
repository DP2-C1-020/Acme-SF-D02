
package acme.entities.progress_logs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.data.AbstractEntity;
import acme.entities.contracts.Contract;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProgressLog extends AbstractEntity {

	// Serialisation identifier ----------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "PG-[A-Z]{1,2}-[0-9]{4}", message = "{validation.ProgressLogRecord}")
	protected String			recordId;

	@DecimalMin(value = "0", inclusive = true, message = "{validation.Progresscompleteness}")
	@DecimalMax(value = "100", message = "{validation.Progresscompleteness}")
	@Digits(integer = 3, fraction = 2, message = "{validation.Progresscompleteness}")
	protected double			completeness;

	@NotBlank
	@Length(max = 100)
	protected String			comment;

	@PastOrPresent
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date				registrationMoment;

	@NotBlank
	@Length(max = 75)
	protected String			responsiblePerson;

	protected boolean			draftMode;

	// Relationships ----------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Contract			contract;

}
