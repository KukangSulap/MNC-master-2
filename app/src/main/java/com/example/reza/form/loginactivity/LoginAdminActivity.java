package com.example.reza.form.loginactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.reza.form.AdminActivity;
import com.example.reza.form.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginAdminActivity extends AppCompatActivity {

    @BindView(R.id.idAdmin)
    EditText idAdmin;
    @BindView(R.id.passAdmin)
    EditText passAdmin;
    @BindView(R.id.btnAdminLogin)
    Button btnAdminLogin;
    String strusername;
    String strpassword;
    public static Context c;
    @BindView(R.id.warning)
    TextView warning;

    Animation animation;
    public void myanimation(TextView edtanimasi){
        animation= AnimationUtils.loadAnimation(c, R.anim.animasigetar);
        edtanimasi.setAnimation(animation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        ButterKnife.bind(this);
        c=LoginAdminActivity.this;

    }

    @OnClick({R.id.idAdmin, R.id.passAdmin, R.id.btnAdminLogin})
    public void onViewClicked(View view) {
        strusername = idAdmin.getText().toString();
        strpassword = passAdmin.getText().toString();

        switch (view.getId()) {
            case R.id.btnAdminLogin:
                if (TextUtils.isEmpty(strusername) && TextUtils.isEmpty(strpassword)) {
                    idAdmin.setError("tidak boleh kosong");
                    passAdmin.setError("tidak boleh kosong");
                } else if (strusername.contentEquals("admin") && strpassword.contentEquals("admin321")) {
                    inten();
                } else {
                warning.setVisibility(View.VISIBLE);
                    warning.requestFocus();
                    myanimation(warning);
                }
                break;
        }
    }

    private void inten() {
        Intent intentq = new Intent(this, AdminActivity.class);
        startActivity(intentq);
    }

}

