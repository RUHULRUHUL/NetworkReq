package com.example.networkreq.services.network;

import com.example.networkreq.Common;
import com.example.networkreq.services.model.SliderResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET(Common.Sliders)
    Call<SliderResponse> getSliders();
}
