/*
 * @(#)ResourceLoader.java	1.3 00/02/02
 *
 * Copyright 1998-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */

package javax.swing.text.html.parser;

import java.io.InputStream;

/**
 * Simple class to load resources using the 1.2
 * security model.  Since the html support is loaded
 * lazily, it's resources are potentially fetched with
 * applet code in the call stack.  By providing this 
 * functionality in a class that is only built on 1.2,
 * reflection can be used from the code that is also
 * built on 1.1 to call this functionality (and avoid
 * the evils of preprocessing).  This functionality
 * is called from ParserDelegator.getResourceAsStream.
 *
 * @author  Timothy Prinzing
 * @version 1.3 02/02/00
 */
class ResourceLoader implements java.security.PrivilegedAction {

    ResourceLoader(String name) {
	this.name = name;
    }

    public Object run() {
	Object o = ParserDelegator.class.getResourceAsStream(name);
	return o;
    }

    public static InputStream getResourceAsStream(String name) {
	java.security.PrivilegedAction a = new ResourceLoader(name);
        return (InputStream) java.security.AccessController.doPrivileged(a);
    }

    private String name;
}
