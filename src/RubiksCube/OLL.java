/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

/**
 *
 * @author ivan
 */
public class OLL {
    
    public static String[] OLL_ALGORITHMS = {"List of PLL algorithms",
        "M'U MU2 M'U M", 
        "RUR'U' M'URU' r'",
        "r' RU RUR'U' r2 R2U RU' r'", 
        "R2D R'U2 RD' R'U2 R'",
        "rU R'U' r'F RF'", 
        "R'F RB' R'F' RB",
        "RUR'U RU2R'", 
        "RU2 R'U' RU'R'",
        "RU2' R2'U' R2U' R2'U2'R", 
        "F RUR'U' RUR'U' RUR'U' F'",
        "f RUR'U' f' U' F RUR'U' F'", 
        "f RUR'U' f' U F RUR'U' F'",
        "RUR'U R'FRF' U2 R'FRF'", 
        "r' RU RUR'U' r x R2'U RU'",
        "F RUR'U y' R'U2 R'FRF'", 
        "F RUR'U' S RUR'U' f'",
        "RU2 R2'F RF' U2' R'FRF'", 
        "RUR'U' R'FRF'",
        "F RUR'U' F'", 
        "f RUR'U' f'",
        "f' L'U'LU f", 
        "Rd L'd' R'U lU l'",
        "R'U' FU RU'R' F' R", 
        "RUR'U RU'R'U' R'FRF'",
        "L'U'LU' L'ULU LF'L'F", 
        "rU R'URU' R'U RU2' r'",
        "r'U' RU' R'URU' R'U2 r", 
        "RB' RB R2'U2 FR'F'R",
        "R'F R'F' R2U2 y R'FRF'", 
        "F RUR'U' RUR'U' F'",
        "F' L'U'LU L'U'LU F", 
        "LF' L'U'LU FU'L'",
        "R'F RUR'U' F'UR", 
        "RU R2'U' R'F RURU' F'",
        "R'U' R'FRF' U R", 
        "r'U2 RUR'U r",
        "rU2 R'U'RU' r'", 
        "rU R'U RU2 r'",
        "MU2 R'U'RU' R'U2 RU M'", 
        "r'U' RU' R'U2 r",
        "r' R2U R'U RU2 R'U M'", 
        "F RU' R'U'RU R'F'",
        "RU2 R2F RF' RU2 R'", 
        "RUR'U R'FRF' RU2 R'",
        "RUR'U' R'F R2U R'U' F'", 
        "f RUR'U' RUR'U' f'",
        "RUR'U Rd' RU'R'F'", 
        "f RUR'U' f' F RUR'U' RUR'U' F'",
        "RU2 R2U' RU' R'U2 F RF'", 
        "rU' r'U' rU r' y' R'UR",
        "rU r' RUR'U' rU' r'", 
        "R'F RUR'F' R y' RU'R'",
        "l'U' l L'U'LU l'U l", 
        "RU' R'U2 RU y RU'R'U' F'",
        "R2'U R'B' RU' R2'U lU l'", 
        "L'U LU2' L'U' y' L'ULU F",
        "L2U' L B L'U L2U' r'U' r"};
    
    public static void main(String[] args){
        RubiksCube rc = new RubiksCube();
        OLL.A01(rc);
//        rc.show();
        System.out.println(OLLSuccess(rc));
    }
    
    public static void doOLLAlg(RubiksCube cube, int alg){
        
        switch(alg){
            case 1:  OLL.A01(cube);   break;
            case 2:  OLL.A02(cube);   break;
            case 3:  OLL.A03(cube);   break;
            case 4:  OLL.A04(cube);   break;
            case 5:  OLL.A05(cube);   break;
            case 6:  OLL.A06(cube);   break;
            case 7:  OLL.A07(cube);   break;
            case 8:  OLL.A08(cube);   break;
            case 9:  OLL.A09(cube);   break;
            case 10: OLL.A10(cube);   break;
            case 11: OLL.A11(cube);   break;
            case 12: OLL.A12(cube);   break;
            case 13: OLL.A13(cube);   break;
            case 14: OLL.A14(cube);   break;
            case 15: OLL.A15(cube);   break;
            case 16: OLL.A16(cube);   break;
            case 17: OLL.A17(cube);   break;
            case 18: OLL.A18(cube);   break;
            case 19: OLL.A19(cube);   break;
            case 20: OLL.A20(cube);   break;
            case 21: OLL.A21(cube);   break;
            case 22: OLL.A22(cube);   break;
            case 23: OLL.A23(cube);   break;
            case 24: OLL.A24(cube);   break;
            case 25: OLL.A25(cube);   break;
            case 26: OLL.A26(cube);   break;
            case 27: OLL.A27(cube);   break;
            case 28: OLL.A28(cube);   break;
            case 29: OLL.A29(cube);   break;
            case 30: OLL.A30(cube);   break;
            case 31: OLL.A31(cube);   break;
            case 32: OLL.A32(cube);   break;
            case 33: OLL.A33(cube);   break;
            case 34: OLL.A34(cube);   break;
            case 35: OLL.A35(cube);   break;
            case 36: OLL.A36(cube);   break;
            case 37: OLL.A37(cube);   break;
            case 38: OLL.A38(cube);   break;
            case 39: OLL.A39(cube);   break;
            case 40: OLL.A40(cube);   break;
            case 41: OLL.A41(cube);   break;
            case 42: OLL.A42(cube);   break;
            case 43: OLL.A43(cube);   break;
            case 44: OLL.A44(cube);   break;
            case 45: OLL.A45(cube);   break;
            case 46: OLL.A46(cube);   break;
            case 47: OLL.A47(cube);   break;
            case 48: OLL.A48(cube);   break;
            case 49: OLL.A49(cube);   break;
            case 50: OLL.A50(cube);   break;
            case 51: OLL.A51(cube);   break;
            case 52: OLL.A52(cube);   break;
            case 53: OLL.A53(cube);   break;
            case 54: OLL.A54(cube);   break;
            case 55: OLL.A55(cube);   break;
            case 56: OLL.A56(cube);   break;
            case 57: OLL.A57(cube);   break;
        }
    }
    
