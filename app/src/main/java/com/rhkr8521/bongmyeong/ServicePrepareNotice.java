package com.rhkr8521.bongmyeong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ServicePrepareNotice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviceprepare);

        Toast toast = Toast.makeText(this, "서비스 준비중입니다, 오픈되면 Push 알림 메세지가 발신됩니다.", Toast.LENGTH_LONG );
        toast.show();

        }
}