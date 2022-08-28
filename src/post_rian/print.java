/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post_rian;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import javax.swing.JEditorPane;

/**
 *
 * @author Lenovo
 */
public class print {

    static MessageFormat head = new MessageFormat("");
    static MessageFormat foot = new MessageFormat("");

    public static void main(String[] args) throws Exception {

        PrinterJob pj = PrinterJob.getPrinterJob();

        PageFormat pf = pj.defaultPage();
        Paper paper = new Paper();
        double margin = 20; // half inch
        paper.setImageableArea(margin, margin - 15, paper.getWidth() - margin * 2, paper.getHeight()
                - margin * 2);
        pf.setPaper(paper);

        if (pj.printDialog()) {
            JEditorPane text = new JEditorPane("text/html", ""
                    + "<center style='font-family: monospace;font-size: 10;'>"
                    + "<h3>STRUK PEMBELIAN LISTRIK PRABAYAR</h3>"
                    + "</center>");
            text.repaint();
            pj.setPrintable(text.getPrintable(head, foot), pf);
            pj.print();
            System.out.println("done .............. ");
        }
    }
}
