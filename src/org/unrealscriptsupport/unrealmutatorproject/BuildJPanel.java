/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImportantFilesVisual.java
 *
 * Created on 23/04/2011, 1:43:54 PM
 */

package org.unrealscriptsupport.unrealmutatorproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.util.NbPreferences;
import org.unrealscriptsupport.options.global.UnrealScriptToolsOptionsPanelController;
import org.unrealscriptsupport.options.global.UnrealScriptToolsPanel;

/**
 *
 * @author jacqui
 */
public class BuildJPanel extends javax.swing.JPanel {

    UnrealMutatorProject project;

    /** Creates new form ImportantFilesVisual */
    public BuildJPanel(UnrealMutatorProject project) {
        this.project = project;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JComboBox jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText(org.openide.util.NbBundle.getMessage(BuildJPanel.class, "BuildJPanel.jLabel1.text")); // NOI18N

        jComboBox1.setModel(loadModel());

        jLabel2.setText(org.openide.util.NbBundle.getMessage(BuildJPanel.class, "BuildJPanel.jLabel2.text")); // NOI18N

        jTextField1.setText(loadUserDir());
        jTextField1.setEnabled(false);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText(org.openide.util.NbBundle.getMessage(BuildJPanel.class, "BuildJPanel.jRadioButton1.text")); // NOI18N
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText(org.openide.util.NbBundle.getMessage(BuildJPanel.class, "BuildJPanel.jRadioButton2.text")); // NOI18N
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText(org.openide.util.NbBundle.getMessage(BuildJPanel.class, "BuildJPanel.jLabel4.text")); // NOI18N

        jLabel3.setText(loadDefaultDir());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, 297, Short.MAX_VALUE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

        toggleTextField();
        return;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

        toggleTextField();
        return;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void toggleTextField() {
        if (jRadioButton2.isSelected()) {
            jTextField1.setEnabled(true);
        }
        else {
            jTextField1.setEnabled(false);
        }
        return;
    }

    private ComboBoxModel loadModel() {
        return new ToolModel();
    }

    private String loadDefaultDir() {
        return NbPreferences
                .forModule(UnrealScriptToolsPanel.class)
                .get("compiler.basedir", "");
    }

    private String loadUserDir() {

        Properties prefs = new Properties();
        try {
            prefs.load(new FileInputStream(
                    project.getProjectDirectory().getPath() +
                    "/nbproject/project.properties"));
        }
        catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
        catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        return prefs.getProperty("compiler.basedir");
    }

    private class ToolModel extends AbstractListModel implements ComboBoxModel {

        private final List<String> elements;
        private int selection = -1;

        public ToolModel() {
            elements = new ArrayList<String>();
            elements.add("KF");
            elements.add("UDK3");
            Collections.sort(elements);
        }

        @Override
        public void setSelectedItem(Object anItem) {

            boolean found = false;
            if (anItem instanceof String) {
                int i = Collections.binarySearch(elements, (String) anItem);
                
                // Found
                if (i >= 0) {
                    selection = i;
                    found = true;
                }
            }
            
            if (!found) {
                selection = -1;
            }

            return;
        }

        @Override
        public Object getSelectedItem() {

            String item = null;
            if (selection >= 0) {
                item = elements.get(selection);
            }

            return item;
        }

        @Override
        public int getSize() {
            return elements.size();
        }

        @Override
        public Object getElementAt(int index) {
            return elements.get(index);
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}