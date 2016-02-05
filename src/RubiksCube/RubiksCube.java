/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

/**
 *
 * @author ivan
 */
public class RubiksCube {
    
//    private enum Color {WHITE,YELLOW,RED,BLUE,GREEN,ORANGE};
    private enum Color {W,Y,R,B,G,O};
    private Color[][][] cube;// = new Color[6][3][3];
//    private Color[] sides = {Color.WHITE, Color.RED,Color.YELLOW,Color.ORANGE,Color.GREEN,Color.BLUE};
    private Color[] sides = {Color.W, Color.R,Color.Y,Color.O,Color.G,Color.B};
    //private Color[] sides = {Color.G, Color.R,Color.B,Color.A,Color.P,Color.W};
    private int[] side_rotation = {1,4,3,5};
    
    public RubiksCube(){
        cube = new Color[6][3][3];
        //sides =
        initializeCube();
    }
    
    public RubiksCube(Color[][][] rc){
        cube = new Color[6][3][3];
        cube = copy(rc);
    }
    
    public RubiksCube(int[][][] rc)
    {
        cube = new Color[6][3][3];
        for(int i = 0; i < 6; i++)
            for(int j = 0; j < 3; j++)
                for(int k = 0; k < 3; k++)
                    cube[i][j][k] = sides[rc[i][j][k]];
    }
    
    public Color[][][] getCube(){
        return cube;
    }
    
    public Color getColor(int side, int row, int col){
        return cube[side][row][col];
    }
    
    public void setCube(RubiksCube rc){
        cube = copy(rc.getCube());
    }
    
    private void initializeCube(){
        
        for(int s = 0; s<6; s++)
            for(int i = 0; i<3; i++)
                for(int j = 0; j<3; j++)
                    cube[s][i][j] = sides[s];
    }
    
    public String[] Layer1(){
        String[] layer_1 = new String[12];
        for(int i = 0, k = 0; i < layer_1.length; i+=3, k++){
            for(int j = 0; j<3; j++){
                int l = side_rotation[k] != 3 ? 2 : 0;
                layer_1[i+j] = cube[side_rotation[k]][l][j].toString(); 
            }
        }
        
        return layer_1;
    }
    
    public String[] Layer2(){
        String[] layer_1 = new String[12];
        for(int i = 0, k = 0; i < layer_1.length; i+=3, k++)
            for(int j = 0; j<3; j++)
                layer_1[i+j] = cube[side_rotation[k]][1][j].toString(); 
        
        return layer_1;
    }
    
    public String[] Layer3(){
        String[] layer_3 = new String[12];
        for(int i = 0, k = 0; i < layer_3.length; i+=3, k++){
            for(int j = 0; j<3; j++){
                int l = side_rotation[k] == 3 ? 2 : 0;
                layer_3[i+j] = cube[side_rotation[k]][l][j].toString(); 
            }
        }
        
        return layer_3;
    }
    
    public String[] getFace(int face){
        String[] face_s = new String[9];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                face_s[i*3+j] = "" + cube[face][i][j];
        return face_s;
    }
    
    public static Color[][][] copy(Color[][][] cube){
        Color[][][] temp = new Color[6][3][3];
        for(int s = 0; s<6; s++)
            for(int i = 0; i<3; i++)
                for(int j = 0; j<3; j++)
                    temp[s][i][j] = cube[s][i][j];
                //System.arraycopy(cube[s][i], 0, temp[s][i], 0, 3);
        return temp;
    }
    
    public void R(){
        Color[][][] temp = copy(cube);
        
        //Rotates the right column
        for(int s = 0; s<4; s++){
            for(int i = 0; i<3; i++)
                cube[s][i][2] = temp[(s+3)%4][i][2];
        }
        
        rotateClockwise(4);
    }
    
    public void R_prime(){
        R(); R(); R();
    }
    
    public void R2(){
        R(); R();
    }
    
