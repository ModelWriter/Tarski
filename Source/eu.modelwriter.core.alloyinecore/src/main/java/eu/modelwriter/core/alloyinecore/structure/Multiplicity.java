/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore.structure;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.visitor.AlloyInEcoreVisitor;

import java.util.Arrays;

public class Multiplicity extends Element<EMultiplicityContext>{
    public Multiplicity(EMultiplicityContext context) {
        super(context);
    }

    @Override
    public String getLabel() {
        int l = 1;
        int u = 1;

        if (getContext().stringBound != null) {
            switch (getContext().stringBound.getText()) {
                case "*": l = 0; u = -1; break;
                case "+": l = 1; u = -1; break;
                case "?": l = 0; u =  1; break;
                default: break;
            }
        } else {
            try {
                l = Integer.valueOf(getContext().lowerBound.getText());
            }catch (NumberFormatException ex){
                System.out.println(Arrays.toString(ex.getStackTrace()));
            }
            if (getContext().upperBound != null) {
                if (getContext().upperBound.getText().equals("*")) u = -1;
                else try { u = Integer.valueOf(getContext().upperBound.getText());}
                catch (NumberFormatException ex){
                    System.out.println(Arrays.toString(ex.getStackTrace()));
                }
            } else { u = l;}
        }
        String multiplicity;
        if (l==0 && u==-1)
            multiplicity = "[*]";
        else if (l==1 && u==-1)
            multiplicity = "[+]";
        else if (l==0 && u==1)
            multiplicity = "[?]";
        else if (l==1 && u==1)
            multiplicity = "[1]";
        else if (l==u)
            multiplicity = "[" + l + "]";
        else
            multiplicity = "[" + l + ".." + u + "]";
        return multiplicity;
    }

    @Override
    public <T> T accept(AlloyInEcoreVisitor<? extends T> visitor) {
        return visitor.visitMultiplicity(this);
    }
}
