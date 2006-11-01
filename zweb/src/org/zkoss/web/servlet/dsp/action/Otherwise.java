/* Otherwise.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Sep  6 15:33:38     2005, Created by tomyeh
}}IS_NOTE

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.web.servlet.dsp.action;

import java.io.IOException;

import org.zkoss.web.mesg.MWeb;
import org.zkoss.web.servlet.ServletException;

/**
 * Represents the last alternative within a {@link Choose} action.
 *
 * @author tomyeh
 */
public class Otherwise extends AbstractAction {
	//-- Action --//
	public void render(ActionContext ac, boolean nested)
	throws javax.servlet.ServletException, IOException {
		if (!nested && !isEffective())
			return;

		final Action parent = ac.getParent();
		if (!(parent instanceof Choose))
			throw new ServletException("The parent of otherwise must be choose");
		final Choose choose = (Choose)parent;
		if (!choose.isMatched())
			ac.renderFragment(null);
	}

	//-- Object --//
	public String toString() {
		return "otherwise";
	}
}
