/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

/**
 *
 * @author ivan
 */
public class F2L {
    
    public static void main(String[] args){
        RubiksCube rc = new RubiksCube();
//        for(int i = 41; i <= 42; i++){
//            doTrainAlg(rc, i);
//            new CubeVisualizer(rc,"train "+i);
//            doF2LAlg(rc, i);
//            new CubeVisualizer(rc,"train "+i);
//            rc = new RubiksCube();
//        }
//        doTrainAlg(rc, 44);
//        new CubeVisualizer(rc,"1");
//        doF2LAlg(rc, 44);
//        new CubeVisualizer(rc,"2"); 
//        prepareF2L(rc);
//        new CubeVisualizer(rc,"3");
    }
    
    public static void doTrainAlg(RubiksCube cube, int alg){
        switch(alg){
            case 1:  F2L.A01(cube);     break;
            case 2:  F2L.A_I02(cube);   break;
            case 3:  F2L.A02(cube);     break;
            case 4:  F2L.A04(cube);   break;
            case 5:  F2L.A06(cube);     break;
            case 6:  F2L.A05(cube);     break;
            case 7:  F2L.A11(cube);     break;
            case 8:  F2L.A12(cube);     break;
            case 9:  F2L.A_I09(cube);     break;
            case 10: F2L.A_I10(cube);     break;
            case 11: F2L.A07(cube);     break;
            case 12: F2L.A08(cube);     break;
            case 13: F2L.A_I13(cube);     break;
            case 14: F2L.A10(cube);   break;
            case 15: F2L.A24(cube);     break;
            case 16: F2L.A_I16(cube);     break;
            case 17: F2L.A_I17(cube);   break;
            case 18: F2L.A_I18(cube);     break;
            case 19: F2L.A37(cube);     break;
            case 20: F2L.A_I20(cube);     break;
            case 21: F2L.A_I21(cube);     break;
            case 22: F2L.A_I22(cube);     break;
            case 23: F2L.A23(cube);     break;
            case 24: F2L.A15(cube);   break;
            case 25: F2L.A26(cube);   break;
            case 26: F2L.A_I26(cube);     break;
            case 27: F2L.A27(cube);     break;
            case 28: F2L.A_I28(cube);   break;
            case 29: F2L.A17(cube);   break;
            case 30: F2L.A_I30(cube);     break;
            case 31: F2L.A38(cube);   break;
            case 32: F2L.A_I32(cube);     break;
            case 33: F2L.A_I33(cube);     break;
            case 34: F2L.A_I34(cube);   break;
            case 35: F2L.A_I35(cube);   break;
            case 36: F2L.A25(cube);     break;
            case 37: F2L.A_I37(cube);     break;
            case 38: F2L.A31(cube);     break;
            case 39: F2L.A_I39(cube);   break;
            case 40: F2L.A40(cube);     break;
            case 41: F2L.A28(cube);   break;
            case 42: F2L.A_I42(cube); break;
            case 43: F2L.A_I43(cube); break;
            case 44: F2L.A_I44(cube); break;
        }
    }
    
    public static String[] F2L_ALGORITHMS = {"List of PLL algorithms",
        "RU'R' d R'U2 RU2 R'UR", 
        "U RU'R' d' L'UL",
        "R'U'R'U' R'URU R", 
        "RUR'U' RUR'U' RUR'",
        "d R'U RU2 R'UR", 
        "U' RU' R'U2 RU'R'",
        "R2U2 R'U'RU' R'U2 R'", 
        "RU'RU y RU'R' F2",
        "U2 RU'R' y L'U' L", 
        "RU'R'U RU'R'",
        "RU2 RUR'U RU2 R2", 
        "RU'R' F' L'U2 L F",
        "RU2 R' y' R'U2 R", 
        "RUR'U' RUR'",
        "RU'R' d R'UR", 
        "y L'U2 LU L'U' L",
        "U2 R2U2 R'U'RU' R2", 
        "d' L' U2 LU' L'U L",
        "U2 RUR'U RU'R'", 
        "RU2 R'U' RUR'",
        "y U2 L2 U2 LU L'U L2", 
        "U RU2 R'U RU'R'",
        "F' L' U2 L F", 
        "d R'U'R d' RUR'",
        "d' L'U L", 
        "d R'U2 Rd' RUR'",
        "d R'U'R U2 R'UR", 
        "d R'UR d' RUR'",
        "U' RU'R'U RUR'", 
        "RU' R'U2 y' R'U'R",
        "RUR'", 
        "d R'U2 RU2 R'UR",
        "U' RUR' d R'U'R", 
        "d R'URU' R'U'R",
        "lU L F' L'U' l'", 
        "y L'U' L",
        "U' RU2 R'U2 RU'R'", 
        "U RU'R'",
        "U' RU2 R'd R'U'R", 
        "U' RUR' U2 RU'R'",
        "U' RU'R' d R'U'R"};
    
