/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://platform.netbeans.org/tutorials/nbm-projecttype.html
 */

package org.unrealscriptsupport.unrealmutatorproject.operations;

import java.io.IOException;
import org.netbeans.spi.project.DeleteOperationImplementation;
import org.unrealscriptsupport.unrealmutatorproject.UnrealMutatorProject;

/**
 *
 * @author jacqui
 */
public final class DeleteOperation
        extends UnrealMutatorOperation
        implements DeleteOperationImplementation {

    public DeleteOperation(UnrealMutatorProject project) {
        super(project);
    }

    @Override
    public void notifyDeleting() throws IOException {
    }

    @Override
    public void notifyDeleted() throws IOException {
    }
}