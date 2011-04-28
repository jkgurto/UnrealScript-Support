/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://wiki.netbeans.org/DevFaqNodesDecorating
 */

package org.unrealscriptsupport.unrealmutatorproject.nodes;

import java.io.*;
import java.util.*;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.nodes.*;

/**
 *
 * @author jacqui
 */
public class FileFilteredNode extends FilterNode {
    
    public FileFilteredNode(Node defaultNode,
                            FileFilter fileFilter) {
        super(defaultNode,
              new FileFilteredChildren(defaultNode, fileFilter));
    }

    /**
     * Reference:
     * http://wiki.netbeans.org/DevFaqNodesDecorating
     */
    static class FileFilteredChildren extends FilterNode.Children {

        private final FileFilter fileFilter;

        public FileFilteredChildren(Node owner,
                                    FileFilter fileFilter) {
            super(owner);
            this.fileFilter = fileFilter;
        }

        //@Override
        //protected Node copyNode(Node original) {
        //    return new FileFilteredNode(original, fileFilter);
        //}

        @Override
        protected Node[] createNodes(Node key) {
            List<Node> result = new ArrayList<Node>();

            for (Node node : super.createNodes(key)) {
                DataObject dataObject =
                        node.getLookup().lookup(DataObject.class);

                if (dataObject != null) {
                    FileObject fileObject = dataObject.getPrimaryFile();
                    File file = FileUtil.toFile(fileObject);

                    if (fileFilter.accept(file)) {
                        result.add(node);
                    }
                }
            }

            return result.toArray(new Node[result.size()]);
        }
    }

}
