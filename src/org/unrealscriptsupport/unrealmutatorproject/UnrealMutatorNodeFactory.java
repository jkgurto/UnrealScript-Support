/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://platform.netbeans.org/tutorials/nbm-projecttypeant.html
 */
package org.unrealscriptsupport.unrealmutatorproject;


import org.netbeans.api.project.*;
import org.netbeans.spi.project.ui.support.*;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.*;
import org.openide.util.Exceptions;

@NodeFactory.Registration(projectType="org-unrealscriptsupport-UnrealMutatorProject", position=200)
public class UnrealMutatorNodeFactory implements NodeFactory {

    public UnrealMutatorNodeFactory() {
    }

    @Override
    public NodeList createNodes(Project proj) {
        
        if (!(proj instanceof UnrealMutatorProject)) {
            throw new RuntimeException(
                    "Cannot create nodes for an UnrealMutatorProject " +
                    "that is not an UnrealMutatorProject");
        }
        UnrealMutatorProject project = (UnrealMutatorProject) proj;

        try {
            Node[] nodeList = new Node[2];
            FileObject dir;
            DataFolder dataObject;
            Node defaultNode;

            // -- Src Node
            // Get the src directory, creating if deleted
            dir = project.getSrcFolder(true);

            // Get the DataObject that represents it
            dataObject = DataFolder.findFolder(dir);

            // Get its default node-we'll wrap our node around it to change the
            // display name, icon, etc
            defaultNode = dataObject.getNodeDelegate();

            nodeList[0] = new SrcNode(defaultNode, project);
            
            // -- Important Files node
            // Get the project directory
            dir = project.getProjectDirectory();

            // Get the DataObject that represents it
            dataObject = DataFolder.findFolder(dir);

            // Get its default node-we'll wrap our node around it to change the
            // display name, icon, etc
            defaultNode = dataObject.getNodeDelegate();

            nodeList[1] = new ImportantFilesNode(defaultNode, project);

            return NodeFactorySupport.fixedNodeList(nodeList);

        }
        catch (DataObjectNotFoundException ex) {
            Exceptions.printStackTrace(ex);
            //Fallback-the directory couldn't be created -
            //read-only filesystem or something evil happened
            //return new AbstractNode(Children.LEAF);
        }

        return NodeFactorySupport.fixedNodeList();
    }

}
