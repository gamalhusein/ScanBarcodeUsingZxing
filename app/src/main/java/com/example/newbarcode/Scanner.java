package com.example.newbarcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final String FLASH_STATE = "FLASH_STATE";
    private static final String AUTO_FOCUS_STATE = "AUTO_FOCUS_STATE";
    private static final String CAMERA_ID = "CAMERA_ID";
    private boolean mFlash;
    private boolean mFocus;
    private int mCameraId = -1;

    ZXingScannerView mScannerView;

    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        if (state != null){
            mFlash = state.getBoolean(FLASH_STATE,true);
            mFocus = state.getBoolean(AUTO_FOCUS_STATE, true);
            mCameraId = state.getInt(CAMERA_ID, -1);
        } else {
            mFlash= false;
            mFocus = true;
            mCameraId = -1;
        }
        mScannerView = new ZXingScannerView(this);
        mScannerView.setAspectTolerance(0.5f);
        setContentView(mScannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera(mCameraId);
        mScannerView.setAutoFocus(mFocus);
        mScannerView.setFlash(mFlash);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(FLASH_STATE, mFlash);
        outState.putBoolean(AUTO_FOCUS_STATE, mFocus);
        outState.putInt(CAMERA_ID, mCameraId);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }
    @Override
    public void handleResult(Result rawResult) {
        Intent intent = new Intent();
        intent.putExtra("result", rawResult.getText());
        setResult(RESULT_OK, intent);

        finish();

    }
}
