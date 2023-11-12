package com.example.chat_disro;

import lombok.Data;

@Data
public class User {
    private String _id;
    private String username;
    private String image;

    public User(String _id, String username, String image) {
        this._id=_id;
        this.username=username;
        this.image=image;
    }
}
