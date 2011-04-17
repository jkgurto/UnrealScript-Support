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

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.project.*;
import org.netbeans.spi.project.*;
import org.netbeans.spi.project.support.ant.AntBasedProjectRegistration;
import org.netbeans.spi.project.support.ant.AntProjectHelper;
import org.openide.filesystems.FileObject;
import org.openide.util.*;
import org.openide.util.lookup.Lookups;

@AntBasedProjectRegistration(type = "org.unrealscriptsupport.UnrealMutatorProject",
iconResource = "org/unrealscriptsupport/unrealmutatorproject/resources/unreal.png",
sharedName = "data",
sharedNamespace = "http://www.netbeans.org/ns/unreal-mutator-project/1",
privateName = "project-private",
privateNamespace = "http://www.netbeans.org/ns/unreal-mutator-project-private/1")
public class UnrealMutatorProject implements Project {

    public static final String PROJECT_ICON =
                "org/unrealscriptsupport/unrealmutatorproject/resources/unreal.png";

    private final AntProjectHelper helper;
    private final FileObject projectDir;
    private final Info info;
    private Lookup _lookup;

    public UnrealMutatorProject(AntProjectHelper helper) {
        this.helper = helper;
        this.projectDir = helper.getProjectDirectory();
        info = new Info();
    }

    @Override
    public FileObject getProjectDirectory() {
        return projectDir;
    }

    FileObject getSrcFolder(boolean create) {
        FileObject result = projectDir.getFileObject(SrcNode.DIR);
        if ((result == null) && create) {
            try {
                result = projectDir.createFolder(SrcNode.DIR);
            }
            catch (IOException ioe) {
                Exceptions.printStackTrace(ioe);
            }
        }
        return result;
    }

    /**
     * The project type's capabilities are registered in the project's lookup:
     */
    @Override
    public Lookup getLookup() {
        if (_lookup == null) {
            _lookup = Lookups.fixed(new Object[]{
                //allow outside code to mark the project as needing saving
                //state,
                //Provides standard actions like Build and Clean
                new UnrealMutatorActionProvider(this, helper),
                new UnrealMutatorMoveOperation(this),
                new UnrealMutatorCopyOperation(this),
                new UnrealMutatorDeleteOperation(this),
                //Project information implementation
                info,
                //Logical view of project implementation
                new UnrealMutatorProjectLogicalView(this),
                    });
        }
        return _lookup;
    }

    public ProjectInformation getInfo() {
        return info;
    }

    private class UnrealMutatorOperation {

        private final UnrealMutatorProject project;
        private final FileObject projectDir;

        public UnrealMutatorOperation(UnrealMutatorProject project) {
            this.project = project;
            this.projectDir = project.getProjectDirectory();
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

    private final class UnrealMutatorMoveOperation
            extends UnrealMutatorOperation
            implements MoveOperationImplementation {

        public UnrealMutatorMoveOperation(UnrealMutatorProject project) {
            super(project);
        }

        @Override
        public void notifyMoving() throws IOException {
        }

        @Override
        public void notifyMoved(Project original,
                                File originalPath,
                                String newName)
                                throws IOException {
        }
    }

    private final class UnrealMutatorCopyOperation
            extends UnrealMutatorOperation
            implements CopyOperationImplementation {

        public UnrealMutatorCopyOperation(UnrealMutatorProject project) {
            super(project);
        }

        @Override
        public void notifyCopying() throws IOException {
        }

        @Override
        public void notifyCopied(Project arg0, File arg1, String arg2)
                throws IOException {
        }

        
    }

    private final class UnrealMutatorDeleteOperation
            extends UnrealMutatorOperation
            implements DeleteOperationImplementation {

        public UnrealMutatorDeleteOperation(UnrealMutatorProject project) {
            super(project);
        }

        @Override
        public void notifyDeleting() throws IOException {
        }

        @Override
        public void notifyDeleted() throws IOException {
        }
    }

    private final class Info implements ProjectInformation {

        @Override
        public Icon getIcon() {
            return new ImageIcon(
                    ImageUtilities.loadImage(PROJECT_ICON));
        }

        @Override
        public String getName() {
            return getProjectDirectory().getName();
        }

        @Override
        public String getDisplayName() {
            return getName();
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener pcl) {
            //do nothing, won't change
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener pcl) {
            //do nothing, won't change
        }

        @Override
        public Project getProject() {
            return UnrealMutatorProject.this;
        }
    }
}
