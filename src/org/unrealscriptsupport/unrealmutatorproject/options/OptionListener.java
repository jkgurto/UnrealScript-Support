/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unrealscriptsupport.unrealmutatorproject.options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.netbeans.api.project.Project;

/**
 *
 * @author jacqui
 */
public class OptionListener
            extends WindowAdapter implements ActionListener {

    private Project project;
    private PanelProvider panelProvider;

    public OptionListener(Project project, PanelProvider panelProvider) {
        this.project = project;
        this.panelProvider = panelProvider;
    }

    /**
     * Called when OK button was pressed.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        panelProvider.saveAll();
        return;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        return;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        return;
    }
}
