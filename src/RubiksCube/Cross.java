/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

import java.util.Arrays;

/**
 *
 * @author Ivan
 */
public class Cross {
    
    public static int cross_orien, cross_orien_loc;
    public static int[] cross;
    private static String moves;
    
    public static String solveCross(RubiksCube cube){
        moves = "";
        int[] edges;// = getCrossEdges(cube);
        if(crossSuccess(cube))
            return moves;
        while(!crossSuccess(cube)){
            edges = getCrossEdges(cube);
            
            if(containsCrossEdge(edges, 20, 4)){
                onTopFace(cube);
                edges = getCrossEdges(cube);
            }
            if(containsCrossEdge(edges, 8, 8)){
                onMiddleLayer(cube);
                edges = getCrossEdges(cube);
            }
            if(containsCrossEdge(edges,4,4) || containsCrossEdge(edges,16,4)){
                onLowerUpperLayer(cube);
                edges = getCrossEdges(cube);
            }
            if(!crossSuccess(cube) && onCrossEdgeCount(edges) == 4 && crossInOrder(edges)){
                rotateToPosition(cube);
            }
        }
        return moves;
    }
    
    public static boolean crossSuccess(RubiksCube cube){
        int[] edges = getCrossEdges(cube);
        return edges[0] == 1 && crossInOrder(edges) && onCrossEdgeCount(edges) == 4;
    }
    
    public static void rotateToPosition(RubiksCube cube){
        int[] edges = getCrossEdges(cube);
        if(crossSuccess(cube) || onCrossEdgeCount(edges) < 4 || !crossInOrder(edges))
            return;
        while(edges[0] != 1){
            cube.D();
            edges = getCrossEdges(cube);
            moves += "D";
        }
    }
    
    public static void onLowerUpperLayer(RubiksCube cube){
        
        int[] edges = getCrossEdges(cube);
        if(!containsCrossEdge(edges,4,4) && !containsCrossEdge(edges,16,4))
            return;
        
        while(containsCrossEdge(edges,4,4) || containsCrossEdge(edges,16,4)){
            for(int i = 0; i < 4; i++){
                edges = getCrossEdges(cube);
                if(edges[i+4] != 0 || edges[i+16] != 0){
                    crossCorrectArray(edges);
                    while(cross[i] != 0){
                        cube.D();
                        rotRight();
                        moves += "D";
                    }
//                    printEdges(cross);
                    switch(i+1){
                        case 1: cube.F(); moves += "F"; break;
                        case 2: cube.L(); moves += "L"; break;
                        case 3: cube.B(); moves += "B"; break;
                        case 4: cube.R(); moves += "R"; break;
                    }
                    edges = getCrossEdges(cube);
                    if(containsCrossEdge(edges, 8, 8)){
                        onMiddleLayer(cube);
                        i = 10;
                    }
                }
            }
        }
    }
    
    
    /**
     * TODO: avoid using crossCorrectArray more than once.
     * @param cube 
     */
    public static void onMiddleLayer(RubiksCube cube){
        int[] edges = getCrossEdges(cube);
        if(!containsCrossEdge(edges, 8, 8))
            return;
        
        crossCorrectArray(edges);
        RubiksCube rc = new RubiksCube(cube.getCube());
        while(containsCrossEdge(edges,8,8)){
            for(int i = 0; i < 8; i++){
                if(edges[i+8] != 0){
                    int old_count = onCrossEdgeCount(cross);
                    for(int turns = 0; turns < 4; turns++){
                        switch(i+1){
                            case 1: rc.R_prime(); break;
                            case 2: rc.L(); break;
                            case 3: rc.B(); break;
                            case 4: rc.R(); break;
                            case 5: rc.F(); break;
                            case 6: rc.F_prime(); break;
                            case 7: rc.L_prime(); break;
                            case 8: rc.B_prime(); break;
                        }
                        edges = getCrossEdges(rc);
                        crossCorrectArray(edges);
//                        if(old_count < onCrossEdgeCount(cross) && crossInOrder(edges)){
                        if(old_count < onCrossEdgeCount(cross)){
                                switch(i+1){
                                case 1: cube.R_prime(); moves += "R'";  break;
                                case 2: cube.L(); moves += "L"; break;
                                case 3: cube.B(); moves += "B"; break;
                                case 4: cube.R(); moves += "R"; break;
                                case 5: cube.F(); moves += "F"; break;
                                case 6: cube.F_prime(); moves += "F'"; break;
                                case 7: cube.L_prime(); moves += "L'"; break;
                                case 8: cube.B_prime(); moves += "B'"; break;
                            }
                            turns = 20;
                        }
                        else {
                            cube.D();
                            moves += "D"; 
                            rc = new RubiksCube(cube.getCube());
                        }
                    }
                }
            }
        }
    }
    
