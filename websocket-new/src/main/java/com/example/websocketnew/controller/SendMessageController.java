package com.example.websocketnew.controller;

import com.example.websocketnew.server.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class SendMessageController {


    @GetMapping("/sendMsg/{content}")
    public void sendMsg(@PathVariable("content") String content){
        List<String> list = WebSocketServer.getList();
        list.stream().forEach(sid ->{
            try {
                    System.out.println("sid = " + sid);
                    WebSocketServer.sendInfo("服务端说：" + content, sid);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }


}