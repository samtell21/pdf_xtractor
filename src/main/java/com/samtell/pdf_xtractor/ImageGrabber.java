/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author samtell
 */
public class ImageGrabber extends PDFStreamEngine{
    
    public ImageGrabber() throws IOException{
	images = new LinkedList<>();
    }
    
    protected LinkedList<BufferedImage> images;
    public LinkedList<BufferedImage> getImages(){
	return images;
    }
    
    public void processDoc(PDDocument doc) throws IOException{
	for(PDPage p : doc.getPages()){
	    this.processPage(p);
	}
    }
    
  
    @Override
    protected void processOperator( Operator operator, List<COSBase> operands) 
	    throws IOException{
        String operation = operator.getName();
        if( "Do".equals(operation) ){
            COSName objectName = (COSName) operands.get( 0 );
            PDXObject xobject = getResources().getXObject( objectName );
            if( xobject instanceof PDImageXObject){
                PDImageXObject image = (PDImageXObject)xobject;
                BufferedImage bImage = image.getImage();
		images.add(bImage);
                
            } else if(xobject instanceof PDFormXObject){
                PDFormXObject form = (PDFormXObject)xobject;
                showForm(form);
            }
        }else{
            super.processOperator( operator, operands);
        }
    }
 
}