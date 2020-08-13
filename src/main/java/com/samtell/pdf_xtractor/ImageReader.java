/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;



/**
 *
 * @author samtell
 */
public class ImageReader {
    public static String extractImage(String path){
	File imageFile = new File(path);
	ITesseract instance = new Tesseract();
	instance.setDatapath("tessdata");
	try {
	    String result = instance.doOCR(imageFile);
	    return result;
	} catch(TesseractException e){
	    System.err.println(e.getMessage());
	    return "sdfasdfasdf";
	}
    }
}
