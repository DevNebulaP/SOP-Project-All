package com.example.chat_disro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/chats")
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @PostMapping("/chats")
    public ResponseEntity<?> addChat(@RequestBody MultiValueMap<String, String> formdata) {
        Map<String, String> d = formdata.toSingleValueMap();

        Chat chat = new Chat(d.get("roomId"), new User(d.get("userId"), d.get("username"), d.get("image")), d.get("text"), null);
        System.out.println(chat);
        if (chat.getText() != null && !chat.getText().isEmpty()) {
            // สร้าง timestamp โดยอัตโนมัติที่เป็นปัจจุบัน
            chat.setDateTime(new Date()); // หรือ LocalDateTime.now() ถ้าคุณใช้ Java 8 หรือใหม่กว่า

            Chat addedChat = chatService.addChat(chat); // เพิ่มข้อมูลแชทโดยใช้คำขอ POST
            return new ResponseEntity<>(addedChat, HttpStatus.OK);
        } else {
            // หาก msg เป็นค่าว่างหรือ null ให้ส่งคำตอบผิดพลาดและแจ้งเตือนผู้ใช้
            String responseMessage = "ข้อมูลไม่ถูกต้องหรือไม่ครบถ้วน";
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/room/{roomId}")
    public List<Chat> getChatsByRoom(@PathVariable String roomId) {
        System.out.println("/room/"+roomId);
        return chatService.getChatsByRoom(roomId);
    }
}