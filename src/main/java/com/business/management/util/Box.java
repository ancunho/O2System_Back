package com.business.management.util;

import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */
public class Box extends Hashtable {

    protected String name = null;

    public Box(String name) {
        super();
        this.name = name;
    }

    public Object clone() {

        Box newbox = new Box(name);

        Hashtable src = (Hashtable)this;
        Hashtable target = (Hashtable)newbox;

        Enumeration e = src.keys();
        while(e.hasMoreElements()) {
            String key = (String) e.nextElement();
            Object value =  src.get(key);
            target.put(key,value);
        }
        return newbox;
    }

    public void copyToEntity(Object entity) {
        if ( entity == null )
            throw new NullPointerException("trying to copy from box to null entity class");

        Class c = entity.getClass();
        java.lang.reflect.Field[] field = c.getDeclaredFields();
        for (int i=0 ; i<field.length; i++) {
            try {
                field[i].setAccessible(true);
                String fieldtype = field[i].getType().getName();
                String fieldname = field[i].getName();

                if ( containsKey( fieldname ) ) {
                    if ( fieldtype.equals("java.lang.String")) {
                        field[i].set(entity, getString(fieldname));
                    }
                    else if ( fieldtype.equals("int")) {
                        field[i].setInt(entity, getInt(fieldname));
                    }
                    else if ( fieldtype.equals("double")) {
                        field[i].setDouble(entity, getDouble(fieldname));
                    }
                    else if ( fieldtype.equals("long")) {
                        field[i].setLong(entity, getLong(fieldname));
                    }
                    else if ( fieldtype.equals("float")) {
                        field[i].set(entity, new Float(getDouble(fieldname)));
                    }
                    else if ( fieldtype.equals("boolean")) {
                        field[i].setBoolean(entity, getBoolean(fieldname));
                    }
                }
            }
            catch(Exception e){
                //Debug.warn.println(this, e.getMessage());
            }

            field[i].setAccessible(false);
        }
    }

    public String get(String key) {
        return getString(key);
    }

    public boolean getBoolean(String key) {
        String value = getString(key);
        boolean isTrue = false;
        try {
            isTrue = (new Boolean(value)).booleanValue();
        }
        catch(Exception e){}
        return isTrue;
    }

    public double getDouble(String key) {
        String value = removeComma(getString(key));
        if ( value.equals("") ) return 0;
        double num = 0;
        try {
            num = Double.valueOf(value).doubleValue();
        }
        catch(Exception e) {
            num = 0;
        }
        return num;
    }

    public double getFloat(String key) {
        return (float)getDouble(key);
    }

    public int getInt(String key) {
        double value = getDouble(key);
        return (int)value;
    }

    public long getLong(String key) {
        String value = removeComma(getString(key));
        if ( value.equals("") ) return 0L;

        long lvalue = 0L;
        try {
            lvalue = Long.valueOf(value).longValue();
        }
        catch(Exception e) {
            lvalue = 0L;
        }

        return lvalue;
    }

    public String getString(String key) {
        String value = null;
        try {
            Object o = (Object)super.get(key);
            Class c = o.getClass();
            if ( o == null ) value = "";
            else if( c.isArray() ) {
                int length = Array.getLength(o);
                if ( length == 0 ) value = "";
                else {
                    Object item = Array.get(o, 0);
                    if ( item == null ) value = "";
                    else value = item.toString();
                }
            }
            else 	value = o.toString();
        }
        catch(Exception e) {
            value = "";
        }
        return value;
    }

    public Vector getVector(String key) {
        Vector vector = new Vector();
        try {
            Object o = (Object)super.get(key);
            Class c = o.getClass();
            if ( o != null ) {
                if( c.isArray() ) {
                    int length = Array.getLength(o);
                    if ( length != 0 ) {
                        for(int i=0; i<length;i++) {
                            Object tiem = Array.get(o, i);
                            if (tiem == null ) vector.addElement("");
                            else vector.addElement(tiem.toString());
                        }
                    }
                }
                else
                    vector.addElement(o.toString());
            }
        }
        catch(Exception e) {}
        return vector;
    }

    public void put(String key, String value) {
        super.put(key, value);
    }

    private static String removeComma(String s) {
        if ( s == null ) return null;
        if ( s.indexOf(",") != -1 ) {
            StringBuffer buf = new StringBuffer();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if ( c != ',') buf.append(c);
            }
            return buf.toString();
        }
        return s;
    }

    public synchronized String toString() {
        int max = size() - 1;
        StringBuffer buf = new StringBuffer();
        Enumeration keys = keys();
        Enumeration objects = elements();
        buf.append("{");

        for (int i = 0; i <= max; i++) {
            String key = keys.nextElement().toString();
            String value = null;
            Object o = objects.nextElement();
            if ( o == null ) value = "";
            else {
                Class  c = o.getClass();
                if( c.isArray() ) {
                    int length = Array.getLength(o);
                    if ( length == 0 ) 	value = "";
                    else if ( length == 1 ) {
                        Object item = Array.get(o, 0);
                        if ( item == null ) value = "";
                        else value = item.toString();
                    }
                    else {
                        StringBuffer valueBuf = new StringBuffer();
                        valueBuf.append("[");
                        for ( int j=0;j<length;j++) {
                            Object item = Array.get(o, j);
                            if ( item != null ) valueBuf.append(item.toString());
                            if ( j<length-1) valueBuf.append(",");
                        }
                        valueBuf.append("]");
                        value = valueBuf.toString();
                    }
                }
                else
                    value = o.toString();
            }
            buf.append(key + "=" + value);
            if (i < max) buf.append(", ");
        }
        buf.append("}");

        return "Box["+name+"]=" + buf.toString();

    }

}
