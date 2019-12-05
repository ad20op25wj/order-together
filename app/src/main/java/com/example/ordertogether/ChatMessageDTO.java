package com.example.ordertogether;

// 출처 : https://mailmail.tistory.com/44
public class ChatMessageDTO {

    private String userName;
    private String message;

    public ChatMessageDTO(){}
    public ChatMessageDTO(String userName, String message){
        this.userName = userName;
        this.message = message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }
}
