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

import org.unrealscriptsupport.unrealmutatorproject.nodes.RootNode;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.openide.nodes.*;

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

}
