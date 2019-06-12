package com.example.reza.form.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reza.form.InformasiDetailSurveyArea;
import com.example.reza.form.R;
import com.example.reza.form.TanggalSurveyArea;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.reza.form.loginactivity.Constants.SURVEYOR;
import static com.example.reza.form.loginactivity.Constants.TANGGAL;

public class LoginUserActivity extends AppCompatActivity {

    @BindView(R.id.ETlogin1)
    EditText ETlogin1;
//    @BindView(R.id.ETlogin2)
//    EditText ETlogin2;
    @BindView(R.id.btnuserlogin)
    Button btnuserlogin;
     Bundle bundle;
     String surveyor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user_activity);
        ButterKnife.bind(this);
//        bundle = new Bundle();

    }

    @OnClick(R.id.btnuserlogin)
    public void onViewClicked() {
        if (TextUtils.isEmpty(ETlogin1.getText())) {
        ETlogin1.setError("Harus Diisi");

//        surveyor = ETlogin1.getText().toString();
//        bundle.putString(SURVEYOR, surveyor);

    }else {
        Intent intent9 = new Intent(this, TanggalSurveyArea.class);
//            intent9.putExtras(bundle);
            startActivity(intent9);
        };
    }
}
