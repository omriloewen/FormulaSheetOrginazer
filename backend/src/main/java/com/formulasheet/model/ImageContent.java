package com.formulasheet.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageContent extends RawContent {

    private String src;

    public ImageContent() {
        super();
        this.src = "";
        widthPerFontSize = 0;
        heightPerFontSize = 0;
    }


    public ImageContent(String src, int rootFontSize) {
        super();
        this.src = src;
        int[] dims = getImageDimensions(src);
        widthPerFontSize = dims[0] / (double)rootFontSize;
        heightPerFontSize = dims[1] / (double)rootFontSize;
    }

    public static int[] getImageDimensions(String src) {
        try {
            // Load the image from the given source path
            File file = new File(src);
            BufferedImage image = ImageIO.read(file);

            // Get width and height
            int width = image.getWidth();
            int height = image.getHeight();

            return new int[]{width, height};

        } catch (IOException e) {
            e.printStackTrace();
            return new int[]{-1, -1};  // Return -1, -1 if there's an error
        }
    }

    public String getSrc() {
        return src;
    }

    public boolean setSrc(String src) {
        if(getOwner() != null){
        this.src = src;
        int[] dims = getImageDimensions(src);
        widthPerFontSize = dims[0] / (double)getOwner().getRootTextSize();
        heightPerFontSize = dims[1] / (double)getOwner().getRootTextSize();
        return true;

        }else{
            System.err.println("must have an owner to set the src");
            return false;
        }
        
    }

}





     
    

 