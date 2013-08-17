/*
 * @(#)IDLType.java	1.18 00/02/02
 *
 * Copyright 1997-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */
/*
 * File: ./org/omg/CORBA/IDLType.java
 * From: ./ir.idl
 * Date: Fri Aug 28 16:03:31 1998
 *   By: idltojava Java IDL 1.2 Aug 11 1998 02:00:18
 */

package org.omg.CORBA;
/**
* tempout/org/omg/CORBA/IDLType.java
* Generated by the IBM IDL-to-Java compiler, version 1.0
* from ../../Lib/ir.idl
* Thursday, February 25, 1999 2:11:23 o'clock PM PST
*/

/**
  * An abstract interface inherited by all Interface Repository
  * (IR) objects that represent OMG IDL types. It provides access
  * to the <code>TypeCode</code> object describing the type and is used in defining the
  * other interfaces wherever definitions of <code>IDLType</code> must be referenced.
  */

public interface IDLType extends IDLTypeOperations, org.omg.CORBA.IRObject, org.omg.CORBA.portable.IDLEntity 
{
} // interface IDLType



