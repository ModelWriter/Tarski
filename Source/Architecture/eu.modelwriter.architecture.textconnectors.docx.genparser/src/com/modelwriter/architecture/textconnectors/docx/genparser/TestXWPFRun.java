/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
package com.modelwriter.architecture.textconnectors.docx.genparser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalAlignRun;

/**
 * Tests for XWPF Run
 */
public class TestXWPFRun extends TestCase {
    public CTR ctRun;
    public XWPFParagraph p;

    protected void setUp() {
        XWPFDocument doc = new XWPFDocument();
        p = doc.createParagraph();

        this.ctRun = CTR.Factory.newInstance();
    }

    public void testSetGetText() {
        ctRun.addNewT().setStringValue("TEST STRING");	
        ctRun.addNewT().setStringValue("TEST2 STRING");	
        ctRun.addNewT().setStringValue("TEST3 STRING");

        assertEquals(3,ctRun.sizeOfTArray());
        XWPFRun run = new XWPFRun(ctRun, p);

        assertEquals("TEST2 STRING",run.getText(1));

        run.setText("NEW STRING",0);
        assertEquals("NEW STRING",run.getText(0));

        //run.setText("xxx",14);
        //fail("Position wrong");
    }
  
    public void testSetGetBold() {
        CTRPr rpr = ctRun.addNewRPr();
        rpr.addNewB().setVal(STOnOff.TRUE);

        XWPFRun run = new XWPFRun(ctRun, p);
        assertEquals(true, run.isBold());

        run.setBold(false);
        assertEquals(STOnOff.FALSE, rpr.getB().getVal());
    }

    public void testSetGetItalic() {
        CTRPr rpr = ctRun.addNewRPr();
        rpr.addNewI().setVal(STOnOff.TRUE);

        XWPFRun run = new XWPFRun(ctRun, p);
        assertEquals(true, run.isItalic());

        run.setItalic(false);
        assertEquals(STOnOff.FALSE, rpr.getI().getVal());
    }

    public void testSetGetStrike() {
        CTRPr rpr = ctRun.addNewRPr();
        rpr.addNewStrike().setVal(STOnOff.TRUE);

        XWPFRun run = new XWPFRun(ctRun, p);
        assertEquals(true, run.isStrike());

        run.setStrike(false);
        assertEquals(STOnOff.FALSE, rpr.getStrike().getVal());
    }

    public void testSetGetUnderline() {
        CTRPr rpr = ctRun.addNewRPr();
        rpr.addNewU().setVal(STUnderline.DASH);

        XWPFRun run = new XWPFRun(ctRun, p);
        assertEquals(UnderlinePatterns.DASH.getValue(), run.getUnderline()
                .getValue());

        run.setUnderline(UnderlinePatterns.NONE);
        assertEquals(STUnderline.NONE.intValue(), rpr.getU().getVal()
                .intValue());
    }


    public void testSetGetVAlign() {
        CTRPr rpr = ctRun.addNewRPr();
        rpr.addNewVertAlign().setVal(STVerticalAlignRun.SUBSCRIPT);

        XWPFRun run = new XWPFRun(ctRun, p);
        assertEquals(VerticalAlign.SUBSCRIPT, run.getSubscript());

        run.setSubscript(VerticalAlign.BASELINE);
        assertEquals(STVerticalAlignRun.BASELINE, rpr.getVertAlign().getVal());
    }


    public void testSetGetFontFamily() {
        CTRPr rpr = ctRun.addNewRPr();
        rpr.addNewRFonts().setAscii("Times New Roman");

        XWPFRun run = new XWPFRun(ctRun, p);
        assertEquals("Times New Roman", run.getFontFamily());

        run.setFontFamily("Verdana");
        assertEquals("Verdana", rpr.getRFonts().getAscii());
    }


    public void testSetGetFontSize() {
        CTRPr rpr = ctRun.addNewRPr();
        rpr.addNewSz().setVal(new BigInteger("14"));

        XWPFRun run = new XWPFRun(ctRun, p);
        assertEquals(7, run.getFontSize());

        run.setFontSize(24);
        assertEquals(48, rpr.getSz().getVal().longValue());
    }


    public void testSetGetTextForegroundBackground() {
        CTRPr rpr = ctRun.addNewRPr();
        rpr.addNewPosition().setVal(new BigInteger("4000"));

        XWPFRun run = new XWPFRun(ctRun, p);
        assertEquals(4000, run.getTextPosition());

        run.setTextPosition(2400);
        assertEquals(2400, rpr.getPosition().getVal().longValue());
    }

    public void testSetGetColor() {
        XWPFRun run = new XWPFRun(ctRun, p);
        run.setColor("0F0F0F");
        String clr = run.getColor();
        assertEquals("0F0F0F", clr);
    }

    public void testAddCarriageReturn() {
        ctRun.addNewT().setStringValue("TEST STRING");
        ctRun.addNewCr();
        ctRun.addNewT().setStringValue("TEST2 STRING");
        ctRun.addNewCr();
        ctRun.addNewT().setStringValue("TEST3 STRING");
        assertEquals(2, ctRun.sizeOfCrArray());

        XWPFRun run = new XWPFRun(CTR.Factory.newInstance(), p);
        run.setText("T1");
        run.addCarriageReturn();
        run.addCarriageReturn();
        run.setText("T2");
        run.addCarriageReturn();
        assertEquals(3, run.getCTR().sizeOfCrArray());
        
        assertEquals("T1\n\nT2\n", run.toString());
    }
    
    public void testAddTabsAndLineBreaks() {
        ctRun.addNewT().setStringValue("TEST STRING");
        ctRun.addNewCr();
        ctRun.addNewT().setStringValue("TEST2 STRING");
        ctRun.addNewTab();
        ctRun.addNewT().setStringValue("TEST3 STRING");
        assertEquals(1, ctRun.sizeOfCrArray());
        assertEquals(1, ctRun.sizeOfTabArray());

        XWPFRun run = new XWPFRun(CTR.Factory.newInstance(), p);
        run.setText("T1");
        run.addCarriageReturn();
        run.setText("T2");
        run.getCTR().addNewTab();
        run.setText("T3");
        assertEquals(1, run.getCTR().sizeOfCrArray());
        assertEquals(1, run.getCTR().sizeOfTabArray());
        
        assertEquals("T1\nT2\tT3", run.toString());
    }

    public void testAddPageBreak() {
        ctRun.addNewT().setStringValue("TEST STRING");
        ctRun.addNewBr();
        ctRun.addNewT().setStringValue("TEST2 STRING");
        CTBr breac=ctRun.addNewBr();
        breac.setClear(STBrClear.LEFT);
        ctRun.addNewT().setStringValue("TEST3 STRING");
        assertEquals(2, ctRun.sizeOfBrArray());

        XWPFRun run = new XWPFRun(CTR.Factory.newInstance(), p);
        run.setText("TEXT1");
        run.addBreak();
        run.setText("TEXT2");
        run.addBreak(BreakType.TEXT_WRAPPING);
        assertEquals(2, run.getCTR().sizeOfBrArray());
    }


}