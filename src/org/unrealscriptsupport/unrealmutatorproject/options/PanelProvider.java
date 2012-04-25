/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unrealscriptsupport.unrealmutatorproject.options;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;

/**
 *
 * @author jacqui
 */
public class PanelProvider
        implements ProjectCustomizer.CategoryComponentProvider {

    private JPanel EMPTY_PANEL = new JPanel();

    private Map<ProjectCustomizer.Category, OptionPanel> panels;

    public PanelProvider(Map<ProjectCustomizer.Category, OptionPanel> panels) {
        this.panels = panels;
    }

    @Override
    public JComponent create(ProjectCustomizer.Category category) {

        JComponent panel = (JComponent) panels.get(category);

        if (panel == null) {
            panel = EMPTY_PANEL;
        }

        return panel;
    }

    public void loadAll() {

        Set<Entry<ProjectCustomizer.Category, OptionPanel>>
                panelSet = panels.entrySet();
        Iterator<Entry<ProjectCustomizer.Category, OptionPanel>> itr =
                panelSet.iterator();

        while (itr.hasNext()) {
            OptionPanel p = itr.next().getValue();
            p.load();
        }
        return;
    }

    public void saveAll() {

        Set<Entry<ProjectCustomizer.Category, OptionPanel>>
                panelSet = panels.entrySet();
        Iterator<Entry<ProjectCustomizer.Category, OptionPanel>> itr =
                panelSet.iterator();

        while (itr.hasNext()) {
            OptionPanel p = itr.next().getValue();
            p.save();
        }
        return;
    }
}
