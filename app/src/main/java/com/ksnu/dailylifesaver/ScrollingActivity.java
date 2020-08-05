package com.ksnu.dailylifesaver;

import android.app.NotificationManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    //오디오매니저 선언
    private AudioManager mAudioManager;

    //버튼 3개 선언
    Button btn_normal;
    Button btn_vibe;
    Button btn_silent;
    Button btn_v_db;

    //DB선언

    SQLiteDatabase database;
    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        //툴바 잡아주기
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //무음모드에 필요한 권한 요청
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(!notificationManager.isNotificationPolicyAccessGranted())
        {
            startActivity(new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS));
        }

        //데이터베이스 생성
//        final DailyDatabase db = Room.databaseBuilder(this,DailyDatabase.class,"daily-db")
//                .allowMainThreadQueries()   //백그라운드 스레드에서
//                .build();


        //플로팅액션버튼(추가버튼) 구현
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "추가버튼을 눌렀습니다.", Snackbar.LENGTH_SHORT)
                      .setAction("Action", null).show();
                Intent intent = new Intent(ScrollingActivity.this, AddActivity.class);
                startActivity(intent);                                                                //액티비티 이동
            }
        });

        //오디오 매니저
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        //버튼 동작
        //벨소리
        btn_normal = findViewById(R.id.btn_normal);
        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼눌렀을때 동작
                mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(getApplicationContext(), "벨소리 모드 변경", Toast.LENGTH_LONG).show();
            }
        });
        //진동
        btn_vibe = findViewById(R.id.btn_vibe);
        btn_vibe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼눌렀을때 동작
                mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(getApplicationContext(), "진동 모드 변경", Toast.LENGTH_LONG).show();
            }
        });
        //무음
        btn_silent = findViewById(R.id.btn_silent);
        btn_silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼눌렀을때 동작
                mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(getApplicationContext(), "무음 모드 변경", Toast.LENGTH_LONG).show();
            }
        });

        //데이터베이스 액티비티로 이동
        btn_v_db = findViewById(R.id.btn_v_db);
        btn_v_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼눌렀을때 동작
                Intent intent = new Intent(ScrollingActivity.this, ViewDB_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void createDatabase(String name)
    {
        //////////////////////////////////////////////////////////////////////////////////////////
    }

    //꾹 눌렀을 때 나오는 메뉴(컨텍스트 메뉴) 만들기
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_edit:
                //편집 동작설정
                return true;
            case R.id.menu_delete:
                //삭제 동작설정
                return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 액션바의 item 클릭을 제어.
        // 액션바는 AndroidManifest.xml에서 부모 액티비티를 지정해주는 한 Home / Up 버튼의 클릭을 자동으로 제어함.
        int id = item.getItemId();

        //각 아이템을 눌렀을때 동작을 설정

        //세팅 버튼을 눌렀을 때
        if (id == R.id.action_settings) {
            return true;
        }

        //종료 버튼을 눌렀을 때
        if(id==R.id.action_close)
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
