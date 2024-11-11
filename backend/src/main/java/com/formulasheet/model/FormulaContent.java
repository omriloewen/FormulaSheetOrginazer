package com.formulasheet.model;

import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class FormulaContent extends RawContent {

    private String latex;
    private String src;


    public FormulaContent() {
        super();
        setLatex("");
    }

    public FormulaContent(String latex) {
        super();
       setLatex(latex);
    }

 

    public void setSrc(String latex, int fontSize) {
        this.src = latexToSrc(latex, fontSize) ;
        
    }

    public static BufferedImage latexToBufferedImage(String latex, int fontSize){
         if(latex.trim().isEmpty()){
            latex = "EMPTY";
        }

        try {
            // Generate the LaTeX formula as an image
            TeXFormula formula = new TeXFormula(latex);
            BufferedImage image = (BufferedImage) formula.createBufferedImage(TeXConstants.STYLE_DISPLAY, fontSize, Color.BLACK, Color.WHITE);

            // Crop the image to remove extra white space
            BufferedImage croppedImage = cropWhiteSpace(image);
            return croppedImage;
            } catch (Exception e) {
            e.printStackTrace();
            return new BufferedImage(0, 0, 0); // Return an empty string in case of an error
        }

    }

    public static String latexToSrc(String latex, int fontSize) {
        try {

        BufferedImage croppedImage = latexToBufferedImage(latex, fontSize);
            // Define the output path for the image
            String outputPath = "images/" + latex.hashCode() + ".png";
            File outputFile = new File(outputPath);

            // Create the directory if it doesn’t exist
            outputFile.getParentFile().mkdirs();

            // Write the cropped image to the file
            ImageIO.write(croppedImage, "png", outputFile);

            // Return the relative path to the image file
            return outputPath;

        } catch (Exception e) {
            e.printStackTrace();
            return ""; // Return an empty string in case of an error
        }
    }

    // Helper method to crop white space from an image
    public static BufferedImage cropWhiteSpace(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int minX = width;
        int minY = height;
        int maxX = 0;
        int maxY = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (image.getRGB(x, y) != Color.WHITE.getRGB()) {
                    if (x < minX) minX = x;
                    if (y < minY) minY = y;
                    if (x > maxX) maxX = x;
                    if (y > maxY) maxY = y;
                }
            }
        }

        return image.getSubimage(minX, minY, maxX - minX + 1, maxY - minY + 1);
    }

    public void setComputeSizesPerFontSize(){
        if (latex == null || latex.trim().isEmpty()){
            this.widthPerFontSize = 0;
            this.heightPerFontSize = 0;
        }else{
            BufferedImage image = latexToBufferedImage(latex, 50);
            this.widthPerFontSize = image.getWidth() / (double)50 ;
            this.heightPerFontSize = image.getHeight() / (double)50;
        }

    }

    public String getLatex() {
        return latex;
    }

    public void setLatex(String latex) {
        this.latex = latex;
        setComputeSizesPerFontSize();
    }

    public String getSrc() {
        return src;
    }
    
}
