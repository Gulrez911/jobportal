package com.gul.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String languageName;
	String proficiency;
	boolean read;
	boolean write;
	boolean speak;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getProficiency() {
		return proficiency;
	}

	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

	public boolean isSpeak() {
		return speak;
	}

	public void setSpeak(boolean speak) {
		this.speak = speak;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", languageName=" + languageName + ", proficiency=" + proficiency + ", read="
				+ read + ", write=" + write + ", speak=" + speak + "]";
	}
}
