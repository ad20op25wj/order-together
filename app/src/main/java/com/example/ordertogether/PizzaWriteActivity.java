package com.example.ordertogether;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PizzaWriteActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    private EditText mWriteTitleText;
    private EditText mWriteContentsText;
    private EditText mWriteNameText;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mWriteTitleText = findViewById(R.id.write_title_text);
        mWriteContentsText = findViewById(R.id.write_contents_text);
        mWriteNameText = findViewById(R.id.write_name_text);

        findViewById(R.id.write_upload_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        id = mStore.collection("pizzaboard").document().getId();

        ChattingRoomManager manager = ChattingRoomManager.getInstance();
        String roomKey = manager.makeNewChattingRoom();

        Map<String, Object> post = new HashMap<>();
        post.put("id",id);
        post.put("title",mWriteTitleText.getText().toString());
        post.put("contents",mWriteContentsText.getText().toString());
        post.put("name", mWriteNameText.getText().toString());
        post.put("roomkey", roomKey);

        mStore.collection("pizzaboard").document(id).set(post)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(PizzaWriteActivity.this, "업로드 성공!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PizzaWriteActivity.this, "업로드 실패!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