    public static boolean OLLSuccess(RubiksCube cube){
        double[] oll_data = CubeData.OLLDataRow(cube);
        for(int i = 0; i<8; i++)
            if(oll_data[i] < 3)
                return false;
        
        return true;
    }
    
    //***************************************************************************
    //*  CORNERS CORRECT, EDGES FLIPPED
    //***************************************************************************
    
    /**
     * Algorithm 1
     ** <p>
     * M'U MU2 M'U M
     ** <p>
     * Do Algorithm 1 in order to set up the cube for solving with Algorithm 1
     * <P>
     * @param cube 
     */
    public static void A01(RubiksCube cube){
        Move.MpU(cube);
        Move.MU2(cube);
        Move.MpU(cube);
        cube.M();
//        cube.U_prime(); // Added to prepare for training
    }
    
    /**
     * Algorithm 2
     ** <p>
     * RUR'U' M'URU' r'
     ** <p>
     * Use setup algorithm 2
     * <P>
     * @param cube 
     */
    public static void A02(RubiksCube cube){
        Move.RURpUp(cube);
        Move.MpU(cube);
        Move.RUp(cube);
        cube.r_prime();
    }
    
    /**
     * Algorithm 2 setup
     ** <p>
     * F R'F' R L'U RU’ R’ L
     ** <p>
     * Used to setup for algorithm 2
     * <P>
     * @param cube 
     */
    public static void A_S02(RubiksCube cube){
        cube.F();
        Move.RpFp(cube);
        cube.R();
        Move.LpU(cube);
        Move.RUp(cube);
        cube.R_prime(); cube.L();
    }
    
    /**
     * Algorithm 3
     ** <p>
     * r' RU RUR'U' r2 R2U RU' r'
     ** <p>
     * Do Algorithm 3 in order to set up the cube for solving with Algorithm 3
     * <P>
     * @param cube 
     */
    public static void A03(RubiksCube cube){
        cube.r_prime();
        Move.RURU(cube);
        Move.RpUp(cube);
        cube.r2();
        Move.R2U(cube);
        Move.RUp(cube);
        cube.r_prime();
    }
    
    //***************************************************************************
    //*  ALL EDGES FLIPPED CORRECTLY
    //***************************************************************************
    
    /**
     * Algorithm 4˙
     ** <p>
     * R2D R'U2 RD' R'U2 R'
     ** <p>
     * Use setup algorithm 4
     * <P>
     * @param cube 
     */
    public static void A04(RubiksCube cube){
        Move.R2D(cube);
        Move.RpU2(cube);
        Move.RDp(cube);
        Move.RpU2(cube);
        cube.R_prime();
    }
    
    /**
     * Algorithm 4 setup
     ** <p>
     * RU2 RD R'U2 RD' R2
     ** <p>
     * Used to setup for algorithm 4
     * <P>
     * @param cube 
     */
    public static void A_S04(RubiksCube cube){
        Move.RU2(cube);
        Move.RD(cube);
        Move.RpU2(cube);
        Move.RDp(cube);
        cube.R2();
    }
    
    /**
     * Algorithm 5
     ** <p>
     * rU R'U' r'F RF'
     ** <p>
     * Do Algorithm 6 in order to set up the cube for solving with Algorithm 5
     * <P>
     * @param cube 
     */
    public static void A05(RubiksCube cube){
        Move.rU(cube);
        Move.RpUp(cube);
        Move.rpF(cube);
        Move.RFp(cube);
    }
    
    /**
     * Algorithm 6
     ** <p>
     * R'F RB' R'F' RB
     ** <p>
     * Do Algorithm 5 in order to set up the cube for solving with Algorithm 6
     * <P>
     * @param cube 
     */
    public static void A06(RubiksCube cube){
        Move.RpF(cube);
        Move.RBp(cube);
        Move.RpFp(cube);
        Move.RB(cube);
//        cube.U_prime(); // Added to train for alg 5
    }
    
    /**
     * Algorithm 7
     ** <p>
     * RUR'U RU2R'
     ** <p>
     * Do Algorithm 8 in order to set up the cube for solving with Algorithm 7
     * <P>
     * @param cube 
     */
    public static void A07(RubiksCube cube){
        Move.RURp(cube); cube.U();
        Move.RU2(cube);
        cube.R_prime();
    }
    
    /**
     * Algorithm 8
     ** <p>
     * 	RU2 R'U' RU'R'
     ** <p>
     * Do Algorithm 7 in order to set up the cube for solving with Algorithm 8
     * <P>
     * @param cube 
     */
    public static void A08(RubiksCube cube){
        Move.RU2(cube);
        Move.RpUp(cube);
        Move.RUpRp(cube);
    }
    