    public static void onMiddleLayerShuffle(RubiksCube cube){
        for(int i = 0; i < 5; i++){
            int move = (int)(Math.random()*200%8 + 1);
            switch(move){
                case 1: cube.R_prime(); break;
                case 2: cube.L(); break;
                case 3: cube.B(); break;
                case 4: cube.R(); break;
                case 5: cube.F(); break;
                case 6: cube.F_prime(); break;
                case 7: cube.L_prime(); break;
                case 8: cube.B_prime(); break;
            }
            int move2 = (int)(Math.random()*200%3 + 1);
            switch(move2){
                case 1: cube.D_prime(); break;
                case 2: cube.D(); break;
                case 3: cube.D2(); break;
            }
        }
    }
    
    public static void onTopFace(RubiksCube cube){

        int[] edges = getCrossEdges(cube);
        if(!containsCrossEdge(edges, 20, 4))
            return;
        crossCorrectArray(edges);
        while(containsCrossEdge(edges, 20, 4)){
            for(int i = 0; i < 4; i++){
                if(edges[i+20] != 0){
                    for(int j = 0; j < 4; j++){
                        if(cross[(i+j)%4] != 0) continue;
                        int[] temp = Arrays.copyOf(cross,4);
                        temp[(i+j)%4] = edges[i+20];
//                        printEdges(temp);
                        if(Cross.crossInOrder(temp)){
                            switch(j){
                                case 1: cube.U(); moves += "U"; break;
                                case 2: cube.U2(); moves += "U2"; break;
                                case 3: cube.U_prime(); moves += "U'"; break;
                            }
                            switch((i+j)%4){
                                case 0: cube.F2(); moves += "F2"; break;
                                case 1: cube.L2(); moves += "L2"; break;
                                case 2: cube.B2(); moves += "B2"; break;
                                case 3: cube.R2(); moves += "R2"; break;
                            }
                            cross = Arrays.copyOf(temp,4);
                            if(!containsCrossEdge(edges, 20, 4))
                                return;
                            j = 10;
                        }
                    }
                }
                edges = getCrossEdges(cube);
            }
            
        }
        
    }
    
    public static void onTopFaceShuffle(RubiksCube cube){
        for(int i = 0; i < 30; i++){
            int move = (int)(Math.random()*200%8 + 1);
            switch(move){
                case 1:  cube.R2(); break;
                case 2:  cube.U(); break;
                case 3:  cube.F2(); break;
                case 4:  cube.L2(); break;
                case 5:  cube.D(); break;
                case 6:  cube.B2(); break;
                case 7:  cube.D_prime(); break;
                case 8:  cube.U_prime(); break;
            }
        }
    }
    
    public static String getCrossColor(RubiksCube cube){
        return "" + cube.getColor(0, 1, 1);
    }
    
    public static String getColorOrder(RubiksCube cube){
        return "" + cube.getColor(1, 1, 1) + cube.getColor(5, 1, 1) +
                cube.getColor(3, 1, 1) + cube.getColor(4, 1, 1);
    }
    
