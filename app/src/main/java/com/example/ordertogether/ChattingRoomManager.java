package com.example.ordertogether;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ChattingRoomManager {
    private static ChattingRoomManager chattingRoomManager;
    private static FirebaseDatabase database;
    private static DatabaseReference databaseReference;

    public static ChattingRoomManager getInstance(){
        if(chattingRoomManager == null)
        {
            chattingRoomManager = new ChattingRoomManager();
            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference().child("chat");
        }
        return chattingRoomManager;
    }

    public String makeNewChattingRoom() {

        DatabaseReference newRoom = databaseReference.push();
        String roomKey = newRoom.getKey();
        databaseReference.child(roomKey).child("activate").setValue(1);
        return roomKey;
    }

    public void loadChattingRoom(Context context, String roomKey){

        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("roomKey", roomKey);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void shutdownChattingRoom(String roomKey){
        databaseReference.child(roomKey).child("activate").setValue(0);
    }
}
