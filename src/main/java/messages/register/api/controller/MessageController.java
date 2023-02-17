package messages.register.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import messages.register.api.messages.Message;
import messages.register.api.messages.MessageListDTO;
import messages.register.api.messages.MessageRegisterDTO;
import messages.register.api.messages.MessageRepository;

@RestController
@RequestMapping("messages")
@CrossOrigin("http://localhost:4200/")
public class MessageController {

    @Autowired
    private MessageRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid MessageRegisterDTO data) {
        repository.save(new Message(data));
    }

    @GetMapping
    public List<MessageListDTO> list() {
        return repository.findAll().stream().map(MessageListDTO::new).toList();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public List<MessageListDTO> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return repository.findAll().stream().map(MessageListDTO::new).toList();
    }
}