/* TreefootDefault.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Sep 7, 2007 8:18:51 AM , Created by robbiecheng
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 3.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zkmax.zul.render;

import java.io.IOException;
import java.io.Writer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.render.ComponentRenderer;
import org.zkoss.zk.ui.render.SmartWriter;
import org.zkoss.zul.Treefoot;

/**
 * {@link Treefoot}'s default mold.
 * 
 * @author robbiecheng
 * 
 * @since 3.0.0
 */
public class TreefootDefault implements ComponentRenderer {
	public void render(Component comp, Writer out) throws IOException {
		final SmartWriter wh = new SmartWriter(out);
		final Treefoot self = (Treefoot) comp;
		
		wh.write("<tr id=\"").write(self.getUuid()).write('"')
			.write(self.getOuterAttrs()).write(self.getInnerAttrs()).write(" z.type=\"zul.zul.Ftrs\">")
			.writeChildren(self)
			.writeln("</tr>");
	}
}