    /**
     * Returns an integer array detailing where each cross edge is located.
     * A zero represents that it is not a cross edge. A non-zero integer shows 
     * where the edge needs to be following the order of FLBR-faces (1234).
     * <p>
     * The first 8 indices represent the bottom layer, the next 8 are the middle 
     * layer and the last 8 are the top layer. 
     * @param cube
     * @return 
     */
    public static int[] getCrossEdges(RubiksCube cube){
        int[] cross_edges = new int[24];
        String[] dl_edges = Cubicle.getDLEdges(cube);
        String[] ml_edges = Cubicle.getMLEdges(cube);
        String[] ul_edges = Cubicle.getULEdges(cube);
        for(int i = 0; i < dl_edges.length; i++){
            cross_edges[i] = isCrossColor(cube,dl_edges[i],0);
            cross_edges[i+4] = isCrossColor(cube,dl_edges[i],1);
            cross_edges[i+8] = isCrossColor(cube,ml_edges[i],0);
            cross_edges[i+12] = isCrossColor(cube,ml_edges[i],1);
            cross_edges[i+16] = isCrossColor(cube,ul_edges[i],1);
            cross_edges[i+20] = isCrossColor(cube,ul_edges[i],0);
        }
        
        return cross_edges;
    }
    
    private static int isCrossColor(RubiksCube cube,String edge, int side){
        if(getCrossColor(cube).equals("" + edge.charAt(side))){
            return getColorOrder(cube).indexOf(edge.charAt(reverseSide(side))) + 1;
        }
        return 0;
    }
    
    private static int reverseSide(int side){
        return side == 0 ? 1 : 0;
    }
    
    public static int onCrossEdgeCount(int[] edges){
        int count = 0;
        for(int i = 0; i < 4; i++)
            if(edges[i] > 0)
                count++;
        return count;
    }
    
    public static boolean containsCrossEdge(int[] edges, int min, int elems){
        for(int i = min; i < min + elems; i++)
            if(edges[i] > 0)
                return true;
        return false;
    }
    
    public static boolean crossInOrder(int[] edges){
        if(!containsCrossEdge(edges,0,4))
            return false;
        for(int i = 0; i < 4; i++){
            if(edges[i] == 0)
                continue;
            if(edges[i] == 1 && edges[(i+7)%4] != 0 &&  edges[(i+7)%4] != 4)
                return false;
            if(edges[i] == 1 && edges[(i+6)%4] != 0 && edges[(i+6)%4] == 4)
                return false;
            if(edges[i] == 4 && edges[(i+5)%4] != 0 &&  edges[(i+5)%4] != 1)
                return false;
            if(edges[i] != 4 && edges[(i+1)%4] != 0 && Math.abs(edges[(i+1)%4] - edges[i]) != 1)
                return false;
            if(edges[i] != 1 && edges[(i+7)%4] != 0 && Math.abs(edges[(i+7)%4] - edges[i]) != 1)
                return false;
            if(edges[(i+6)%4] != 0 && Math.abs(edges[(i+6)%4] - edges[i]) == 1)
                return false;
            if(edges[i] != 1 && edges[(i+7)%4] > edges[i])
                return false;
            
            
        }
        return true;
    }
    
    public static void testCrossInOrder(){
        int[][] edges = {{1,2,3,4},{4,1,2,3},{3,4,1,2},{1,0,0,4},{0,4,1,0},{1,2,4,3}};
        for(int[] e : edges)
            System.out.println(crossInOrder(e));
    }
    
    public static void crossCorrectArray(int[] edges){
        cross = new int[4];
        
        if(crossInOrder(edges)){
            cross = Arrays.copyOf(edges, 4);
            return;
        }
        
        int on_cross = Cross.onCrossEdgeCount(edges);
        
        switch(on_cross){
            case 1: cross = Arrays.copyOf(edges, 4); break;
            case 2: {
                for(int i = 0; i < 4; i++)
                    if(edges[i] != 0){ cross[i] = edges[i]; break;}
            } break;
            case 3: {
                boolean flag = true;
                int[] temp = Arrays.copyOf(edges, 4);
                for(int i = 0; i < 4; i++){
                    temp[i] = 0;
                    if(Cross.crossInOrder(temp)){
                        cross = Arrays.copyOf(temp,4);
                        flag = false;
                    }
                    temp = Arrays.copyOf(edges, 4);
                }
                if(flag){
                    for(int i = 0; i < 4; i++)
                        if(edges[i] != 0){ cross[i] = edges[i]; break;}
                }
            } break;
            case 4: {
                int[] temp = Arrays.copyOf(edges, 4);
                for(int i = 0; i < 4; i++){
                    
                    for(int j = 0; j < 4; j++){
                        if(i == j) continue;
                        temp[i] = 0;
                        temp[j] = 0;
                        if(Cross.crossInOrder(temp)){
                            cross = Arrays.copyOf(temp,4);
                            return;
                        }
                        temp = Arrays.copyOf(edges, 4);
                    }
                }
                
            } break;
        }
    }
    
