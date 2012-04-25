/**
 * @author Jacqui Hawkins
 * @date 2011
 * @licence CDDL Licence, Version 1.0
 *
 * Reference:
 * NetBeans java.navigator sources.
 */
package org.unrealscriptsupport.navigator;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.BeanTreeView;
import org.openide.filesystems.FileObject;
import org.openide.nodes.Node;
import org.openide.util.lookup.InstanceContent;
import org.unrealscriptsupport.navigator.ElementNode.Description;

/**
 *
 * @author jacqui
 */
public class ClassMemberPanelUI
        extends javax.swing.JPanel
        implements ExplorerManager.Provider,
                   PropertyChangeListener {

    private ExplorerManager manager = new ExplorerManager();
    private BeanTreeView elementView = new BeanTreeView();
    private InstanceContent selectedNodes = new InstanceContent();

    public ClassMemberPanelUI() {

        setLayout(new java.awt.BorderLayout());
        manager.addPropertyChangeListener(this);

        // View of the elements
        add(elementView, BorderLayout.CENTER);

        manager.setRootContext(ElementNode.getWaitNode());
    }

    public void showWaitNode() {
        //SwingUtilities.invokeLater(new Runnable() {

        //    @Override
        //    public void run() {
                elementView.setRootVisible(true);
                manager.setRootContext(ElementNode.getWaitNode());
                elementView.expandAll();
        //    }
        //});
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /*if (ExplorerManager.PROP_SELECTED_NODES.equals(evt.getPropertyName())) {
            for (Node n : (Node[]) evt.getOldValue()) {
                selectedNodes.remove(n);
            }
            for (Node n : (Node[]) evt.getNewValue()) {
                selectedNodes.add(n);
            }
        }*/
        return;
    }

    private ElementNode getRootNode() {

        Node n = manager.getRootContext();
        if (n instanceof ElementNode) {
            return (ElementNode) n;
        }
        else {
            return null;
        }
    }

    public void refresh(final Description description) {

        /*final ElementNode rootNode = getRootNode();

        if (rootNode != null) {
            // update
            //System.out.println("UPDATE ======" + description.fileObject.getName() );
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    rootNode.updateRecursively(description);
                }
            });
        }
        else {
            //System.out.println("REFRES =====" + description.fileObject.getName() );
            // New fileobject => refresh completely*/
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    manager.setRootContext(new ElementNode(description));
                    elementView.setRootVisible(true);
                    //elementView.setAutoWaitCursor(false);
                    elementView.expandAll();
                    //elementView.setAutoWaitCursor(true);
                }
            });

        //}

        return;
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return manager;
    }
}
