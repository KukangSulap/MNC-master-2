package com.example.reza.form;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.reza.form.loginactivity.Constants.AKSESPENJUALAN;
import static com.example.reza.form.loginactivity.Constants.DEVELOPER;
import static com.example.reza.form.loginactivity.Constants.JENISPROPERTI;
import static com.example.reza.form.loginactivity.Constants.KABKOTA;
import static com.example.reza.form.loginactivity.Constants.KECEMATAN;
import static com.example.reza.form.loginactivity.Constants.KELURAHAN;
import static com.example.reza.form.loginactivity.Constants.KLASIFIKASITIPERUMAH;
import static com.example.reza.form.loginactivity.Constants.KOMPETITOR;
import static com.example.reza.form.loginactivity.Constants.KOMPLEKS;
import static com.example.reza.form.loginactivity.Constants.MAYORITASKENDARAAN;
import static com.example.reza.form.loginactivity.Constants.MAYORITASPROVIDER;
import static com.example.reza.form.loginactivity.Constants.METODEPEMBANGUNAN;
import static com.example.reza.form.loginactivity.Constants.RATA2BIAYA;
import static com.example.reza.form.loginactivity.Constants.REGION;
import static com.example.reza.form.loginactivity.Constants.SURVEYOR;
import static com.example.reza.form.loginactivity.Constants.TANGGAL;

public class InformasiDetailSurveyArea extends AppCompatActivity {

    //TODO CHECKBOX GROUP
    CheckBox CBAjenisPro, CBBjenisPro, CBCjenisPro,
            CBAklartipe, CBBklartipe, CBCklartipe, CBDklartipe, CBEklartipe, CBFklartipe,
            CBAMetod, CBBMetod, CBCMetod, CBDMetod,
            CBAAkses, CBBAkses, CBCAkses, CBDAkses,
            CBAKom, CBBKom, CBCKom, CBDKom, CBEKom, CBFKom,
            CBAPro, CBBPro, CBCPro, CBDPro, CBEPro, CBFPro;

    //TODO BUTTON GROUP
    Button btnNDS, btnBDS;

    //TODO STRING GROUP
    String s_cbajenispro, s_cbbjenispro, s_cbcjenispro,
            s_aklartipe, s_bklartipe, s_cklartipe, s_dklartipe, s_eklartipe, s_fklartipe,
            s_cbametode, s_cbbmetode, s_cbcmetode, s_cbdmetode,
            s_cbaakses, s_cbbakses, s_cbcakses, s_cbdakses,
            s_cbakom, s_cbbkom, s_cbckom, s_cbdkom, s_cbekom, s_cbfkom,
            s_cbapro, s_cbbpro, s_cbcpro, s_cbdpro, s_cbepro, s_cbfpro, s_metode;

    @BindView(R.id.edKlarifikasiA)
    EditText edKlarifikasiA;
    @BindView(R.id.edKlarifikasiB)
    EditText edKlarifikasiB;
    @BindView(R.id.edKlarifikasiC)
    EditText edKlarifikasiC;
    @BindView(R.id.edKlarifikasiD)
    EditText edKlarifikasiD;
    @BindView(R.id.edKlarifikasiSoho)
    EditText edKlarifikasiSoho;
    @BindView(R.id.edKlarifikasiKos)
    EditText edKlarifikasiKos;
    @BindView(R.id.edMetode)
    EditText edMetode;
    @BindView(R.id.rbMobilMotor)
    RadioButton rbMobilMotor;
    @BindView(R.id.rbMotor)
    RadioButton rbMotor;
    @BindView(R.id.edRata2BiayaInternet)
    EditText edRata2BiayaInternet;
    @BindView(R.id.btnNextDetailSurvey)
    Button btnNextDetailSurvey;
    @BindView(R.id.scrollKab)
    ScrollView scrollKab;
    @BindView(R.id.etMayoritasKendaraan)
    TextView etMayoritasKendaraan;
    @BindView(R.id.etMetodePembangunan)
    TextView etMetodePembangunan;
    @BindView(R.id.etMayoritasProvider)
    TextView etMayoritasProvider;
    RadioGroup Radiogroup;
    RadioButton radioButton;
    ArrayList<CheckBox> listJenisProperti = new ArrayList<>();
    ArrayList<CheckBox> listMetodePembangunan = new ArrayList<>();
    ArrayList<EditText> listMetodePembangunan1 = new ArrayList<>();
    ArrayList<CheckBox> listAksesPenjualan = new ArrayList<>();
    ArrayList<EditText> listAksesPenjualan1 = new ArrayList<>();
    ArrayList<CheckBox> listKompetitor = new ArrayList<>();
    ArrayList<EditText> listKompetitor1 = new ArrayList<>();
    ArrayList<CheckBox> listMayoritasProvider = new ArrayList<>();
    ArrayList<EditText> listMayoritasProvider1 = new ArrayList<>();
    ArrayList<EditText> listKlasiTipeRumah = new ArrayList<>();

