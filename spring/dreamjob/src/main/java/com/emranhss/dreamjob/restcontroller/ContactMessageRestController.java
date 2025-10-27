package com.emranhss.dreamjob.restcontroller;

import com.emranhss.dreamjob.entity.ContactMessage;
import com.emranhss.dreamjob.service.ContactMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact/")
public class ContactMessageRestController {

    private final ContactMessageService contactMessageService;


    public ContactMessageRestController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping("")
    public ContactMessage receiveMessage(@RequestBody ContactMessage msg) {
        return contactMessageService.saveMessage(msg);
    }

    @GetMapping("")
    public List<ContactMessage> getAllMessages() {
        return contactMessageService.getAllMessages();
    }

}
