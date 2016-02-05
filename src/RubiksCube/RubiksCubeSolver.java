/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

import java.util.Random;

/**
 *
 * @author ivan
 */
public class RubiksCubeSolver {
    private NNPredict nn_pll = new NNPredict("PLL");
    private NNPredict nn_oll = new NNPredict("OLL");
    private NNPredict nn_f2l = new NNPredict("F2L");
    //private RubiksCube cube = new RubiksCube();
    
    public RubiksCubeSolver(){
        
    }
    
    public void LastLayerShuffle(RubiksCube cube){
        PLL.Z(cube);
//        OLL.A52(cube);
//        PLL.F(cube);
        OLL.A23(cube);
        
    }
    
    private String findF2LAlg(RubiksCube cube){
        String moves = "";
        RubiksCube rc = new RubiksCube(cube.getCube());
        int rotations = 0;
        
        do{
            do {
                rc = new RubiksCube(cube.getCube());
                if(F2L.F2LComplete(cube)){
                    return moves;
                }
                if(F2L.F2LSuccess(cube)){
                    cube.d();
                    moves += "d ";
                    continue;
                }
                
                double[] X = CubeData.F2LDataRow(cube);
                int alg = nn_f2l.nnPredict(X,20);
                
                if(alg >= 42){
                    if(rotations >= 4){
                        F2L.doF2LAlg(rc, alg);
                        moves += F2L.doF2LAlgS(cube, alg);
                        rotations = 0;
                    }
                    else {
                        rotations++;
                        cube.d();
                        moves += "d ";
                    }
                    X = CubeData.F2LDataRow(cube);
                    alg = nn_f2l.nnPredict(X,20);
                }
                
                if(F2L.F2LSuccess(cube)){
                    cube.d();
                    moves += "d ";
                    continue;
                }
                rc = new RubiksCube(cube.getCube());
                //Get color of the front face
                String f_face = "" + rc.getColor(1, 1, 1);
                int u_turns = F2L.prepareF2L(rc);
                F2L.doF2LAlg(rc, alg);
                int y_turns = 0;
                while(!f_face.equals("" + rc.getColor(1, 1, 1))){
                    rc.y();
                    y_turns++;
                }

                if(F2L.F2LSuccess(rc)){
//                    new CubeVisualizer(cube,"F2L before");
                    F2L.prepareF2L(cube);
                    F2L.doF2LAlg(cube, alg);
                    if(u_turns == 1) moves += "U'";
                    else if(u_turns == 2) moves += "U2";
                    else if(u_turns == 3) moves += "U";
                    moves += F2L.F2L_ALGORITHMS[alg] + "\n";
//                    new CubeVisualizer(cube,"F2L after");
                }
                    
            }while(!F2L.F2LSuccess(cube));
            
            if(F2L.F2LSuccess(cube) && !F2L.F2LComplete(cube)){
                cube.d();
                moves += "d ";
            }
            
        }while(!F2L.F2LComplete(cube));
        return moves;
    }
    
    private String findOLLAlg(RubiksCube cube){
        int turns = 0;
        String moves = "";
        RubiksCube rc = new RubiksCube(cube.getCube());
        double[] X = CubeData.OLLDataRow(rc);
        int alg = nn_oll.nnPredict(X);
        
        do {
            OLL.doOLLAlg(rc, alg);
            if(!OLL.OLLSuccess(rc)){
                turns++;
                cube.U();
            }
            else
                OLL.doOLLAlg(cube, alg);
            rc = new RubiksCube(cube.getCube());
        }while(!OLL.OLLSuccess(rc));
        
        if(turns == 1) moves += "U";
        else if(turns == 2) moves += "U2";
        else if(turns == 3) moves += "U'";
//        new CubeVisualizer(rc,"OLL");
        moves += OLL.OLL_ALGORITHMS[alg];
        return moves;
    }
    
