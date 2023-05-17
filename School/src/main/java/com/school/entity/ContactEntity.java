package com.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.school.dto.ContactDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_contact")
public class ContactEntity {
	
	public ContactEntity(ContactDto contact) {
		this.contactId = contact.getContactId();
		this.name = contact.getName();
		this.email = contact.getEmail();
		this.title = contact.getTitle();
		this.content = contact.getContent();
	}
	
	public ContactDto exportContactDto() {
		ContactDto contact = new ContactDto();
		contact.setContactId(contactId);
		contact.setName(name);
		contact.setEmail(email);
		contact.setTitle(title);
		contact.setContent(content);
		
		return contact;
	}
	
	@Id
	private int contactId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;
	
}
