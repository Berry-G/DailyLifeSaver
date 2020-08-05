package com.ksnu.dailylifesaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    TimePicker timePicker1_s;
    TimePicker timePicker2_e;

    Button btn_save;
    Button btn_cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);  //추가 액티비티에서 작동하겠다.

        //timepicker 객체 생성
        timePicker1_s = (TimePicker) findViewById(R.id.timePicker1_s);
        timePicker2_e = (TimePicker) findViewById(R.id.timePicker2_e);

        //데이터베이스 생성성
       DailyDatabase db = Room.databaseBuilder(this, DailyDatabase.class, "daily-db")
                .allowMainThreadQueries()
                .build();

//        db.dailyDao().getAll().toString()
        //유투브 기준 12분 24초  https://www.youtube.com/watch?v=pG6OkJ3rSjg

        //시간 받아오기 : getHour()
        //분 받아오기 : getMinute();

        //저장 버튼 동작
        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //저장 버튼 눌렀을때 동작 입력
                Toast.makeText(getApplicationContext(), "저장버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
                //제목 입력란 내용 받아오기
                EditText editTitle = (EditText) findViewById(R.id.editTitle);
                String id = editTitle.getText().toString();

//추가                db.dailyDao().insert(new DailyData(editTitle.getText().toString()));

                finish();   //액티비티 종료
            }
        });
        //취소 버튼 동작
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //취소 버튼 눌렀을때 동작 입력
                Toast.makeText(getApplicationContext(), "취소버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
                finish();   //액티비티 종료
            }
        });


    }

}
