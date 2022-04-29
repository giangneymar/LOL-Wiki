package com.example.lolwiki.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.lolwiki.R;
import com.example.lolwiki.bases.BaseActivity;
import com.example.lolwiki.databinding.ActivityFeedbackBinding;

public class FeedbackActivity extends BaseActivity {
    /*
     * Area : variable
     */
    private ActivityFeedbackBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedbackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setActivityTitle(R.string.feedback);
        checkItemNavigation(R.id.feedback);
        setSlider();
        onClick();
    }

    /*
     * Area : function
     */
    private void setSlider() {
        Animation in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        binding.sliderFeedback.setInAnimation(in);
        binding.sliderFeedback.setOutAnimation(out);
        binding.sliderFeedback.setFlipInterval(5000);
        binding.sliderFeedback.setAutoStart(true);
    }

    private void onClick() {
        binding.disappointed.setOnClickListener(view -> binding.feedback.setText(R.string.disappointed));
        binding.sad.setOnClickListener(view -> binding.feedback.setText(R.string.sad));
        binding.fine.setOnClickListener(view -> binding.feedback.setText(R.string.fine));
        binding.happy.setOnClickListener(view -> binding.feedback.setText(R.string.happy));
        binding.blissful.setOnClickListener(view -> binding.feedback.setText(R.string.blissful));

        binding.send.setOnClickListener(view -> sendMail());
    }

    private void sendMail() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:giangneymar99@gmail.com"));
        intent.putExtra(Intent.EXTRA_TEXT,binding.feedback.getText().toString());
        startActivity(intent);
    }
}