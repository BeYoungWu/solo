package com.school.service;

import com.school.dto.ContactDto;
import com.school.entity.ContactEntity;

public interface ContactService {

	public default ContactDto contactEntityToDto(ContactEntity contactEntity) {
		
		ContactDto contactDto = new ContactDto();
		
		contactDto.setContactId(contactEntity.getContactId());
		contactDto.setName(contactEntity.getName());
		contactDto.setEmail(contactEntity.getEmail());
		contactDto.setTitle(contactEntity.getTitle());
		contactDto.setContent(contactEntity.getContent());
		
		return contactDto;
	}
	
	public default ContactEntity contactDtoToEntity(ContactDto contactDto) {
		
		ContactEntity contactEntity = ContactEntity.builder()
											 .contactId(contactDto.getContactId())
											 .name(contactDto.getName())
											 .email(contactDto.getEmail())
											 .title(contactDto.getTitle())
											 .content(contactDto.getContent())
											 .build();
		
		return contactEntity;
	}

	// 문의 등록하기 (사용자)
	public void registerContact(ContactDto contact);


}
