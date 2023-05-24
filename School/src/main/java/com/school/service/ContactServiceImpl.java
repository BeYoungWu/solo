package com.school.service;

import java.util.ArrayList;
import java.util.List;

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

	// 문의 등록 (사용자)
	@Override
	public void registerContact(ContactDto contact) {

		ContactEntity ce = contactDtoToEntity(contact);
		contactRepository.save(ce);
		
	}

	// 문의 목록 조회 (관리자)
	@Override
	public List<ContactDto> findAllContact() {

		List<ContactEntity> ces = contactRepository.findAll();
		ArrayList<ContactDto> contacts = new ArrayList<>();
		for (ContactEntity ce : ces) {
			contacts.add(contactEntityToDto(ce));
		}
		
		return contacts;
	}

	// 문의 상세 조회 (관리자)
	@Override
	public ContactDto findByContactNo(int contactNo) {

		ContactEntity ce = contactRepository.findById(contactNo).orElse(null);
		ContactDto contact = contactEntityToDto(ce);
		
		return contact;
	}
	
	// 문의 접수 완료
	@Override
	public void contactCheck(int contactNo) {

		contactRepository.contactCheck(contactNo);
		
	}

	
	
}