    /**
     * Algorithm 9
     ** <p>
     * RU2' R2'U' R2U' R2'U2'R
     ** <p>
     * Do Algorithm 9 in order to set up the cube for solving with Algorithm 9
     * <P>
     * @param cube 
     */
    public static void A09(RubiksCube cube){
        Move.RU2(cube);
        Move.R2Up(cube);
        Move.R2Up(cube);
        Move.R2U2(cube);
        cube.R();
    }
    
    /**
     * Algorithm 10
     ** <p>
     * F RUR'U' RUR'U' RUR'U' F'
     ** <p>
     * Do Algorithm 10 in order to set up the cube for solving with Algorithm 10
     * <P>
     * @param cube 
     */
    public static void A10(RubiksCube cube){
        cube.F();
        Move.RURpUp(cube);
        Move.RURpUp(cube);
        Move.RURpUp(cube);
        cube.F_prime();
    }
    
    //***************************************************************************
    //*  NO EDGES FLIPPED CORRECTLY
    //***************************************************************************
    
    /**
     * Algorithm 11
     ** <p>
     * f RUR'U' f' U' F RUR'U' F'
     ** <p>
     * Do Algorithm 12 in order to set up the cube for solving with Algorithm 11
     * <P>
     * @param cube 
     */
    public static void A11(RubiksCube cube){
        cube.f();
        Move.RURpUp(cube);
        cube.f_prime(); cube.U_prime(); cube.F();
        Move.RURpUp(cube);
        cube.F_prime();
//        cube.U2(); // Added to train for alg 12
    }
    
    /**
     * Algorithm 12
     ** <p>
     * f RUR'U' f' U F RUR'U' F'
     ** <p>
     * Do Algorithm 11 in order to set up the cube for solving with Algorithm 12
     * <P>
     * @param cube 
     */
    public static void A12(RubiksCube cube){
        cube.f();
        Move.RURpUp(cube);
        cube.f_prime(); cube.U(); cube.F();
        Move.RURpUp(cube);
        cube.F_prime();
//        cube.U2(); // Added to train for alg 11
    }
    
    /**
     * Algorithm 13
     ** <p>
     * RUR'U R'FRF' U2 R'FRF'
     ** <p>
     * Do Algorithm 14 in order to set up the cube for solving with Algorithm 13
     * <P>
     * @param cube 
     */
    public static void A13(RubiksCube cube){
        Move.RURpU(cube);
        Move.RpFRFp(cube);
        cube.U2();
        Move.RpFRFp(cube);
//        cube.U2(); // added to train for alg 15
    }
    
    /**
     * Algorithm 14
     ** <p>
     * r' RU RUR'U' r x R2'U RU'
     ** <p>
     * Use setup algorithm 14
     * <P>
     * @param cube 
     */
    public static void A14(RubiksCube cube){
        cube.r_prime();
        Move.RU(cube);
        Move.RURpUp(cube);
        cube.r(); cube.x();
        Move.R2U(cube);
        Move.RUp(cube);
        cube.x_prime();
//        cube.U2(); // added to train for alg 13
    }
    
    /**
     * Algorithm 14 setup
     ** <p>
     * R'F' U2 F2 U RU'R'F' U2 R
     ** <p>
     * Used to setup for algorithm 4
     * <P>
     * @param cube 
     */
    public static void A_S14(RubiksCube cube){
        Move.RpFp(cube);
        cube.U2(); cube.F2(); cube.U();
        Move.RUp(cube); Move.RpFp(cube);
        cube.U2(); cube.R();
    }
    
    /**
     * Algorithm 15
     ** <p>
     * F RUR'U y' R'U2 R'FRF'
     ** <p>
     * Do Algorithm 13 in order to set up the cube for solving with Algorithm 15
     * <P>
     * @param cube 
     */
    public static void A15(RubiksCube cube){
        cube.F();
        Move.RURpU(cube);
        cube.y_prime();
        Move.RpU2(cube);
        Move.RpFRFp(cube);
//        cube.U_prime(); // added to train for alg 13
    }
    
    /**
     * Algorithm 16
     ** <p>
     * F RUR'U' S RUR'U' f'
     ** <p>
     * Do Algorithm 16 in order to set up the cube for solving with Algorithm 16
     * <P>
     * @param cube 
     */
    public static void A16(RubiksCube cube){
        cube.F();
        Move.RURpUp(cube);
        cube.S();
        Move.RURpUp(cube);
        cube.f_prime();
//        cube.U2(); // added to train itself
    }
    
    /**
     * Algorithm 17
     ** <p>
     * RU2 R2'F RF' U2' R'FRF'
     ** <p>
     * Use setup algorithm 17
     * <P>
     * @param cube 
     */
    public static void A17(RubiksCube cube){
        Move.RU2(cube);
        Move.R2F(cube);
        Move.RFp(cube);
        cube.U2();
        Move.RpFRFp(cube);
    }
    
    /**
     * Algorithm 17 setup
     ** <p>
     * F R’F’ RU R2B’ R’B U’ R’
     ** <p>
     * Used to setup for algorithm 17
     * <P>
     * @param cube 
     */
    public static void A_S17(RubiksCube cube){
        cube.F();
        Move.RpFp(cube);
        Move.RU(cube);
        cube.R2(); cube.B_prime();
        Move.RpB(cube);
        cube.U_prime(); cube.R_prime();
    }
    
