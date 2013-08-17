/*
 * @(#)AlreadyBoundHelper.java	1.10 00/02/02
 *
 * Copyright 1997-2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */
/*
 * File: ./org/omg/CosNaming/NamingContextPackage/AlreadyBoundHelper.java
 * From: nameservice.idl
 * Date: Tue Aug 11 03:12:09 1998
 *   By: idltojava Java IDL 1.2 Aug 11 1998 02:00:18
 */

package org.omg.CosNaming.NamingContextPackage;
public class AlreadyBoundHelper {
    // It is useless to have instances of this class
    private AlreadyBoundHelper() { }

    public static void write(org.omg.CORBA.portable.OutputStream out, org.omg.CosNaming.NamingContextPackage.AlreadyBound that) {
	out.write_string(id());
    }
    public static org.omg.CosNaming.NamingContextPackage.AlreadyBound read(org.omg.CORBA.portable.InputStream in) {
        org.omg.CosNaming.NamingContextPackage.AlreadyBound that = new org.omg.CosNaming.NamingContextPackage.AlreadyBound();
	// read and discard the repository id
        in.read_string();
	return that;
    }
    public static org.omg.CosNaming.NamingContextPackage.AlreadyBound extract(org.omg.CORBA.Any a) {
	org.omg.CORBA.portable.InputStream in = a.create_input_stream();
	return read(in);
    }
    public static void insert(org.omg.CORBA.Any a, org.omg.CosNaming.NamingContextPackage.AlreadyBound that) {
	org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
	write(out, that);
	a.read_value(out.create_input_stream(), type());
    }
    private static org.omg.CORBA.TypeCode _tc;
    synchronized public static org.omg.CORBA.TypeCode type() {
	int _memberCount = 0;
	org.omg.CORBA.StructMember[] _members = null;
	if (_tc == null) {
	    _members= new org.omg.CORBA.StructMember[0];
	    _tc = org.omg.CORBA.ORB.init().create_exception_tc(id(), "AlreadyBound", _members);
	}
	return _tc;
    }
    public static String id() {
	return "IDL:omg.org/CosNaming/NamingContext/AlreadyBound:1.0";
    }
}