    public static void doF2LAlg(RubiksCube cube, int alg){
        
        switch(alg){
            case 1:
                F2L.A01(cube);
                break;
            case 2:
                F2L.A02(cube);
                break;
            case 3:
                F2L.A03(cube);
                break;
            case 4:
                F2L.A04(cube);
                break;
            case 5:
                F2L.A05(cube);
                break;
            case 6:
                F2L.A06(cube);
                break;
            case 7:
                F2L.A07(cube);
                break;
            case 8:
                F2L.A08(cube);
                break;
            case 9:
                F2L.A09(cube);
                break;
            case 10:
                F2L.A10(cube);
                break;
            case 11:
                F2L.A11(cube);
                break;
            case 12:
                F2L.A12(cube);
                break;
            case 13:
                F2L.A13(cube);
                break;
            case 14:
                F2L.A14(cube);
                break;
            case 15:
                F2L.A15(cube);
                break;
            case 16:
                F2L.A16(cube);
                break;
            case 17:
                F2L.A17(cube);
                break;
            case 18:
                F2L.A18(cube);
                break;
            case 19:
                F2L.A19(cube);
                break;
            case 20:
                F2L.A20(cube);
                break;
            case 21:
                F2L.A21(cube);
                break;
            case 22:
                F2L.A22(cube);
                break;
            case 23:
                F2L.A23(cube);
                break;
            case 24:
                F2L.A24(cube);
                break;
            case 25:
                F2L.A25(cube);
                break;
            case 26:
                F2L.A26(cube);
                break;
            case 27:
                F2L.A27(cube);
                break;
            case 28:
                F2L.A28(cube);
                break;
            case 29:
                F2L.A29(cube);
                break;
            case 30:
                F2L.A30(cube);
                break;
            case 31:
                F2L.A31(cube);
                break;
            case 32:
                F2L.A32(cube);
                break;
            case 33:
                F2L.A33(cube);
                break;
            case 34:
                F2L.A34(cube);
                break;
            case 35:
                F2L.A35(cube);
                break;
            case 36:
                F2L.A36(cube);
                break;
            case 37:
                F2L.A37(cube);
                break;
            case 38:
                F2L.A38(cube);
                break;
            case 39:
                F2L.A39(cube);
                break;
            case 40:
                F2L.A40(cube);
                break;
            case 41:
                F2L.A41(cube);
                break;
            case 42:
                F2L.A42(cube);
                break;
            case 43:
                F2L.A43(cube);
                break;
            case 44:
                F2L.A44(cube);
                break;
        }
    }
    
    /**
     * Only used for the special cases in which the edge cube is hidden in the 
     * F2L layer (Algs 42, 43, 44). 
     * @param cube
     * @param alg
     * @return
     */
    public static String doF2LAlgS(RubiksCube cube, int alg){
        
        switch(alg){
            
            case 42: return F2L.A42(cube); 
            case 43: return F2L.A43(cube); 
            case 44: return F2L.A44(cube); 
        }
        return "";
    }
    
    public static boolean F2LComplete(RubiksCube cube){
        RubiksCube rc = new RubiksCube(cube.getCube());
        for(int i = 0; i<4; i++){
            if(!F2LSuccess(rc))
                return false;
            rc.d();
        }
        return true;       
    }
    
    public static boolean F2LSuccess(RubiksCube cube){
        double[] data = CubeData.F2LDataRow(cube);
        return (data[25] == 689 && data[30] == 89);
    }
    
