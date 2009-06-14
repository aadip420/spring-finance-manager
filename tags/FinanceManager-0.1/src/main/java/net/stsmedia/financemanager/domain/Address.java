package net.stsmedia.financemanager.domain;

import javax.persistence.Embeddable;

import org.hibernate.validator.NotNull;
import org.springframework.core.style.ToStringCreator;
import org.springframework.util.Assert;

/**
 * An example for an JPA embeddable class. Ideally this class should be
 * treated as a value object as documented in Evan's book p. 97
 * 
 * @author Stefan Schmidt
 *
 */
@Embeddable
public class Address {

	@NotNull
	private String streetName;
	
	@NotNull
	private String streetNumber;
	
	@NotNull
	private String city;
	
	@NotNull
	private String zipCode;
	
	private String state;
	
	private String country;
	
	//this object should be treated as VO and therefore this constructor is just to be 
	//used by the ORM
	protected Address(){}
	
	public Address(String streetName, String streetNumber, String city, String zipCode) {
		Assert.hasText(streetName, "Street name required.");
		Assert.hasText(streetNumber, "Street number required.");
		Assert.hasText(city, "City required.");
		Assert.hasText(zipCode, "Zip code required.");
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}

	public Address(String streetName, String streetNumber, String city, String zipCode, String state, String country) {
		Assert.hasText(streetName, "Street name required.");
		Assert.hasText(streetNumber, "Street number required.");
		Assert.hasText(city, "City required.");
		Assert.hasText(zipCode, "Zip code required.");
		Assert.hasText(state, "State required.");
		Assert.hasText(country, "Country required.");
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getCity() {
		return city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}	
	
	public String toString() {
		ToStringCreator tsc = new ToStringCreator(this);
		tsc.append("Street Name: " + getStreetName());
		tsc.append("Street Number: ", getStreetNumber());
		tsc.append("City: ", getCity());
		tsc.append("Zip Code: ", getZipCode());
		if(getState()!=null)
			tsc.append("State: ", getState());
		if(getCountry()!=null)
			tsc.append("Country: ", getCountry());
		return tsc.toString();
	}
}