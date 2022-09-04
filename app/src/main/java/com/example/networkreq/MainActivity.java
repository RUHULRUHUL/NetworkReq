package com.example.networkreq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.networkreq.model.Slider;
import com.example.networkreq.model.SliderResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSliders();
    }

    private void getSliders() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Common.BaseUrl)
                .build();

        ApiServices apiServices = retrofit.create(ApiServices.class);
        Call<SliderResponse> call = apiServices.getSliders();


        call.enqueue(new Callback<SliderResponse>() {
            @Override
            public void onResponse(Call<SliderResponse> call, Response<SliderResponse> response) {
                if (response.isSuccessful()) {
                    List<Slider> sliderList = response.body().getData();
                    if (sliderList != null) {
                        for (Slider slider : sliderList) {
                            //System.out.println("SliderItem : " + slider.getImage());
                            Log.d("Slider", "Slider Img: " + slider.getImage());

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SliderResponse> call, Throwable t) {

            }
        });


    }
}