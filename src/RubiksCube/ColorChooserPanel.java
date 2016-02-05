/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RubiksCube;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ivan
 */
public class ColorChooserPanel extends JPanel{
    
    private Container parent;
    private int chosenColor;
    private final Color[] colors = {Color.white, Color.red,Color.yellow,
        Color.orange,Color.green,Color.blue};
    public CubeNetPanel cubeNet;
    public RubiksCube cube;
    
    public ColorChooserPanel()
    {
        initComponents();
    }
    
    public ColorChooserPanel(Container parent, RubiksCube cube)
    {
        this.parent = parent;
        this.cube = cube;
        initComponents();
    }
    
    private void initComponents()
    {
        
        cubeNet = new CubeNetPanel();
        JPanel sidebar = new JPanel();
        JPanel availableColors = new AvailableColorPanel();
        JPanel info = new InformationPanel();
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.add(availableColors);
        
        sidebar.add(info);
        add(cubeNet);
        add(sidebar);
        
        setPreferredSize(new Dimension(680,725));
    }
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Rubiks Cube Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ColorChooserPanel primary = new ColorChooserPanel();
        
        frame.getContentPane().add(primary);
        frame.pack();
        frame.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = frame.getSize();
        screenSize.height = screenSize.height/2;
        screenSize.width = screenSize.width/2;
        size.height = size.height/2;
        size.width = size.width/2;
        int y = screenSize.height - size.height;
        int x = screenSize.width - size.width;
        frame.setLocation(x, y);
    }
    
    class CubeNetPanel extends JPanel
    {
        private int size = 50;
        private Rectangle[][][] net = new Rectangle[6][3][3];
        private int[][][] colorNet = new int[6][3][3];
        private int[] colorCount = new int[6];
        
        public CubeNetPanel()
        {
            initComponents();
        }
        
        private void initComponents()
        {
            // set up the rectangle positions and initial color configuration
            for(int i = 0, yc = 0, y = size*11+50; i < 6; i++, yc++)
            {
                for(int j = 0, n = net[0].length; j < n; j++)
                {
                    int x = size*3 + 25;
                    if(i > 3)
                    {
                        x = i == 5 ? x - size*3 : x + size*3;
                        yc = 1;
                    }
                    for(int k = 0, p = net[0][0].length; k < p; k++)
                    {
                            net[i][j][k] = new Rectangle(x+(j*size),y-(yc*3+k)*size, size, size);
                            colorNet[i][j][k] = i;
                    }
                }
                colorCount[i] = 6;
            }
            
            
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) 
                {
                    for(int i = 0; i < net.length; i++)
                        for(int j = 0; j < 3; j++)
                            for(int k = 0; k < 3; k++)
                            {
                                if(net[i][j][k].contains(e.getPoint()))
                                {
                                    if(!(j == 1 && k == 1))
                                    {
                                        colorCount[colorNet[i][j][k]]--;
                                        colorNet[i][j][k] = chosenColor;
                                        ++colorCount[chosenColor];
                                        repaint();
                                    }
                                    break;
                                }
                            }
                        }
            });

            setPreferredSize(new Dimension(size*9+20,size*12+20));
            
            setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Cube Net"),
                BorderFactory.createBevelBorder(0)));
                //BorderFactory.createEmptyBorder(1,1,1,1)));
        }
        
        public boolean validCubeNet()
        {
            for(int i = 0; i < 6; i++)
            {
                if(colorCount[i] != 6)
                {
                    JOptionPane.showMessageDialog(null, "Error: count");
                    System.out.println(colorCount[i]);
                    return false;
                }
                
            }
            RubiksCube rc = createCubeFromNet();
//            Visual v = new Visual();
//            v.setCube(rc);
//            v.setVisible(true);
            for(String edge : Cubicle.getEdges(rc))
                if(edge.charAt(0) == edge.charAt(1))
                {
                    String[] edges = Cubicle.getEdges(rc);
                    JOptionPane.showMessageDialog(null, "Error: edges");
                    for(int i = 0; i < edges.length; i++)
                        System.out.print(edges[i] + " ");
                    return false;
                }
            
            for(String corner : Cubicle.getCorners(rc))
                if(corner.charAt(0) == corner.charAt(1) ||
                   corner.charAt(1) == corner.charAt(2) ||
                   corner.charAt(0) == corner.charAt(2))
                {
                    JOptionPane.showMessageDialog(null, "Error: corners");
                    System.out.println(corner);
                    
                    return false;
                }

            return true;
        }
        
        private RubiksCube createCubeFromNet()
        {
            int[][][] tmp = new int[6][3][3];
            for(int i = 0; i < 6; i++)
                for(int j = 0; j < 3; j++)
                    for(int k = 0; k < 3; k++)
                    {
                        //if(i == 0)
                            tmp[i][j][k] = colorNet[i][k][2-j];
//                        else if(i == 3)
//                            tmp[i][j][k] = colorNet[i][k][j];
                        //else
                            //tmp[i][j][k] = colorNet[i][k][2-j];
                    }
            RubiksCube c = new RubiksCube(tmp);
            return c;
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            
            for(int i = 0; i < 6; i++)
                for(int j = 0, n = net[0].length; j < n; j++)
                    for(int k = 0, p = net[0][0].length; k < p; k++)
                        drawRec(net[i][j][k], colors[colorNet[i][j][k]], g);
            
        }
        
        private void drawRec(Rectangle rec, Color color, Graphics g)
        {
            g.setColor(color);
            g.fillRect(rec.x, rec.y, rec.width, rec.height);
            g.setColor(Color.black);
            g.drawRect(rec.x, rec.y, rec.width, rec.height);
        }
    }
    
    class AvailableColorPanel extends JPanel
    {
        private Rectangle[] recs = new Rectangle[6];

        public AvailableColorPanel()
        {
            setPreferredSize(new Dimension(120, 170));
            setMaximumSize(new Dimension(120, 170));
            for(int i = 0,x = 50, y = 50; i < recs.length; i++)
            {
                recs[i] = new Rectangle(x*(i%2)+13, y*(i%3)+15, 45, 45);
            }
            
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) 
                {
                    for(int i = 0; i < recs.length; i++)
                    {
                        if(recs[i].contains(e.getPoint()))
                        {
                            chosenColor = i;
                            repaint();
                            break;
                        }
                    }
                }
            });
            
            setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Colors"),
                BorderFactory.createEmptyBorder(1,1,1,1)));
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for(int i = 0; i < recs.length; i++)
            {
                drawRec(recs[i], colors[i], g);
            }
        }
        
        public void drawRec(Rectangle rec, Color color, Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(color);
            g2.fillRect(rec.x, rec.y, rec.width, rec.height);
            g2.setColor(Color.black);
            if(color.equals(colors[chosenColor]))
                g2.setStroke(new BasicStroke(3));
            else
                g2.setStroke(new BasicStroke(1));
            g.drawRect(rec.x, rec.y, rec.width, rec.height);
        }
        
    }
    
    class InformationPanel extends JPanel
    {

        public InformationPanel()
        {
            initComponents();
        }
        
        private void initComponents()
        {
            final JButton check_but = new JButton("Set Cube");
            
            check_but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(cubeNet.validCubeNet()){
                        RubiksCube cube = cubeNet.createCubeFromNet();
                        CubeSolverPanel csp = ((CubeSolverPanel)parent.getComponent(0));
                        csp.setCube(cube);
                        //cube.show();
                    }
                }
            });
            
            add(check_but);
        }
    }
}
