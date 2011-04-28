/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://platform.netbeans.org/tutorials/nbm-projecttype.html
 * http://platform.netbeans.org/tutorials/nbm-projecttypeant.html
 */

package org.unrealscriptsupport.unrealmutatorproject.nodes;

import java.awt.Image;
import javax.swing.Action;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.ImageUtilities;
import org.unrealscriptsupport.unrealmutatorproject.UnrealMutatorProject;

/** This is the node you actually see in the project tab for the project */
public class SrcNode extends FilterNode {

    public static final String DIR = "src";
    public static final String DISPLAY_NAME = "Source Files";

    private static Image smallImage =
            ImageUtilities.loadImage(
                "org/unrealscriptsupport/unrealmutatorproject/resources/unreal-badge.png");

    final UnrealMutatorProject project;

    public SrcNode(Node defaultNode,
                   UnrealMutatorProject project)
                   throws DataObjectNotFoundException {
        super(defaultNode);
        this.project = project;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public Action[] getActions(boolean arg0) {
        Action[] nodeActions = new Action[1];
        nodeActions[0] = CommonProjectActions.newFileAction();
        //nodeActions[1] = CommonProjectActions.copyProjectAction();
        //nodeActions[2] = CommonProjectActions.deleteProjectAction();
        //nodeActions[5] = CommonProjectActions.setAsMainProjectAction();
        //nodeActions[6] = CommonProjectActions.closeProjectAction();
        return nodeActions;
    }

    //Next, we add icons, for the default state, which is
    //closed, and the opened state; we will make them the same.
    //Icons in project logical views are
    //based on combinations--you must combine the node's own icon
    //with a distinguishing badge that is merged with it. Here we
    //first obtain the icon from a data folder, then we add our
    //badge to it by merging it via a NetBeans API utility method:
    @Override
    public Image getIcon(int type) {
        DataFolder root = DataFolder.findFolder(FileUtil.getConfigRoot());
        Image original = root.getNodeDelegate().getIcon(type);
        return ImageUtilities.mergeImages(original, smallImage, 7, 7);
        //return original;
    }

    @Override
    public Image getOpenedIcon(int type) {
        DataFolder root = DataFolder.findFolder(FileUtil.getConfigRoot());
        Image original = root.getNodeDelegate().getIcon(type);
        return ImageUtilities.mergeImages(original, smallImage, 7, 7);
        //return original;
    }
}
