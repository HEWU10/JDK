/*
 * @(#)MultiTextUI.java	1.30 00/02/02
 *
 * Copyright 1997-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */
package javax.swing.plaf.multi;

import java.util.Vector;
import javax.swing.plaf.TextUI;
import java.awt.Rectangle;
import javax.swing.text.JTextComponent;
import javax.swing.text.BadLocationException;
import java.awt.Point;
import javax.swing.text.EditorKit;
import javax.swing.text.Position;
import javax.swing.text.View;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.accessibility.Accessible;

/**
 * MultiTextUI implementation
 *
 * <p>This file was automatically generated by AutoMulti.
 *
 * @version 1.30 02/02/00 18:15:48
 * @author  Otto Multey
 */
public class MultiTextUI extends TextUI {

    /**
     * The Vector containing the real UI's.  This is populated
     * in the call to createUI, and can be obtained by calling
     * getUIs.  The first element is guaranteed to the real UI
     * obtained from the default look and feel.
     */
    protected Vector uis = new Vector();

////////////////////
// Common UI methods
////////////////////

    /**
     * Return the list of UI's associated with this multiplexing UI.  This
     * allows processing of the UI's by an application aware of multiplexing
     * UI's on components.
     */
    public ComponentUI[] getUIs() {
        return MultiLookAndFeel.uisToArray(uis);
    }

////////////////////
// TextUI methods
////////////////////