    //***************************************************************************
    //*  'T' SHAPES
    //***************************************************************************

    /**
     * Algorithm 18
     ** <p>
     * RUR'U' R'FRF'
     ** <p>
     * Do Algorithm 42 in order to set up the cube for solving with Algorithm 18
     * <P>
     * @param cube 
     */
    public static void A18(RubiksCube cube){
        Move.RURpUp(cube);
        Move.RpFRFp(cube);
    }
    
    /**
     * Algorithm 19
     ** <p>
     * F RUR'U' F'
     ** <p>
     * Do Algorithm 20 || 21 in order to set up the cube for solving with Algorithm 19
     * <P>
     * @param cube 
     */
    public static void A19(RubiksCube cube){
        cube.F();
        Move.RURpUp(cube);
        cube.F_prime();
//        cube.U2(); // added for data training
    }
    
    //***************************************************************************
    //*  'P' SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 20
     ** <p>
     * f RUR'U' f'
     ** <p>
     * Do Algorithm 19 in order to set up the cube for solving with Algorithm 20
     * <P>
     * @param cube 
     */
    public static void A20(RubiksCube cube){
        cube.f();
        Move.RURpUp(cube);
        cube.f_prime();
//        cube.U2(); // added to train for alg 19
    }
    
    /**
     * Algorithm 21
     ** <p>
     * f' L'U'LU f
     ** <p>
     * Do Algorithm 35 in order to set up the cube for solving with Algorithm 21
     * <P>
     * @param cube 
     */
    public static void A21(RubiksCube cube){
        cube.f_prime();
        Move.LpUp(cube);
        Move.LU(cube);
        cube.f();
    }
    
    /**
     * Algorithm 22
     ** <p>
     * Rd L'd' R'U lU l'
     ** <p>
     * Do Algorithm 25 || 32 in order to set up the cube for solving with Algorithm 22
     * <P>
     * @param cube 
     */
    public static void A22(RubiksCube cube){
        Move.Rd(cube);
        cube.L_prime(); cube.d_prime();
        Move.RpU(cube);
        Move.lU(cube);
        cube.l_prime();
//        cube.U2(); // added to train for #39#
    }
    
    /**
     * Algorithm 23
     ** <p>
     * R'U' FU RU'R' F' R
     ** <p>
     * Do Algorithm 24 || 33 in order to set up the cube for solving with Algorithm 23
     * <P>
     * @param cube 
     */
    public static void A23(RubiksCube cube){
        Move.RpUp(cube);
        cube.F(); cube.U();
        Move.RUp(cube);
        Move.RpFp(cube);
        cube.R();
    }
    
    //***************************************************************************
    //*  'W' SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 24
     ** <p>
     * RUR'U RU'R'U' R'FRF'
     ** <p>
     * Use setup algorithm 24
     * <P>
     * @param cube 
     */
    public static void A24(RubiksCube cube){
        Move.RURpU(cube);
        Move.RUpRpUp(cube);
        Move.RpFRFp(cube);
//        cube.U(); // added for data training
    }
    
    /**
     * Algorithm 24 setup
     ** <p>
     * F R’F’ RURU R’U’ RU’ R’
     ** <p>
     * Used to setup for algorithm 24
     * <P>
     * @param cube 
     */
    public static void A_S24(RubiksCube cube){
        cube.F();
        Move.RpFp(cube);
        Move.RURU(cube);
        Move.RpUp(cube);
        Move.RUp(cube);
        cube.R_prime();
    }
    
    /**
     * Algorithm 25
     ** <p>
     * L'U'LU' L'ULU LF'L'F
     ** <p>
     * Use setup algorithm 25
     * <P>
     * @param cube 
     */
    public static void A25(RubiksCube cube){
        Move.LpUp(cube);
        Move.LUp(cube);
        Move.LpU(cube);
        Move.LU(cube);
        cube.L(); cube.F_prime();
        cube.L_prime(); cube.F();
//        cube.U(); // added to train for alg 22
    }
    
    /**
     * Algorithm 25 setup
     ** <p>
     * B’ RB R’U’R’U’ RUR’U RU2
     ** <p>
     * Used to setup for algorithm 25
     * <P>
     * @param cube 
     */
    public static void A_S25(RubiksCube cube){
        cube.B_prime();
        Move.RB(cube);
        Move.RpUp(cube);
        Move.RpUp(cube);
        Move.RURpU(cube);
        Move.RU2(cube);
    }
    
    //***************************************************************************
    //*  'L' SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 26
     ** <p>
     * rU R'URU' R'U RU2' r'
     ** <p>
     * Do Algorithm 26 || 29 in order to set up the cube for solving with Algorithm 26
     * <P>
     * @param cube 
     */
    public static void A26(RubiksCube cube){
        Move.rU(cube);
        Move.RpURUp(cube);
        Move.RpU(cube);
        Move.RU2(cube);
        cube.r_prime();
//        cube.U(); // added for data training
    }
    
