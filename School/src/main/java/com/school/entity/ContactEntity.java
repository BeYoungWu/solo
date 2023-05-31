package com.school.entity;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.school.dto.ContactDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity(name = "tbl_contact")
@Table(name = "tbl_contact")
public class ContactEntity {
	
	public ContactEntity(ContactDto contact) {
		this.contactNo = contact.getContactNo();
		this.name = contact.getName();
		this.email = contact.getEmail();
		this.title = contact.getTitle();
		this.content = contact.getContent();
		this.checked = contact.getChecked();
	}
	
	public ContactDto exportContactDto() {
		ContactDto contact = new ContactDto();
		contact.setContactNo(contactNo);
		contact.setName(name);
		contact.setEmail(email);
		contact.setTitle(title);
		contact.setContent(content);
		contact.setChecked(checked);
		
		return contact;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactNo;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp contactDate;
	
	@Column
	private int checked;
	
	@PrePersist
    public void onInsert() {
		contactDate = Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant());
    }
	
}
