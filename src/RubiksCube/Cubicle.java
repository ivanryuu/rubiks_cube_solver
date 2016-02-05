/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

/**
 *
 * @author Ivan
 */
public class Cubicle {
    public static void main(String[] args){
        RubiksCube rc = new RubiksCube();
//        System.out.println(findEdge(rc,"GR"));
        String corner = "WRB";
        String other = "RBG";
        System.out.println(equalsCorner(corner,other));
    }
    
    /**
     * Returns the number of d rotations needed to find the given edge
     * @param cube
     * @param edge
     * @return 
     */
    public static int findEdge(RubiksCube cube, String edge){
        String[] edges = getMLEdges(cube);
        int e = 0;
        for(String try_edge : edges){
            if(edge.equals(try_edge) || edge.equals(rotate(try_edge)))
                return e;
            ++e;
        }
        return -1;
    }
    
    public static int findCorner(RubiksCube cube, String corner){
        String[] corners = getLowerCorners(cube);
        int c = 0;
        for(String try_corner : corners){
            if(equalsCorner(try_corner, corner))
                return c;
            ++c;
        }
        return -1;
    }
    
    public static boolean equalsCorner(String corner, String other){
        for(char c : corner.toCharArray())
            if(!other.contains("" + c))
                return false;
        return true;
    }
    
    private static String rotate(String edge){
        String rv = "";
        for(char c : edge.toCharArray())
            rv = c + rv;
        return rv;
    }
    
    public static String[] getCorners(RubiksCube cube){
        String[] corners = new String[8];
        System.arraycopy(getLowerCorners(cube), 0, corners, 0, 4);
        System.arraycopy(getUpperCorners(cube), 0, corners, 4, 4);
        return corners;
    }
    
    public static String[] getLowerCorners(RubiksCube cube){
        String[] corners = new String[4];
        corners[0] = getFRD(cube);
        corners[1] = "" + cube.getColor(0, 0, 0) + cube.getColor(1, 2, 0) + cube.getColor(5, 2, 2);
        corners[2] = "" + cube.getColor(0, 2, 0) + cube.getColor(5, 2, 0) + cube.getColor(3, 0, 0);
        corners[3] = "" + cube.getColor(0, 2, 2) + cube.getColor(3, 0, 2) + cube.getColor(4, 2, 2);
        return corners;
    }
    
    public static String[] getUpperCorners(RubiksCube cube){
        String[] corners = new String[4];
        corners[0] = "" + cube.getColor(2, 2, 2) + cube.getColor(1, 0, 2) + cube.getColor(4, 0, 0);
        corners[1] = "" + cube.getColor(2, 2, 0) + cube.getColor(1, 0, 0) + cube.getColor(5, 0, 2);
        corners[2] = "" + cube.getColor(2, 0, 0) + cube.getColor(5, 0, 0) + cube.getColor(3, 2, 0);
        corners[3] = "" + cube.getColor(2, 0, 2) + cube.getColor(3, 2, 2) + cube.getColor(4, 0, 2);
        return corners;
    }
    
    public static String getFRD(RubiksCube cube){
        return "" + cube.getColor(0, 0, 2) + cube.getColor(1, 2, 2) + cube.getColor(4, 2, 0);
    }
    
    public static String[] getEdges(RubiksCube cube){
        String[] edges = new String[12];
        System.arraycopy(getULEdges(cube), 0, edges, 0, 4);
        System.arraycopy(getMLEdges(cube), 0, edges, 4, 4);
        System.arraycopy(getDLEdges(cube), 0, edges, 8, 4);
        return edges;
    }
            
    public static String[] getULEdges(RubiksCube cube){
        String[] edges = new String[4];
        edges[0] = "" + cube.getColor(2, 2, 1) + cube.getColor(1, 0, 1);
        edges[1] = "" + cube.getColor(2, 1, 0) + cube.getColor(5, 0, 1);
        edges[2] = "" + cube.getColor(2, 0, 1) + cube.getColor(3, 2, 1);
        edges[3] = "" + cube.getColor(2, 1, 2) + cube.getColor(4, 0, 1);
        return edges;
    }
    
    /**
     * Gets the middle layer edges in the FR, FL, LB, BR order.
     * @param cube
     * @return a String array containing the four edges in the middle layer
     */
    public static String[] getMLEdges(RubiksCube cube){
        String[] edges = new String[4];
        edges[0] = getFR(cube);
        edges[1] = "" + cube.getColor(1, 1, 0) + cube.getColor(5, 1, 2);
        edges[2] = "" + cube.getColor(5, 1, 0) + cube.getColor(3, 1, 0);
        edges[3] = "" + cube.getColor(3, 1, 2) + cube.getColor(4, 1, 2);
        return edges;
    }
    
    public static String[] getDLEdges(RubiksCube cube){
        String[] edges = new String[4];
        edges[0] = "" + cube.getColor(0, 0, 1) + cube.getColor(1, 2, 1);
        edges[1] = "" + cube.getColor(0, 1, 0) + cube.getColor(5, 2, 1);
        edges[2] = "" + cube.getColor(0, 2, 1) + cube.getColor(3, 0, 1);
        edges[3] = "" + cube.getColor(0, 1, 2) + cube.getColor(4, 2, 1);
        return edges;
    }
    
    public static String getFR(RubiksCube cube){
        return "" + cube.getColor(1, 1, 2) + cube.getColor(4, 1, 0);
    }
    
    public static String getUF(RubiksCube cube){
        return "" + cube.getColor(2, 2, 1) + cube.getColor(1, 0, 1);
    }
    
    public static String getUR(RubiksCube cube){
        return "" + cube.getColor(2, 1, 2) + cube.getColor(4, 0, 1);
    }
}
