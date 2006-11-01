/* StyleSheet.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Jun  2 12:32:59     2005, Created by tomyeh
}}IS_NOTE

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.web.servlet;

import org.zkoss.lang.Objects;

/**
 * Represents a style sheet.
 *
 * @author tomyeh
 */
public class StyleSheet implements java.io.Serializable, Cloneable {
    private static final long serialVersionUID = 20060622L;

	private final String _href, _type, _content;
	/** Creates by specifying the file to contain the style sheets.
	 *
	 * @param href URI of the file containing the style sheets.
	 * @param type the type. If null, "text/css" is assumed.
	 */
	public StyleSheet(String href, String type) {
		this(href, type, false);
	}
	/** Creates by assigning the content (style sheets).
	 *
	 * @param content the style content or an URI to an external file.
	 * @param type the type. If null, "text/css" is assumed.
	 * @param byContent the content argument is the style content, or
	 * an URI to an external content
	 */
	public StyleSheet(String content, String type, boolean byContent) {
		if (content == null)
			throw new IllegalArgumentException("null content");

		if (byContent) {
			_href = null;
			_content = content;
		} else {
			_href = content;
			_content = null;
		}
		_type = type != null && type.length() != 0 ? type: "text/css";
	}

	/** Returns the href that contains the style sheets, or null if
	 * {@link #getContent} is not null.
	 */
	public String getHref() {
		return _href;
	}
	/** Returns the type. */
	public String getType() {
		return _type;
	}
	/** Returns the style sheets, or null if {@link #getHref} is not null.
	 */
	public String getContent() {
		return _content;
	}

	//-- cloneable --//
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	//-- Object --//
	public String toString() {
		return "[href: "+_href+" type="+_type+']';
	}
	public int hashCode() {
		return _href.hashCode() + _type.hashCode();
	}
	public boolean equals(Object o) {
		if (!(o instanceof StyleSheet))
			return false;
		final StyleSheet ss = (StyleSheet)o;
		return Objects.equals(ss._href, _href)
			&& Objects.equals(ss._type, _type)
			&& Objects.equals(ss._content, _content);
	}
}
