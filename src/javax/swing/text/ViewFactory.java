/*
 * @(#)ViewFactory.java	1.15 00/02/02
 *
 * Copyright 1997-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */
package javax.swing.text;

import java.awt.Container;

/**
 * A factory to create a view of some portion of document subject.
 * This is intended to enable customization of how views get 
 * mapped over a document model. 
 *
 * @author  Timothy Prinzing
 * @version 1.15 02/02/00
 */
public interface ViewFactory {

    /**
     * Creates a view from the given structural element of a
     * document.
     *
     * @param elem  the piece of the document to build a view of
     * @return the view
     * @see View
     */
    public View create(Element elem);

}