    /**
     * Algorithm 27
     ** <p>
     * r'U' RU' R'URU' R'U2 r
     ** <p>
     * Do Algorithm 27 || 28 in order to set up the cube for solving with Algorithm 27
     * <P>
     * @param cube 
     */
    public static void A27(RubiksCube cube){
        cube.r_prime(); cube.U_prime();
        Move.RUp(cube);
        Move.RpURUp(cube);
        Move.RpU2(cube);
        cube.r();
//        cube.U_prime(); // added for data training
    }
    
    /**
     * Algorithm 28
     ** <p>
     * RB' RB R2'U2 FR'F'R
     ** <p>
     * Use setup algorithm 28
     * <P>
     * @param cube 
     */
    public static void A28(RubiksCube cube){
        Move.RBp(cube);
        Move.RB(cube);
        Move.R2U2(cube);
        cube.F();
        Move.RpFp(cube);
        cube.R();
//        cube.U_prime();// added for data training
    }
    
    /**
     * Algorithm 28 setup
     ** <p>
     * B’ RB R’ y’ d2 R2B’ R’B R’
     ** <p>
     * Used to setup for algorithm 28
     * <P>
     * @param cube 
     */
    public static void A_S28(RubiksCube cube){
        cube.B_prime();
        Move.RB(cube);
        cube.R_prime(); cube.y_prime();
        cube.d2(); cube.R2();
        cube.B_prime();
        Move.RpB(cube);
        cube.R_prime();
    }
    
    /**
     * Algorithm 29
     ** <p>
     * R'F R'F' R2U2 y R'FRF'
     ** <p>
     * Use setup algorithm 29
     * <P>
     * @param cube 
     */
    public static void A29(RubiksCube cube){
        Move.RpF(cube);
        Move.RpFp(cube);
        Move.R2U2(cube);
        cube.y();
        Move.RpFRFp(cube);
//        cube.U2(); // added for data training
    }
    
    /**
     * Algorithm 29 setup
     ** <p>
     * RB’ R’B U2 R2 F R F’ R
     ** <p>
     * Used to setup for algorithm 29
     * <P>
     * @param cube 
     */
    public static void A_S29(RubiksCube cube){
        Move.RBp(cube);
        Move.RpB(cube);
        cube.U2(); cube.R2();
        cube.F();
        Move.RFp(cube);
        cube.R();
    }
    
    /**
     * Algorithm 30
     ** <p>
     * F RUR'U' RUR'U' F'
     ** <p>
     * Do Algorithm 46 || 49 in order to set up the cube for solving with Algorithm 30
     * <P>
     * @param cube 
     */
    public static void A30(RubiksCube cube){
        cube.F();
        Move.RURpUp(cube);
        Move.RURpUp(cube);
        cube.F_prime();
//        cube.U2(); // added for data training
    }
    
    /**
     * Algorithm 31
     ** <p>
     * F' L'U'LU L'U'LU F
     ** <p>
     * Use setup algorithm 31
     * <P>
     * @param cube 
     */
    public static void A31(RubiksCube cube){
        cube.F_prime();
        Move.LpUp(cube);
        Move.LU(cube);
        Move.LpUp(cube);
        Move.LU(cube);
        cube.F();
    }
    
    /**
     * Algorithm 31 setup
     ** <p>
     * F’ U’ L’U LU’ L’U L F
     ** <p>
     * Used to setup for algorithm 31
     * <P>
     * @param cube 
     */
    public static void A_S31(RubiksCube cube){
        cube.F_prime(); cube.U_prime();
        Move.LpU(cube);
        Move.LUp(cube);
        Move.LpU(cube);
        cube.L(); cube.F();
    }
    
    //***************************************************************************
    //*  BIG 'Z' SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 32
     ** <p>
     * LF' L'U'LU FU'L'
     ** <p>
     * Do Algorithm 22 in order to set up the cube for solving with Algorithm 32
     * <P>
     * @param cube 
     */
    public static void A32(RubiksCube cube){
        cube.L(); cube.F_prime();
        Move.LpUp(cube);
        Move.LU(cube);
        cube.F(); cube.U_prime(); cube.L_prime();
//        cube.U2(); // added for data training
    }
    
    /**
     * Algorithm 33
     ** <p>
     * R'F RUR'U' F'UR
     ** <p>
     * Do Algorithm 23 in order to set up the cube for solving with Algorithm 33
     * <P>
     * @param cube 
     */
    public static void A33(RubiksCube cube){
        Move.RpF(cube);
        Move.RURpUp(cube);
        cube.F_prime(); cube.U(); cube.R();
    }
    
    //***************************************************************************
    //*   'C' SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 34
     ** <p>
     * RU R2'U' R'F RURU' F'
     ** <p>
     * Use setup algorithm 34
     * <P>
     * @param cube 
     */
    public static void A34(RubiksCube cube){
        Move.RU(cube);
        Move.R2Up(cube);
        Move.RpF(cube);
        Move.RURUp(cube);
        cube.F_prime();
    }
    
    /**
     * Algorithm 34 setup
     ** <p>
     * B’ F R’F’ RB U RU’ R’
     ** <p>
     * Used to setup for algorithm 34
     * <P>
     * @param cube 
     */
    public static void A_S34(RubiksCube cube){
        cube.B_prime(); cube.F();
        Move.RpFp(cube);
        Move.RB(cube);
        cube.U();
        Move.RUpRp(cube);
    }
    
