/* Borderlayout.java

 {{IS_NOTE
 Purpose:
 
 Description:
 
 History:
 Aug 27, 2007 3:34:53 PM , Created by jumperchen
 }}IS_NOTE

 Copyright (C) 2007 Potix Corporation. All Rights Reserved.

 {{IS_RIGHT
 This program is distributed under GPL Version 2.0 in the hope that
 it will be useful, but WITHOUT ANY WARRANTY.
 }}IS_RIGHT
 */
package org.zkoss.zkex.zul;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.ext.render.ChildChangedAware;
import org.zkoss.zul.impl.XulElement;

/**
 * A border layout lays out a container, arranging and resizing its components
 * to fit in five regions: north, south, east, west, and center. Each region may
 * contain no more than one component, and is identified by a corresponding
 * constant: <code>NORTH</code>, <code>SOUTH</code>, <code>EAST</code>,
 * <code>WEST</code>, and <code>CENTER</code>. When adding a component to
 * a container with a border layout, use one of these five constants, for
 * example:
 * 
 * <pre>
 *  &lt;borderlayout&gt;
 *  &lt;north margins=&quot;1,5,1,1&quot; size=&quot;20%&quot; splittable=&quot;true&quot; collapsible=&quot;true&quot; minsize=&quot;100&quot; maxsize=&quot;400&quot;&gt;
 *  &lt;div&gt;
 *  North
 *  &lt;/div&gt;
 *  &lt;/north&gt;
 *  &lt;west size=&quot;25%&quot; splittable=&quot;true&quot; autoscroll=&quot;true&quot;&gt;
 *  &lt;div&gt;
 *  West
 *  &lt;/div&gt;
 *  &lt;/west&gt;
 *  &lt;center flex=&quot;true&quot;&gt;
 *  &lt;div&gt;
 *  Center
 *  &lt;/div&gt;
 *  &lt;/center&gt;
 *  &lt;east size=&quot;25%&quot; collapsible=&quot;true&quot; onOpen='alert(self.id + &quot; is open :&quot; +event.open)'&gt;
 *  &lt;div&gt;
 *  East
 *  &lt;/div&gt;
 *  &lt;/east&gt;
 *  &lt;south size=&quot;50%&quot; splittable=&quot;true&quot;&gt;
 *  &lt;div&gt;
 *  south
 *  &lt;/div&gt;
 *  &lt;/south&gt;
 *  &lt;/borderlayout&gt;
 * 
 * </pre>
 * 
 * The default class of CSS is specified "layout-container".
 * 
 * @author jumperchen
 * @since 3.0.0
 */
public class Borderlayout extends HtmlBasedComponent {

	/**
	 * The north layout constraint (top of container).
	 */
	public static final String NORTH = "north";

	/**
	 * The south layout constraint (bottom of container).
	 */
	public static final String SOUTH = "south";

	/**
	 * The east layout constraint (right side of container).
	 */
	public static final String EAST = "east";

	/**
	 * The west layout constraint (left side of container).
	 */
	public static final String WEST = "west";

	/**
	 * The center layout constraint (middle of container).
	 */
	public static final String CENTER = "center";

	private North _north;

	private South _south;

	private West _west;

	private East _east;

	private Center _center;

	public Borderlayout() {
		setClass("layout-container");
	}

	public North getNorth() {
		return _north;
	}

	public South getSouth() {
		return _south;
	}

	public West getWest() {
		return _west;
	}

	public East getEast() {
		return _east;
	}

	public Center getCenter() {
		return _center;
	}

	/**
	 * Re-size this layout component.
	 */
	public void resize() {
		smartUpdate("z.resize", "");
	}

	public boolean insertBefore(Component child, Component insertBefore) {
		if (!(child instanceof LayoutRegion))
			throw new UiException("Unsupported child for Borderlayout: "
					+ child);
		if (child instanceof North) {
			if (_north != null && child != _north)
				throw new UiException("Only one north child is allowed: "
						+ this);
			_north = (North) child;
		} else if (child instanceof South) {
			if (_south != null && child != _south)
				throw new UiException("Only one south child is allowed: "
						+ this);
			_south = (South) child;
		} else if (child instanceof West) {
			if (_west != null && child != _west)
				throw new UiException("Only one west child is allowed: " + this);
			_west = (West) child;
		} else if (child instanceof East) {
			if (_east != null && child != _east)
				throw new UiException("Only one east child is allowed: " + this);
			_east = (East) child;
		} else if (child instanceof Center) {
			if (_center != null && child != _center)
				throw new UiException("Only one center child is allowed: "
						+ this);
			_center = (Center) child;
		}
		return super.insertBefore(child, insertBefore);
	}

	// -- ComponentCtrl --//
	protected Object newExtraCtrl() {
		return new ExtraCtrl();
	}

	/**
	 * A utility class to implement {@link #getExtraCtrl}. It is used only by
	 * component developers.
	 */
	protected class ExtraCtrl extends XulElement.ExtraCtrl implements
			ChildChangedAware {

		public boolean isChildChangedAware() {
			return true;
		}
	}
}