    /**
     * Call modelToView on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public Rectangle modelToView(JTextComponent a, int b)
            throws BadLocationException {
        Rectangle returnValue =
            ((TextUI) (uis.elementAt(0))).modelToView(a,b);
        for (int i = 1; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).modelToView(a,b);
        }
        return returnValue;
    }

    /**
     * Converts the given location in the model to a place in
     * the view coordinate system.
     *
     * @param pos  the local location in the model to translate >= 0
     * @return the coordinates as a rectangle
     * @exception BadLocationException  if the given position does not
     *   represent a valid location in the associated document
     */
    public Rectangle modelToView(JTextComponent t, int pos, Position.Bias bias)
        throws BadLocationException {
        Rectangle returnValue =
            ((TextUI) (uis.elementAt(0))).modelToView(t, pos, bias);
        for (int i = 1; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).modelToView(t, pos, bias);
        }
        return returnValue;
    }
    
    /**
     * Call viewToModel on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public int viewToModel(JTextComponent a, Point b) {
        int returnValue =
            ((TextUI) (uis.elementAt(0))).viewToModel(a,b);
        for (int i = 1; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).viewToModel(a,b);
        }
        return returnValue;
    }
    /**
     * Provides a mapping from the view coordinate space to the logical
     * coordinate space of the model.  The biasReturn argument will be
     * filled in to indicate that the point given is closer to the next
     * character in the model or the previous character in the model.
     *
     * @param x the X coordinate >= 0
     * @param y the Y coordinate >= 0
     * @param a the allocated region to render into
     * @return the location within the model that best represents the
     *  given point in the view >= 0.  The biasReturn argument will be
     * filled in to indicate that the point given is closer to the next
     * character in the model or the previous character in the model.
     */
    public int viewToModel(JTextComponent t, Point pt,
                           Position.Bias[] biasReturn) {
        int returnValue =
            ((TextUI) (uis.elementAt(0))).viewToModel(t, pt, biasReturn);
        for (int i = 1; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).viewToModel(t, pt, biasReturn);
        }
        return returnValue;
    }

    /**
     * Provides a way to determine the next visually represented model 
     * location that one might place a caret.  Some views may not be visible,
     * they might not be in the same order found in the model, or they just
     * might not allow access to some of the locations in the model.
     *
     * @param pos the position to convert >= 0
     * @param a the allocated region to render into
     * @param direction the direction from the current position that can
     *  be thought of as the arrow keys typically found on a keyboard.
     *  This may be SwingConstants.WEST, SwingConstants.EAST, 
     *  SwingConstants.NORTH, or SwingConstants.SOUTH.  
     * @return the location within the model that best represents the next
     *  location visual position.
     * @exception BadLocationException
     * @exception IllegalArgumentException for an invalid direction
     */
    public int getNextVisualPositionFrom(JTextComponent t, int pos,
                                         Position.Bias b, int direction,
                                         Position.Bias[] biasRet)
        throws BadLocationException {
        int returnValue =
            ((TextUI) (uis.elementAt(0))).getNextVisualPositionFrom(t, pos, b, direction, biasRet);
        for (int i = 1; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).getNextVisualPositionFrom(t, pos, b, direction, biasRet);
        }
        return returnValue;
    }

    /**
     * Call damageRange on each UI handled by this MultiUI.
     */
    public void damageRange(JTextComponent a, int b, int c) {
        for (int i = 0; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).damageRange(a,b,c);
        }
    }

    /**
     * Causes the portion of the view responsible for the 
     * given part of the model to be repainted.
     *
     * @param p0 the beginning of the range >= 0
     * @param p1 the end of the range >= p0
     */
    public void damageRange(JTextComponent t, int p0, int p1,
                            Position.Bias firstBias,
                            Position.Bias secondBias) {
        for (int i = 0; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).damageRange(t, p0, p1,
						      firstBias,
						      secondBias);
	}
    }

    /**
     * Call getEditorKit on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public EditorKit getEditorKit(JTextComponent a) {
        EditorKit returnValue =
            ((TextUI) (uis.elementAt(0))).getEditorKit(a);
        for (int i = 1; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).getEditorKit(a);
        }
        return returnValue;
    }

    /**
     * Call getRootView on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public View getRootView(JTextComponent a) {
        View returnValue =
            ((TextUI) (uis.elementAt(0))).getRootView(a);
        for (int i = 1; i < uis.size(); i++) {
            ((TextUI) (uis.elementAt(i))).getRootView(a);
        }
        return returnValue;
    }

////////////////////
// ComponentUI methods
////////////////////

    /**
     * Call installUI on each UI handled by this MultiUI.
     */
    public void installUI(JComponent a) {
        for (int i = 0; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).installUI(a);
        }
    }

    /**
     * Call uninstallUI on each UI handled by this MultiUI.
     */
    public void uninstallUI(JComponent a) {
        for (int i = 0; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).uninstallUI(a);
        }
    }

    /**
     * Call paint on each UI handled by this MultiUI.
     */
    public void paint(Graphics a, JComponent b) {
        for (int i = 0; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).paint(a,b);
        }
    }

    /**
     * Call update on each UI handled by this MultiUI.
     */
    public void update(Graphics a, JComponent b) {
        for (int i = 0; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).update(a,b);
        }
    }

    /**
     * Call getPreferredSize on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public Dimension getPreferredSize(JComponent a) {
        Dimension returnValue =
            ((ComponentUI) (uis.elementAt(0))).getPreferredSize(a);
        for (int i = 1; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).getPreferredSize(a);
        }
        return returnValue;
    }

    /**
     * Call getMinimumSize on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public Dimension getMinimumSize(JComponent a) {
        Dimension returnValue =
            ((ComponentUI) (uis.elementAt(0))).getMinimumSize(a);
        for (int i = 1; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).getMinimumSize(a);
        }
        return returnValue;
    }

    /**
     * Call getMaximumSize on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public Dimension getMaximumSize(JComponent a) {
        Dimension returnValue =
            ((ComponentUI) (uis.elementAt(0))).getMaximumSize(a);
        for (int i = 1; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).getMaximumSize(a);
        }
        return returnValue;
    }

    /**
     * Call contains on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public boolean contains(JComponent a, int b, int c) {
        boolean returnValue =
            ((ComponentUI) (uis.elementAt(0))).contains(a,b,c);
        for (int i = 1; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).contains(a,b,c);
        }
        return returnValue;
    }

    /**
     * Return a multiplexing UI instance if any of the auxiliary
     * LookAndFeels support this UI.  Otherwise, just return a
     * UI obtained using the normal methods.
     */
    public static ComponentUI createUI(JComponent a) {
        ComponentUI mui = new MultiTextUI();
        return MultiLookAndFeel.createUIs(mui,
                                          ((MultiTextUI) mui).uis,
                                          a);
    }

    /**
     * Call getAccessibleChildrenCount on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public int getAccessibleChildrenCount(JComponent a) {
        int returnValue =
            ((ComponentUI) (uis.elementAt(0))).getAccessibleChildrenCount(a);
        for (int i = 1; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).getAccessibleChildrenCount(a);
        }
        return returnValue;
    }

    /**
     * Call getAccessibleChild on each UI handled by this MultiUI.
     * Return only the value obtained from the first UI, which is
     * the UI obtained from the default LookAndFeel.
     */
    public Accessible getAccessibleChild(JComponent a, int b) {
        Accessible returnValue =
            ((ComponentUI) (uis.elementAt(0))).getAccessibleChild(a,b);
        for (int i = 1; i < uis.size(); i++) {
            ((ComponentUI) (uis.elementAt(i))).getAccessibleChild(a,b);
        }
        return returnValue;
    }
}