    /**
     * Algorithm 35
     ** <p>
     * R'U' R'FRF' U R
     ** <p>
     * Use setup algorithm 35
     * <P>
     * @param cube 
     */
    public static void A35(RubiksCube cube){
        Move.RpUp(cube);
        Move.RpFRFp(cube);
        cube.U(); cube.R();
//        cube.U2(); //added to train for alg 21
    }
    
    /**
     * Algorithm 35 setup
     ** <p>
     * RU B’ RB R’U’ R’
     ** <p>
     * Used to setup for algorithm 35
     * <P>
     * @param cube 
     */
    public static void A_S35(RubiksCube cube){
        Move.RU(cube);
        cube.B_prime();
        Move.RB(cube);
        Move.RpUp(cube);
        cube.R_prime();
    }
    
    //***************************************************************************
    //*   SQUARES
    //***************************************************************************
    
    /**
     * Algorithm 36
     ** <p>
     * r'U2 RUR'U r
     ** <p>
     * Do Algorithm 39 || 40 in order to set up the cube for solving with Algorithm 36
     * <P>
     * @param cube 
     */
    public static void A36(RubiksCube cube){
        cube.r_prime(); cube.U2();
        Move.RURpU(cube);
        cube.r();
    }
    
    /**
     * Algorithm 37
     ** <p>
     * rU2 R'U'RU' r'
     ** <p>
     * Do Algorithm 38 || 41 in order to set up the cube for solving with Algorithm 37
     * <P>
     * @param cube 
     */
    public static void A37(RubiksCube cube){
        cube.r(); cube.U2();
        Move.RpUp(cube);
        Move.RUp(cube);
        cube.r_prime();
    }
    
    //***************************************************************************
    //*   SMALL 'Z' SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 38
     ** <p>
     * rU R'U RU2 r'
     ** <p>
     * Do Algorithm 37 || 51 in order to set up the cube for solving with Algorithm 38
     * <P>
     * @param cube 
     */
    public static void A38(RubiksCube cube){
        Move.rU(cube);
        Move.RpU(cube);
        Move.RU2(cube);
        cube.r_prime();
    }
    
    /**
     * Algorithm 39
     ** <p>
     * MU2 R'U'RU' R'U2 RU M'
     ** <p>
     * Use setup algorithm 39
     * <P>
     * @param cube 
     */
    public static void A39(RubiksCube cube){
        Move.MU2(cube);
        Move.RpUp(cube);
        Move.RUp(cube);
        Move.RpU2(cube);
        Move.RU(cube);
        cube.M_prime();
//        cube.U_prime(); // added to train 36
    }
    
    /**
     * Algorithm 39 setup
     ** <p>
     * M’U R’U2 RUR’U R2 r’U2
     ** <p>
     * Used to setup for algorithm 39
     * <P>
     * @param cube 
     */
    public static void A_S39(RubiksCube cube){
        Move.MpU(cube);
        Move.RpU2(cube);
        Move.RURpU(cube);
        cube.R2();
        cube.r_prime(); cube.U2();
    }
    
    /**
     * Algorithm 40
     ** <p>
     * r'U' RU' R'U2 r
     ** <p>
     * Do Algorithm 36 || 44 in order to set up the cube for solving with Algorithm 40
     * <P>
     * @param cube 
     */
    public static void A40(RubiksCube cube){
        Move.rpUp(cube);
        Move.RUp(cube);
        Move.RpU2(cube);
        cube.r();
    }
    
    /**
     * Algorithm 41
     ** <p>
     * r' R2U R'U RU2 R'U M'
     ** <p>
     * Use setup algorithm 41
     * <P>
     * @param cube 
     */
    public static void A41(RubiksCube cube){
        cube.r_prime();
        Move.R2U(cube);
        Move.RpU(cube);
        Move.RU2(cube);
        Move.RpU(cube);
        cube.M_prime();
//        cube.U_prime(); // added to train for alg 37
    }
    
    /**
     * Algorithm 41 setup
     ** <p>
     * MU’ RU2 R’U’RU’ R2 r
     ** <p>
     * Used to setup for algorithm 41
     * <P>
     * @param cube 
     */
    public static void A_S41(RubiksCube cube){
        Move.MUp(cube);
        Move.RU2(cube);
        Move.RpUp(cube);
        Move.RUp(cube);
        cube.R2();
        cube.r(); 
    }
    
    //***************************************************************************
    //*   'Y' SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 42
     ** <p>
     * F RU' R'U'RU R'F'
     ** <p>
     * Do Algorithm 18 || 43 in order to set up the cube for solving with Algorithm 42
     * <P>
     * @param cube 
     */
    public static void A42(RubiksCube cube){
        cube.F();
        Move.RUp(cube);
        Move.RpUpRU(cube);
        Move.RpFp(cube);
    }
    
    /**
     * Algorithm 43
     ** <p>
     * RU2 R2F RF' RU2 R'
     ** <p>
     * Use setup algorithm 43
     * <P>
     * @param cube 
     */
    public static void A43(RubiksCube cube){
        Move.RU2(cube);
        Move.R2F(cube);
        Move.RFp(cube);
        Move.RU2(cube);
        cube.R_prime();
//        cube.U();// added for data training
    }
    
