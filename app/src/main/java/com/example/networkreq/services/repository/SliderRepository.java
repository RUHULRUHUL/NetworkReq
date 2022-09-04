package com.example.networkreq.services.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.networkreq.services.model.Slider;
import com.example.networkreq.services.model.SliderResponse;
import com.example.networkreq.services.network.ApiServices;
import com.example.networkreq.services.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SliderRepository {

    public MutableLiveData<List<Slider>> sliderMutableLiveData = new MutableLiveData<>();

    public static SliderRepository repository;

    public static SliderRepository getRepository() {
        if (repository == null) {
            repository = new SliderRepository();

        }
        return repository;
    }

    public MutableLiveData<List<Slider>> getSliders() {
        ApiServices apiServices = RetrofitInstance.getRetrofit().create(ApiServices.class);

        Call<SliderResponse> call = apiServices.getSliders();
        call.enqueue(new Callback<SliderResponse>() {
            @Override
            public void onResponse(Call<SliderResponse> call, Response<SliderResponse> response) {
                if (response.isSuccessful()) {
                    List<Slider> sliderList = response.body().getData();
                    sliderMutableLiveData.postValue(sliderList);
                }
            }

            @Override
            public void onFailure(Call<SliderResponse> call, Throwable t) {

            }
        });

        return sliderMutableLiveData;

    }
}
