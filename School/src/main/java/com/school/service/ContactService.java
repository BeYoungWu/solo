package com.school.service;

import java.util.List;

import com.school.dto.ContactDto;
import com.school.entity.ContactEntity;

public interface ContactService {

	public default ContactDto contactEntityToDto(ContactEntity contactEntity) {
		
		ContactDto contactDto = new ContactDto();
		
		contactDto.setContactNo(contactEntity.getContactNo());
		contactDto.setName(contactEntity.getName());
		contactDto.setEmail(contactEntity.getEmail());
		contactDto.setTitle(contactEntity.getTitle());
		contactDto.setContent(contactEntity.getContent());
		contactDto.setContactDate(contactEntity.getContactDate());
		
		return contactDto;
	}
	
	public default ContactEntity contactDtoToEntity(ContactDto contactDto) {
		
		ContactEntity contactEntity = ContactEntity.builder()
											 .contactNo(contactDto.getContactNo())
											 .name(contactDto.getName())
											 .email(contactDto.getEmail())
											 .title(contactDto.getTitle())
											 .content(contactDto.getContent())
											 .contactDate(contactDto.getContactDate())
											 .build();
		
		return contactEntity;
	}

	// 문의 등록 (사용자)
	public void registerContact(ContactDto contact);

	// 문의 목록 조회 (관리자)
	public List<ContactDto> findAllContact();

	// 문의 상세 조회 (관리자)
	public ContactDto findByContactNo(int contactNo);


}
