package com.example.ordertogether;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordertogether.R;

public class DosirakActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosirak);
    }

    public void btn_dosirak1Clicked (View v){
        Toast.makeText(getApplicationContext(), "도시락 배달 공유방 입니다\n대화방 생성,참가,현재 위치 확인이 가능합니다 ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(DosirakActivity.this, DosirakBoard.class);
        startActivity(intent);
    }
    public void btn_dosirak2Clicked (View v){
        Toast.makeText(getApplicationContext(), "도시락 배달 위치를 찾습니다.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/%EB%8F%84%EC%8B%9C%EB%9D%BD/@35.8897135,128.6109865,15z?hl=ko"));
        startActivity(intent);

    }
    public void btn_dosirak3Clicked (View v) {
        Toast.makeText(getApplicationContext(), "도시락 주문을 진행합니다", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yogiyo.co.kr/mobile/?gclid=EAIaIQobChMIn7WxmbGY5gIVF1pgCh1JoAhPEAAYASAAEgID2vD_BwE#/%EB%8C%80%EA%B5%AC%EA%B4%91%EC%97%AD%EC%8B%9C/701013/%ED%95%9C%EC%8B%9D/"));
        startActivity(intent);
    }


}