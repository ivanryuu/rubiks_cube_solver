/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

/**
 *
 * @author ivan
 */
public class PLL {
    
    public static void main(String[] args){
        RubiksCube rc = new RubiksCube();
        for(int i = 1; i <= 21; i++){
            doTrainAlg(rc, i);
            doPLLAlg(rc, i);
//            new CubeVisualizer(rc, "Alg" + i);
            rc = new RubiksCube();
        }
    }
    
    public static String[] PLL_ALGORITHMS = {"List of PLL algorithms",
        "x R'UR' D2 RU'R' D2 R2 x'", 
        "x R2 D2 RUR' D2 RU'R x'",
        "x' RU'R' D RUR' D' RUR' D RU'R' D' x", 
        "RU'RU RURU' R'U' R2",
        "R2U RUR'U' R'U' R'UR'",
        "M2U M2U2 M2U M2",
        "M2U M2U M'U2 M2U2 M'U2",
        "R'UL' U2 RU'R' U2 LRU'",
        "RUR'F' RUR'U' R'F R2U' R'U'",
        "RUR'U' R'F R2U' R'U'RU R'F'",
        "RUR'F' RU2 R'U2 R'FRU RU2 R'U'",
        "R'U2 RU2 R'FRU R'U'R'F' R2U'",
        "R'U'F' RUR'U' R'F R2U' R'U'RU R'UR",
        "R'UR' d' R'F' R2U' R'UR'F RF",
        "z D R'U R2D' RDU' R'U R2D' RU'R z'",
        "z U' RD' R2U R'D U' RD' R2U R'D R' z'",
        "FRU' R'U'RU R'F' RUR'U' R'FRF'",
        "R2u R'UR'U' Ru' R2 y' R'UR",
        "R'U'R y R2u R'URU' Ru' R2",
        "R2u' RU'RU R'u R2 f R' f'",
        "RUR' y' R2u' RU'R'U R'u R2"};
    
    public static void doPLLAlg(RubiksCube cube, int alg){
        
        switch(alg){
            case 1:  PLL.Aa(cube); break;
            case 2:  PLL.Ab(cube); break;
            case 3:  PLL.E(cube);  break;
            case 4:  PLL.Ua(cube); break;
            case 5:  PLL.Ub(cube); break;
            case 6:  PLL.H(cube);  break;
            case 7:  PLL.Z(cube);  break;
            case 8:  PLL.Ja(cube); break;
            case 9:  PLL.Jb(cube); break;
            case 10: PLL.T(cube);  break;
            case 11: PLL.Ra(cube); break;
            case 12: PLL.Rb(cube); break;
            case 13: PLL.F(cube);  break;
            case 14: PLL.V(cube);  break;
            case 15: PLL.Na(cube); break;
            case 16: PLL.Nb(cube); break;
            case 17: PLL.Y(cube);  break;
            case 18: PLL.Ga(cube); break;
            case 19: PLL.Gb(cube); break;
            case 20: PLL.Gc(cube); break;
            case 21: PLL.Gd(cube); break;
        }
    }
    
    public static void doTrainAlg(RubiksCube cube, int alg){
        switch(alg){
            case 1:  PLL.Ab(cube); break;
            case 2:  PLL.Aa(cube); break;
            case 3:  PLL.E(cube);  break;
            case 4:  PLL.Ub(cube); break;
            case 5:  PLL.Ua(cube); break;
            case 6:  PLL.H(cube);  break;
            case 7:  PLL.Z(cube);  break;
            case 8:  PLL.Ja(cube); break;
            case 9:  PLL.Jb(cube); break;
            case 10: PLL.T(cube);  break;
            case 11: PLL.Ra(cube); break;
            case 12: PLL.Rb(cube); break;
            case 13: PLL.F(cube);  break;
            case 14: PLL.V(cube);  break;
            case 15: PLL.Na(cube); break;
            case 16: PLL.Nb(cube); break;
            case 17: PLL.Y(cube);  break;
            case 18: PLL.Gb(cube); break;
            case 19: PLL.Ga(cube); break;
            case 20: PLL.Gd(cube); break;
            case 21: PLL.Gc(cube); cube.y(); break;
        }
    }
    
    public static boolean PLLSuccess(RubiksCube cube){
        String[] layer_3 = cube.Layer3();
        for(int i = 0; i<4; i++)
            if(!layer_3[i*3].equals(layer_3[i*3 + 1]) || 
               !layer_3[i*3 + 1].equals(layer_3[i*3 + 2]) ||
               !layer_3[i*3].equals(layer_3[i*3 + 2]))
                return false;
        
        return true;
    }
    
    
    //***************************************************************************
    //*  CORNERS ONLY ALGORITHMS
    //***************************************************************************
    
    
    /**
     * Algorithm 1
     ** <p>
     * x R'UR' D2 RU'R' D2 R2 x'
     ** <p>
     * Do Ab in order to set up the cube for solving with Aa
     */
    public static void Aa(RubiksCube cube){
        cube.x(); 
        Move.RpURp(cube); // <== cube.R_prime(); cube.U(); cube.R_prime(); 
        cube.D2(); 
        Move.RUpRp(cube); // <== cube.R(); cube.U_prime(); cube.R_prime(); 
        cube.D2(); cube.R2(); cube.x_prime();
    }
    
