package com.example.reza.form.network;

import com.example.reza.form.loginactivity.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.reza.form.loginactivity.Constants.BASE_URL;

public class ApiClient {

    public static RegisterAPI apiInterface;

    public static RegisterAPI getClient() {
        if (apiInterface == null) {
            Gson gson = new GsonBuilder()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apiInterface = retrofit.create(RegisterAPI.class);
        }
        return apiInterface;
    }
}