    /**
     * Algorithm 43 setup
     ** <p>
     * R’U2 lU’ RUR’ l’ U2 RU
     ** <p>
     * Used to setup for algorithm 43
     * <P>
     * @param cube 
     */
    public static void A_S43(RubiksCube cube){
        Move.RpU2(cube);
        Move.lUp(cube);
        Move.RURp(cube);
        cube.l_prime();
        cube.U2();
        Move.RU(cube);
    }
    
    /**
     * Algorithm 44
     ** <p>
     * RUR'U R'FRF' RU2 R'
     ** <p>
     * Do Algorithm 52 in order to set up the cube for solving with Algorithm 44
     * <P>
     * @param cube 
     */
    public static void A44(RubiksCube cube){
        Move.RURpU(cube);
        Move.RpFRFp(cube);
        Move.RU2(cube);
        cube.R_prime();
    }
    
    /**
     * Algorithm 45
     ** <p>
     * RUR'U' R'F R2U R'U' F'
     ** <p>
     * Do Algorithm 50 in order to set up the cube for solving with Algorithm 45
     * <P>
     * @param cube 
     */
    public static void A45(RubiksCube cube){
        Move.RURpUp(cube);
        Move.RpF(cube);
        Move.R2U(cube);
        Move.RpUp(cube);
        cube.F_prime();
    }
    
    //***************************************************************************
    //*   'I' SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 46
     ** <p>
     * f RUR'U' RUR'U' f'
     ** <p>
     * Do Algorithm 30 in order to set up the cube for solving with Algorithm 46
     * <P>
     * @param cube 
     */
    public static void A46(RubiksCube cube){
        cube.f();
        Move.RURpUp(cube);
        Move.RURpUp(cube);
        cube.f_prime();
//        cube.U2();// added for data training
    }
    
    /**
     * Algorithm 47
     ** <p>
     * RUR'U Rd' RU'R'F'
     ** <p>
     * Do Algorithm 47 in order to set up the cube for solving with Algorithm 47
     * <P>
     * @param cube 
     */
    public static void A47(RubiksCube cube){
        Move.RURpU(cube);
        Move.Rdp(cube);
        Move.RUp(cube);
        Move.RpFp(cube);
//        cube.U();// added for data training
    }
    
    /**
     * Algorithm 48
     ** <p>
     * f RUR'U' f' F RUR'U' RUR'U' F'
     ** <p>
     * Use setup algorithm 48
     * <P>
     * @param cube 
     */
    public static void A48(RubiksCube cube){
        cube.f();
        Move.RURpUp(cube);
        cube.f_prime();
        cube.F();
        Move.RURpUp(cube);
        Move.RURpUp(cube);
        cube.F_prime();
    }
    
    /**
     * Algorithm 48 setup
     ** <p>
     * L’ B’ L R’U’RU R’U’RU L’ B LU
     ** <p>
     * Used to setup for algorithm 48
     * <P>
     * @param cube 
     */
    public static void A_S48(RubiksCube cube){
        cube.L_prime(); cube.B_prime();
        cube.L();
        Move.RpUpRU(cube);
        Move.RpUpRU(cube);
        cube.L_prime();
        cube.B();
        Move.LU(cube);
    }
    
    /**
     * Algorithm 49
     ** <p>
     * RU2 R2U' RU' R'U2 F RF'
     ** <p>
     * Use setup algorithm 49
     * <P>
     * @param cube 
     */
    public static void A49(RubiksCube cube){
        Move.RU2(cube);
        Move.R2Up(cube);
        Move.RUp(cube);
        Move.RpU2(cube);
        cube.F();
        Move.RFp(cube);
    }
    
    /**
     * Algorithm 49 setup
     ** <p>
     * B’ RB U2 R’U’ RU’ R2U2 R
     ** <p>
     * Used to setup for algorithm 49
     * <P>
     * @param cube 
     */
    public static void A_S49(RubiksCube cube){
        cube.B_prime();
        Move.RB(cube);
        cube.U2();
        Move.RpUp(cube);
        Move.RUp(cube);
        Move.R2U2(cube);
        cube.R();
    }
    
    //***************************************************************************
    //*   "KNIGHT MOVE" SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 50
     ** <p>
     * rU' r'U' rU r' y' R'UR
     ** <p>
     * Do Algorithm 45 in order to set up the cube for solving with Algorithm 50
     * <P>
     * @param cube 
     */
    public static void A50(RubiksCube cube){
        Move.rUp(cube);
        Move.rpUp(cube);
        Move.rU(cube);
        cube.r_prime();
        cube.y_prime();
        Move.RpUR(cube);
    }
    
    /**
     * Algorithm 51
     ** <p>
     * rU r' RUR'U' rU' r'
     ** <p>
     * Use setup algorithm 51
     * <P>
     * @param cube 
     */
    public static void A51(RubiksCube cube){
        Move.rU(cube);
        cube.r_prime();
        Move.RURpUp(cube);
        Move.rUp(cube);
        cube.r_prime();
    }
    
    /**
     * Algorithm 51 setup
     ** <p>
     * L F L’U RU’ R’ L F’ L’
     ** <p>
     * Used to setup for algorithm 51
     * <P>
     * @param cube 
     */
    public static void A_S51(RubiksCube cube){
        cube.L(); cube.F();
        Move.LpU(cube);
        Move.RUp(cube);
        cube.R_prime(); cube.L();
        cube.F_prime(); cube.L_prime();
    }
    