    /**
     * Algorithm 2
     * <p>
     * x R2 D2 RUR' D2 RU'R x'
     * <p>
     * Do Aa in order to set up the cube for solving with Ab
     */
    public static void Ab(RubiksCube cube){
        cube.x(); cube.R2(); cube.D2(); 
        Move.RURp(cube); // <== cube.R(); cube.U(); cube.R_prime(); 
        cube.D2(); 
        Move.RUpR(cube); // <== cube.R(); cube.U_prime(); cube.R(); 
        cube.x_prime();
    }
    
    /**
     * Algorithm 3
     * <p>
     * x' RU'R' D RUR' D' RUR' D RU'R' D' x
     * <p>
     * Do E in order to set up the cube for solving with E
     */
    public static void E(RubiksCube cube){
        cube.x_prime(); 
        Move.RUpRp(cube); // <== cube.R(); cube.U_prime(); cube.R_prime(); 
        cube.D();
        Move.RURp(cube);  // <== cube.R(); cube.U(); cube.R_prime(); 
        cube.D_prime();
        Move.RURp(cube);  // <== cube.R(); cube.U(); cube.R_prime(); 
        cube.D();
        Move.RUpRp(cube); // <== cube.R(); cube.U_prime(); cube.R_prime(); 
        cube.D_prime();
        cube.x();
    }
    
    //***************************************************************************
    //*  EDGES ONLY ALGORITHMS
    //***************************************************************************
    
    /**
     * Algorithm 4
     * 
     * RU'RU RURU' R'U' R2
     * 
     * Do Ub in order to set up the cube for solving with Ua
     */
    public static void Ua(RubiksCube cube){
        Move.RUpRU(cube);
        Move.RURUp(cube);
        Move.RpUp(cube);
        cube.R2();
    }
    
    /**
     * Algorithm 5
     * 
     * R2U RUR'U' R'U' R'UR'
     * 
     * Do Ua in order to set up the cube for solving with Ub
     */
    public static void Ub(RubiksCube cube){
        Move.R2U(cube); // <== cube.R2(); cube.U();
        Move.RURpUp(cube);
        Move.RpUp(cube);
        Move.RpURp(cube);
    }
    
    /**
     * Algorithm 6
     * 
     * M2U M2U2 M2U M2
     * 
     * Do H in order to set up the cube for solving with H
     */
    public static void H(RubiksCube cube){
        Move.M2U(cube);
        Move.M2U2(cube);
        Move.M2U(cube);
        cube.M2();
    }
    
    /**
     * Algorithm 7
     * 
     * M2U M2U M'U2 M2U2 M'U2
     * 
     * Do Z in order to set up the cube for solving with Z
     */
    public static void Z(RubiksCube cube){
        Move.M2U(cube);
        Move.M2U(cube);
        Move.MpU2(cube);
        Move.M2U2(cube);
        Move.MpU2(cube);
    }
    
    //***************************************************************************
    //*  SWAPPING TWO ADJACENT CORNERS & TWO EDGES ALGORITHMS
    //***************************************************************************
    
    /**
     * Algorithm 8
     * 
     * R'UL' U2 RU'R' U2 LRU'
     * 
     * Do Ja in order to set up the cube for solving with Ja
     */
    public static void Ja(RubiksCube cube){
        Move.RpULp(cube);
        cube.U2();
        Move.RUpRp(cube);
        cube.U2();
        Move.LRUp(cube);
    }
    
    /**
     * Algorithm 9
     * 
     * RUR'F' RUR'U' R'F R2U' R'U'
     * 
     * Do Jb in order to set up the cube for solving with Jb
     */
    public static void Jb(RubiksCube cube){
        Move.RURpFp(cube);
        Move.RURpUp(cube);
        Move.RpF(cube);
        Move.R2Up(cube);
        Move.RpUp(cube);
    }
    
    /**
     * Algorithm 10
     * 
     * RUR'U' R'F R2U' R'U'RU R'F'
     * 
     * Do T in order to set up the cube for solving with T
     */
    public static void T(RubiksCube cube){
        Move.RURpUp(cube);
        Move.RpF(cube);
        Move.R2Up(cube);
        Move.RpUpRU(cube);
        Move.RpFp(cube);
    }
    
    /**
     * Algorithm 11
     * 
     * RUR'F' RU2 R'U2 R'FRU RU2 R'U'
     * 
     * Do Ra in order to set up the cube for solving with Ra
     */
    public static void Ra(RubiksCube cube){
        Move.RURpFp(cube);
        Move.RU2(cube);
        Move.RpU2(cube);
        Move.RpFRU(cube); // <== Move.RpF(cube); Move.RU(cube);
        Move.RU2(cube);
        Move.RpUp(cube);
    }
    
