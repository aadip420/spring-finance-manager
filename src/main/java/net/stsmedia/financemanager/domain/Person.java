package net.stsmedia.financemanager.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.core.style.ToStringCreator;

/**
 * A JPA entity for the person domain object.
 * 
 * @author Stefan Schmidt
 *
 */
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]+", message="Last name must not be empty!")
	private String lastName;

	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]+", message="First name must not be empty!")
	private String firstName;

	@NotNull
	@Pattern(message="Email invalid", regexp="[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
	private String email;
	
	@Valid
	@NotNull
	@Embedded
	private Address address;
	
	public Person(){
		address = new Address();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	

	public String toString() {
		ToStringCreator tsc = new ToStringCreator(this);
		tsc.append("LastName: " + getLastName());
		tsc.append("FirstName: " + getFirstName());
		tsc.append("Email: " + getEmail());
		tsc.append("Address: " + getAddress());
		return tsc.toString();
	}
}
