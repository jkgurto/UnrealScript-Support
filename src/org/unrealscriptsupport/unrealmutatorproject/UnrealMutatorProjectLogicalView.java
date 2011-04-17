/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://platform.netbeans.org/tutorials/nbm-projecttype.html
 * http://platform.netbeans.org/tutorials/nbm-projecttypeant.html
 */

package org.unrealscriptsupport.unrealmutatorproject;

import java.awt.Image;
import javax.swing.Action;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.*;
import org.openide.nodes.*;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.*;

public class UnrealMutatorProjectLogicalView implements LogicalViewProvider {

    private final UnrealMutatorProject project;

    public UnrealMutatorProjectLogicalView(UnrealMutatorProject project) {
        this.project = project;
    }

    @Override
    public Node findPath(Node root, Object target) {
        //leave unimplemented for now
        return null;
    }

    @Override
    public org.openide.nodes.Node createLogicalView() {
        return new RootNode(project);
    }

    private static final class RootNode extends AbstractNode {

        public static final String REGISTERED_NODE_LOCATION =
                "Projects/org-unrealscriptsupport-UnrealMutatorProject/Nodes";
        final UnrealMutatorProject project;

        public RootNode(UnrealMutatorProject project) {
            super(NodeFactorySupport.
                    createCompositeChildren(project,
                                            REGISTERED_NODE_LOCATION),
                    Lookups.singleton(project));
            this.project = project;
            setIconBaseWithExtension(UnrealMutatorProject.PROJECT_ICON);
        }

        @Override
        public Action[] getActions(boolean arg0) {
            Action[] nodeActions = new Action[11];
            nodeActions[0] = CommonProjectActions.newFileAction();
            
            //The 'null' is a reference to no properties being used, in this case.
            nodeActions[1] = ProjectSensitiveActions.
                    projectCommandAction(ActionProvider.COMMAND_BUILD,
                                         "Build",
                                         null);
            nodeActions[2] = ProjectSensitiveActions.
                    projectCommandAction(ActionProvider.COMMAND_REBUILD,
                                         "Clean and Build",
                                         null);
            nodeActions[3] = ProjectSensitiveActions.
                    projectCommandAction(ActionProvider.COMMAND_CLEAN,
                                         "Clean",
                                         null);
            nodeActions[4] = ProjectSensitiveActions.
                    projectCommandAction(ActionProvider.COMMAND_RUN,
                                         "Run",
                                         null);

            nodeActions[5] = CommonProjectActions.setAsMainProjectAction();
            nodeActions[6] = CommonProjectActions.closeProjectAction();

            nodeActions[7] = CommonProjectActions.renameProjectAction();
            nodeActions[8] = CommonProjectActions.moveProjectAction();
            nodeActions[9] = CommonProjectActions.copyProjectAction();
            nodeActions[10] = CommonProjectActions.deleteProjectAction();
            
            return nodeActions;
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

}
