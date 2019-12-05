package com.example.ordertogether;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    private ArrayList<ChatMessageDTO> chatList;
    private ChatAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private String chattingRoom;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();

        chattingRoom = intent.getExtras().getString("roomKey");

        user = FirebaseAuth.getInstance().getCurrentUser();
        chatList = new ArrayList<>();
        adapter = new ChatAdapter();
        ListView listview = findViewById(R.id.chatMessageListView);
        listview.setAdapter(adapter);
        listview.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        Button button = findViewById(R.id.sendButton);
        button.setOnClickListener(new SendMessageButtonListener());


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        databaseReference.child("chat").child(chattingRoom).child("messageList").addChildEventListener(new ReceiveMessage());
    }


    class SendMessageButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view){

            EditText editText = findViewById(R.id.messageToSend);
            String message = editText.getText().toString();

            if (message.equals("")){
                Toast.makeText(getApplicationContext(), "입력된 메시지가 없습니다", Toast.LENGTH_SHORT).show();
            }
            else {
                ChatMessageDTO chat = new ChatMessageDTO(user.getEmail(), message);
                DatabaseReference newPost = databaseReference.child("chat").child(chattingRoom).child("messageList").push();
                newPost.setValue(chat);
                editText.setText("");
            }
        }
    }

    class ReceiveMessage implements ChildEventListener{
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s){
            ChatMessageDTO chat = dataSnapshot.getValue(ChatMessageDTO.class);
            adapter.add(chat);
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s){

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot){

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s){

        }

        @Override
        public void onCancelled(DatabaseError databaseError){

        }
    }
}




