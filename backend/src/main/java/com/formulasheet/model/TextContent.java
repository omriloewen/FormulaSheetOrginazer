package com.formulasheet.model ;
import java.awt.* ;
import java.awt.image.BufferedImage ;

public class TextContent extends RawContent {

    private String text ;
    private boolean bold ;

    public TextContent() {
        this("", false) ;
        
    }

    public TextContent(String text) {
      this(text, false) ;
    }

    public TextContent(String text, boolean bold) {
        super();
        this.text = text ;
        this.bold = bold ;
        setComputeSizesPerFontSize() ;
    }

    public static int[] getTextDimensions(String text, int fontSize, String fontType, boolean bold) {
        // Create a temporary image to get the Graphics2D context
        BufferedImage tempImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = tempImage.createGraphics() ;
        
        // Set font
        Font font ;
        if(bold){
            font = new Font(fontType, Font.BOLD, fontSize) ;
        }else{
            font = new Font(fontType, Font.PLAIN, fontSize) ;
        }
        
        g2d.setFont(font) ;
        
        // Get font metrics for the given font
        FontMetrics metrics = g2d.getFontMetrics() ;
        
        // Calculate exact width and height of the text
        int textWidth = metrics.stringWidth(text) ;
        int textHeight = metrics.getAscent() + metrics.getDescent() ;

        // Clean up
        g2d.dispose() ;

        return new int[]{textWidth, textHeight} ;
    }

    public static int[] getTextDimensions(String text, int fontSize, String fontType){
        return getTextDimensions( text,  fontSize,  fontType, false) ;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text ;
        setComputeSizesPerFontSize();
    }

 
    private void setComputeSizesPerFontSize(){
        if (text.isEmpty()){
            heightPerFontSize = 0 ;
            heightPerFontSize = 0 ;
        }else{
            int[] dims1 = getTextDimensions(text, 8, "Serif", bold) ;
            double heightPerFontSize1 = dims1[1] ;
            double widthPerFontSize1 = dims1[0] ;
            int[] dims2 = getTextDimensions(text, 20, "Serif", bold) ;
            double heightPerFontSize2 = dims2[1] ;
            double widthPerFontSize2 = dims2[0] ;
            heightPerFontSize = (heightPerFontSize2 - heightPerFontSize1) / 12.0 ;
            widthPerFontSize = (widthPerFontSize2 - widthPerFontSize1) / 12.0 ;
        }
       
    }

    public void setBold(boolean bold) {
        this.bold = bold ;
        setComputeSizesPerFontSize() ;
    }

    public boolean isBold() {
        return bold ;
    }

    public void setTextAndBold(String text, boolean bold){
        this.text = text ;
        this.bold = bold ;
        setComputeSizesPerFontSize() ;
    }

    
}