    /**
     * Algorithm 52
     ** <p>
     * R'F RUR'F' R y' RU'R'
     ** <p>
     * Use setup algorithm 52
     * <P>
     * @param cube 
     */
    public static void A52(RubiksCube cube){
        Move.RpF(cube);
        Move.RURpFp(cube);
        cube.R(); cube.y_prime();
        Move.RUpRp(cube);
    }
    
    /**
     * Algorithm 52 setup
     ** <p>
     * F U F’ R’ F RU’R’F’ R
     ** <p>
     * Used to setup for algorithm 52
     * <P>
     * @param cube 
     */
    public static void A_S52(RubiksCube cube){
        cube.F(); cube.U();
        cube.F_prime(); cube.R_prime();
        cube.F(); 
        Move.RUp(cube);
        Move.RpFp(cube);
        cube.R(); 
    }
    
    /**
     * Algorithm 53
     ** <p>
     * l'U' l L'U'LU l'U l
     ** <p>
     * Use setup algorithm 53
     * <P>
     * @param cube 
     */
    public static void A53(RubiksCube cube){
        Move.lpUp(cube);
        cube.l();
        Move.LpUp(cube);
        Move.LU(cube);
        Move.lpU(cube);
        cube.l();
    }
    
    /**
     * Algorithm 53 setup
     ** <p>
     * L’ B’ LU’ R’U R L’ B LU2
     ** <p>
     * Used to setup for algorithm 53
     * <P>
     * @param cube 
     */
    public static void A_S53(RubiksCube cube){
        cube.L_prime();cube.B_prime();
        Move.LUp(cube);
        Move.RpU(cube);
        cube.R(); cube.L_prime();
        cube.B(); cube.L(); cube.U2();
    }
    
    //***************************************************************************
    //*   WEIRD SHAPES
    //***************************************************************************
    
    /**
     * Algorithm 54
     ** <p>
     * RU' R'U2 RU y RU'R'U' F'
     ** <p>
     * Use setup algorithm 54
     * <P>
     * @param cube 
     */
    public static void A54(RubiksCube cube){
        Move.RUp(cube);
        Move.RpU2(cube);
        Move.RU(cube);
        cube.y();
        Move.RUpRpUp(cube);
        cube.F_prime();
    }
    
    /**
     * Algorithm 54 setup
     ** <p>
     * F U RUR’ y’ U’ R’U2 RUR’
     ** <p>
     * Used to setup for algorithm 54
     * <P>
     * @param cube 
     */
    public static void A_S54(RubiksCube cube){
        cube.F();cube.U();
        Move.RURp(cube);
        cube.y_prime(); cube.U_prime();
        Move.RpU2(cube);
        Move.RURp(cube);
    }
    
    /**
     * Algorithm 55
     ** <p>
     * R2'U R'B' RU' R2'U lU l'
     ** <p>
     * Use setup algorithm 55
     * <P>
     * @param cube 
     */
    public static void A55(RubiksCube cube){
        Move.R2U(cube);
        Move.RpBp(cube);
        Move.RUp(cube);
        Move.R2U(cube);
        Move.lU(cube);
        cube.l_prime();
    }
    
    /**
     * Algorithm 55 setup
     ** <p>
     * lU’ l’U’ R2U R’B RU’ R2
     ** <p>
     * Used to setup for algorithm 55
     * <P>
     * @param cube 
     */
    public static void A_S55(RubiksCube cube){
        Move.lUp(cube);
        Move.lpUp(cube);
        Move.R2U(cube);
        Move.RpB(cube);
        Move.RUp(cube);
        cube.R2();
    }
    
    /**
     * Algorithm 56
     ** <p>
     * L'U LU2' L'U' y' L'ULU F
     ** <p>
     * Use setup algorithm 56
     * <P>
     * @param cube 
     */
    public static void A56(RubiksCube cube){
        Move.LpU(cube);
        cube.L(); cube.U2();
        Move.LpUp(cube);
        cube.y_prime();
        Move.LpU(cube);
        Move.LU(cube);
        cube.F();
    }
    
    /**
     * Algorithm 56 setup
     ** <p>
     * B’ U’ R’U’R (y) U RU2 R’U’ RU2
     ** <p>
     * Used to setup for algorithm 56
     * <P>
     * @param cube 
     */
    public static void A_S56(RubiksCube cube){
        cube.B_prime();cube.U_prime();
        Move.RpUpR(cube);
        cube.y(); cube.U();
        Move.RU2(cube);
        Move.RpUp(cube);
        Move.RU2(cube);
    }
    
    /**
     * Algorithm 57
     ** <p>
     * L2U' L B L'U L2U' r'U' r
     ** <p>
     * Use setup algorithm 57
     * <P>
     * @param cube 
     */
    public static void A57(RubiksCube cube){
        cube.L2(); cube.U_prime();
        cube.L(); cube.B();
        Move.LpU(cube);
        cube.L2(); cube.U_prime();
        Move.rpUp(cube);
        cube.r();
    }
    
    /**
     * Algorithm 57 setup
     ** <p>
     * B2 R’URU’ R’U’ R2 B R’ B
     ** <p>
     * Used to setup for algorithm 57
     * <P>
     * @param cube 
     */
    public static void A_S57(RubiksCube cube){
        cube.B2();
        Move.RpURUp(cube);
        Move.RpUp(cube);
        cube.R2(); cube.B();
        Move.RpB(cube);
    }
    
    /**
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
