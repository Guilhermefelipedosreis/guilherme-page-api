package messages.register.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import messages.register.api.messages.Message;
import messages.register.api.messages.MessageListDTO;
import messages.register.api.messages.MessageRegisterDTO;
import messages.register.api.messages.MessageRepository;

@RestController
@RequestMapping("messages")
public class MessageController {

    @Autowired
    private MessageRepository repository;
    
    @PostMapping
    @Transactional
    public void register(@RequestBody MessageRegisterDTO data) {
        repository.save(new Message(data));        
    }

    @GetMapping
    public Page<MessageListDTO> list(Pageable page) {
        return repository.findAll(page).map(MessageListDTO::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}


