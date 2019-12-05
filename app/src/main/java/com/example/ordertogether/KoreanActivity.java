package com.example.ordertogether;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ordertogether.R;

public class KoreanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korean);
    }

    public void btn_korean1Clicked (View v){
        Toast.makeText(getApplicationContext(), "한식 배달 공유방을 찾습니다 ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(KoreanActivity.this,KoreanShare.class);
        startActivity(intent);
    }
    public void btn_korean2Clicked (View v){
        Toast.makeText(getApplicationContext(), "한식 배달 위치로 이동합니다", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/%ED%95%9C%EC%8B%9D/@35.8897818,128.6109865,15z/data=!3m1!4b1?hl=ko"));
        startActivity(intent);
    }
    public void btn_korean3Clicked (View v) {
        Toast.makeText(getApplicationContext(), "한식 주문을 진행합니다", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yogiyo.co.kr/mobile/?gclid=EAIaIQobChMIn7WxmbGY5gIVF1pgCh1JoAhPEAAYASAAEgID2vD_BwE#/%EB%8C%80%EA%B5%AC%EA%B4%91%EC%97%AD%EC%8B%9C/701013/%ED%95%9C%EC%8B%9D/"));
        startActivity(intent);
    }

}