    public void r(){
        Color[][][] temp = copy(cube);
        
        //Rotates the right column
        for(int s = 0; s<4; s++){
            for(int i = 0; i<3; i++){
                cube[s][i][2] = temp[(s+3)%4][i][2];
                cube[s][i][1] = temp[(s+3)%4][i][1];
            }
        }
        
        rotateClockwise(4);
    }
    
    public void r_prime(){
        r(); r(); r();
    }
    
    public void r2(){
        r(); r();
    }
    
    public void U(){
        Color[][][] temp = copy(cube);
        
        for(int s = 1;s<6;s++){
            if(s == 1)
                for(int j = 0; j<3; j++)
                    cube[s][0][j] = temp[4][0][j];
            else if(s == 3)
                for(int j = 0; j<3; j++)
                    cube[s][2][j] = temp[5][0][2-j];
            else if(s == 4)
                for(int j = 0; j<3; j++)
                    cube[s][0][j] = temp[3][2][2-j];
            else if(s == 5)
                for(int j = 0; j<3; j++)
                    cube[s][0][j] = temp[1][0][j];
        }
        
        rotateClockwise(2);
    }
    
    public void U_prime(){
        U(); U(); U();
    }
    
    public void U2(){
        U(); U();
    }
    
    public void u(){
        Color[][][] temp = copy(cube);
        
        for(int s = 1;s<6;s++){
            if(s == 1)
                for(int j = 0; j<3; j++){
                    cube[s][0][j] = temp[4][0][j];
                    cube[s][1][j] = temp[4][1][j];
                }
            else if(s == 3)
                for(int j = 0; j<3; j++){
                    cube[s][2][j] = temp[5][0][2-j];
                    cube[s][1][j] = temp[5][1][2-j];
                }
            else if(s == 4)
                for(int j = 0; j<3; j++){
                    cube[s][0][j] = temp[3][2][2-j];
                    cube[s][1][j] = temp[3][1][2-j];
                }
            else if(s == 5)
                for(int j = 0; j<3; j++){
                    cube[s][0][j] = temp[1][0][j];
                    cube[s][1][j] = temp[1][1][j];
                }
        }
        
        rotateClockwise(2);
    }
    
    public void u_prime(){
        u(); u(); u();
    }
    
    public void u2(){
        u(); u();
    }
    
    public void D(){
        Color[][][] temp = copy(cube);
        
        for(int s = 0;s<6;s++){
            if(s == 1)
                for(int j = 0; j<3; j++)
                    cube[s][2][j] = temp[5][2][j];
            else if(s == 3)
                for(int j = 0; j<3; j++)
                    cube[s][0][j] = temp[4][2][2-j];
            else if(s == 4)
                for(int j = 0; j<3; j++)
                    cube[s][2][j] = temp[1][2][j];
            else if(s == 5)
                for(int j = 0; j<3; j++)
                    cube[s][2][j] = temp[3][0][2-j];
        }
        
        rotateClockwise(0);
    }
    
    public void D_prime(){
        D(); D(); D();
        //flipRow(1,2);
        //flipRow(4,2);
        //flipRow(5,2);
    }
    
    public void D2(){
        D(); D();
        //flipRow(1,2);
        //flipRow(5,2);
    }
    
    public void d(){
        Color[][][] temp = copy(cube);
        
        for(int s = 0;s<6;s++){
            if(s == 1)
                for(int j = 0; j<3; j++){
                    cube[s][2][j] = temp[5][2][j];
                    cube[s][1][j] = temp[5][1][j];
                }
            else if(s == 3)
                for(int j = 0; j<3; j++){
                    cube[s][0][j] = temp[4][2][2-j];
                    cube[s][1][j] = temp[4][1][2-j];
                }
            else if(s == 4)
                for(int j = 0; j<3; j++){
                    cube[s][2][j] = temp[1][2][j];
                    cube[s][1][j] = temp[1][1][j];
                }
            else if(s == 5)
                for(int j = 0; j<3; j++){
                    cube[s][2][j] = temp[3][0][2-j];
                    cube[s][1][j] = temp[3][1][2-j];
                }
        }
        
        rotateClockwise(0);
    }
    
    public void d_prime(){
        d(); d(); d();
    }
    
