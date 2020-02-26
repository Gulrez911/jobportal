package com.gul.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class PersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String permanentAddress;
	String gender;
	String maritalStatus;
	String hometown;
	String category;
	String defferentlyAbled;
	Date dob;
	@OneToMany
	List<Language> languages = new ArrayList<Language>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDefferentlyAbled() {
		return defferentlyAbled;
	}

	public void setDefferentlyAbled(String defferentlyAbled) {
		this.defferentlyAbled = defferentlyAbled;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "PersonalDetails [id=" + id + ", permanentAddress=" + permanentAddress + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + ", hometown=" + hometown + ", category=" + category
				+ ", defferentlyAbled=" + defferentlyAbled + ", dob=" + dob + ", languages=" + languages + "]";
	}

}
