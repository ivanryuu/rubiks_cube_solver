/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

/**
 *
 * @author ivan
 */
public class Move {
    
    //***************************************************************************
    //*  MOVES ONLY R & U LAYERS
    //***************************************************************************
    
    /**
     * Moves layers RU
     */
    public static void RU(RubiksCube cube){
        cube.R(); cube.U();
    }
    
    /**
     * Moves layers RU'
     */
    public static void RUp(RubiksCube cube){
        cube.R(); cube.U_prime();
    }
    
    /**
     * Moves layers R'U
     */
    public static void RpU(RubiksCube cube){
        cube.R_prime(); cube.U();
    }
    
    /**
     * Moves layers R'U'
     */
    public static void RpUp(RubiksCube cube){
        cube.R_prime(); cube.U_prime();
    }
    
    /**
     * Moves layers rU
     */
    public static void rU(RubiksCube cube){
        cube.r(); cube.U();
    }
    
    /**
     * Moves layers rU'
     */
    public static void rUp(RubiksCube cube){
        cube.r(); cube.U_prime();
    }
    
    /**
     * Moves layers r'U
     */
    public static void rpU(RubiksCube cube){
        cube.r_prime(); cube.U();
    }
    
    /**
     * Moves layers r'U'
     */
    public static void rpUp(RubiksCube cube){
        cube.r_prime(); cube.U_prime();
    }
    
    /**
     * Moves layers Ru
     */
    public static void Ru(RubiksCube cube){
        cube.R(); cube.u();
    }
    
    /**
     * Moves layers Ru'
     */
    public static void Rup(RubiksCube cube){
        cube.R(); cube.u_prime();
    }
    
    /**
     * Moves layers R'u
     */
    public static void Rpu(RubiksCube cube){
        cube.R_prime(); cube.u();
    }
    
    /**
     * Moves layers R'U'
     */
    public static void Rpup(RubiksCube cube){
        cube.R_prime(); cube.u_prime();
    }
    
    /**
     * Moves layers R2U
     */
    public static void R2U(RubiksCube cube){
        cube.R2(); cube.U();
    }
    
    /**
     * Moves layers R2U'
     */
    public static void R2Up(RubiksCube cube){
        cube.R2(); cube.U_prime();
    }
    
    /**
     * Moves layers RU2
     */
    public static void RU2(RubiksCube cube){
        cube.R(); cube.U2();
    }
    
    /**
     * Moves layers R2U2
     */
    public static void R2U2(RubiksCube cube){
        cube.R2(); cube.U2();
    }
    
    /**
     * Moves layers R'U2
     */
    public static void RpU2(RubiksCube cube){
        cube.R_prime(); cube.U2();
    }
    
    /**
     * Moves layers R2u
     */
    public static void R2u(RubiksCube cube){
        cube.R2(); cube.u();
    }
    
    /**
     * Moves layers R2u'
     */
    public static void R2up(RubiksCube cube){
        cube.R2(); cube.u_prime();
    }
    
    /**
     * Moves layers Ru2
     */
    public static void Ru2(RubiksCube cube){
        cube.R(); cube.u2();
    }
    
    /**
     * Moves layers R'u2
     */
    public static void Rpu2(RubiksCube cube){
        cube.R_prime(); cube.u2();
    }
    
    /**
     * Moves layers RUR
     */
    public static void RUR(RubiksCube cube){
        Move.RU(cube); cube.R();
    }
    
    /**
     * Moves layers RUR'
     */
    public static void RURp(RubiksCube cube){
        Move.RU(cube); cube.R_prime();
    }
    
    /**
     * Moves layers R'UR
     */
    public static void RpUR(RubiksCube cube){
        Move.RpU(cube); cube.R();
    }
    
    /**
     * Moves layers RU'R
     */
    public static void RUpR(RubiksCube cube){
        Move.RUp(cube); cube.R();
    }
    
    /**
     * Moves layers RU'R'
     */
    public static void RUpRp(RubiksCube cube){
        Move.RUp(cube); cube.R_prime();
    }
    
    /**
     * Moves layers R'U'R
     */
    public static void RpUpR(RubiksCube cube){
        Move.RpUp(cube); cube.R();
    }
    
    /**
     * Moves layers R'UR'
     */
    public static void RpURp(RubiksCube cube){
        Move.RpU(cube); cube.R_prime();
    }
    
    /**
     * Moves layers RURU
     */
    public static void RURU(RubiksCube cube){
        Move.RUR(cube); cube.U();
    }
    
    /**
     * Moves layers RU'RU
     */
    public static void RUpRU(RubiksCube cube){
        Move.RUpR(cube); cube.U();
    }
    
    /**
     * Moves layers RURU'
     */
    public static void RURUp(RubiksCube cube){
        Move.RUR(cube); cube.U_prime();
    }
    
    /**
     * Moves layers RUR'U'
     */
    public static void RURpUp(RubiksCube cube){
        Move.RU(cube); Move.RpUp(cube);
    }
    
    /**
     * Moves layers RUR'U
     */
    public static void RURpU(RubiksCube cube){
        Move.RU(cube); Move.RpU(cube);
    }
    