    /**
     * Algorithm 12
     * 
     * R'U2 RU2 R'FRU R'U'R'F' R2U'
     * 
     * Do Rb in order to set up the cube for solving with Rb
     */
    public static void Rb(RubiksCube cube){
        Move.RpU2(cube);
        Move.RU2(cube);
        Move.RpFRU(cube);
        Move.RpUpRpFp(cube);
        Move.R2Up(cube);
    }
    
    /**
     * Algorithm 13
     * 
     * R'U'F' RUR'U' R'F R2U' R'U'RU R'UR
     * 
     * Do F in order to set up the cube for solving with F
     */
    public static void F(RubiksCube cube){
        Move.RpUp(cube); cube.F_prime();
        Move.RURpUp(cube);
        Move.RpF(cube);
        Move.R2Up(cube);
        Move.RpUpRU(cube);
        Move.RpUR(cube);
    }
    
    //***************************************************************************
    //*  SWAPPING TWO DIAGONAL CORNERS & TWO EDGES ALGORITHMS
    //***************************************************************************
    
    /**
     * Algorithm 14
     * 
     * R'UR' d' R'F' R2U' R'UR'F RF y'
     * 
     * Do V in order to set up the cube for solving with V
     */
    public static void V(RubiksCube cube){
        Move.RpURp(cube); cube.d_prime();
        Move.RpFp(cube);
        Move.R2Up(cube);
        Move.RpURpF(cube);
        Move.RF(cube);
        cube.y_prime();
    }
    
    /**
     * Algorithm 15
     * 
     * z D R'U R2D' RDU' R'U R2D' RU'R z'
     * 
     * Do Na in order to set up the cube for solving with Na
     */
    public static void Na(RubiksCube cube){
        cube.z(); cube.D();
        Move.RpU(cube); Move.R2Dp(cube);
        Move.RD(cube); cube.U_prime();
        Move.RpU(cube); Move.R2Dp(cube);
        Move.RUpR(cube); cube.z_prime();
    }
    
    /**
     * Algorithm 16
     * 
     * z U' RD' R2U R'D U' RD' R2U R'D R' z'
     * 
     * Do Nb in order to set up the cube for solving with Nb
     */
    public static void Nb(RubiksCube cube){
        cube.z(); cube.U_prime();
        Move.RDp(cube); Move.R2U(cube);
        Move.RpD(cube); cube.U_prime();
        Move.RDp(cube); Move.R2U(cube);
        Move.RpD(cube); cube.R_prime();
        cube.z_prime();
    }
    
    /**
     * Algorithm 17
     * 
     * FRU' R'U'RU R'F' RUR'U' R'FRF'
     * 
     * Do Y in order to set up the cube for solving with Y
     */
    public static void Y(RubiksCube cube){
        Move.FRUp(cube);
        Move.RpUpRU(cube);
        Move.RpFp(cube);
        Move.RURpUp(cube);
        Move.RpFRFp(cube);
    }
    
    //***************************************************************************
    //*  CYCLING THREE CORNERS & THREE EDGES ALGORITHMS
    //***************************************************************************
    
    /**
     * Algorithm 18
     * 
     * R2u R'UR'U' Ru' R2 y' R'UR
     * 
     * Do Gb in order to set up the cube for solving with Ga
     */
    public static void Ga(RubiksCube cube){
        Move.R2u(cube);
        Move.RpURpUp(cube);
        Move.Rup(cube);
        cube.R2(); cube.y_prime();
        Move.RpUR(cube);
    }
    
    /**
     * Algorithm 19
     * 
     * R'U'R y R2u R'URU' Ru' R2 
     * 
     * Do Ga in order to set up the cube for solving with Gb
     */
    public static void Gb(RubiksCube cube){
        Move.RpUpR(cube);
        cube.y();
        Move.R2u(cube);
        Move.RpURUp(cube);
        Move.Rup(cube);
        cube.R2();
    }
    
    /**
     * Algorithm 20
     * 
     * R2u' RU'RU R'u R2 f R' f'
     * 
     * Do Gd in order to set up the cube for solving with Gc
     */
    public static void Gc(RubiksCube cube){
        Move.R2up(cube);
        Move.RUpRU(cube);
        Move.Rpu(cube);
        cube.R2(); cube.f();
        cube.R_prime(); cube.f_prime();
    }
    
    /**
     * Algorithm 21
     ** 
     * RUR' y' R2u' RU'R'U R'u R2
     ** 
     * Do Gc & y in order to set up the cube for solving with Gd
     */
    public static void Gd(RubiksCube cube){
        Move.RURp(cube);
        cube.y_prime();
        Move.R2up(cube);
        Move.RUpRpU(cube);
        Move.Rpu(cube);
        cube.R2();
    }
}
