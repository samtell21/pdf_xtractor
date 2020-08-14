/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;
import java.io.*;
import javax.swing.*;
import org.apache.pdfbox.pdmodel.*;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author samtell
 */
public class OrgoScratch extends MainGuiAbstract{
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
	    new OrgoScratch().setVisible(true);
	});
    }
    
    @Override
    public void xtract(String path, String outputdir) throws IOException{
	File file = new File(path);
	try(PDDocument doc = PDDocument.load(file)){
	    LinkedList<AbstractPDPage> pages = new LinkedList<>();
	    doc.getPages().forEach(p -> { 
		pages.add((TestPDPage) p);
	    });
	    
	    LinkedList<String> codes = new LinkedList<>();
	    
	    for(AbstractPDPage p : pages){
		String c = p.scan();
		if(!codes.contains(c)) codes.add(c);
	    }
	    
	    
	    for(String c : codes){
		PDDocument newdoc = new PDDocument();
		for(AbstractPDPage p : (LinkedList<AbstractPDPage>) pages.clone()){
		    if(p.scan() == c){
			newdoc.addPage(p);
			pages.remove(p);
		    }
		}
		File newfile = new File("PackTicket_"+c);
		newfile.createNewFile();
		newdoc.save(newfile);
	    }
	       
	}
	    
    }
    
}
