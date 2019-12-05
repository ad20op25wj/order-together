package com.example.ordertogether;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {

    private ArrayList<ChatMessageDTO> arrayList = new ArrayList<>();

    @Override
    public int getCount(){
        return arrayList.size();
    }

    @Override
    public ChatMessageDTO getItem(int position){
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();
        ChatMessageDTO message = arrayList.get(position);
        LayoutInflater inflater;
        TextView name, text;

        if (message.getUserName().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.my_message, parent, false);
            text = convertView.findViewById(R.id.myMessageTextView);
            text.setText(message.getMessage());
        }
        else{
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.others_message, parent, false);
            name = convertView.findViewById(R.id.othersName);
            text = convertView.findViewById(R.id.othersMessageTextView);
            name.setText(message.getUserName());
            text.setText(message.getMessage());
        }
        return convertView;
    }

    public void add(ChatMessageDTO chatMessageDTO){
        arrayList.add(chatMessageDTO);
        notifyDataSetChanged();
    }




}
