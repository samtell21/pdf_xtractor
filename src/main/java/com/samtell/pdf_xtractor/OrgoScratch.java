

package com.samtell.pdf_xtractor;
import java.io.*;
import org.apache.pdfbox.pdmodel.*;

import java.util.LinkedList;

/**
 *
 * @author samtell
 */
public class OrgoScratch extends MainGuiAbstract{
    

    /**
     *
     */
    private static final long serialVersionUID = -7114905337304100022L;

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
	
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
                    pages.add(createPDPage(p));
                });
	    
            LinkedList<String> codes = new LinkedList<>();
	    
            for(AbstractPDPage p : pages){
                System.out.println("loop itteration");
                String c = p.scan();
                if(!codes.contains(c)) {
                    codes.add(c);
                    System.out.println("code added: "+c);
                }
            }
	    
            int i = 1;
	    
            for(String c : codes){
                try(PDDocument newdoc = new PDDocument()){
                    for(AbstractPDPage p : pages){
                        if(p.scan() == null ? c == null : p.scan().equals(c)){
                            newdoc.importPage(p.getThis());
                        }
                    }
                    String fname = (c==null) ? "{null}" : c.replaceAll("/","-");
                    File newfile = new File(outputdir+"/"+fname+(i++)+".pdf");
                    newdoc.save(newfile);
                }
            }
	       
        }
	    
    }
    
    protected AbstractPDPage createPDPage(PDPage p){
        return new TestPDPage(p);
    }
    
}
