package com.example.networkreq.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.networkreq.R;
import com.example.networkreq.services.model.Slider;
import com.example.networkreq.viewModel.SliderViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SliderViewModel sliderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSliderWithPatter();
    }

    private void getSliderWithPatter() {
        if (sliderViewModel == null) {
            sliderViewModel = new ViewModelProvider(MainActivity.this).get(SliderViewModel.class);
        }

        sliderViewModel.getSliders()
                .observe(this, new Observer<List<Slider>>() {
                    @Override
                    public void onChanged(List<Slider> sliders) {
                        if (sliders != null) {
                            for (Slider slider : sliders) {
                                Log.d("Slider", "Slider Img: " + slider.getImage());

                            }
                        }
                    }
                });
    }

}