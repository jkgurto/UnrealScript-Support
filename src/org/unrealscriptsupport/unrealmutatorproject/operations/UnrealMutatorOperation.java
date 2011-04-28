/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://platform.netbeans.org/tutorials/nbm-projecttype.html
 */

package org.unrealscriptsupport.unrealmutatorproject.operations;

import java.util.*;
import org.openide.filesystems.FileObject;
import org.unrealscriptsupport.unrealmutatorproject.nodes.SrcNode;
import org.unrealscriptsupport.unrealmutatorproject.UnrealMutatorProject;

/**
 *
 * @author jacqui
 */
public class UnrealMutatorOperation {

    protected final UnrealMutatorProject project;

    public UnrealMutatorOperation(UnrealMutatorProject project) {
        this.project = project;
    }

    /**
     * Reference: RailsProjectOperations.java
     * @return
     */
    public List<FileObject> getMetadataFiles() {
        FileObject projectDirectory = project.getProjectDirectory();
        Set<FileObject> files = new LinkedHashSet<FileObject>();

        addFile(projectDirectory, "nbproject", files);
        addFile(projectDirectory, "build.xml", files);

        return new ArrayList<FileObject>(files);
    }

    /**
     * Reference: RailsProjectOperations.java
     * @return
     */
    public List<FileObject> getDataFiles() {
        Set<FileObject> files = new LinkedHashSet<FileObject>();
        // Add src dir
        addFile(project.getProjectDirectory(), SrcNode.DIR, files);
        return new ArrayList<FileObject>(files);
    }

    /**
     * Reference: RailsProjectOperations.java
     * @return
     */
    private void addFile(FileObject projectDirectory,
                         String fileName,
                         Set<FileObject> result) {
        FileObject file = projectDirectory.getFileObject(fileName);
        if (file != null) {
            result.add(file);
        }
        return;
    }
}
