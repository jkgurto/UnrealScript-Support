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

import java.io.IOException;
import org.apache.tools.ant.module.api.support.ActionUtils;
import org.netbeans.spi.project.*;
import org.netbeans.spi.project.support.ant.AntProjectHelper;
import org.netbeans.spi.project.ui.support.DefaultProjectOperations;
import org.openide.filesystems.FileObject;
import org.openide.util.*;

/**
 *
 * @author jacqui
 */
public class UnrealMutatorActionProvider implements ActionProvider {

    private String[] supported = new String[]{
        ActionProvider.COMMAND_BUILD,
        ActionProvider.COMMAND_REBUILD,
        ActionProvider.COMMAND_CLEAN,
        ActionProvider.COMMAND_RUN,
        ActionProvider.COMMAND_RENAME,
        ActionProvider.COMMAND_MOVE,
        ActionProvider.COMMAND_COPY,
        ActionProvider.COMMAND_DELETE
    };

    private final UnrealMutatorProject project;
    private final AntProjectHelper helper;

    public UnrealMutatorActionProvider(UnrealMutatorProject project,
                                       AntProjectHelper helper) {
        this.project = project;
        this.helper = helper;
    }

    @Override
    public String[] getSupportedActions() {
        return supported;
    }

    @Override
    public void invokeAction(String string,
                             Lookup lookup)
                             throws IllegalArgumentException {
        //Here we find the Ant script and call the target we need!
        if (string.equals(ActionProvider.COMMAND_BUILD)) {
            try {
                FileObject buildImpl =
                        helper.getProjectDirectory()
                        .getFileObject("build.xml");
                ActionUtils.runTarget(buildImpl,
                                      new String[]{"compile"},
                                      null);
            }
            catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        else if(string.equals(ActionProvider.COMMAND_REBUILD)) {
            try {
                FileObject buildImpl =
                        helper.getProjectDirectory()
                        .getFileObject("build.xml");
                ActionUtils.runTarget(buildImpl,
                                      new String[]{"recompile"},
                                      null);
            }
            catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        else if(string.equals(ActionProvider.COMMAND_CLEAN)) {
            try {
                FileObject buildImpl =
                        helper.getProjectDirectory()
                        .getFileObject("build.xml");
                ActionUtils.runTarget(buildImpl,
                                      new String[]{"clean"},
                                      null);
            }
            catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        else if (string.equals(ActionProvider.COMMAND_RUN)) {
            try {
                FileObject buildImpl =
                        helper.getProjectDirectory()
                        .getFileObject("build.xml");
                ActionUtils.runTarget(buildImpl,
                                      new String[]{"run"},
                                      null);
            }
            catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        else if (string.equals(ActionProvider.COMMAND_RENAME)) {
            DefaultProjectOperations.performDefaultRenameOperation(
                    project,
                    helper.getProjectDirectory().getName()); // @todo FIXME
        }
        else if (string.equals(ActionProvider.COMMAND_MOVE)) {
            DefaultProjectOperations.performDefaultMoveOperation(project);
        }
        else if (string.equals(ActionProvider.COMMAND_COPY)) {
            DefaultProjectOperations.performDefaultCopyOperation(project);
        }
        else if(string.equals(ActionProvider.COMMAND_DELETE)) {
            DefaultProjectOperations.performDefaultDeleteOperation(project);
        }

        return;
    }

    @Override
    public boolean isActionEnabled(String command,
                                   Lookup lookup)
                                   throws IllegalArgumentException {
        if ((command.equals(ActionProvider.COMMAND_BUILD))) {
            return true;
        }
        else if ((command.equals(ActionProvider.COMMAND_REBUILD))) {
            return true;
        }
        else if ((command.equals(ActionProvider.COMMAND_CLEAN))) {
            return true;
        }
        else if ((command.equals(ActionProvider.COMMAND_RUN))) {
            return true;
        }
        else if ((command.equals(ActionProvider.COMMAND_RENAME))) {
            return true;
        }
        else if ((command.equals(ActionProvider.COMMAND_MOVE))) {
            return true;
        }
        else if ((command.equals(ActionProvider.COMMAND_COPY))) {
            return true;
        }
        else if ((command.equals(ActionProvider.COMMAND_DELETE))) {
            return true;
        }
        else {
            throw new IllegalArgumentException(command);
        }
    }
}
