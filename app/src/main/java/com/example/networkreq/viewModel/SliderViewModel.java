package com.example.networkreq.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.networkreq.services.model.Slider;
import com.example.networkreq.services.repository.SliderRepository;


import java.util.List;

public class SliderViewModel extends AndroidViewModel {

    public SliderRepository repository;

    public SliderViewModel(@NonNull Application application) {
        super(application);
        repository = SliderRepository.getRepository();

    }

    public MutableLiveData<List<Slider>> getSliders() {
        return repository.getSliders();
    }

}
