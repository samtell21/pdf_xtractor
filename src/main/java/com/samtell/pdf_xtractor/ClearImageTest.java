/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import ClearImageJNI.CiException;
import ClearImageJNI.CiServer;
import ClearImageJNI.EInfoType;
import ClearImageJNI.FBarcodeType;
import ClearImageJNI.ICiBarcode;
import ClearImageJNI.ICiBarcodePro;
import ClearImageJNI.ICiServer;
import java.util.Arrays;

/**
 *
 * @author samtell
 */
public class ClearImageTest {

    static ICiServer initClearImage() {
	try {
	    //  Create ClearImage Server
	    CiServer objCi = new CiServer();
	    ICiServer Ci = objCi.getICiServer();
	    //  Display version and licensing information
	    System.out.println("ClearImage ver " + Ci.getVerMajor() + "." + Ci.getVerMinor() + "." + Ci.getVerRelease() + 
		    "  " + Ci.getInfo(EInfoType.fromInt(6748), 0));
	    System.out.println(Ci.getInfo(EInfoType.ciModulesList, 0));  
	    return Ci;
	 } catch (CiException ex) {
	    System.out.println(Arrays.toString(ex.getStackTrace())); 	    
	    return null;
	 }
    }
 
    static void readBarcodes(ICiServer Ci, String fileName, int page) {
	ICiBarcodePro reader = null;
	try {
	    reader = Ci.CreateBarcodePro(); // Create and configure barcode reader
	    reader.setType(new FBarcodeType(FBarcodeType.cibfCode39, FBarcodeType.cibfCode128));
	    reader.getImage().Open(fileName, page); // Open image from an image file
	    int n = reader.Find(0); // Read barcodes
	    for (int i = 1; i <= n; i++) { // Process results
		ICiBarcode Bc = reader.getBarcodes().getItem(i); // getItem is 1-based
		System.out.println(" Barcode + type: " + Bc.getType() + "   Text: \n" + Bc.getText());
	    }
	} catch (CiException ex) { // Process exceptions
	    System.out.println(Arrays.toString(ex.getStackTrace())); 	 
	} finally {
	    if (reader != null) try {
		reader.getImage().Close(); // Close images and free memory
	    } catch (CiException ex) {}
	}
    }
    
    public static void main(String[] args){
	readBarcodes(initClearImage(), "home/samtell/NatBeansProjects/pdf_xtractor/img.png", 0);
    }
    
     
    
}
