/*
 * @(#)AnySeqHelper.java	1.6 00/02/02
 *
 * Copyright 1999, 2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */
package org.omg.CORBA;


/**
* org/omg/CORBA/AnySeqHelper.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from streams.idl
* 13 May 1999 22:41:36 o'clock GMT+00:00
*/

public final class AnySeqHelper
{
    private static String  _id = "IDL:omg.org/CORBA/AnySeq:1.0";

    public AnySeqHelper()
    {
    }

    public static void insert (org.omg.CORBA.Any a, org.omg.CORBA.Any[] that)
    {
	org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
	a.type (type ());
	write (out, that);
	a.read_value (out.create_input_stream (), type ());
    }

    public static org.omg.CORBA.Any[] extract (org.omg.CORBA.Any a)
    {
	return read (a.create_input_stream ());
    }

    private static org.omg.CORBA.TypeCode __typeCode = null;
    synchronized public static org.omg.CORBA.TypeCode type ()
    {
	if (__typeCode == null)
	    {
		__typeCode = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_any);
		__typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
		__typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (org.omg.CORBA.AnySeqHelper.id (), "AnySeq", __typeCode);
	    }
	return __typeCode;
    }

    public static String id ()
    {
	return _id;
    }

    public static org.omg.CORBA.Any[] read (org.omg.CORBA.portable.InputStream istream)
    {
	org.omg.CORBA.Any value[] = null;
	int _len0 = istream.read_long ();
	value = new org.omg.CORBA.Any[_len0];
	for (int _o1 = 0;_o1 < value.length; ++_o1)
	    value[_o1] = istream.read_any ();
	return value;
    }

    public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.CORBA.Any[] value)
    {
	ostream.write_long (value.length);
	for (int _i0 = 0;_i0 < value.length; ++_i0)
	    ostream.write_any (value[_i0]);
    }

}
