package com.example.reza.form.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.reza.form.R;
import com.example.reza.form.TanggalSurveyArea;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.adminBTN)
    Button adminBTN;
    @BindView(R.id.userBTN)
    Button userBTN;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.adminBTN, R.id.userBTN})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.adminBTN:
                Intent intent = new Intent(this, LoginAdminActivity.class);
                        startActivity(intent);
                break;
            case R.id.userBTN:
                Intent intent1 = new Intent(this, TanggalSurveyArea.class);
                startActivity(intent1);
                break;
        }
    }
}
