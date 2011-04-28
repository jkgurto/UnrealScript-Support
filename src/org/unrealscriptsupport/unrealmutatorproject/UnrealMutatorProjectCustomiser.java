/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://blogs.sun.com/gridbag/entry/project_properties_gui_for_custom
 */

package org.unrealscriptsupport.unrealmutatorproject;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.spi.project.ui.CustomizerProvider;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.NbBundle;

/**
 *
 * @author jacqui
 */
public class UnrealMutatorProjectCustomiser implements CustomizerProvider {

    private ProjectCustomizer.Category[] categories = null;
    private ProjectCustomizer.CategoryComponentProvider panelProvider = null;

    // Names of categories
    private static final String BUILD_CATEGORY = "BuildCategory";
    private static final String BUILD_DISPLAY = "BuildCustomiser";

    private final UnrealMutatorProject project;
    private ResourceBundle bundle =
            NbBundle.getBundle(UnrealMutatorProjectCustomiser.class);

    public UnrealMutatorProjectCustomiser(UnrealMutatorProject project) {
        this.project = project;
    }

    @Override
    public void showCustomizer() {
        setup();

        OptionListener listener = new OptionListener(project);
        Dialog dialog = ProjectCustomizer.createCustomizerDialog(
                categories,
                panelProvider,
                null,
                listener,
                null);
        dialog.addWindowListener(listener);

        dialog.setTitle(ProjectUtils.getInformation(project).getDisplayName());

        dialog.setVisible(true);
    }

    private void setup() {

        // Don't create more than once
        if (panelProvider != null) {
            return;
        }

        // Add categories
        ProjectCustomizer.Category category;

        category = ProjectCustomizer.Category.create(
                       BUILD_CATEGORY,
                       bundle.getString(BUILD_DISPLAY),
                       null);

        categories = new ProjectCustomizer.Category[] { category };

        // Add panels to categories
        Map<ProjectCustomizer.Category, JPanel> panels =
                new HashMap<ProjectCustomizer.Category, JPanel>();
        panels.put(category, new BuildJPanel(project));

        // Add categories and panels to panel provider
        panelProvider = new PanelProvider(panels);

        return;
    }

    private static class PanelProvider
            implements ProjectCustomizer.CategoryComponentProvider {
        private Map panels;

        private JPanel EMPTY_PANEL = new JPanel();

        public PanelProvider(Map panels) {
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

    }

    private class OptionListener
            extends WindowAdapter implements ActionListener {
        
        private Project project;

        OptionListener(Project project) {
            this.project = project;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Close and dispose the dialog
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            // Close and dispose the dialog
        }
    }
}
