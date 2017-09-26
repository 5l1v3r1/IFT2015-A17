/*
 * Copyright (c) 2017, Mikl&oacute;s Cs&#369;r&ouml;s
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package lindenmayer;

import java.awt.geom.Point2D;
/**
 * Turtle graphics interface. The turtle state is defined as its 
 * location on the plane and the orientation of its nose. 
 * Implementing classes are expected to initialize 
 * the turtle with position (0,0) and angle 0 by default.
 * The turtle moves and draws by unit-length steps, and turns left or right by a unit angle
 * (e.g., 30), which are set in {@link #setUnits(double, double) }. 
 * 
 * 
 * @author Mikl&oacute;s Cs&#369;r&ouml;s
 */
public interface Turtle
{
    /**
     * Draws a line of unit length
     */
    public void draw();
    /**
     * Moves by unit length, no drawing. 
     */
    public void move();
    /**
     * Turn right (clockwise) by unit angle.
     */
    public void turnR();
    /**
     * Turn left (counter-clockwise) by unit angle.
     */
    public void turnL();
    /**
     * Saves turtle state
     */
    public void push();
    /**
     * Recovers turtle state
     */
    public void pop();
    /**
     * Lets the turtle relax. 
     */
    public void stay();
    /**
     * initializes the turtle state (and clears the state stack)
     * @param pos turtle position
     * @param angle_deg angle in degrees (90=up, 0=right)
     */
    public void init(Point2D pos, double angle_deg);
    /**
     * position of the turtle
     * @return position as a 2D point
     */
    /**
     * Turtle position 
     * 
     * @return location of the turtle on the plane
     */
    public Point2D getPosition();
    /**
     * angle of the turtle's nose
     * @return angle in degrees
     */
    public double getAngle();
    /**
     * sets the unit step and unit angle
     * 
     * @param step length of an advance (move or draw)
     * @param delta unit angle change in degrees (for turnR and turnL)
     */
    public void setUnits(double step, double delta);
}    
