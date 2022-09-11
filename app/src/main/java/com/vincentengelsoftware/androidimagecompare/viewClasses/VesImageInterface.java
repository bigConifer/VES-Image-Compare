package com.vincentengelsoftware.androidimagecompare.viewClasses;

import android.graphics.Bitmap;
import android.view.View;

public interface VesImageInterface {
    void setBitmapImage(Bitmap bitmap);
    int getVisibility();
    void setVisibility(int visibility);
    void setOnClickListener(View.OnClickListener l);
    void bringToFront();
    void setAlpha(float alpha);
}