package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {
	
	@Autowired
    private MessageRepository repository;
    
    @Transactional
    public void save(Message message) {
    	repository.save(message);
    }

	public List<Message> getRecentMessages(int n) {
		return repository.findByOrderByIdDesc(PageRequest.of(0, n));
	}

}
