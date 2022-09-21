package com.example.newbarcode.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScanBarcodeResponse {

	@SerializedName("data")
	@Expose
	private ScanBarcodeData scanBarcodeData;

	@SerializedName("message")
	@Expose
	private String message;

	public void setData(ScanBarcodeData scanBarcodeData){
		this.scanBarcodeData = scanBarcodeData;
	}

	public ScanBarcodeData getData(){
		return scanBarcodeData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}