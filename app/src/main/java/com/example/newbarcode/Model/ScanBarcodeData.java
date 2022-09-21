package com.example.newbarcode.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScanBarcodeData {

	@SerializedName("STOCK_OF_NAME")
	@Expose
	private String sTOCKOFNAME;

	@SerializedName("STORAGE_LOCATION2")
	@Expose
	private String sTORAGELOCATION2;

	@SerializedName("UPDATE_DATE")
	@Expose
	private String uPDATEDATE;

	@SerializedName("UPDATE_BY")
	@Expose
	private String uPDATEBY;

	@SerializedName("BARCODE")
	@Expose
	private String bARCODE;

	@SerializedName("SUCOFINDO_BARCODE")
	@Expose
	private String sUCOFINDOBARCODE;

	@SerializedName("REMARKS")
	@Expose
	private String rEMARKS;

	@SerializedName("ASSET_DESCRIPTION_SKK")
	@Expose
	private String aSSETDESCRIPTIONSKK;

	@SerializedName("NO_ASSET")
	@Expose
	private String nOASSET;

	@SerializedName("NEW_INVENTORY_NO")
	@Expose
	private String nEWINVENTORYNO;

	@SerializedName("COPY_STORAGE_LOCATION2")
	@Expose
	private String cOPYSTORAGELOCATION2;

	@SerializedName("INPUT_DATE")
	@Expose
	private Object iNPUTDATE;

	@SerializedName("STATUS")
	@Expose
	private String sTATUS;

	@SerializedName("OBJECT_ID")
	@Expose
	private int oBJECTID;

	@SerializedName("DESCRIPTION")
	@Expose
	private String dESCRIPTION;

	@SerializedName("ASSET_TYPE")
	@Expose
	private Object aSSETTYPE;

	@SerializedName("INPUT_BY")
	@Expose
	private Object iNPUTBY;

	@SerializedName("CONDITION")
	@Expose
	private String cONDITION;

	@SerializedName("DIGITAL")
	@Expose
	private String dIGITAL;

	public Integer countData(){
		return this.getClass().getDeclaredFields().length;
	}

	public void setSTOCKOFNAME(String sTOCKOFNAME){
		this.sTOCKOFNAME = sTOCKOFNAME;
	}

	public String getSTOCKOFNAME(){
		return sTOCKOFNAME;
	}

	public void setSTORAGELOCATION2(String sTORAGELOCATION2){
		this.sTORAGELOCATION2 = sTORAGELOCATION2;
	}

	public String getSTORAGELOCATION2(){
		return sTORAGELOCATION2;
	}

	public void setUPDATEDATE(String uPDATEDATE){
		this.uPDATEDATE = uPDATEDATE;
	}

	public String getUPDATEDATE(){
		return uPDATEDATE;
	}

	public void setUPDATEBY(String uPDATEBY){
		this.uPDATEBY = uPDATEBY;
	}

	public String getUPDATEBY(){
		return uPDATEBY;
	}

	public void setBARCODE(String bARCODE){
		this.bARCODE = bARCODE;
	}

	public String getBARCODE(){
		return bARCODE;
	}

	public void setSUCOFINDOBARCODE(String sUCOFINDOBARCODE){
		this.sUCOFINDOBARCODE = sUCOFINDOBARCODE;
	}

	public String getSUCOFINDOBARCODE(){
		return sUCOFINDOBARCODE;
	}

	public void setREMARKS(String rEMARKS){
		this.rEMARKS = rEMARKS;
	}

	public String getREMARKS(){
		return rEMARKS;
	}

	public void setASSETDESCRIPTIONSKK(String aSSETDESCRIPTIONSKK){
		this.aSSETDESCRIPTIONSKK = aSSETDESCRIPTIONSKK;
	}

	public String getASSETDESCRIPTIONSKK(){
		return aSSETDESCRIPTIONSKK;
	}

	public void setNOASSET(String nOASSET){
		this.nOASSET = nOASSET;
	}

	public String getNOASSET(){
		return nOASSET;
	}

	public void setNEWINVENTORYNO(String nEWINVENTORYNO){
		this.nEWINVENTORYNO = nEWINVENTORYNO;
	}

	public String getNEWINVENTORYNO(){
		return nEWINVENTORYNO;
	}

	public void setCOPYSTORAGELOCATION2(String cOPYSTORAGELOCATION2){
		this.cOPYSTORAGELOCATION2 = cOPYSTORAGELOCATION2;
	}

	public String getCOPYSTORAGELOCATION2(){
		return cOPYSTORAGELOCATION2;
	}

	public void setINPUTDATE(Object iNPUTDATE){
		this.iNPUTDATE = iNPUTDATE;
	}

	public Object getINPUTDATE(){
		return iNPUTDATE;
	}

	public void setSTATUS(String sTATUS){
		this.sTATUS = sTATUS;
	}

	public String getSTATUS(){
		return sTATUS;
	}

	public void setOBJECTID(int oBJECTID){
		this.oBJECTID = oBJECTID;
	}

	public int getOBJECTID(){
		return oBJECTID;
	}

	public void setDESCRIPTION(String dESCRIPTION){
		this.dESCRIPTION = dESCRIPTION;
	}

	public String getDESCRIPTION(){
		return dESCRIPTION;
	}

	public void setASSETTYPE(Object aSSETTYPE){
		this.aSSETTYPE = aSSETTYPE;
	}

	public Object getASSETTYPE(){
		return aSSETTYPE;
	}

	public void setINPUTBY(Object iNPUTBY){
		this.iNPUTBY = iNPUTBY;
	}

	public Object getINPUTBY(){
		return iNPUTBY;
	}

	public void setCONDITION(String cONDITION){
		this.cONDITION = cONDITION;
	}

	public String getCONDITION(){
		return cONDITION;
	}

	public void setDIGITAL(String dIGITAL){
		this.dIGITAL = dIGITAL;
	}

	public String getDIGITAL(){
		return dIGITAL;
	}
}