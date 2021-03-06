/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RubiksCube;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author Ivan
 */
public class CubeSolverPanel extends JPanel{
    private Container parent;
    private RubiksCube cube = new RubiksCube();
    private RubiksCubeSolver rcs;
    private final RubiksCube reset_cube = new RubiksCube();
    private MoveParser move_parser;;
    private Timer timer;
    private int h_pos = 0;
    private JButton next_but, shuffle_but, solve_but, prev_but; 
    private JTextArea shuffle_mov, solve_mov;
    private Highlighter hilite;
    public CubeSolverPanel(){
        initComponents();
    }
    
    public CubeSolverPanel(Container parent, RubiksCube rc)
    {
        this.parent = parent;
        cube.setCube(rc);
        initComponents();
    }
    
    private void initComponents(){
        cube = new RubiksCube();
//        Move.RpUp(cube);
//        cube.show();
        rcs = new RubiksCubeSolver();
        move_parser = new MoveParser();
        
        JPanel options = new JPanel();
        JPanel shuffle_panel = new JPanel();
        JPanel solve_panel = new JPanel();
        CubePanel cube_panel = new CubePanel(cube);
        
        next_but = new JButton("next");
        shuffle_but = new JButton("Shuffle!");
        solve_but = new JButton("Solve!");
        prev_but = new JButton("previous");
        
        shuffle_mov = new JTextArea("shuffle",2,60);
        solve_mov = new JTextArea("solve",3,60);
        
        hilite = solve_mov.getHighlighter();
        
        solve_mov.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        shuffle_mov.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        solve_mov.setEditable(false);
        shuffle_mov.setEditable(false);
        solve_mov.setLineWrap(true);
        shuffle_mov.setLineWrap(true);
        solve_mov.setWrapStyleWord(true);
        shuffle_mov.setWrapStyleWord(true);
        
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
//        shuffle_mov.setSize(500, 100);
        
        next_but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                move_parser.next(cube);
                hilite.removeAllHighlights();
                try {
                    hilite.addHighlight(h_pos, h_pos + move_parser.previousLength(), 
                            new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
                    h_pos += move_parser.previousLength() + 1;
                } catch (BadLocationException ex) {}
                repaint();
                if(!prev_but.isEnabled())
                    prev_but.setEnabled(true);
            }
        });
        
        prev_but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                move_parser.previous(cube);
                hilite.removeAllHighlights();
                try {
                    h_pos -= move_parser.previousLength() + move_parser.currentLength()+2;
                    hilite.addHighlight(h_pos, h_pos+move_parser.previousLength(), 
                            new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
                    h_pos += move_parser.previousLength() + 1;
                } catch (BadLocationException ex) {}
                repaint();
            }
        });
        
        shuffle_but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                h_pos = 0;
                hilite.removeAllHighlights();
                cube.setCube(reset_cube);
                if(timer != null && timer.isRunning())
                    timer.stop();
                next_but.setEnabled(true);
                solve_but.setEnabled(true);
                String shuffled_text = rcs.shuffle(cube);
                String solved_text = rcs.solveCube(new RubiksCube(cube.getCube()));
                move_parser.clear(solved_text);
                shuffle_mov.setText(move_parser.compressMoves(shuffled_text));
                solve_mov.setText(move_parser.getMoves());
                repaint();
            }
        });
        
        solve_but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                solve(move_parser, hilite);
                repaint();
            }
        });
        
        next_but.setEnabled(false);
        prev_but.setEnabled(false);
        solve_but.setEnabled(false);
        options.add(shuffle_but);
        options.add(prev_but);
        options.add(next_but);
        options.add(solve_but);
        
        shuffle_panel.add(shuffle_mov);
        solve_panel.add(solve_mov);
