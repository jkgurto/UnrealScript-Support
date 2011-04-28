/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unrealscriptsupport.unrealmutatorproject.nodes;

import java.awt.Image;
import javax.swing.Action;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.ui.support.*;
import org.openide.actions.FileSystemAction;
import org.openide.actions.ToolsAction;
import org.openide.nodes.*;
import org.openide.util.ImageUtilities;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.*;
import org.unrealscriptsupport.unrealmutatorproject.UnrealMutatorProject;

/**
 *
 * @author jacqui
 */
public class RootNode extends AbstractNode {

    public static final String REGISTERED_NODE_LOCATION =
            "Projects/org-unrealscriptsupport-UnrealMutatorProject/Nodes";
    final UnrealMutatorProject project;

    private Action[] actions;

    public RootNode(UnrealMutatorProject project) {
        super(NodeFactorySupport.
                createCompositeChildren(project,
                                        REGISTERED_NODE_LOCATION),
                Lookups.singleton(project));
        this.project = project;
        setIconBaseWithExtension(UnrealMutatorProject.PROJECT_ICON);
    }

    /*
     * org.netbeans.spi.java.project.support.ui
     public @Override Action[] getActions(boolean context) {
        if ( actions == null ) {
            actions = new Action[] {
                CommonProjectActions.newFileAction(),
                null,
                SystemAction.get( FindAction.class ),
                null,
                SystemAction.get( PasteAction.class ),
                null,
                SystemAction.get( FileSystemAction.class ),
                null,
                SystemAction.get( ToolsAction.class ),
            };
        }
        return actions;
    }
     */
    @Override
    public Action[] getActions(boolean arg0) {

        if (actions == null) {
            actions = new Action[] {

                CommonProjectActions.newFileAction(),

                null,

                //The 'null' is a reference to no properties being used, in this case.
                ProjectSensitiveActions.
                        projectCommandAction(ActionProvider.COMMAND_BUILD,
                                             "Build",
                                             null),
                ProjectSensitiveActions.
                        projectCommandAction(ActionProvider.COMMAND_REBUILD,
                                             "Clean and Build",
                                             null),
                ProjectSensitiveActions.
                        projectCommandAction(ActionProvider.COMMAND_CLEAN,
                                             "Clean",
                                             null),

                null,

                ProjectSensitiveActions.
                        projectCommandAction(ActionProvider.COMMAND_RUN,
                                             "Run",
                                             null),

                null,

                CommonProjectActions.setAsMainProjectAction(),
                CommonProjectActions.closeProjectAction(),

                null,

                CommonProjectActions.renameProjectAction(),
                CommonProjectActions.moveProjectAction(),
                CommonProjectActions.copyProjectAction(),
                CommonProjectActions.deleteProjectAction(),

                null,

                //SystemAction.get( FileSystemAction.class ),
                //null,
                //SystemAction.get( ToolsAction.class ),

                null,

                CommonProjectActions.customizeProjectAction()
            };
        }

        return actions;
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage(UnrealMutatorProject.PROJECT_ICON);
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }

    /**
     * Same name as project.
     * @return
     */
    @Override
    public String getDisplayName() {
        return project.getInfo().getDisplayName();
    }
}
