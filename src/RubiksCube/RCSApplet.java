/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RubiksCube;

import java.awt.Container;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;

/**
 *
 * @author Ivan
 */
public class RCSApplet extends JApplet {

    RubiksCube cube;
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        cube = new RubiksCube();
        Container container = this.getContentPane();

        JTabbedPane tabbedPane = new JTabbedPane();
        
        JComponent cubeSolver = new CubeSolverPanel(tabbedPane, cube);
        JComponent colorChooser = new ColorChooserPanel(tabbedPane, cube);
        tabbedPane.addTab("Cube Solver", null, cubeSolver, "Solves the cube");
        tabbedPane.addTab("Color Chooser", null, colorChooser, "Choose the cube colors");
        
        container.add(tabbedPane);
        setSize(680, 725);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