//        options.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createTitledBorder("Controls"), 
//                BorderFactory.createEmptyBorder(1,1,1,1)));
        shuffle_panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Shuffle Moves"), 
                BorderFactory.createEmptyBorder(1,1,1,1)));
        solve_panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Solve Moves"), 
                BorderFactory.createEmptyBorder(1,1,1,1)));
        
        // Add the panels to the main window
        add(options);
        add(cube_panel);
        add(shuffle_panel);
        add(solve_panel);
        setSize(600, 625);
        setPreferredSize(new Dimension(700, 725));
    }
    
    public void setCube(RubiksCube rc)
    {
        cube.setCube(rc);
        h_pos = 0;
        hilite.removeAllHighlights();
        if(timer != null && timer.isRunning())
            timer.stop();
        next_but.setEnabled(true);
        solve_but.setEnabled(true);
        //String shuffled_text = rcs.shuffle(cube);
        String solved_text = rcs.solveCube(new RubiksCube(cube.getCube()));
        move_parser.clear(solved_text);
        //shuffle_mov.setText(move_parser.compressMoves(shuffled_text));
        shuffle_mov.setText("Cube built from color chooser");
        solve_mov.setText(move_parser.getMoves());
        repaint();
    }
    
    public void solve(final MoveParser move_parser,final Highlighter hilite){
        timer = new Timer(200, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(move_parser.hasNext()){
                    move_parser.next(cube);
                    hilite.removeAllHighlights();
                    try {
                        hilite.addHighlight(h_pos, h_pos + move_parser.previousLength(), 
                                new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
                        h_pos += move_parser.previousLength() + 1;
                    } catch (BadLocationException ex) {}
                    repaint();
                }
                else
                    timer.stop();
            }
        });
        timer.start();
    }
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Rubiks Cube Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CubeSolverPanel primary = new CubeSolverPanel();
        
        frame.getContentPane().add(primary);
        frame.pack();
        frame.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = frame.getSize();
        System.out.println(size);
        screenSize.height = screenSize.height/2;
        screenSize.width = screenSize.width/2;
        size.height = size.height/2;
        size.width = size.width/2;
        int y = screenSize.height - size.height;
        int x = screenSize.width - size.width;
        frame.setLocation(x, y);
    }
    
    class CubePanel extends JPanel{
        
        private RubiksCube rc;
        String[] titles = {"Top-Front-Right","Top-Back-Left",
            "Bottom-Right-Front","Bottom-Left-Back"};
        private int[][][] cube = new int[6][3][3];
        private Color[] colors = {Color.WHITE, Color.RED, Color.YELLOW,
                              Color.ORANGE, Color.GREEN, Color.BLUE};
        
        public CubePanel(RubiksCube cube){
            rc = cube;
            CubeView[] views = new CubeView[4];
            for(int i = 0; i < 4; i++)
                views[i] = new CubeView(titles[i]);
            views[0].setParams(2,1,4);
            views[1].setParams(-2,-3,5);
            //views[2].setParams(6,4,1);
            views[2].setParams(6,4,1);
            views[3].setParams(-6,5,-3);
            for(int i = 0; i < 4; i++)
                this.add(views[i]);
            setPreferredSize(new Dimension(500,520));
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
//            g.setColor(Color.red);
//            g.fillRect(0, 0, 700, 600);
            convertCube();

//            for(int i = 0; i < 4; i++)
//                views[i] = new CubeView(titles[i]);
//            draw3FaceCube(g, 100, 75,2,1,4);
//            draw3FaceCube(g, 350, 75,-2,-3,5);
//            draw3FaceCube(g, 100, 350,6,4,1);
//            draw3FaceCube(g, 350, 350,-6,5,-3);
        }
        
        private void convertCube(){
        for(int s = 0; s<6; s++)
            for(int r = 0; r<3; r++)
                for(int c = 0; c<3; c++){
                    if((""+rc.getColor(s, r, c)).equals("W")) cube[s][r][c] = 0;
                    if((""+rc.getColor(s, r, c)).equals("R")) cube[s][r][c] = 1;
                    if((""+rc.getColor(s, r, c)).equals("Y")) cube[s][r][c] = 2;
                    if((""+rc.getColor(s, r, c)).equals("O")) cube[s][r][c] = 3;
                    if((""+rc.getColor(s, r, c)).equals("G")) cube[s][r][c] = 4;
                    if((""+rc.getColor(s, r, c)).equals("B")) cube[s][r][c] = 5;
                }
        }
        
        private void draw3FaceCube(Graphics g, int x_pos, int y_pos, int tf, int ff, int rf){
        int tr, fr, rr,tc,fc,rc;
        tr = fr = rr = tc = fc = rc = 0;
        if(Math.abs(tf) == 6){
            if(tf < 0){
                //tf *= -1;
                tr = 0;
                tc = 0;
            }
            else {
                tr = 2;
                tc = 2;
            }
            if(ff < 0){
                ff *= -1;
                fr = 0;
            }
            else fr = 2;
            if(rf < 0){
                rf *= -1;
                rr = 0;
            }
            else rr = 2;
            tf = 0;
            fc = Math.abs(ff) == 3 ? 0 : 2;
            rc = Math.abs(rf) == 3 ? 0 : 2;
        }
        else if(Math.abs(tf) == 2){
            if(tf < 0){
               tf *= -1;
                tr = 0;
                tc = 2;
            }
            else {
                tr = 2;
                tc = 0;
            }
            if(ff < 0){
                ff *= -1;
                fr = 2;
            }
            else fr = 0;
            if(rf < 0){
                rf *= -1;
                rr = 2;
            }
            else rr = 0;
            fc = Math.abs(ff) == 3 ? 2 : 0;
            rc = Math.abs(rf) == 3 ? 2 : 0;
        }
//        tc = Math.abs(tf) == 3 ? 2 : 0;
        
        // Draws the FRT faces. (Front-Right-Top)
        // First it draws the top layer
//        if(tf < 0){
//            tf *= -1;
//            tr = 0;
//        }
//        else tr = 2;

        int[] xt = {x_pos,x_pos-30,x_pos,x_pos+30};
        int[] y = {y_pos - 20,y_pos,y_pos + 20,y_pos};
        Polygon p = new Polygon(xt, y, xt.length);
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(tf == 0)
                    g.setColor(colors[cube[tf][Math.abs(tr-j)][Math.abs(tc-i)]]);
                else
                    g.setColor(colors[cube[tf][Math.abs(tr-i)][Math.abs(tc-j)]]);
                //g.fillPolygon(xt, y, xt.length);
                g.fillPolygon(p);
                g.setColor(Color.black);
                g.drawPolygon(p);
                p.translate(30, 20);
                //g.drawPolygon(xt, y, xt.length);
//                for(int a = 0; a<xt.length; a++){
//                    xt[a] += 30;
//                    y[a] += 20;
//                }
            }
            p.translate(-60,-80);
//            for(int a = 0; a<xt.length; a++){
//                xt[a] -= 2*30;
//                y[a] -= 4*20;
//            }
        }

        int[] xf = {x_pos-30,x_pos-30,x_pos,x_pos};
        int[] yf = {y_pos + 30,y_pos,y_pos + 20,y_pos + 50};
        p = new Polygon(xf,yf,xf.length);
        //p.translate(100, 100);
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                g.setColor(colors[cube[ff][Math.abs(fr-i)][Math.abs(fc-j)]]);
                g.fillPolygon(p);
                g.setColor(Color.black);
                g.drawPolygon(p);
                p.translate(30, 20);
            }
            p.translate(-90,-30);
        }
        
