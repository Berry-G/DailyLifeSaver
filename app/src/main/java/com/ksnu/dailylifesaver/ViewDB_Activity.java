package com.ksnu.dailylifesaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewDB_Activity extends AppCompatActivity {

    Button button_refresh;
    TextView tv_result;
    Button button_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_db_);     //DB액티비티에서 작동한다.

        final DailyDatabase db = Room.databaseBuilder(this,DailyDatabase.class,"daily-db")
                .allowMainThreadQueries()   //백그라운드 스레드에서
                .build();

        tv_result.setText(db.dailyDao().getAll().toString());

        //새로고침버튼 필요한가?
        button_refresh = findViewById(R.id.button_refresh);
        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //취소 버튼 눌렀을때 동작 입력
//                tv_result.setText(db.dailyDao().getAll().toString());
                Toast.makeText(getApplicationContext(), "새로고침 완료했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        //돌아가기버튼
        button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //취소 버튼 눌렀을때 동작 입력
                Toast.makeText(getApplicationContext(), "되돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();   //액티비티 종료
            }
        });

    }
}