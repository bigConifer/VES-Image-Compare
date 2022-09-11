package com.vincentengelsoftware.androidimagecompare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.vincentengelsoftware.androidimagecompare.globals.Images;
import com.vincentengelsoftware.androidimagecompare.globals.Status;
import com.vincentengelsoftware.androidimagecompare.helper.FullScreenHelper;
import com.vincentengelsoftware.androidimagecompare.helper.TransparentHelper;
import com.vincentengelsoftware.androidimagecompare.viewClasses.VesImageInterface;

public class OverlayTransparentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Status.activityIsOpening = false;

        FullScreenHelper.setFullScreenFlags(this.getWindow());

        setContentView(R.layout.activity_overlay_transparent);

        Images.first.updateVesImageViewWithAdjustedImage(findViewById(R.id.overlay_transparent_image_view_base));

        VesImageInterface image_transparent = findViewById(R.id.overlay_transparent_image_view_transparent);

        Images.second.updateVesImageViewWithAdjustedImage(image_transparent);

        image_transparent.bringToFront();

        SeekBar seekBar = findViewById(R.id.overlay_slide_seek_bar);

        TransparentHelper.makeTargetTransparent(seekBar, image_transparent);

        seekBar.setProgress(50);

        ImageButton hideShow = findViewById(R.id.overlay_transparent_button_hide_front_image);
        hideShow.setOnClickListener(view -> {
            if (image_transparent.getVisibility() == View.VISIBLE) {
                image_transparent.setVisibility(View.GONE);
            } else {
                image_transparent.setVisibility(View.VISIBLE);
            }
        });
    }
}