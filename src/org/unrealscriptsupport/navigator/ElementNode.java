/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unrealscriptsupport.navigator;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

/**
 *
 * @author jacqui
 */
public class ElementNode extends AbstractNode {

    public static final String ICON_BASE =
            "org/unrealscriptsupport/navigator/resources/";

    private static Node WAIT_NODE;
    private Description description;

    public ElementNode(Description description) {
        super(description.subs == null ? Children.LEAF: new ElementChildren(description.subs));
        this.description = description;
        setDisplayName(description.name);
    }

    @Override
    public Image getIcon(int type) {
        
        Image img = null;

        final ElementKind kind = description.kind;
        if (kind == ElementKind.CLASS) {
            img = ImageUtilities.loadImage(ICON_BASE + "class.png");
        }
        else if (kind == ElementKind.CONST) {
            img = ImageUtilities.loadImage(ICON_BASE + "const.png");
        }
        else if (kind == ElementKind.DEFAULTPROPERTIES) {
            img = ImageUtilities.loadImage(ICON_BASE + "defaultproperties.png");
        }
        else if (kind == ElementKind.ENUM) {
            img = ImageUtilities.loadImage(ICON_BASE + "enum.png");
        }
        else if (kind == ElementKind.EVENT) {
            img = ImageUtilities.loadImage(ICON_BASE + "event.png");
        }
        else if (kind == ElementKind.FUNCTION) {
            img = ImageUtilities.loadImage(ICON_BASE + "function.png");
        }
        else if (kind == ElementKind.REPLICATION) {
            img = ImageUtilities.loadImage(ICON_BASE + "replication.png");
        }
        else if (kind == ElementKind.STATE) {
            img = ImageUtilities.loadImage(ICON_BASE + "state.png");
        }
        else if (kind == ElementKind.STATEDEFAULTPROPERTIES) {
            img = ImageUtilities.loadImage(ICON_BASE + "statedefaultproperties.png");
        }
        else if (kind == ElementKind.STRUCT) {
            img = ImageUtilities.loadImage(ICON_BASE + "struct.png");
        }
        else if (kind == ElementKind.VAR) {
            img = ImageUtilities.loadImage(ICON_BASE + "var.png");
        }
        else {
            img = super.getIcon(type);
        }

        return img;
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }

    @Override
    public java.lang.String getDisplayName() {
        if (description.name != null) {
            return description.name;
        }
        //if (description.fileObject != null) {
        //    return description.fileObject.getNameExt();
        //}
        return null;
    }

    @Override
    public String getHtmlDisplayName() {
        //return description.htmlHeader;
        return getDisplayName();
    }

    public Description getDescritption() {
        return description;
    }

    static synchronized Node getWaitNode() {
        if (WAIT_NODE == null) {
            WAIT_NODE = new WaitNode();
        }
        return WAIT_NODE;
    }

    /*static synchronized Node getWaitNode() {
        Description d2 = new Description("functionname", ElementKind.FUNCTION, null);
        List<Description> subs = new ArrayList<Description>();
        subs.add(d2);
        Description d1 = new Description("classname", ElementKind.CLASS, subs);
        ElementNode n1 = new ElementNode(d1);
        return n1;
    }*/

    public void refreshRecursively() {
        Children ch = getChildren();
        if (ch instanceof ElementChildren) {
            ((ElementChildren) ch).resetKeys(description.subs);
            for (Node sub : ch.getNodes()) {
                ((ElementNode) sub).refreshRecursively();
            }
        }
        return;
    }

    public void updateRecursively(Description newDescription) {
        Children ch = getChildren();
        if (ch instanceof ElementChildren) {
            HashSet<Description> oldSubs = new HashSet<Description>(description.subs);


            // Create a hashtable which maps Description to node.
            // We will then identify the nodes by the description. The trick is
            // that the new and old description are equal and have the same hashcode
            Node[] nodes = ch.getNodes(true);
            HashMap<Description, ElementNode> oldD2node = new HashMap<Description, ElementNode>();
            for (Node node : nodes) {
                oldD2node.put(((ElementNode) node).description, (ElementNode) node);
            }

            // Now refresh keys
            ((ElementChildren) ch).resetKeys(newDescription.subs);


            // Reread nodes
            nodes = ch.getNodes(true);

            for (Description newSub : newDescription.subs) {
                ElementNode node = oldD2node.get(newSub);
                if (node != null) { // filtered out
                    //if (!oldSubs.contains(newSub) && node.getChildren() != Children.LEAF) {
                    //    description.ui.expandNode(node); // Make sure new nodes get expanded
                    //}
                    node.updateRecursively(newSub); // update the node recursively
                }
            }
        }

        description = newDescription; // set new descrioption to the new node
    }

    private static final class ElementChildren extends Children.Keys<Description> {

        public ElementChildren(List<Description> descriptions) {
            resetKeys(descriptions);
        }

        @Override
        protected Node[] createNodes(Description key) {
            return new Node[] {new  ElementNode(key)};
        }

        void resetKeys(List<Description> descriptions) {
            setKeys(descriptions);
        }
    }

    private static class WaitNode extends AbstractNode {

        private Image waitIcon =
                ImageUtilities.loadImage(ICON_BASE + "wait.png");

        public WaitNode() {
            super(Children.LEAF);
        }

        @Override
        public Image getIcon(int type) {
            return waitIcon;
        }

        @Override
        public java.lang.String getDisplayName() {
            return NbBundle.getMessage(ElementNode.class, "LBL_WaitNode");
        }
    }

    public static enum ElementKind {
        CLASS,
        VAR,
        ENUM,
        STRUCT,
        CONST,
        REPLICATION,
        STATE,
        STATEDEFAULTPROPERTIES,
        FUNCTION,
        EVENT,
        DEFAULTPROPERTIES
    }

    public static class Description {

        final String name;
        final ElementKind kind;
        List<Description> subs;

        public Description() {
            this.name = null;
            this.kind = null;
            this.subs = null;
        }

        public Description(String name,
                           ElementKind kind,
                           List<Description> subs) {
            this.name = name;
            this.kind = kind;
            this.subs = subs;
        }

        @Override
        public boolean equals(Object object) {

            if ( object == null ) {
                return false;
            }

            if (object instanceof Description) {

                Description d = (Description)object;
                if (name.equals(d.name) && (kind == d.kind) ) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
            hash = 79 * hash + (this.kind != null ? this.kind.hashCode() : 0);
            return hash;
        }
    }
}