    private String findPLLAlg(RubiksCube cube){
        int turns = 0;
        int alg = -1;
        String moves = "";
        RubiksCube rc;
        do {
            rc = new RubiksCube(cube.getCube());
            
            if(PLL.PLLSuccess(cube)){
                return moves;
            }
            
            double[] X = CubeData.PLLDataRow(rc);
            alg = nn_pll.nnPredict(X,15);
            PLL.doPLLAlg(rc, alg);
            if(!PLL.PLLSuccess(rc)){
                turns++;
                cube.U();
            }
            else
                PLL.doPLLAlg(cube, alg);
        }while(!PLL.PLLSuccess(rc));
        
        if(turns == 1) moves += "U";
        else if(turns == 2) moves += "U2";
        else if(turns == 3) moves += "U'";
//        new CubeVisualizer(rc,"PLL");
        moves += PLL.PLL_ALGORITHMS[alg];
        return moves;
    }
    
    private String lastTurn(RubiksCube cube){
        String center = "" + cube.getColor(1, 1, 1);
        int turns = 0;
        for(int s = 0; s<4; s++)
            if(center.equals(cube.Layer3()[s*3]))
                turns = s;
        switch(turns){
            case 1: cube.U(); return " U";
            case 2: cube.U2(); return " U2";
            case 3: cube.U_prime(); return " U'";
            default: return "";
        }
    }
    
    private String solveCross(RubiksCube cube){
        String cross_moves = "\nCross: ";
        cross_moves += Cross.solveCross(cube);
        return cross_moves;
    }
    
    private String solveF2L(RubiksCube cube){
        String F2L_moves = "\nF2L: ";
        F2L_moves += findF2LAlg(cube);
        return F2L_moves;
    }
    
    private String solveOLL(RubiksCube cube){
        String OLL_moves = "\nOLL: ";
        OLL_moves += findOLLAlg(cube);
        return OLL_moves;
    }
    
    private String solvePLL(RubiksCube cube){
        String PLL_moves = "\nPLL: ";
        PLL_moves += findPLLAlg(cube);
        PLL_moves += lastTurn(cube);
        return PLL_moves;
    }
    
    public String solveLastLayer(RubiksCube cube){
        return solveOLL(cube) + solvePLL(cube);
    }
    
    public String solveCube(RubiksCube cube){
        return solveCross(cube) + solveF2L(cube) + solveLastLayer(cube);
    }
    
    public String solveCube(String shuffleMoves) {
        return "";
    }
    
    public String supervisedTest(RubiksCube cube){
        String shuffle = "Shuffle: ";
        F2L.A01(cube);
        cube.U2();
        shuffle += F2L.F2L_ALGORITHMS[1] + "U2";
        F2L.A34(cube);
        cube.d();
        shuffle += F2L.F2L_ALGORITHMS[34] + "d";
        F2L.A09(cube);
        shuffle += F2L.F2L_ALGORITHMS[9] + "\n";
        return shuffle;
    }
    
    public String shuffle(RubiksCube cube){
        String moves = "";
        for(int i = 1; i <= 30; i++){
            int move = (int)(Math.random()*200%18 + 1);
            switch(move){
                case 1:  cube.R(); moves += "R"; break;
                case 2:  cube.U(); moves += "U"; break;
                case 3:  cube.F(); moves += "F"; break;
                case 4:  cube.L(); moves += "L"; break;
                case 5:  cube.D(); moves += "D"; break;
                case 6:  cube.B(); moves += "B"; break;
                case 7:  cube.R2(); moves += "R2"; break;
                case 8:  cube.U2(); moves += "U2"; break;
                case 9:  cube.F2(); moves += "F2"; break;
                case 10:  cube.L2(); moves += "L2"; break;
                case 11:  cube.D2(); moves += "D2"; break;
                case 12:  cube.B2(); moves += "B2"; break;
                case 13:  cube.R_prime(); moves += "R'"; break;
                case 14:  cube.U_prime(); moves += "U'"; break;
                case 15:  cube.F_prime(); moves += "F'"; break;
                case 16:  cube.L_prime(); moves += "L'"; break;
                case 17:  cube.D_prime(); moves += "D'"; break;
                case 18:  cube.B_prime(); moves += "B'"; break;
            }
        }
        return moves;
    }
    
    public static void main(String[] args){
        RubiksCube rc = new RubiksCube();
        RubiksCubeSolver rcs = new RubiksCubeSolver();
//        rcs.shuffle(rc);
        rcs.supervisedTest(rc);
//        new CubeVisualizer(rc,"Initial");
        System.out.println(rcs.solveCube(rc));
//        new CubeVisualizer(rc,"Solved");
    }
}
