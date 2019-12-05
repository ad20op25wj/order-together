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

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void btn_chineseClicked (View v){
            Toast.makeText(getApplicationContext(), "중국요리 주문 화면으로 이동합니다", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, ChineseActivity.class);
            startActivity(intent);
        }
        public void btn_chickenClicked (View v){
            Toast.makeText(getApplicationContext(), "치킨 주문 화면으로 이동합니다", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, ChickenActivity.class);
            startActivity(intent);
        }
        public void btn_pizzaClicked (View v){
            Toast.makeText(getApplicationContext(), "피자 주문 화면으로 이동합니다", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, PizzaActivity.class);
            startActivity(intent);
        }
        public void btn_koreanClicked (View v){
            Toast.makeText(getApplicationContext(), "한식 주문 화면으로 이동합니다", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, KoreanActivity.class);
            startActivity(intent);
        }
        public void btn_dosirakClicked (View v){
            Toast.makeText(getApplicationContext(), "도시락 주문 화면으로 이동합니다", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, DosirakActivity.class);
            startActivity(intent);
        }
        public void btn_godevelopmentClicked (View v){
            Toast.makeText(getApplicationContext(), "홈페이지 화면으로 이동합니다", Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.knu.ac.kr"));
            startActivity(myIntent);
        }


    }
