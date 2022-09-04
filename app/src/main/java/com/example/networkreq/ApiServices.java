package com.example.networkreq;

import com.example.networkreq.model.SliderResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET(Common.Sliders)
    Call<SliderResponse> getSliders();
}