    /**
     * @param cube
     * @return 
     */
    public static int prepareF2L(RubiksCube cube){
        String corner = "" + cube.getColor(0, 1, 1) + cube.getColor(1, 1, 1) + cube.getColor(4, 1, 1);
        String[] corners = Cubicle.getUpperCorners(cube);
        int u_turns = 0;
        for(String try_c : corners)
            if(!Cubicle.equalsCorner(try_c, corner)){
                cube.U_prime();
                u_turns++;
            }
            else
                break;
        if(u_turns >= 4){
            u_turns = 0;
            for(int i = 0; i < 4; i++)
            {
                String UF = Cubicle.getUF(cube);
                String UR = Cubicle.getUR(cube);
                if(("" + cube.getColor(1, 1, 1)).equals("" + UF.charAt(1)) && ("" + cube.getColor(4, 1, 1)).equals("" + UF.charAt(0)) 
                || ("" + cube.getColor(4, 1, 1)).equals("" + UR.charAt(1)) && ("" + cube.getColor(1, 1, 1)).equals("" + UR.charAt(0)))
                    break;
                else{
                    cube.U_prime();
                    u_turns++;
                }
            }
        }
        return u_turns;
    }
    //***************************************************************************
    //*   CORNER CORRECT, EDGE NOT PLACED
    //***************************************************************************
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 01
     ** <p>
     * FR: RU'R' d R'U2 RU2 R'UR [d']
     ** <p>
     * Do Algorithm 01 in order to set up the cube for solving with Algorithm 01
     * <P>
     * @param cube 
     */
    public static void A01(RubiksCube cube){
        Move.RUpRp(cube);
        cube.d();
        Move.RpU2(cube);
        Move.RU2(cube);
        Move.RpUR(cube);
//        cube.d_prime(); //added for data training
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 02
     ** <p>
     * FR: U RU'R' d' L'UL [d]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A02(RubiksCube cube){
        cube.U();
        Move.RUpRp(cube);
        cube.d_prime();
        Move.LpU(cube);
        cube.L(); 
//        cube.d(); //added for data training
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 02 inverse/setup
     ** <p>
     * FR: d' L'U' L d RUR'U'
     ** <p>
     * Inverse of algorithm 02
     * <P>
     * @param cube 
     */
    public static void A_I02(RubiksCube cube){
        cube.d_prime();
        Move.LpUp(cube);
        cube.L(); cube.d();
        Move.RURpUp(cube);
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 03
     ** <p>
     * R'U'R'U' R'URU R
     ** <p>
     * Do Algorithm 02 || 03 in order to set up the cube for solving with Algorithm 03
     * <P>
     * @param cube 
     */
    public static void A03(RubiksCube cube){
        Move.RpUpRpUp(cube);
        Move.RpU(cube);
        Move.RU(cube);
        cube.R();
    }
    
    //***************************************************************************
    //*   EDGE CORRECT, CORNER SLOT FREE
    //***************************************************************************
    
    /**
     * EDGE CORRECT, CORNER SLOT FREE
     * <p>
     * Algorithm 04
     ** <p>
     * FR: RUR'U' RUR'U' RUR' [U']
     ** <p>
     * Do Algorithm 04 in order to set up the cube for solving with Algorithm 04
     * <P>
     * @param cube 
     */
    public static void A04(RubiksCube cube){
        Move.RURpUp(cube);
        Move.RURpUp(cube);
        Move.RURp(cube);
//        cube.U_prime(); //added for data training
    }
    
    /**
     * EDGE CORRECT, CORNER SLOT FREE
     * <p>
     * Algorithm 05
     ** <p>
     * FR: d R'U RU2 R'UR [y U]
     ** <p>
     * Do Algorithm 06 in order to set up the cube for solving with Algorithm 05
     * <P>
     * @param cube 
     */
    public static void A05(RubiksCube cube){
        cube.d();
        Move.RpU(cube);
        Move.RU2(cube);
        Move.RpUR(cube);
//        cube.y(); cube.U(); //added for data training
    }
    
    /**
     * EDGE CORRECT, CORNER SLOT FREE
     * <p>
     * Algorithm 06
     ** <p>
     * FR: U' RU' R'U2 RU'R' [U']
     ** <p>
     * Do Algorithm 05 in order to set up the cube for solving with Algorithm 06
     * <P>
     * @param cube 
     */
    public static void A06(RubiksCube cube){
        cube.U_prime();
        Move.RUp(cube);
        Move.RpU2(cube);
        Move.RUpRp(cube);
//        cube.U_prime(); //added for data training
    }
    
    //***************************************************************************
    //*   CORNER IN FIRST LAYER TWISTED CLOCKWISE
    //***************************************************************************
    
    /**
     * CORNER IN FIRST LAYER TWISTED CLOCKWISE
     * <P>
     * Algorithm 07
     ** <p>
     * FR: R2U2 R'U'RU' R'U2 R'
     ** <p>
     * Do Algorithm 11 in order to set up the cube for solving with Algorithm 07
     * <P>
     * @param cube 
     */
    public static void A07(RubiksCube cube){
        Move.R2U2(cube);
        Move.RpUpR(cube); cube.U_prime();
        Move.RpU2(cube);
        cube.R_prime();
    }
    
    /**
     * CORNER IN FIRST LAYER TWISTED CLOCKWISE
     * <P>
     * Algorithm 08
     ** <p>
     * FR: RU'RU y RU'R' F2 [y']
     ** <p>
     * Do Algorithm 12 in order to set up the cube for solving with Algorithm 08
     * <P>
     * @param cube 
     */
    public static void A08(RubiksCube cube){
        Move.RUpRU(cube);
        cube.y();
        Move.RUpRp(cube);
        cube.F2();
//        cube.y_prime(); //added for data training
    }
    
    /**
     * CORNER IN FIRST LAYER TWISTED CLOCKWISE
     * <P>
     * Algorithm 09
     ** <p>
     * FR: U2 RU'R' y L'U' L [y']
     ** <p>
     * Do Algorithm xx in order to set up the cube for solving with Algorithm 09
     * <P>
     * @param cube 
     */
    public static void A09(RubiksCube cube){
        cube.U2();
        Move.RUpRp(cube);
        cube.y();
        Move.LpUp(cube);
        cube.L();
//        cube.y_prime(); //added for data training
//        cube.y(); // added for correct oritentation
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 09 inverse/setup
     ** <p>
     * FR: L'U L y' RU R'U2
     ** <p>
     * Inverse of algorithm 09
     * <P>
     * @param cube 
     */
    public static void A_I09(RubiksCube cube){
        Move.LpU(cube);
        cube.L(); cube.y_prime();
        Move.RU(cube);
        Move.RpU2(cube);
    }
    
    /**
     * CORNER IN FIRST LAYER TWISTED CLOCKWISE
     * <P>
     * Algorithm 10
     ** <p>
     * FR: RU'R'U RU'R'
     ** <p>
     * Do Algorithm 13 in order to set up the cube for solving with Algorithm 10
     * <P>
     * @param cube 
     */
    public static void A10(RubiksCube cube){
        Move.RUpRpU(cube);
        Move.RUpRp(cube);
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 10 inverse/setup
     ** <p>
     * FR: RUR'U' RUR'
     ** <p>
     * Inverse of algorithm 10
     * <P>
     * @param cube 
     */
    public static void A_I10(RubiksCube cube){
        Move.RURpUp(cube);
        Move.RURp(cube);
    }
    
    //***************************************************************************
    //*   CORNER IN FIRST LAYER TWISTED COUNTER-CLOCKWISE
    //***************************************************************************
    
    /**
     * CORNER IN FIRST LAYER TWISTED COUNTER-CLOCKWISE
     * <P>
     * Algorithm 11
     ** <p>
     * FR: RU2 RUR'U RU2 R2
     ** <p>
     * Do Algorithm 07 in order to set up the cube for solving with Algorithm 11
     * <P>
     * @param cube 
     */
    public static void A11(RubiksCube cube){
        Move.RU2(cube);
        Move.RURpU(cube);
        Move.RU2(cube);
        cube.R2();
    }
    
    /**
     * CORNER IN FIRST LAYER TWISTED COUNTER-CLOCKWISE
     * <P>
     * Algorithm 12
     ** <p>
     * FR: RU'R' F' L'U2 L F
     ** <p>
     * Do Algorithm 08 in order to set up the cube for solving with Algorithm 12
     * <P>
     * @param cube 
     */
    public static void A12(RubiksCube cube){
        Move.RUpRp(cube);
        cube.F_prime();
        cube.L_prime(); cube.U2();
        cube.L(); cube.F();
    }
    
    /**
     * CORNER IN FIRST LAYER TWISTED COUNTER-CLOCKWISE
     * <P>
     * Algorithm 13
     ** <p>
     * FR: RU2 R' y' R'U2 R [y]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A13(RubiksCube cube){
        Move.RU2(cube);
        cube.R_prime(); cube.y_prime();
        Move.RpU2(cube);
        cube.R();
//        cube.y(); //added for data training
//        cube.y_prime(); // added for correct oritentation
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 13 inverse/setup
     ** <p>
     * FR: R'U2 R y RU2 R'
     ** <p>
     * Inverse of algorithm 13
     * <P>
     * @param cube 
     */
    public static void A_I13(RubiksCube cube){
        Move.RpU2(cube);
        cube.R(); cube.y();
        Move.RU2(cube);
        cube.R_prime();
    }
    
    /**
     * CORNER IN FIRST LAYER TWISTED COUNTER-CLOCKWISE
     * <P>
     * Algorithm 14
     ** <p>
     * FR: RUR'U' RUR'
     ** <p>
     * Do Algorithm 10 in order to set up the cube for solving with Algorithm 14
     * <P>
     * @param cube 
     */
    public static void A14(RubiksCube cube){
        Move.RURpUp(cube);
        Move.RURp(cube);
    }
    
    //***************************************************************************
    //*   CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
    //***************************************************************************
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 15
     ** <p>
     * FR: RU'R' d R'UR [d']
     ** <p>
     * Do Algorithm 24 in order to set up the cube for solving with Algorithm 15
     * <P>
     * @param cube 
     */
    public static void A15(RubiksCube cube){
        Move.RUpRp(cube);
        cube.d();
        Move.RpUR(cube);
//        cube.d_prime(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 16
     ** <p>
     * FL: (y) L'U2 LU L'U' L [d]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A16(RubiksCube cube){
        cube.y(); // added to set up into correct position
        cube.L_prime(); cube.U2();
        Move.LU(cube);
        Move.LpUp(cube);
        cube.L(); 
//        cube.d(); //added for data training
//        cube.y(); // added for correct oritentation
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 16 inverse/setup
     ** <p>
     * FR: L'U LU' L'U2 L
     ** <p>
     * Inverse of algorithm 16
     * <P>
     * @param cube 
     */
    public static void A_I16(RubiksCube cube){
        Move.LpU(cube);
        Move.LUp(cube);
        cube.L_prime(); cube.U2();
        cube.L();
        cube.y_prime();
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 17
     ** <p>
     * FR: U2 R2U2 R'U'RU' R2 [U2]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A17(RubiksCube cube){
        cube.U2();
        Move.R2U2(cube);
        Move.RpUp(cube);
        Move.RUp(cube);
        cube.R2();
//        cube.U2(); //added for data training
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 17 inverse/setup
     ** <p>
     * FR: R2U R'U RU2 R2U2
     ** <p>
     * Inverse of algorithm 17
     * <P>
     * @param cube 
     */
    public static void A_I17(RubiksCube cube){
        Move.R2U(cube);
        Move.RpU(cube);
        Move.RU2(cube);
        Move.R2U2(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 18
     ** <p>
     * FR: d' L' U2 LU' L'U L [d U2]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A18(RubiksCube cube){
        cube.d_prime(); cube.L_prime(); cube.U2();
        Move.LUp(cube);
        Move.LpU(cube);
        cube.L(); 
//        cube.d(); cube.U2(); //added for data training
//        cube.y(); // added for correct oritentation
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 18 inverse/setup
     ** <p>
     * FR: L'U' LU L' U2 L d
     ** <p>
     * Inverse of algorithm 18
     * <P>
     * @param cube 
     */
    public static void A_I18(RubiksCube cube){
        Move.LpUp(cube);
        Move.LU(cube);
        cube.L_prime(); cube.U2();
        cube.L(); cube.d();
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 19
     ** <p>
     * FR: U2 RUR'U RU'R' [U']
     ** <p>
     * Do Algorithm 37 in order to set up the cube for solving with Algorithm 19
     * <P>
     * @param cube 
     */
    public static void A19(RubiksCube cube){
        cube.U2();
        Move.RURpU(cube);
        Move.RUpRp(cube);
//        cube.U_prime(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 20
     ** <p>
     * FR: RU2 R'U' RUR' [U2]
     ** <p>
     * Do inverse algorithm to setup
     * Use for 38
     * <P>
     * @param cube 
     */
    public static void A20(RubiksCube cube){
        Move.RU2(cube);
        Move.RpUp(cube);
        Move.RURp(cube);
//        cube.U2(); //added for data training
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 20 inverse/setup
     ** <p>
     * FR: RU' R'U RU2 R'
     ** <p>
     * Inverse of algorithm 20
     * <P>
     * @param cube 
     */
    public static void A_I20(RubiksCube cube){
        Move.RUp(cube);
        Move.RpU(cube);
        Move.RU2(cube);
        cube.R_prime();
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 21
     ** <p>
     * FL: (y) U2 L2 U2 LU L'U L2 [U d]
     ** <p>
     * Do inverse algorithm to setup
     * Use for 34
     * <P>
     * @param cube 
     */
    public static void A21(RubiksCube cube){
        cube.y(); // added to correctly set up into position
        cube.U2(); cube.L2(); cube.U2();
        Move.LU(cube);
        Move.LpU(cube);
        cube.L2(); 
//        cube.U(); cube.d(); //added for data training
//        cube.y(); // added for correct oritentation
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 21 inverse/setup
     ** <p>
     * FL: L2 U' LU' L' U2 L2 U2
     ** <p>
     * Inverse of algorithm 21
     * <P>
     * @param cube 
     */
    public static void A_I21(RubiksCube cube){
        cube.L2(); cube.U_prime();
        Move.LUp(cube);
        cube.L_prime(); cube.U2();
        cube.L2(); cube.U2();
        cube.y_prime();
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 22
     ** <p>
     * FR: U RU2 R'U RU'R'
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A22(RubiksCube cube){
        cube.U();
        Move.RU2(cube);
        Move.RpU(cube);
        Move.RUpRp(cube);
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 22 inverse/setup
     ** <p>
     * FR: RUR'U' RU2 R'U'
     ** <p>
     * Inverse of algorithm 22
     * <P>
     * @param cube 
     */
    public static void A_I22(RubiksCube cube){
        Move.RURpUp(cube);
        Move.RU2(cube);
        Move.RpUp(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON U-FACE
     * <P>
     * Algorithm 23
     ** <p>
     * FR: F' L' U2 L F
     ** <p>
     * Do Algorithm 23 in order to set up the cube for solving with Algorithm 23
     * <P>
     * @param cube 
     */
    public static void A23(RubiksCube cube){
        cube.F_prime(); cube.L_prime(); cube.U2();
        cube.L(); cube.F();
    }
    
    //***************************************************************************
    //*   CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
    //***************************************************************************
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 24
     ** <p>
     * FR: d R'U'R d' RUR'
     ** <p>
     * Do Algorithm 15 in order to set up the cube for solving with Algorithm 24
     * <P>
     * @param cube 
     */
    public static void A24(RubiksCube cube){
        cube.d();
        Move.RpUpR(cube);
        cube.d_prime();
        Move.RURp(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 25
     ** <p>
     * FR: d' L'U L
     ** <p>
     * Do Algorithm 26 in order to set up the cube for solving with Algorithm 25
     * <P>
     * @param cube 
     */
    public static void A25(RubiksCube cube){
        cube.d_prime();
        Move.LpU(cube);
        cube.L();
//        cube.y_prime(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 26
     ** <p>
     * FR: d R'U2 Rd' RUR' [U2]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A26(RubiksCube cube){
        cube.d();
        Move.RpU2(cube);
        Move.Rdp(cube);
        Move.RURp(cube);
//        cube.U2(); //added for data training
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 26 inverse/setup
     ** <p>
     * FR: RU'R' d R'U2 Rd'
     ** <p>
     * Inverse of algorithm 26
     * <P>
     * @param cube 
     */
    public static void A_I26(RubiksCube cube){
        Move.RUpRp(cube);
        cube.d();
        Move.RpU2(cube);
        Move.Rdp(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 27
     ** <p>
     * FR: d R'U'R U2 R'UR [d']
     ** <p>
     * Do Algorithm 27 in order to set up the cube for solving with Algorithm 27
     * <P>
     * @param cube 
     */
    public static void A27(RubiksCube cube){
        cube.d();
        Move.RpUpR(cube);
        cube.U2();
        Move.RpUR(cube);
//        cube.d_prime(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 28
     ** <p>
     * FR: d R'UR d' RUR' [U]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A28(RubiksCube cube){
        cube.d();
        Move.RpUR(cube);
        cube.d_prime();
        Move.RURp(cube);
//        cube.U(); //added for data training
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 28 inverse/setup
     ** <p>
     * FR: RU'R' d R'U'R d'
     ** <p>
     * Inverse of algorithm 28
     * <P>
     * @param cube 
     */
    public static void A_I28(RubiksCube cube){
        Move.RUpRp(cube);
        cube.d();
        Move.RpUp(cube);
        Move.Rdp(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 29
     ** <p>
     * FR: U' RU'R'U RUR' [U2]
     ** <p>
     * Do Algorithm 17 in order to set up the cube for solving with Algorithm 29
     * <P>
     * @param cube 
     */
    public static void A29(RubiksCube cube){
        cube.U_prime();
        Move.RUpRpU(cube);
        Move.RURp(cube);
//        cube.U2(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 30
     ** <p>
     * FR: RU' R'U2 y' R'U'R [y]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A30(RubiksCube cube){
        Move.RUp(cube);
        Move.RpU2(cube);
        cube.y_prime();
        Move.RpUpR(cube);
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 30 inverse/setup
     ** <p>
     * FR: R'UR y U2 RU R'
     ** <p>
     * Inverse of algorithm 30
     * <P>
     * @param cube 
     */
    public static void A_I30(RubiksCube cube){
        Move.RpUR(cube);
        cube.y(); cube.U2();
        Move.RURp(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 31
     ** <p>
     * FR: RUR' [U']
     ** <p>
     * Do Algorithm 38 in order to set up the cube for solving with Algorithm 31
     * <P>
     * @param cube 
     */
    public static void A31(RubiksCube cube){
        Move.RURp(cube);
//        cube.U_prime(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 32
     ** <p>
     * FR: d R'U2 RU2 R'UR [y U2]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A32(RubiksCube cube){
        cube.d();
        Move.RpU2(cube);
        Move.RU2(cube);
        Move.RpUR(cube);
//        cube.y(); cube.U2(); //added for data training
//        cube.y_prime();// added for correct oritentation
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 32 inverse/setup
     ** <p>
     * FR: R'U' RU2 R'U2 Rd'
     ** <p>
     * Inverse of algorithm 32
     * <P>
     * @param cube 
     */
    public static void A_I32(RubiksCube cube){
        Move.RpUp(cube);
        Move.RU2(cube);
        Move.RpU2(cube);
        Move.Rdp(cube);
    }
    
    //***************************************************************************
    //*   CORNER IN U-LAYER WITH CROSS-COLOR ON F-FACE
    //***************************************************************************
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 33
     ** <p>
     * FR: U' RUR' d R'U'R [y]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A33(RubiksCube cube){
        cube.U_prime();
        Move.RURp(cube);
        cube.d();
        Move.RpUpR(cube);
//        cube.y(); //added for data training
//        cube.y_prime();// added for correct oritentation
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 33 inverse/setup
     ** <p>
     * FR: R'UR d' RU'R'U
     ** <p>
     * Inverse of algorithm 33
     * <P>
     * @param cube 
     */
    public static void A_I33(RubiksCube cube){
        Move.RpUR(cube);
        cube.d_prime();
        Move.RUpRpU(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 34
     ** <p>
     * FR: d R'URU' R'U'R [y U2]
     ** <p>
     * Do Algorithm 21 in order to set up the cube for solving with Algorithm 34
     * <P>
     * @param cube 
     */
    public static void A34(RubiksCube cube){
        cube.d();
        Move.RpURUp(cube);
        Move.RpUpR(cube);
//        cube.y(); cube.U2(); //added for data training
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 33 inverse/setup
     ** <p>
     * FR: R'UR d' RU'R'U
     ** <p>
     * Inverse of algorithm 33
     * <P>
     * @param cube 
     */
    public static void A_I34(RubiksCube cube){
        cube.y(); // added to correctly set up into position
        cube.U2(); cube.L2(); cube.U2();
        Move.LU(cube);
        Move.LpU(cube);
        cube.L2(); 
        cube.U(); cube.d();
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 35
     ** <p>
     * FR: lU L F' L'U' l' [U]
     ** <p>
     * Do Algorithm 30 in order to set up the cube for solving with Algorithm 35
     * <P>
     * @param cube 
     */
    public static void A35(RubiksCube cube){
        Move.lU(cube);
        cube.L(); cube.F_prime();
        Move.LpUp(cube);
        cube.l_prime();
//        cube.U(); //added for data training
    }
    
    /**
     * CORNER CORRECT, EDGE NOT PLACED
     * <p>
     * Algorithm 35 inverse/setup
     ** <p>
     * FR: R'UR d' RU'R'U y
     ** <p>
     * Inverse of algorithm 35
     * <P>
     * @param cube 
     */
    public static void A_I35(RubiksCube cube){
        Move.RUp(cube);
        Move.RpU2(cube);
        cube.y_prime();
        Move.RpUpR(cube);
        cube.y();
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 36
     ** <p>
     * FL: (y) L'U' L [U y']
     ** <p>
     * Do Algorithm 25 in order to set up the cube for solving with Algorithm 36
     * <P>
     * @param cube 
     */
    public static void A36(RubiksCube cube){
        cube.y(); // added to correctly set up into position
        Move.LpUp(cube); cube.L();
//        cube.U(); cube.y_prime(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 37
     ** <p>
     * FR: U' RU2 R'U2 RU'R' [U2]
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A37(RubiksCube cube){
        cube.U_prime();
        Move.RU2(cube);
        Move.RpU2(cube);
        Move.RUpRp(cube);
//        cube.U2(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <p>
     * Algorithm 37 inverse/setup
     ** <p>
     * FR: RU R'U2 RU2 R'U
     ** <p>
     * Inverse of algorithm 37
     * <P>
     * @param cube 
     */
    public static void A_I37(RubiksCube cube){
        Move.RU(cube);
        Move.RpU2(cube);
        Move.RU2(cube);
        Move.RpU(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 38
     ** <p>
     * FR: U RU'R'
     ** <p>
     * Do Algorithm 31 in order to set up the cube for solving with Algorithm 38
     * <P>
     * @param cube 
     */
    public static void A38(RubiksCube cube){
        cube.U();
        Move.RUpRp(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 39
     ** <p>
     * FR: U' RU2 R'd R'U'R [U' d']
     ** <p>
     * Do inverse algorithm to setup
     * <P>
     * @param cube 
     */
    public static void A39(RubiksCube cube){
        cube.U_prime();
        Move.RU2(cube);
        Move.Rpd(cube);
        Move.RpUpR(cube);
//        cube.U_prime(); cube.d_prime(); //added for data training
//        cube.y_prime();// added for correct oritentation
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <p>
     * Algorithm 39 inverse/setup
     ** <p>
     * FR: R'U Rd' RU2 R'U
     ** <p>
     * Inverse of algorithm 39
     * <P>
     * @param cube 
     */
    public static void A_I39(RubiksCube cube){
        Move.RpU(cube);
        Move.Rdp(cube);
        Move.RU2(cube);
        Move.RpU(cube);
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 40
     ** <p>
     * FR: U' RUR' U2 RU'R' [U]
     ** <p>
     * Do Algorithm 40 in order to set up the cube for solving with Algorithm 40
     * <P>
     * @param cube 
     */
    public static void A40(RubiksCube cube){
        cube.U_prime();
        Move.RURp(cube);
        cube.U2();
        Move.RUpRp(cube);
//        cube.U(); //added for data training
    }
    
    /**
     * CORNER IN U-LAYER WITH CROSS-COLOR ON R-FACE
     * <P>
     * Algorithm 41
     ** <p>
     * FR: U' RU'R' d R'U'R [d']
     ** <p>
     * Do Algorithm 28 in order to set up the cube for solving with Algorithm 41
     * <P>
     * @param cube 
     */
    public static void A41(RubiksCube cube){
        cube.U_prime();
        Move.RUpRp(cube);
        cube.d();
        Move.RpUpR(cube);
//        cube.d_prime(); //added for data training
    }
    
    /**
     * This algorithm is used when the corner is on the working space but the edge
     * is incorrectly placed or hidden in the middle layer.
     * @param cube 
     */
    public static String A42(RubiksCube cube){
        String moves = "";
        String edge = "" + cube.getColor(1, 1, 1) + cube.getColor(4, 1, 1);
        int rot = Cubicle.findEdge(cube, edge);
        for(int i = 0; i < rot; i++)
            cube.d();
        if(rot == 1) moves += "d";
        else if(rot == 2) moves += "d2";
        else if(rot == 3) moves += "d'";
        A03(cube);
        moves += F2L_ALGORITHMS[3];
        for(int i = 0; i < rot; i++)
            cube.d_prime();
        if(rot == 1) moves += "d'";
        else if(rot == 2) moves += "d2";
        else if(rot == 3) moves += "d";
        return moves;
    }
    
    public static void A_I42(RubiksCube cube){
        A03(cube);
        cube.y_prime();
        A02(cube);
        A04(cube);
        cube.y();
    }
    
    public static String A43(RubiksCube cube){
        return A42(cube) + A44(cube);
    }
    
    public static void A_I43(RubiksCube cube){
        A31(cube);
        cube.d2();
        A31(cube);
        cube.d2();
    }
    
    public static String A44(RubiksCube cube){
        String moves = "";
        String corner = "" + cube.getColor(0, 1, 1) + cube.getColor(1, 1, 1) + cube.getColor(4, 1, 1);
        int rot = Cubicle.findCorner(cube, corner);
        for(int i = 0; i < rot; i++)
            cube.d();
        if(rot == 1) moves += "d";
        else if(rot == 2) moves += "d2";
        else if(rot == 3) moves += "d'";
        A04(cube);
        moves += F2L_ALGORITHMS[4];
        for(int i = 0; i < rot; i++)
            cube.d_prime();
        if(rot == 1) moves += "d'";
        else if(rot == 2) moves += "d2";
        else if(rot == 3) moves += "d";
        return moves;
    }
    
    public static void A_I44(RubiksCube cube){
        A05(cube);
        cube.d2();
        A05(cube);
        cube.d2();
    }
    
    /**
     * 
     * <P>
     * Algorithm xx
     ** <p>
     * 
     ** <p>
     * Do Algorithm xx in order to set up the cube for solving with Algorithm xx
     * <P>
     * @param cube 
     */
    public static void Axx(RubiksCube cube){
        
    }
}
