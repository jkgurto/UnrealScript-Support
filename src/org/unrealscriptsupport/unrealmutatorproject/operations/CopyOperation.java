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
import org.netbeans.spi.project.CopyOperationImplementation;
import org.unrealscriptsupport.unrealmutatorproject.UnrealMutatorProject;

/**
 *
 * @author jacqui
 */
public class CopyOperation
            extends UnrealMutatorOperation
            implements CopyOperationImplementation {

    public CopyOperation(UnrealMutatorProject project) {
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