    /**
     * Moves layers R'U'RU
     */
    public static void RpUpRU(RubiksCube cube){
         Move.RpUp(cube); Move.RU(cube);
    }
    
    /**
     * Moves layers R'UR'U'
     */
    public static void RpURpUp(RubiksCube cube){
         Move.RpU(cube); Move.RpUp(cube);
    }
    
    /**
     * Moves layers R'URU'
     */
    public static void RpURUp(RubiksCube cube){
         Move.RpU(cube); Move.RUp(cube);
    }
    
    /**
     * Moves layers RU'R'U
     */
    public static void RUpRpU(RubiksCube cube){
         Move.RUp(cube); Move.RpU(cube);
    }
    
    /**
     * Moves layers RU'R'U'
     */
    public static void RUpRpUp(RubiksCube cube){
         Move.RUp(cube); Move.RpUp(cube);
    }
    
    /**
     * Moves layers R'U'R'U'
     */
    public static void RpUpRpUp(RubiksCube cube){
         Move.RpUp(cube); Move.RpUp(cube);
    }
    
    //***************************************************************************
    //*  MOVES R, U & F LAYERS
    //***************************************************************************
    
    /**
     * Moves layers RF
     */
    public static void RF(RubiksCube cube){
        cube.R(); cube.F();
    }
    
    /**
     * Moves layers RF'
     */
    public static void RFp(RubiksCube cube){
        cube.R(); cube.F_prime();
    }
    
    /**
     * Moves layers R'F
     */
    public static void RpF(RubiksCube cube){
        cube.R_prime(); cube.F();
    }
    
    /**
     * Moves layers R'F'
     */
    public static void RpFp(RubiksCube cube){
        cube.R_prime(); cube.F_prime();
    }
    
    /**
     * Moves layers R2F
     */
    public static void R2F(RubiksCube cube){
        cube.R2(); cube.F();
    }
    
    /**
     * Moves layers R2F'
     */
    public static void R2Fp(RubiksCube cube){
        cube.R2(); cube.F_prime();
    }
    
    /**
     * Moves layers R'F2
     */
    public static void RpF2(RubiksCube cube){
        cube.R_prime(); cube.F2();
    }
    
    /**
     * Moves layers R2F2
     */
    public static void R2F2(RubiksCube cube){
        cube.R2(); cube.F2();
    }
    
    /**
     * Moves layers rF
     */
    public static void rF(RubiksCube cube){
        cube.r(); cube.F();
    }
    
    /**
     * Moves layers rF'
     */
    public static void rFp(RubiksCube cube){
        cube.r(); cube.F_prime();
    }
    
    /**
     * Moves layers r'F
     */
    public static void rpF(RubiksCube cube){
        cube.r_prime(); cube.F();
    }
    
    /**
     * Moves layers r'F'
     */
    public static void rpFp(RubiksCube cube){
        cube.r_prime(); cube.F_prime();
    }
    
    /**
     * Moves layers FRU'
     */
    public static void FRUp(RubiksCube cube){
        cube.F(); Move.RUp(cube);
    }
    
    /**
     * Moves layers RUR'F'
     */
    public static void RURpFp(RubiksCube cube){
        Move.RU(cube); Move.RpFp(cube);
    }
    
    /**
     * Moves layers RUR'F
     */
    public static void RURpF(RubiksCube cube){
        Move.RU(cube); Move.RpF(cube);
    }
    
    /**
     * Moves layers RFRU
     */
    public static void RFRU(RubiksCube cube){
        Move.RF(cube); Move.RU(cube);
    }
    
    /**
     * Moves layers R'FRU
     */
    public static void RpFRU(RubiksCube cube){
        Move.RpF(cube); Move.RU(cube);
    }
    
    /**
     * Moves layers R'F'R'U'
     */
    public static void RpFpRpUp(RubiksCube cube){
        Move.RpFp(cube); Move.RpUp(cube);
    }
    
    /**
     * Moves layers R'FRF'
     */
    public static void RpFRFp(RubiksCube cube){
        Move.RpF(cube); Move.RFp(cube);
    }
    
    /**
     * Moves layers R'UR'F
     */
    public static void RpURpF(RubiksCube cube){
        Move.RpU(cube); Move.RpF(cube);
    }
    
    /**
     * Moves layers R'U'R'F'
     */
    public static void RpUpRpFp(RubiksCube cube){
        Move.RpUp(cube); Move.RpFp(cube);
    }
    //***************************************************************************
    //*  MOVES R, L & U LAYERS
    //***************************************************************************
    
    /**
     * Moves layers LU
     */
    public static void LU(RubiksCube cube){
        cube.L(); cube.U();
    }
    
    /**
     * Moves layers LU'
     */
    public static void LUp(RubiksCube cube){
        cube.L(); cube.U_prime();
    }
    
    /**
     * Moves layers L'U
     */
    public static void LpU(RubiksCube cube){
        cube.L_prime(); cube.U();
    }
    
    /**
     * Moves layers L'U'
     */
    public static void LpUp(RubiksCube cube){
        cube.L_prime(); cube.U_prime();
    }
    
