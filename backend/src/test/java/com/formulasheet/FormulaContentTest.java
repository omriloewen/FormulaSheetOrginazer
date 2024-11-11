package com.formulasheet;

import com.formulasheet.model.FormulaContent;
import org.junit.jupiter.api.Test;


public class FormulaContentTest {

    @Test
    public void testLatexToSrc() {
        // Test LaTeX input
        String latexCode = "\\sum_{n=1}^{\\infty} \\frac{1}{n^2}";

        // Create a FormulaContent instance and call latexToSrc
        FormulaContent formulaContent = new FormulaContent(latexCode);

        FormulaContent.latexToSrc(latexCode, 50);

        System.out.println(formulaContent.getLatex());

        System.out.println(formulaContent.getHeightPerFontSize());
        System.out.println(formulaContent.getWidthPerFontSize());



     

        
    }
}