    public void d2(){
        d(); d(); 
    }
    
    public void L(){
        Color[][][] temp = copy(cube);
        
        //Rotates the left column
        for(int s = 0; s<4; s++){
            for(int i = 0; i<3; i++)
                cube[s][i][0] = temp[(s+1)%4][i][0];
        }
        
        rotateClockwise(5);
    }

    public void L_prime(){
        L(); L(); L();
    }
    
    public void L2(){
        L(); L();
    }
    
    public void l(){
        Color[][][] temp = copy(cube);
        
        //Rotates the left column
        for(int s = 0; s<4; s++){
            for(int i = 0; i<3; i++){
                cube[s][i][0] = temp[(s+1)%4][i][0];
                cube[s][i][1] = temp[(s+1)%4][i][1];
            }
        }
        
        rotateClockwise(5);
    }
    
    public void l_prime(){
        l(); l(); l();
    }
    
    public void l2(){
        l(); l();
    }
    
    public void F(){
        Color[][][] temp = copy(cube);
        
        for(int s = 0;s<6;s++){
            if(s == 0)
                for(int j = 0; j<3; j++)
                    cube[s][0][j] = temp[4][2-j][0];
            else if(s == 2)
                for(int j = 0; j<3; j++)
                    cube[s][2][j] = temp[5][2-j][2];
            else if(s == 4)
                for(int j = 0; j<3; j++)
                    cube[s][j][0] = temp[2][2][j];
            else if(s == 5)
                for(int j = 0; j<3; j++)
                    cube[s][j][2] = temp[0][0][j];
        }
        
        rotateClockwise(1);
    }
    
    public void F_prime(){
        F(); F(); F();
    }

    public void F2(){
        F(); F();
    }
    
    public void f(){
        Color[][][] temp = copy(cube);
        
        for(int s = 0;s<6;s++){
            if(s == 0)
                for(int j = 0; j<3; j++){
                    cube[s][0][j] = temp[4][2-j][0];
                    cube[s][1][j] = temp[4][2-j][1];
                }
            else if(s == 2)
                for(int j = 0; j<3; j++){
                    cube[s][2][j] = temp[5][2-j][2];
                    cube[s][1][j] = temp[5][2-j][1];
                }
            else if(s == 4)
                for(int j = 0; j<3; j++){
                    cube[s][j][0] = temp[2][2][j];
                    cube[s][j][1] = temp[2][1][j];
                }
            else if(s == 5)
                for(int j = 0; j<3; j++){
                    cube[s][j][2] = temp[0][0][j];
                    cube[s][j][1] = temp[0][1][j];
                }
        }
        
        rotateClockwise(1);
    }
    
    public void f_prime(){
        f(); f(); f();
    }
    
    public void f2(){
        f(); f();
    }
    
    public void B(){
        Color[][][] temp = copy(cube);
        
        for(int s = 0;s<6;s++){
            if(s == 0)
                for(int j = 0; j<3; j++)
                    cube[s][2][j] = temp[5][j][0];
            else if(s == 2)
                for(int j = 0; j<3; j++)
                    cube[s][0][j] = temp[4][j][2];
            else if(s == 4)
                for(int j = 0; j<3; j++)
                    cube[s][j][2] = temp[0][2][2-j];
            else if(s == 5)
                for(int j = 0; j<3; j++)
                    cube[s][j][0] = temp[2][0][2-j];
        }
        
        rotateClockwise(3);
    }
    
    public void B_prime(){
        B(); B(); B();
    }
    
    public void B2(){
        B(); B();
    }
    
    public void b(){
        Color[][][] temp = copy(cube);
        
        for(int s = 0;s<6;s++){
            if(s == 0)
                for(int j = 0; j<3; j++){
                    cube[s][2][j] = temp[5][j][0];
                    cube[s][1][j] = temp[5][j][1];
                }
            else if(s == 2)
                for(int j = 0; j<3; j++){
                    cube[s][0][j] = temp[4][j][2];
                    cube[s][1][j] = temp[4][j][1];
                }
            else if(s == 4)
                for(int j = 0; j<3; j++){
                    cube[s][j][2] = temp[0][2][2-j];
                    cube[s][j][1] = temp[0][1][2-j];
                }
            else if(s == 5)
                for(int j = 0; j<3; j++){
                    cube[s][j][0] = temp[2][0][2-j];
                    cube[s][j][1] = temp[2][1][2-j];
                }
        }
        
        rotateClockwise(3);
    }
    
