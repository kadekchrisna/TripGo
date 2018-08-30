package com.kadek.tripgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QrActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView zXingScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        zXingScannerView =new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.setAutoFocus(true);
        zXingScannerView.startCamera();



    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {

        Intent detailIntent = new Intent(QrActivity.this, DetailActivity.class);
        detailIntent.putExtra("placeUid", String.valueOf(result));
        startActivity(detailIntent);
        detailIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();


        //Toast.makeText(getApplicationContext(),result.getText(), Toast.LENGTH_SHORT).show();
        //zXingScannerView.resumeCameraPreview(this);

    }
}
