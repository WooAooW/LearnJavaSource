/*
 * Copyright (c) 1997, 2003, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package java.awt.dnd;

import java.awt.Point;

import java.util.EventObject;

/**
 * This class is the base class for
 * <code>DragSourceDragEvent</code> and
 * <code>DragSourceDropEvent</code>.
 * <p>
 * <code>DragSourceEvent</code>s are generated whenever the drag enters, moves
 * over, or exits a drop site, when the drop action changes, and when the drag
 * ends. The location for the generated <code>DragSourceEvent</code> specifies
 * the mouse cursor location in screen coordinates at the moment this event
 * occurred.
 * <p>
 * In a multi-screen environment without a virtual device, the cursor location is
 * specified in the coordinate system of the <i>initiator</i>
 * <code>GraphicsConfiguration</code>. The <i>initiator</i>
 * <code>GraphicsConfiguration</code> is the <code>GraphicsConfiguration</code>
 * of the <code>Component</code> on which the drag gesture for the current drag
 * operation was recognized. If the cursor location is outside the bounds of
 * the initiator <code>GraphicsConfiguration</code>, the reported coordinates are
 * clipped to fit within the bounds of that <code>GraphicsConfiguration</code>.
 * <p>
 * In a multi-screen environment with a virtual device, the location is specified
 * in the corresponding virtual coordinate system. If the cursor location is
 * outside the bounds of the virtual device the reported coordinates are
 * clipped to fit within the bounds of the virtual device.
 *
 * @since 1.2
 */

public class DragSourceEvent extends EventObject {

    private static final long serialVersionUID = -763287114604032641L;

    /**
     * The <code>boolean</code> indicating whether the cursor location
     * is specified for this event.
     *
     * @serial
     */
    private final boolean locationSpecified;

    /**
     * The horizontal coordinate for the cursor location at the moment this
     * event occurred if the cursor location is specified for this event;
     * otherwise zero.
     *
     * @serial
     */
    private final int x;

    /**
     * The vertical coordinate for the cursor location at the moment this event
     * occurred if the cursor location is specified for this event;
     * otherwise zero.
     *
     * @serial
     */
    private final int y;

    /**
     * Construct a <code>DragSourceEvent</code>
     * given a specified <code>DragSourceContext</code>.
     * The coordinates for this <code>DragSourceEvent</code>
     * are not specified, so <code>getLocation</code> will return
     * <code>null</code> for this event.
     *
     * @param dsc the <code>DragSourceContext</code>
     *
     * @throws <code>IllegalArgumentException</code> if <code>dsc</code> is <code>null</code>.
     *
     * @see #getLocation
     */

    public DragSourceEvent(DragSourceContext dsc) {
        super(dsc);
        locationSpecified = false;
        this.x = 0;
        this.y = 0;
    }

    /**
     * Construct a <code>DragSourceEvent</code> given a specified
     * <code>DragSourceContext</code>, and coordinates of the cursor
     * location.
     *
     * @param dsc the <code>DragSourceContext</code>
     * @param x   the horizontal coordinate for the cursor location
     * @param y   the vertical coordinate for the cursor location
     *
     * @throws <code>IllegalArgumentException</code> if <code>dsc</code> is <code>null</code>.
     *
     * @since 1.4
     */
    public DragSourceEvent(DragSourceContext dsc, int x, int y) {
        super(dsc);
        locationSpecified = true;
        this.x = x;
        this.y = y;
    }

    /**
     * This method returns the <code>DragSourceContext</code> that
     * originated the event.
     * <P>
     * @return the <code>DragSourceContext</code> that originated the event
     */

    public DragSourceContext getDragSourceContext() {
        return (DragSourceContext)getSource();
    }

    /**
     * This method returns a <code>Point</code> indicating the cursor
     * location in screen coordinates at the moment this event occurred, or
     * <code>null</code> if the cursor location is not specified for this
     * event.
     *
     * @return the <code>Point</code> indicating the cursor location
     *         or <code>null</code> if the cursor location is not specified
     * @since 1.4
     */
    public Point getLocation() {
        if (locationSpecified) {
            return new Point(x, y);
        } else {
            return null;
        }
    }

    /**
     * This method returns the horizontal coordinate of the cursor location in
     * screen coordinates at the moment this event occurred, or zero if the
     * cursor location is not specified for this event.
     *
     * @return an integer indicating the horizontal coordinate of the cursor
     *         location or zero if the cursor location is not specified
     * @since 1.4
     */
    public int getX() {
        return x;
    }

    /**
     * This method returns the vertical coordinate of the cursor location in
     * screen coordinates at the moment this event occurred, or zero if the
     * cursor location is not specified for this event.
     *
     * @return an integer indicating the vertical coordinate of the cursor
     *         location or zero if the cursor location is not specified
     * @since 1.4
     */
    public int getY() {
        return y;
    }
}