    public void b_prime(){
        b(); b(); b();
    }
    
    public void b2(){
        b(); b();
    }
    
    //rotates middle layer 90 degrees in same
    //direction as L-layer
    public void M(){
        l(); L_prime();
    }
    
    public void M_prime(){
        M(); M(); M();
    }
    
    public void M2(){
        M(); M();
    }
    
    //rotates middle layer 90 degrees in same
    //direction as F-layer
    public void S(){
        f(); F_prime();
    }
    
    public void S_prime(){
        S(); S(); S();
    }
    
    public void S2(){
        S(); S();
    }
    
    //rotates middle layer 90 degrees in same
    //direction as D-layer
    public void E(){
        d(); D_prime();
    }
    
    public void E_prime(){
        E(); E(); E();
    }
    
    public void E2(){
        E(); E();
    }
    
    //rotates the cube 90 degrees in same
    //direction as R-layer
    public void x(){
        r(); L_prime();
    }
    
    public void x_prime(){
        x(); x(); x();
    }
    
    public void x2(){
        x(); x();
    }
    
    //rotates the cube 90 degrees in same
    //direction as U-layer
    public void y(){
        u(); D_prime();
    }
    
    public void y_prime(){
        y(); y(); y();
    }
    
    public void y2(){
        y(); y();
    }
    
    //rotates the cube 90 degrees in same
    //direction as F-layer
    public void z(){
        f(); B_prime();
    }
    
    public void z_prime(){
        z(); z(); z();
    }
    
    public void z2(){
        z(); z();
    }
    
    private void rotateClockwise(int side){
        Color[][][] temp = copy(cube);
        for(int i = 0; i<3; i++)
            for(int j = 0,k = 2; j<3; j++,k--)
                cube[side][i][j] = temp[side][k][i];
    }
  
    private void flipRow(int side, int row){
        Color temp = cube[side][row][0];
        cube[side][row][0] = cube[side][row][2];
        cube[side][row][2] = temp;
    }
    
    public void show(){
        for(int s = 0; s<6; s++){
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++)
                    System.out.print(cube[s][i][j] + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        RubiksCube rc = new RubiksCube();
//        for(int i = 0; i<6; i++){
//            rc.D();
//            rc.U();
//            rc.D_prime();
//            rc.U_prime();
//        }
//        PLL.Aa(rc);
//        PLL.Ab(rc);
//        PLL.H(rc);
//        PLL.H(rc);
//        PLL.Ua(rc);
//        PLL.Ub(rc);
//        PLL.Z(rc);
//        PLL.Z(rc);
        
//        PLL.Ja(rc);
//        PLL.Ja(rc);
//        PLL.Jb(rc);
//        PLL.Jb(rc);
//        PLL.T(rc);
//        PLL.T(rc);
//        PLL.Rb(rc);
//        PLL.Rb(rc);
//        PLL.Ra(rc);
//        PLL.Ra(rc);
//        PLL.F(rc);
//        PLL.F(rc);
        
//        PLL.V(rc);
//        PLL.V(rc);
//        PLL.Nb(rc);
//        PLL.Nb(rc);
//        PLL.Na(rc);
//        PLL.Na(rc);
//        PLL.Y(rc);
//        PLL.Y(rc);
        
//        PLL.Gd(rc);
//        PLL.Gc(rc);
//        PLL.Gc(rc);
//        rc.y();
//        PLL.Ga(rc);
//        PLL.Gb(rc);
        PLL.Gb(rc);
        PLL.Ga(rc);
//        PLL.Na(rc);
//        PLL.E(rc);
//        PLL.E(rc);
        rc.show();
        
        for(String s : rc.Layer1())
            System.out.print(s);
    }
}