//        if(rf < 0){
//            rf *= -1;
//            rr = 2;
//        }
//        else rr = 0;
        int[] xr = {x_pos + 60,x_pos + 60,x_pos + 90,x_pos + 90};
        int[] yr = {y_pos + 90,y_pos + 60,y_pos + 40,y_pos + 70};
        p = new Polygon(xr,yr,xr.length);
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                g.setColor(colors[cube[rf][Math.abs(rr-i)][Math.abs(rc-j)]]);
                g.fillPolygon(p);
                g.setColor(Color.black);
                g.drawPolygon(p);
                p.translate(30, -20);
            }
            p.translate(-90,90);
        }
    }
        
        class CubeView extends JPanel{
        
            int x_pos, y_pos, tf, ff, rf;
            
            public CubeView(String view){
                
                this.setSize(125,125);
                this.setPreferredSize(new Dimension(250,250));
                this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(view), 
                BorderFactory.createEmptyBorder(1,1,1,1)));
            }
            
            public void setParams(int tf, int ff, int rf){
                this.x_pos = 67;
                this.y_pos = 80;
                this.tf = tf;
                this.ff = ff;
                this.rf = rf;
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.DARK_GRAY);
                g.fillRect(10, 15, 230, 225);
                draw3FaceCube(g, x_pos, y_pos, tf, ff, rf);
            }
            
            public void draw(){
                repaint();
            }
        }
    }
}
