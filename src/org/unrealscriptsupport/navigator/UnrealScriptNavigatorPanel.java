/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * http://bits.netbeans.org/dev/javadoc/org-netbeans-spi-navigator/overview-summary.html
 * http://bits.netbeans.org/dev/javadoc/org-netbeans-spi-navigator/org/netbeans/spi/navigator/doc-files/BasicNavPanelImpl_java
 */

/*
 * Licence from http://bits.netbeans.org/dev/javadoc/org-netbeans-spi-navigator/org/netbeans/spi/navigator/doc-files/BasicNavPanelImpl_java
 * Jacqui Hawkins elects to include this software in this distribution
 * under the CDDL license.
 */
/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */

package org.unrealscriptsupport.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JComponent;
import org.netbeans.spi.navigator.NavigatorPanel;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.unrealscriptsupport.navigator.ElementNode.Description;
import org.unrealscriptsupport.navigator.ElementNode.ElementKind;

/**
 *
 * @author jacqui
 */
public class UnrealScriptNavigatorPanel implements NavigatorPanel {
    
    /** holds UI of this panel */
    private ClassMemberPanelUI panelUI;
    /** template for finding data in given context.
     * Object used as example, replace with your own data source, for example JavaDataObject etc */
    private static final Lookup.Template MY_DATA = new Lookup.Template(Object.class);
    /** current context to work on */
    private Lookup.Result currentContext;
    /** listener to context changes */
    private LookupListener contextChangeListener;

    public UnrealScriptNavigatorPanel() {
    }

    @Override
    public String getDisplayName() {
        return NbBundle.getMessage(UnrealScriptNavigatorPanel.class, "LBL_panel");
    }

    @Override
    public String getDisplayHint() {
        return NbBundle.getMessage(UnrealScriptNavigatorPanel.class, "LBL_hint");
    }

    @Override
    public JComponent getComponent() {
        return getPanelUI();
    }

    @Override
    public void panelActivated(Lookup context) {
        assert(context != null);

        // lookup context and listen to result to get notified about context changes
        currentContext = context.lookup(MY_DATA);
        currentContext.addLookupListener(getContextListener());

        // get actual data and recompute content
        Collection data = currentContext.allInstances();
        setNewContent(data);

        getPanelUI().showWaitNode();

        return;
    }

    @Override
    public void panelDeactivated() {
        currentContext.removeLookupListener(getContextListener());
        currentContext = null;

        getPanelUI().showWaitNode();

        return;
    }

    @Override
    public Lookup getLookup() {
        return null;
    }

    private synchronized ClassMemberPanelUI getPanelUI() {
        if (panelUI == null) {
            panelUI = new ClassMemberPanelUI();
            // You can override requestFocusInWindow() on the component if desired.
        }
        return panelUI;
    }

    private void setNewContent(Collection newData) {
        // put your code here that grabs information you need from given
        // collection of data, recompute UI of your panel and show it.
        // Note - be sure to compute the content OUTSIDE event dispatch thread,
        // just final repainting of UI should be done in event dispatch thread.
        // Please use RequestProcessor and Swing.invokeLater to achieve this.

        Description d2 = new Description("functionname", ElementKind.FUNCTION, null);
        List<Description> subs = new ArrayList<Description>();
        subs.add(d2);
        Description d1 = new Description("classname", ElementKind.CLASS, subs);

        getPanelUI().refresh(d1);
    }

    /** Accessor for listener to context */
    private LookupListener getContextListener () {
        if (contextChangeListener == null) {
            contextChangeListener = new ContextListener();
        }
        return contextChangeListener;
    }

    /** Listens to changes of context and triggers proper action */
    private class ContextListener implements LookupListener {

        @Override
        public void resultChanged(LookupEvent ev) {
            Collection data = ((Lookup.Result)ev.getSource()).allInstances();
            setNewContent(data);
        }

    } // end of ContextListener

}
