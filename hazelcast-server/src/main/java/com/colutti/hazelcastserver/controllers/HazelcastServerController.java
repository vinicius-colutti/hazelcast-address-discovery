package com.colutti.hazelcastserver.controllers;

import com.colutti.hazelcastserver.dto.MessageDTO;
import com.colutti.hazelcastserver.services.HazelcastServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class HazelcastServerController {

    @Autowired
    private HazelcastServerService hazelcastServerService;

    @PostMapping
    public String publishMessageOnTopic(@RequestBody MessageDTO messageDTO){
        hazelcastServerService.publishMessageOnTopic(messageDTO.getMessage());
        return "Published!";
    }

}