    public static void testCrossCorrectArray(){
        int[][] edges = {{1,2,3,4},{4,1,2,3},{3,4,1,2},{1,0,0,4},{0,4,1,0},{1,2,4,3},
            {1,3,2,4},{2,0,0,0},{1,0,2,3},{1,3,2,0},{1,0,2,0},{3,1,2,4},{0,0,3,0}};
        for(int[] e : edges){
            crossCorrectArray(e);
            printEdges(cross);
        }
    }
    
    public static void shuffle(RubiksCube cube){
        
        for(int i = 1; i <= 40; i++){
            int move = (int)(Math.random()*200%18 + 1);
            switch(move){
                case 1:  cube.R(); break;
                case 2:  cube.U(); break;
                case 3:  cube.F(); break;
                case 4:  cube.L(); break;
                case 5:  cube.D(); break;
                case 6:  cube.B(); break;
                case 7:  cube.R2(); break;
                case 8:  cube.U2(); break;
                case 9:  cube.F2(); break;
                case 10:  cube.L2(); break;
                case 11:  cube.D2(); break;
                case 12:  cube.B2(); break;
                case 13:  cube.R_prime(); break;
                case 14:  cube.U_prime(); break;
                case 15:  cube.F_prime(); break;
                case 16:  cube.L_prime(); break;
                case 17:  cube.D_prime(); break;
                case 18:  cube.B_prime(); break;
            }
        }
    }
    
    public static void rotLeft(){
        int[] temp = Arrays.copyOf(cross,4);
        for(int i = 0; i < 4; i++)
            cross[i] = temp[(i+7)%4];
    }
    
    public static void rotRight(){
        int[] temp = Arrays.copyOf(cross,4);
        for(int i = 0; i < 4; i++)
            cross[i] = temp[(i+1)%4];
    }
    
    public static void testRot(){
        int[] temp = {1,2,3,4};
        cross = Arrays.copyOf(temp,4);
        rotRight();
        printEdges(cross);
    }
    
    public static void printEdges(int[] edges){
        for(int i = 0; i < edges.length; i++){
            System.out.print(edges[i] + " ");
            if(i != 0 && (i + 1) % 4 == 0) System.out.print("| ");
        }
        System.out.println();
    }
    
    public static void printEdges(RubiksCube rc){
        printEdges(getCrossEdges(rc));
    }
    
    public static void main(String[] args){
//        Cross.testRot();
//        Cross.testCrossCorrectArray();
//        Cross.testCrossInOrder();
        RubiksCube rc = new RubiksCube();
//        Cross.onMiddleLayerShuffle(rc);
//        Cross.onTopFaceShuffle(rc);
        rc.L();
        rc.B_prime();
        rc.D();
        rc.L();
        rc.F2();
        rc.R_prime();
//        Cross.shuffle(rc);
        Cross.printEdges(rc);
//        Cross.onLowerUpperLayer(rc);
        

//        Cross.onTopFace(rc);
//        Cross.onMiddleLayer(rc);
        System.out.println(Cross.solveCross(rc));
        System.out.println(Cross.crossInOrder(Cross.getCrossEdges(rc)));
        Cross.printEdges(rc);
//        for(int x : Cross.getCrossEdges(rc))
//                    System.out.print(x + " ");
    }
}