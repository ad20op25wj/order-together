package com.example.ordertogether;

public class Board {
    private String id;
    private String title;
    private String contents;
    private String name;
    private String roomKey;

    public Board() {

    }

    public Board(String id, String title, String contents, String name, String roomKey) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.roomKey = roomKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomKey() {
        return roomKey;
    }

    public void setRoomKey(String roomKey) {
        this.roomKey = roomKey;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", name='" + name + '\'' +
                ", roomKey='" + roomKey + '\'' +
                '}';
    }
}
