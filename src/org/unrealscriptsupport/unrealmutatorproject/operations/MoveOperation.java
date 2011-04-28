/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://platform.netbeans.org/tutorials/nbm-projecttype.html
 */

package org.unrealscriptsupport.unrealmutatorproject.operations;

import java.io.File;
import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.MoveOperationImplementation;
import org.unrealscriptsupport.unrealmutatorproject.UnrealMutatorProject;

/**
 *
 * @author jacqui
 */
public class MoveOperation
            extends UnrealMutatorOperation
            implements MoveOperationImplementation {

    public MoveOperation(UnrealMutatorProject project) {
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