    /**
     * Moves layers lU
     */
    public static void lU(RubiksCube cube){
        cube.l(); cube.U();
    }
    
    /**
     * Moves layers lU'
     */
    public static void lUp(RubiksCube cube){
        cube.l(); cube.U_prime();
    }
    
    /**
     * Moves layers l'U
     */
    public static void lpU(RubiksCube cube){
        cube.l_prime(); cube.U();
    }
    
    /**
     * Moves layers l'U'
     */
    public static void lpUp(RubiksCube cube){
        cube.l_prime(); cube.U_prime();
    }
    
    /**
     * Moves layers RUL
     */
    public static void RUL(RubiksCube cube){
        Move.RU(cube); cube.L();
    }
    
    /**
     * Moves layers RU'L
     */
    public static void RUpL(RubiksCube cube){
        Move.RUp(cube); cube.L();
    }
    
    /**
     * Moves layers R'UL'
     */
    public static void RpULp(RubiksCube cube){
        Move.RpU(cube); cube.L_prime();
    }
    
    /**
     * Moves layers LRU'
     */
    public static void LRUp(RubiksCube cube){
        cube.L(); Move.RUp(cube); 
    }
    
    //***************************************************************************
    //*  MOVES R & D LAYERS
    //***************************************************************************
    
    /**
     * Moves layers RD
     */
    public static void RD(RubiksCube cube){
        cube.R(); cube.D();
    }
    
    /**
     * Moves layers RD'
     */
    public static void RDp(RubiksCube cube){
        cube.R(); cube.D_prime();
    }
    
    /**
     * Moves layers R'D
     */
    public static void RpD(RubiksCube cube){
        cube.R_prime(); cube.D();
    }
    
    /**
     * Moves layers R'D'
     */
    public static void RpDp(RubiksCube cube){
        cube.R_prime(); cube.D_prime();
    }
    
    /**
     * Moves layers Rd
     */
    public static void Rd(RubiksCube cube){
        cube.R(); cube.d();
    }
    
    /**
     * Moves layers Rd'
     */
    public static void Rdp(RubiksCube cube){
        cube.R(); cube.d_prime();
    }
    
    /**
     * Moves layers R'd
     */
    public static void Rpd(RubiksCube cube){
        cube.R_prime(); cube.d();
    }
    
    /**
     * Moves layers R'd'
     */
    public static void Rpdp(RubiksCube cube){
        cube.R_prime(); cube.d_prime();
    }
    
    /**
     * Moves layers R2D
     */
    public static void R2D(RubiksCube cube){
        cube.R2(); cube.D();
    }
    
    /**
     * Moves layers R2D'
     */
    public static void R2Dp(RubiksCube cube){
        cube.R2(); cube.D_prime();
    }
    
    /**
     * Moves layers RD2
     */
    public static void RD2(RubiksCube cube){
        cube.R(); cube.D2();
    }
    
    /**
     * Moves layers R'D2
     */
    public static void RpD2(RubiksCube cube){
        cube.R_prime(); cube.D2();
    }
    
    //***************************************************************************
    //*  MOVES ONLY M & U LAYERS
    //***************************************************************************
    
    /**
     * Moves layers RB
     */
    public static void RB(RubiksCube cube){
        cube.R(); cube.B();
    }
    
    /**
     * Moves layers RB'
     */
    public static void RBp(RubiksCube cube){
        cube.R(); cube.B_prime();
    }
    
    /**
     * Moves layers R'B
     */
    public static void RpB(RubiksCube cube){
        cube.R_prime(); cube.B();
    }
    
    /**
     * Moves layers R'B'
     */
    public static void RpBp(RubiksCube cube){
        cube.R_prime(); cube.B_prime();
    }
    
    //***************************************************************************
    //*  MOVES ONLY M & U LAYERS
    //***************************************************************************
    
    /**
     * Moves layers MU
     */
    public static void MU(RubiksCube cube){
        cube.M(); cube.U();
    }
    
    /**
     * Moves layers MU'
     */
    public static void MUp(RubiksCube cube){
        cube.M(); cube.U_prime();
    }
    
    /**
     * Moves layers M'U
     */
    public static void MpU(RubiksCube cube){
        cube.M_prime();cube.U();
    }
    
    /**
     * Moves layers M'U'
     */
    public static void MpUp(RubiksCube cube){
        cube.M_prime(); cube.U_prime();
    }
    
    /**
     * Moves layers M2U
     */
    public static void M2U(RubiksCube cube){
        cube.M2(); cube.U();
    }
    
    /**
     * Moves layers M2U'
     */
    public static void M2Up(RubiksCube cube){
        cube.M2(); cube.U_prime();
    }
    
    /**
     * Moves layers M2U2
     */
    public static void M2U2(RubiksCube cube){
        cube.M2(); cube.U2();
    }
    
    /**
     * Moves layers MU2
     */
    public static void MU2(RubiksCube cube){
        cube.M(); cube.U2();
    }
    
    /**
     * Moves layers M'U2
     */
    public static void MpU2(RubiksCube cube){
        cube.M_prime(); cube.U2();
    }
    
}
