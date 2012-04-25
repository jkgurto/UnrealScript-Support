/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://blogs.sun.com/gridbag/entry/project_properties_gui_for_custom
 */

package org.unrealscriptsupport.unrealmutatorproject.options;

import java.awt.Dialog;
import java.util.*;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.spi.project.ui.CustomizerProvider;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.unrealscriptsupport.unrealmutatorproject.UnrealMutatorProject;

/**
 *
 * @author jacqui
 */
public class ProjectCustomiser implements CustomizerProvider {

    private ProjectCustomizer.Category[] categories = null;
    private PanelProvider panelProvider = null;

    // Names of categories
    private static final String BUILD_CATEGORY = "BuildCategory";
    private static final String BUILD_DISPLAY = "BuildCustomiser";

    private final UnrealMutatorProject project;
    private ResourceBundle bundle =
            NbBundle.getBundle(ProjectCustomiser.class);

    public ProjectCustomiser(UnrealMutatorProject project) {
        this.project = project;
    }

    @Override
    public void showCustomizer() {

        // Create panels
        loadPanels();

        // Load preferences into panels
        panelProvider.loadAll();

        // Create dialog
        OptionListener listener = new OptionListener(project, panelProvider);
        Dialog dialog = ProjectCustomizer.createCustomizerDialog(
                categories,
                panelProvider,
                BUILD_CATEGORY,
                listener,
                null);
        dialog.addWindowListener(listener);

        dialog.setTitle(ProjectUtils.getInformation(project).getDisplayName());

        dialog.setVisible(true);

        return;
    }

    private void loadPanels() {

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
        Map<ProjectCustomizer.Category, OptionPanel> panels =
                new HashMap<ProjectCustomizer.Category, OptionPanel>();
        panels.put(category, new BuildJPanel(project));

        // Add categories and panels to panel provider
        panelProvider = new PanelProvider(panels);

        return;
    }
    
}