    String nilaiDataJenisProperti;
    String nilaiDataKlasifikasiTiperRumah;
    String nilaiDataMetodePembangunan;
    String nilaiDataMetodePembangunan1;
    String nilaiDataAksesPenjualan;
    String nilaiDataAksesPenjualan1;
    String nilaiKompetitor;
    String nilaiKompetitor1;
    String nilaiMayoritasProvider;
    String nilaiMayoritasProvider1;
    String nilaiMayoritasKendaraan;
    String rata2_biaya;
    @BindView(R.id.edAkses)
    EditText edAkses;
    @BindView(R.id.edkompetitor)
    EditText edkompetitor;
    @BindView(R.id.edMayoritas)
    EditText edMayoritas;
    private String strMayoritasKendaraan;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_detail_survey_area);
        ButterKnife.bind(this);

//        Gson gson = new Gson();
//        String arrayData = gson.toJson(listMetodePembangunan);
//        String arrayData1 = gson.toJson(listMetodePembangunan1);


        //TODO RADIO GROUP
        Radiogroup = findViewById(R.id.Radiogroup1);

        //TODO CHECKBOX JENIS PROPERTI
        CBAjenisPro = findViewById(R.id.cbAjenisPro);
        CBBjenisPro = findViewById(R.id.cbBjenisPro);
        CBCjenisPro = findViewById(R.id.cbCjenisPro);

        //TODO KLARIFIKASI TIPE
        CBAklartipe = findViewById(R.id.cbAKlarifikasiTipe);
        CBBklartipe = findViewById(R.id.cbBKlarifikasiTipe);
        CBCklartipe = findViewById(R.id.cbCKlarifikasiTipe);
        CBDklartipe = findViewById(R.id.cbDKlarifikasiTipe);
        CBEklartipe = findViewById(R.id.cbEKlarifikasiTipe);
        CBFklartipe = findViewById(R.id.cbFKlarifikasiTipe);

        //TODO METODE PEMBANGUNAN
        CBAMetod = findViewById(R.id.cbAMetode);
        CBBMetod = findViewById(R.id.cbBMetode);
        CBCMetod = findViewById(R.id.cbCMetode);
        CBDMetod = findViewById(R.id.cbDMetode);

        //TODO AKSES PENJUALAN
        CBAAkses = findViewById(R.id.cbAAkses);
        CBBAkses = findViewById(R.id.cbBAkses);
        CBCAkses = findViewById(R.id.cbCAkses);
        CBDAkses = findViewById(R.id.cbDAkses);

        //TODO KOMPETITOR
        CBAKom = findViewById(R.id.cbAkompetitor);
        CBBKom = findViewById(R.id.cbBkompetitor);
        CBCKom = findViewById(R.id.cbCkompetitor);
        CBDKom = findViewById(R.id.cbDkompetitor);
        CBEKom = findViewById(R.id.cbEkompetitor);
        CBFKom = findViewById(R.id.cbFKompetitor);

        //TODO MAYORITAS PROVIDER
        CBAPro = findViewById(R.id.cbAMayoritas);
        CBBPro = findViewById(R.id.cbBMayoritas);
        CBCPro = findViewById(R.id.cbCMayoritas);
        CBDPro = findViewById(R.id.cbDMayoritas);
        CBEPro = findViewById(R.id.cbEMayoritas);
        CBFPro = findViewById(R.id.cbFMayoritas);

        //TODO BUTTON
        btnNDS = findViewById(R.id.btnNextDetailSurvey);

        //setdata listJenisProperti
        listJenisProperti.add(CBAjenisPro);
        listJenisProperti.add(CBBjenisPro);
        listJenisProperti.add(CBCjenisPro);

        //setdata listKlasiTipeRumah
        listKlasiTipeRumah.add(edKlarifikasiA);
        listKlasiTipeRumah.add(edKlarifikasiB);
        listKlasiTipeRumah.add(edKlarifikasiC);
        listKlasiTipeRumah.add(edKlarifikasiD);
        listKlasiTipeRumah.add(edKlarifikasiSoho);
        listKlasiTipeRumah.add(edKlarifikasiKos);

        //setdata listMetodePembangunan
        listMetodePembangunan.add(CBAMetod);
        listMetodePembangunan.add(CBBMetod);
        listMetodePembangunan.add(CBCMetod);
        listMetodePembangunan1.add(edMetode);

        //setdata listAksesPenjualan
        listAksesPenjualan.add(CBAAkses);
        listAksesPenjualan.add(CBBAkses);
        listAksesPenjualan.add(CBCAkses);
        listAksesPenjualan1.add(edAkses);

        //setdata listKompetitor
        listKompetitor.add(CBAKom);
        listKompetitor.add(CBBKom);
        listKompetitor.add(CBCKom);
        listKompetitor.add(CBDKom);
        listKompetitor.add(CBEKom);
        listKompetitor1.add(edkompetitor);

        //setdata listMayoritasProvider
        listMayoritasProvider.add(CBAPro);
        listMayoritasProvider.add(CBBPro);
        listMayoritasProvider.add(CBCPro);
        listMayoritasProvider.add(CBDPro);
        listMayoritasProvider.add(CBEPro);
        listMayoritasProvider1.add(edMayoritas);

        //TODO STRING JENIS PROPERTI
        s_cbajenispro = "";
        s_cbbjenispro = "";
        s_cbcjenispro = "";

        //TODO STRING KLARIFIKASI TIPE
        s_aklartipe = "";
        s_bklartipe = "";
        s_cklartipe = "";
        s_dklartipe = "";
        s_eklartipe = "";
        s_fklartipe = "";

        //TODO STRING METODE PEMBANGUNAN
        s_cbametode = "";
        s_cbbmetode = "";
        s_cbcmetode = "";
        s_cbdmetode = "";

        //TODO STRING AKSES PENJUALAN
        s_cbaakses = "";
        s_cbbakses = "";
        s_cbcakses = "";
        s_cbdakses = "";

        //TODO STRING KOMPETITOR
        s_cbakom = "";
        s_cbbkom = "";
        s_cbckom = "";
        s_cbdkom = "";
        s_cbekom = "";
        s_cbfkom = "";

        //TODO STRING MAYORITAS PROVIDER
        s_cbapro = "";
        s_cbbpro = "";
        s_cbcpro = "";
        s_cbdpro = "";
        s_cbepro = "";
        s_cbfpro = "";

        //TODO CHECKBOX JENIS PROPERTI
        if (CBAjenisPro.isChecked()) {
            s_cbajenispro = CBAjenisPro.getText().toString();
        } else {
            s_cbajenispro = "";
        }

        if (CBBjenisPro.isChecked()) {
            s_cbbjenispro = CBBjenisPro.getText().toString();
        } else {
            s_cbbjenispro = "";
        }

        if (CBCjenisPro.isChecked()) {
            s_cbcjenispro = CBCjenisPro.getText().toString();
        } else {
            s_cbcjenispro = "";
        }

        List<CheckBox> items = new ArrayList<>();
        for (CheckBox item : items) {
            if (item.isChecked()) {
                String text = item.getText().toString();
            }
        }

        //TODO CHECKBOX KLASIFIKASI TIPE
        if (CBAklartipe.isChecked()) {
            edKlarifikasiA.setEnabled(true);
            s_aklartipe = "A" +edKlarifikasiA.getText().toString();
        } else {
            s_aklartipe = "";
        }

        CBAklartipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBAklartipe.isChecked()) {
                    edKlarifikasiA.setVisibility(View.VISIBLE);
                } else {
                    edKlarifikasiA.setVisibility(View.INVISIBLE);
                }
            }
        });

        if (CBBklartipe.isChecked()) {
            edKlarifikasiB.setEnabled(true);
            s_bklartipe = CBBklartipe.getText().toString();
        } else {
            s_bklartipe = "";
        }

        CBBklartipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBBklartipe.isChecked()) {
                    edKlarifikasiB.setVisibility(View.VISIBLE);
                } else {
                    edKlarifikasiB.setVisibility(View.INVISIBLE);
                }
            }
        });

        if (CBCklartipe.isChecked()) {
            edKlarifikasiC.setEnabled(true);
            s_cklartipe = CBCklartipe.getText().toString();
        } else {
            s_cklartipe = "";
        }

        CBCklartipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBCklartipe.isChecked()) {
                    edKlarifikasiC.setVisibility(View.VISIBLE);
                } else {
                    edKlarifikasiC.setVisibility(View.INVISIBLE);
                }
            }
        });

        if (CBDklartipe.isChecked()) {
            edKlarifikasiD.setEnabled(true);
            s_dklartipe = CBDklartipe.getText().toString();
        } else {
            s_dklartipe = "";
        }

        CBDklartipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBDklartipe.isChecked()) {
                    edKlarifikasiD.setVisibility(View.VISIBLE);
                } else {
                    edKlarifikasiD.setVisibility(View.INVISIBLE);
                }
            }
        });

        if (CBEklartipe.isChecked()) {
            edKlarifikasiSoho.setEnabled(true);
            s_eklartipe = CBEklartipe.getText().toString();
        } else {
            s_eklartipe = "";
        }

        CBEklartipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBEklartipe.isChecked()) {
                    edKlarifikasiSoho.setVisibility(View.VISIBLE);
                } else {
                    edKlarifikasiSoho.setVisibility(View.INVISIBLE);
                }
            }
        });

        if (CBFklartipe.isChecked()) {
            edKlarifikasiKos.setEnabled(true);
            s_fklartipe = CBFklartipe.getText().toString();
        } else {
            s_fklartipe = "";
        }

        CBFklartipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBFklartipe.isChecked()) {
                    edKlarifikasiKos.setVisibility(View.VISIBLE);
                } else {
                    edKlarifikasiKos.setVisibility(View.INVISIBLE);
                }
            }
        });

        //TODO CHECKBOX METODE PEMBANGUNAN
        if (CBAMetod.isChecked()) {
            s_cbametode = CBAMetod.getText().toString();
        } else {
            s_cbametode = "";
        }

        if (CBBMetod.isChecked()) {
            s_cbbmetode = CBBMetod.getText().toString();
        } else {
            s_cbbmetode = "";
        }

        if (CBCMetod.isChecked()) {
            s_cbcmetode = CBCMetod.getText().toString();
        } else {
            s_cbcmetode = "";
        }

        if (CBDMetod.isChecked()) {
            edMetode.setEnabled(true);
            s_cbdmetode = edMetode.getText().toString();
        } else {
            s_cbdmetode = "";
        }

        CBDMetod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBDMetod.isChecked()) {
                    edMetode.setVisibility(View.VISIBLE);
                } else {
                    edMetode.setVisibility(View.INVISIBLE);
                }
            }
        });


        List<CheckBox> items2 = new ArrayList<>();
        for (CheckBox item2 : items2) {
            if (item2.isChecked()) {
                String text = item2.getText().toString();
            }
        }

        //TODO CHECKBOX AKSES PENJUALAN
        if (CBAAkses.isChecked()) {
            s_cbaakses = CBAAkses.getText().toString();
        } else {
            s_cbaakses = "";
        }

        if (CBBAkses.isChecked()) {
            s_cbbakses = CBBAkses.getText().toString();
        } else {
            s_cbbakses = "";
        }

        if (CBCAkses.isChecked()) {
            s_cbcakses = CBCAkses.getText().toString();
        } else {
            s_cbcakses = "";
        }

        if (CBDAkses.isChecked()) {
            edAkses.setEnabled(true);
            s_cbdakses = edAkses.getText().toString();
        } else {
            s_cbdakses = "";
        }

        CBDAkses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBDAkses.isChecked()) {
                    edAkses.setVisibility(View.VISIBLE);
                } else {
                    edAkses.setVisibility(View.INVISIBLE);
                }
            }
        });


        //TODO CHECKBOX KOMPETITOR
        if (CBAKom.isChecked()) {
            s_cbakom = CBAKom.getText().toString();
        } else {
            s_cbakom = "";
        }

        if (CBBKom.isChecked()) {
            s_cbbkom = CBBKom.getText().toString();
        } else {
            s_cbbkom = "";
        }

        if (CBCKom.isChecked()) {
            s_cbckom = CBCKom.getText().toString();
        } else {
            s_cbckom = "";
        }

        if (CBDKom.isChecked()) {
            s_cbdkom = CBDKom.getText().toString();
        } else {
            s_cbdkom = "";
        }

        if (CBEKom.isChecked()) {
            s_cbekom = CBEKom.getText().toString();
        } else {
            s_cbekom = "";
        }


        if (CBFKom.isChecked()) {
            edkompetitor.setEnabled(true);
            s_cbfkom = edkompetitor.getText().toString();
        } else {
            s_cbfkom = "";
        }

        CBFKom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBFKom.isChecked()) {
                    edkompetitor.setVisibility(View.VISIBLE);
                } else {
                    edkompetitor.setVisibility(View.INVISIBLE);
                }
            }
        });


        //TODO CHECKBOX PROVIDER
        if (CBAPro.isChecked()) {
            s_cbapro = CBAPro.getText().toString();
        } else {
            s_cbapro = "";
        }

        if (CBBPro.isChecked()) {
            s_cbbpro = CBBPro.getText().toString();
        } else {
            s_cbbpro = "";
        }

        if (CBCPro.isChecked()) {
            s_cbcpro = CBCPro.getText().toString();
        } else {
            s_cbcpro = "";
        }

        if (CBDPro.isChecked()) {
            s_cbdpro = CBDPro.getText().toString();
        } else {
            s_cbdpro = "";
        }

        if (CBEPro.isChecked()) {
            s_cbepro = CBEPro.getText().toString();
        } else {
            s_cbepro = "";
        }

        if (CBFPro.isChecked()) {
            edMayoritas.setEnabled(true);
            s_cbfpro = edMayoritas.getText().toString();
        } else {
            s_cbfpro = "";
        }

        CBFPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBFPro.isChecked()) {
                    edMayoritas.setVisibility(View.VISIBLE);
                } else {
                    edMayoritas.setVisibility(View.INVISIBLE);
                }
            }
        });

        //TODO BUTTON NEXT
        btnNDS.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void onClick(View view) {

                        rata2_biaya = edRata2BiayaInternet.getText().toString();

                        switch (view.getId()) {
                            case R.id.rbMobilMotor:
                                strMayoritasKendaraan = "Mobil dan Motor";

                                break;
                            case R.id.rbMotor:
                                strMayoritasKendaraan = "Motor";

                                break;
                        }

                        if (rbMobilMotor.isChecked()) {
                            strMayoritasKendaraan = "Mobil dan Motor";
                        } else {
                            strMayoritasKendaraan = "Motor";
                        }

                        String messageTiperumah = " ";
                        for (EditText res : listKlasiTipeRumah) {
                            if (!res.getText().toString().trim().equals("")) {
                                messageTiperumah = messageTiperumah + res.getText() + ",";
                            }
                        }

                        String message = " ";
                        for (CheckBox res : listJenisProperti) {
                            if (res.isChecked()) {
                                message = message + res.getText() + ",";
                            }
                        }

                        String message2 = " ";
                        for (CheckBox res : listMetodePembangunan){
                            if (res.isChecked()) {
                                        message2 = message2 + res.getText() + "," ;
                                    }
                                }

                        String message21 = "";
                        for (EditText res : listMetodePembangunan1) {
                            if (!res.getText().toString().trim().equals("")) {
                                message21 = message21 + res.getText();
                            }
                        }

                        String message23 = message2+message21;

                        String message3 = " ";
                        for (CheckBox res : listAksesPenjualan) {
                            if (res.isChecked()) {
                                message3 = message3 + res.getText() + ",";
                            }
                        }

                        String message31 = "";
                        for (EditText res : listAksesPenjualan1) {
                            if (!res.getText().toString().trim().equals("")) {
                                message31 = message31 + res.getText();
                            }
                        }

                        String message33 = message3 + message31;

                        String message4 = " ";
                        for (CheckBox res : listKompetitor) {
                            if (res.isChecked()) {
                                message4 = message4 + res.getText() + ",";
                            }
                        }

                        String message41 = "";
                        for (EditText res : listKompetitor1) {
                            if (!res.getText().toString().trim().equals("")) {
                                message41 = message41 + res.getText();
                            }
                        }

                        String message43 = message4+message41;

                        String message5 = " ";
                        for (CheckBox res : listMayoritasProvider) {
                            if (res.isChecked()) {
                                message5 = message5 + res.getText() + ",";
                            }
                        }

                        String message51 = "";
                        for (EditText res : listMayoritasProvider1) {
                            if (!res.getText().toString().trim().equals("")) {
                                message51 = message51 + res.getText();
                            }
                        }

                        String message53 = message5+message51;

                        nilaiMayoritasKendaraan = strMayoritasKendaraan;
                        nilaiDataJenisProperti = message;
                        nilaiDataMetodePembangunan = message23;
//                        nilaiDataMetodePembangunan1 = message21;
                        nilaiDataAksesPenjualan = message33;
                        nilaiDataAksesPenjualan1 = message31;
                        nilaiKompetitor = message43;
                        nilaiKompetitor1 = message41;
                        nilaiMayoritasProvider = message53;
                        nilaiMayoritasProvider1 = message51;
                        nilaiDataKlasifikasiTiperRumah = messageTiperumah;
                        String region = getIntent().getExtras().getString(REGION);
                        String kecamatan = getIntent().getExtras().getString(KECEMATAN);
                        String kelurahan = getIntent().getExtras().getString(KELURAHAN);
                        String kompleks = getIntent().getExtras().getString(KOMPLEKS);
                        String developer = getIntent().getExtras().getString(DEVELOPER);
                        String kabkota = getIntent().getExtras().getString(KABKOTA);
                        bundle = new Bundle();
                        String tanggal = getIntent().getExtras().getString(TANGGAL);
                        bundle.putString(TANGGAL, tanggal);
//                        String surveyor = getIntent().getExtras().getString(SURVEYOR);
//                        bundle.putString(SURVEYOR, surveyor);
                        bundle.putString(RATA2BIAYA, rata2_biaya);
                        bundle.putString(REGION, region);
                        bundle.putString(KECEMATAN, kecamatan);
                        bundle.putString(KELURAHAN, kelurahan);
                        bundle.putString(DEVELOPER, developer);
                        bundle.putString(KOMPLEKS, kompleks);
                        bundle.putString(KABKOTA, kabkota);
                        bundle.putString(MAYORITASKENDARAAN, nilaiMayoritasKendaraan);
                        bundle.putString(JENISPROPERTI, nilaiDataJenisProperti);
                        bundle.putString(KLASIFIKASITIPERUMAH, nilaiDataKlasifikasiTiperRumah);
                        bundle.putString(METODEPEMBANGUNAN, nilaiDataMetodePembangunan);
                        bundle.putString(AKSESPENJUALAN, nilaiDataAksesPenjualan);
                        bundle.putString(KOMPETITOR, nilaiKompetitor);
                        bundle.putString(MAYORITASPROVIDER, nilaiMayoritasProvider);

                        if (!CBAjenisPro.isChecked() && !CBBjenisPro.isChecked() && !CBCjenisPro.isChecked()) {

                            CBAjenisPro.setError("isi data");
                            CBAjenisPro.requestFocus();
                            Toast.makeText(InformasiDetailSurveyArea.this, "Isi terlebih dahulu sebelum melanjutkat ke halaman berikutnya", Toast.LENGTH_SHORT).show();

                        } else if (!CBAklartipe.isChecked() && !CBBklartipe.isChecked() && !CBCklartipe.isChecked() && !CBDklartipe.isChecked() && !CBEklartipe.isChecked() && !CBFklartipe.isChecked()) {

                            CBAklartipe.setError("isi data");
                            CBAklartipe.requestFocus();
                            Toast.makeText(InformasiDetailSurveyArea.this, "Isi terlebih dahulu sebelum melanjutkat ke halaman berikutnya", Toast.LENGTH_SHORT).show();

                        } else if (!CBAMetod.isChecked() && !CBBMetod.isChecked() && !CBCMetod.isChecked() && !CBDMetod.isChecked()) {

                            CBAMetod.setError("isi data");
                            CBAMetod.requestFocus();
                            Toast.makeText(InformasiDetailSurveyArea.this, "Isi terlebih dahulu sebelum melanjutkat ke halaman berikutnya", Toast.LENGTH_SHORT).show();

                        } else if (!CBAAkses.isChecked() && !CBBAkses.isChecked() && !CBCAkses.isChecked() && !CBDAkses.isChecked()) {

                            CBAAkses.setError("isi data");
                            CBAAkses.requestFocus();
                            Toast.makeText(InformasiDetailSurveyArea.this, "Isi terlebih dahulu sebelum melanjutkat ke halaman berikutnya", Toast.LENGTH_SHORT).show();

                        } else if (!CBAKom.isChecked() && !CBBKom.isChecked() && !CBCKom.isChecked() && !CBDKom.isChecked() && !CBEKom.isChecked() && !CBFKom.isChecked()) {

                            CBAKom.setError("isi data");
                            CBAKom.requestFocus();
                            Toast.makeText(InformasiDetailSurveyArea.this, "Isi terlebih dahulu sebelum melanjutkat ke halaman berikutnya", Toast.LENGTH_SHORT).show();

                        } else if (!CBAPro.isChecked() && !CBBPro.isChecked() && !CBCPro.isChecked() && !CBDPro.isChecked() && !CBEPro.isChecked() && !CBFPro.isChecked()) {

                            CBAPro.setError("isi data");
                            CBAPro.requestFocus();
                            Toast.makeText(InformasiDetailSurveyArea.this, "Isi terlebih dahulu sebelum melanjutkat ke halaman berikutnya", Toast.LENGTH_SHORT).show();

                        } else if (TextUtils.isEmpty(edRata2BiayaInternet.getText())) {
                            edRata2BiayaInternet.setError("Harus Diisi");

                        } else if (Radiogroup.getCheckedRadioButtonId() <= 0) {
                            int radioId = Radiogroup.getCheckedRadioButtonId();
                            radioButton = findViewById(radioId);
                            rbMotor.setError("Select Item");

                        } else {
                            Intent intentnext = new Intent(getApplicationContext(), Identita_Surveyor.class);
                            intentnext.putExtras(bundle);
                            startActivity(intentnext);
                        }

                    }


                });



    }

}
