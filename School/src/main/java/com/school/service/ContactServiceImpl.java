package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.dto.ContactDto;
import com.school.entity.ContactEntity;
import com.school.repository.ContactRepository;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	// 문의 등록하기 (사용자)
	@Override
	public void registerContact(ContactDto contact) {

		ContactEntity ce = contactDtoToEntity(contact);
		contactRepository.save(ce);
		
	}

	
	
}
