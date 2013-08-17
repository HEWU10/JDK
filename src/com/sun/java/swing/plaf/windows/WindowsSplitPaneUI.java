/*
 * @(#)WindowsSplitPaneUI.java	1.11 00/02/02
 *
 * Copyright 1997-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */

package com.sun.java.swing.plaf.windows;

import javax.swing.plaf.basic.*;
import javax.swing.*;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.*;


/**
 * Windows rendition of the component.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases.  The current serialization support is appropriate
 * for short term storage or RMI between applications running the same
 * version of Swing.  A future release of Swing will provide support for
 * long term persistence.
 */
public class WindowsSplitPaneUI extends BasicSplitPaneUI
{

    public WindowsSplitPaneUI() {
	super();
    }

    /**
      * Creates a new WindowsSplitPaneUI instance
      */
    public static ComponentUI createUI(JComponent x) {
	return new WindowsSplitPaneUI();
    }

    /**
      * Creates the default divider.
      */
    public BasicSplitPaneDivider createDefaultDivider() {
	return new WindowsSplitPaneDivider(this);
    }

}

