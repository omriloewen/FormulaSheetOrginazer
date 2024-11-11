package com.formulasheet;

import com.formulasheet.model.TextContent;
import org.junit.jupiter.api.Test;


public class TextContentTest {

    @Test
    public void testTextContent() {
        // Test LaTeX input

        // Create a FormulaContent instance and call latexToSrc
        TextContent reg = new TextContent("שלום !");
        TextContent bold = new TextContent("שלום עולם!", true);
        TextContent empty = new TextContent();

        System.out.println(TextContent.getTextDimensions("", 20, "Serif")[0]);

        

        System.out.println(reg.getHeightPerFontSize());
        System.out.println(reg.getWidthPerFontSize());
        System.out.println(bold.getHeightPerFontSize());
        System.out.println(bold.getWidthPerFontSize());
        System.out.println(empty.getText());
        System.out.println(empty.getHeightPerFontSize());



     

        
    }
}