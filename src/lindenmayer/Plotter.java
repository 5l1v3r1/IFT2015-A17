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
import java.io.PrintStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * Entry point for drawing L-System in PostScript.
 * Call with command-line arguments: JSON file specifying and number of iterations: 
 * <code>java ... Plotter [-o output.ps] lsystem.json n</code> 
 * 
 * @author Mikl&oacute;s Cs&#369;r&ouml;s
 */
public class Plotter 
{
    private PrintStream out = System.out;
    
    Plotter(LSystem ls, EPSTurtle turtle)
    {
        this.lsystem = ls;
        this.turtle = turtle;
    }
    private LSystem lsystem;
    private EPSTurtle turtle;

    private Plotter()
    {
//        this(new LSystem(), new EPSTurtle());
    }
    
    /**
     * Parses the JSON specification of an L-System. 
     * 
     * @param params
     * @throws Exception if I/O problems or bad JSON
     */
    private void parseLSystem(JSONObject params) throws Exception
    {
        JSONObject system_params = params.getJSONObject("parameters");
        JSONArray init_turtle = system_params.getJSONArray("start");
        turtle.init(new Point2D.Double(init_turtle.getDouble(0), init_turtle.getDouble(1)), init_turtle.getDouble(2));
        double unit_step = system_params.getDouble("step");
        double unit_angle = system_params.getDouble("angle");
        turtle.setUnits(unit_step, unit_angle);
        
        String axiom = params.getString("axiom");
        lsystem.setAxiom(axiom);
        
        CODE A INSERER
        
        /* autres paramètres pour lsystem: 
           lsystem.addSymbol, lsystem.setAction, lsystem.addRule
        */
    }    
    
    /**
     * Instance-linked main. 
     * 
     * @param args
     * @throws Exception 
     */
    private void allezallez(String[] args) throws Exception
    {
        int arg_idx=0;
        while (arg_idx<args.length && args[arg_idx].startsWith("-"))
        {
            String arg_key = args[arg_idx++];
            if (arg_idx==args.length)
                throw new IllegalArgumentException("Missing value for option "+arg_key);
            if ("-o".equals(arg_key))
            {
                String output_file = args[arg_idx++];
                out = "=".equals(output_file)?System.out:new java.io.PrintStream(output_file);
            } else 
            {
                throw new IllegalArgumentException("Switch "+arg_key+" not recognized (-o output.ps)");
            }
        }

        if (arg_idx==args.length)
            throw new IllegalArgumentException("Give JSON file name as command-line argument: java ... "+getClass().getName()+" lsystem.json niter");
        String json_file = args[arg_idx++];
        if (arg_idx==args.length)
            throw new IllegalArgumentException("Give number of rewriting iterations as the last command-line argument: java ... "+getClass().getName()+" lsystem.json niter");
        int n_iter = Integer.parseInt(args[arg_idx++]);

        this.lsystem = new LSystem();
        this.turtle = new EPSTurtle(new GhostTurtle(), out);
        
        JSONObject params = new JSONObject(new JSONTokener(new java.io.FileReader(json_file)));
        parseLSystem(params);      
        
        turtle.plot(lsystem, n_iter);
    }
    
    public static void main(String[] args) throws Exception
    {
        Plotter P = new Plotter();
        P.allezallez(args);
    }
    
    
}
