/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unrealscriptsupport.unrealmutatorproject.options;

import javax.swing.JPanel;

/**
 *
 * @author jacqui
 */
public abstract class OptionPanel extends JPanel {

    /**
     * Load preferences into GUI.
     */
    public abstract void load();

    /**
     * Save preferences from GUI.
     */
    public abstract void save();

}
