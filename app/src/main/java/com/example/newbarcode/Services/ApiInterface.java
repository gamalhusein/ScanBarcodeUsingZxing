package com.example.newbarcode.Services;

import com.example.newbarcode.Model.ScanBarcodeData;
import com.example.newbarcode.Model.ScanBarcodeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("barcode")
    Call<ScanBarcodeResponse> getScanBarcode(
            @Query("barcode")String barcode
    );
}
