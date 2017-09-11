/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */


package org.netbeans.modules.image;


import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.openide.util.NbBundle;


/** This class define a panel for "Custom zoom" dialog.
 *
 * @author  Lukas Tadial
 */
public class CustomZoomPanel extends JPanel {

    /** Creates new form CustomZoomPane */
    public CustomZoomPanel() {
        initComponents();
        initAccessibility();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        enlargeLabel = new javax.swing.JLabel();
        enlargeText = new javax.swing.JTextField();
        decreasingLabel = new javax.swing.JLabel();
        decreaseText = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        enlargeLabel.setLabelFor(enlargeText);
        org.openide.awt.Mnemonics.setLocalizedText(enlargeLabel, NbBundle.getBundle(CustomZoomPanel.class).getString("LBL_EnlargeFactor")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(enlargeLabel, gridBagConstraints);

        enlargeText.setDocument(new WholeNumberDocument());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 0, 11);
        add(enlargeText, gridBagConstraints);

        decreasingLabel.setLabelFor(decreaseText);
        org.openide.awt.Mnemonics.setLocalizedText(decreasingLabel, NbBundle.getBundle(CustomZoomPanel.class).getString("LBL_DecreaseFactor")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 11, 0);
        add(decreasingLabel, gridBagConstraints);

        decreaseText.setDocument(new WholeNumberDocument());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 11, 11, 11);
        add(decreaseText, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    private void initAccessibility(){
        getAccessibleContext().setAccessibleDescription(NbBundle.getBundle(CustomZoomPanel.class).getString("ACSD_CustomZoomPanel"));
        enlargeText.getAccessibleContext().setAccessibleDescription(NbBundle.getBundle(CustomZoomPanel.class).getString("ACS_EnlargeText"));
        decreaseText.getAccessibleContext().setAccessibleDescription(NbBundle.getBundle(CustomZoomPanel.class).getString("ACS_DecreaseText"));
        
    }
    
    public int getEnlargeFactor() {
        return Integer.parseInt(enlargeText.getText());
    }
    
    public void setEnlargeFactor(int enlargeFactor) {
        enlargeText.setText("" + enlargeFactor); // NOI18N
    }
    
    public int getDecreaseFactor() {
        return Integer.parseInt(decreaseText.getText());
    } 
    
    public void setDecreaseFactor(int decreaseFactor) {
        decreaseText.setText("" + decreaseFactor); // NOI18N
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField decreaseText;
    private javax.swing.JLabel decreasingLabel;
    private javax.swing.JLabel enlargeLabel;
    private javax.swing.JTextField enlargeText;
    // End of variables declaration//GEN-END:variables
    

    /** Documnet which accepts only digit chars. */
    private static class WholeNumberDocument extends PlainDocument {

        /** Overrides superclass method. */
        public void insertString(int offs, String str, AttributeSet a) 
        throws BadLocationException {
             char[] source = str.toCharArray();
             StringBuffer result = new StringBuffer();
             
             for(int i=0; i<source.length; i++) {
                 if(Character.isDigit(source[i])) {
                     result.append(source[i]);
                 } else { 
                     if(Boolean.getBoolean("netbeans.debug.excpetions")) // NOI18N
                         System.err.println("Image: Trying insert non-digit in custom zoom action."); // NOI18N
                 }
             }
             
             // There has to be some number added.
             if(result.length() == 0)
                 return;
             
             super.insertString(offs, result.toString(), a);
         }
         
     } // End of nested class WholeNumberDocument. 

    
}