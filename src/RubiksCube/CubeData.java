/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class CubeData {
    
    private ArrayList<Integer[]> data_set = new ArrayList<Integer[]>();
    private static final File PLL_file = new File("PLL_data.txt");
    private static final File OLL_file = new File("OLL_data.txt");
    private static final File F2L_file = new File("F2L_data.txt");
    
    public CubeData()
    {}
    
    public static double[] PLLDataRow(RubiksCube cube){
        Integer[] data = PLLDataRow_p(cube,false);
        double[] data_d = new double[data.length];
        for(int i = 0; i < data.length; i++)
            data_d[i] = data[i];
        return data_d;
    }
    
    public static double[] OLLDataRow(RubiksCube cube){
        Integer[] data = OLLDataRow_p(cube,false);
        double[] data_d = new double[data.length];
        for(int i = 0; i < data.length; i++)
            data_d[i] = data[i];
        return data_d;
    }
    
    public static double[] F2LDataRow(RubiksCube cube){
        Integer[] data = F2LDataRow_p(cube,false);
        double[] data_d = new double[data.length];
        for(int i = 0; i < data.length; i++)
            data_d[i] = data[i];
        return data_d;
    }
    
    public static Integer[] F2LDataRow_p(RubiksCube cube, boolean train){
        int length = train ? 41 : 40;
        Integer[] data_row = new Integer[length];
        String f_c = "" + cube.getColor(1, 1, 1);
        String r_c = "" + cube.getColor(4, 1, 1);
        String b_c = "" + cube.getColor(0, 1, 1);
        
        // Do corners first
        data_row[0] = colorClassifier(cube,""+cube.getColor(0, 0, 2));
        
        
        for(int i = 0; i < 2; i++){
            data_row[i+1] = colorClassifier(cube,""+cube.getColor(1, 2-i, 2));
            data_row[i+3] = colorClassifier(cube,""+cube.getColor(4, 2-i, 0));
        }
        
        String[] layer_3 = cube.Layer3();
        String[] t_face = cube.getFace(2);
        
        int[] edges = {7,5,1,3};
        int[] corners_t = {6,8,2,0};
        int[] corner_l = {11,0,2,3,5,8,6,9};
        
        for(int i = 0; i < 4; i++){
            data_row[i+5] = colorClassifier(cube,layer_3[i*3 + 1]);
            data_row[i+9] = colorClassifier(cube,t_face[edges[i]]);
            data_row[i+13] = colorClassifier(cube,t_face[corners_t[i]]);
            data_row[i+17] = colorClassifier(cube,layer_3[corner_l[i*2]]);
            data_row[i+21] = colorClassifier(cube,layer_3[corner_l[i*2+1]]);
            if(data_row[i+5] == 2 || data_row[i+9] == 2){
                data_row[i+5] = 2;
                data_row[i+9] =2;
            }
            if(data_row[i+13] == 2 || data_row[i+17] == 2 || data_row[i+21] == 2){
                data_row[i+13] = 2;
                data_row[i+17] =2;
                data_row[i+21] =2;
            }
            data_row[i+26] = data_row[i+13]*100 + data_row[i+17]*10 + data_row[i+21];
            data_row[i+31] = data_row[i+5]*10 + data_row[i+9];
            data_row[i+36] = data_row[i+26]*10 + data_row[i+31];
        }
        
        if(data_row[0] == 2 || data_row[1] == 2 || data_row[3] == 2)
        {
            data_row[0] = 2;
            data_row[1] =2;
            data_row[3] =2;
        }
        if(data_row[2] == 2 || data_row[4] == 2){
            data_row[2] = 2;
            data_row[4] =2;
        }
        data_row[25] = data_row[0]*100 + data_row[1]*10 + data_row[3];
        data_row[30] = data_row[2]*10 + data_row[4];
        data_row[35] = data_row[25]*10 + data_row[30];
        
        
//        for(int i : data_row)
//            System.out.print(i + " ");
//        System.out.println();
        
        return data_row;
    }
    
    private static int colorClassifier(RubiksCube cube, String color){
        String f_c = "" + cube.getColor(1, 1, 1);
        String r_c = "" + cube.getColor(4, 1, 1);
        String b_c = "" + cube.getColor(0, 1, 1);
        
        if(color.equals(b_c)) return 6;
        else if(color.equals(f_c)) return 8;
        else if(color.equals(r_c)) return 9;
        else return 2;
    }
    
    private static Integer[] PLLDataRow_p(RubiksCube cube, boolean train){
        int length = train ? 25 : 24;
        Integer[] data_row = new Integer[length];
        String[] layer_3 = cube.Layer3();
        String f_c = "" + cube.getColor(1, 1, 1);
        String r_c = "" + cube.getColor(4, 1, 1);
        String b_c = "" + cube.getColor(3, 1, 1);
        String l_c = "" + cube.getColor(5, 1, 1);
        for(int i = 0; i < layer_3.length; i++){
            if(layer_3[i].equals(b_c)) data_row[i] = 2;
            else if(layer_3[i].equals(f_c)) data_row[i] = 3;
            else if(layer_3[i].equals(r_c)) data_row[i] = 4;
            else if(layer_3[i].equals(l_c)) data_row[i] = 5;
        }
        
        
        for(int i = 0; i < 4; i++){
            data_row[i+12] = data_row[i*3]*100 + data_row[i*3 + 1]*10 + data_row[i*3 + 2];
            data_row[i+16] = data_row[i*3 + 1]*10 + data_row[(i*3 + 4)%12];
            data_row[i+20] = data_row[i+12]*10 + data_row[i+16];
        }
        
        return data_row;
    }
    
    private static Integer[] OLLDataRow_p(RubiksCube cube, boolean train){
        int length = train ? 31 : 30;
        String center = "" + cube.getColor(2, 1, 1);
        String[] top_face = cube.getFace(2);
        String[] layer_3 = cube.Layer3();
        Integer[] data_row = new Integer[length];
        
        // Saves the top layer as the first 8 features
        for(int i = 0,j; i<8; i++,j++){
            j = i == 4 ? i+1 : i;
            data_row[i] = center.equals(top_face[j]) ?  3 : 2;
        }
        
        // Saves layer 3 as the next 12 features
        for(int i = 0; i<layer_3.length; i++)
            data_row[i+8] = center.equals(layer_3[i]) ? 3 : 2;
        
        // Combines every 2 features and saves them as a new feature
        for(int i = 0; i<10; i++)
            data_row[i+20] = data_row[i*2]*10 + data_row[i*2+1];
        
        return data_row;
    }
    
    public static void randomSet(){
        RubiksCube rc = new RubiksCube();
        OLL.A01(rc);
        
        for(double i : OLLDataRow_p((rc),false))
            System.out.print(i + " ");
    }
    
    private void getF2LDataExamples(){
        
        for(int alg = 1; alg<=41; alg++){
            for(int side = 0; side < 4; side++){
                RubiksCube cube = new RubiksCube();
                
                
                
                F2L.doTrainAlg(cube, alg);
                
                switch(side){
                    case 1: cube.U(); break;
                    case 2: cube.U2(); break;
                    case 3: cube.U_prime(); break;
                }

                Integer[] data_row = F2LDataRow_p(cube,true);
                data_row[40] = alg;
                if(!data_set.contains(data_row))
                    data_set.add(data_row);
                
//                for(Integer i : data_row)
//                    System.out.print(i + " ");
//                System.out.println();
            }
        }
    }
    
    private void getF2LFailEx(){
        RubiksCube cube = new RubiksCube();
        F2L.A03(cube);
        cube.y_prime();
        F2L.A02(cube);
        F2L.A04(cube);
        cube.y();
//        for(int i = 0; i<4; i++){
//            switch(i){
//                case 1: cube.U(); break;
//                case 2: cube.U2(); break;
//                case 3: cube.U_prime(); break;
//            }
            Integer[] data_row = F2LDataRow_p(cube,true);
            data_row[40] = 42;
            data_set.add(data_row);
//        }
        F2L.A05(cube);
        cube.y();
        F2L.A04(cube);
        cube.y_prime();
        for(int i = 0; i<4; i++){
            switch(i){
                case 1: cube.U(); break;
                case 2: cube.U2(); break;
                case 3: cube.U_prime(); break;
            }
            data_row = F2LDataRow_p(cube,true);
            data_row[40] = 42;
            if(!data_set.contains(data_row))
            data_set.add(data_row);
        }
        
        cube.y2();
        F2L.A04(cube);
        cube.y2();
        for(int i = 0; i<4; i++){
            switch(i){
                case 1: cube.U(); break;
                case 2: cube.U2(); break;
                case 3: cube.U_prime(); break;
            }
            data_row = F2LDataRow_p(cube,true);
            data_row[40] = 43;
            if(!data_set.contains(data_row))
            data_set.add(data_row);
        }
        cube.y_prime();
        F2L.A02(cube);
        cube.y();
        for(int i = 0; i<4; i++){
            switch(i){
                case 1: cube.U(); break;
                case 2: cube.U2(); break;
                case 3: cube.U_prime(); break;
            }
            data_row = F2LDataRow_p(cube,true);
            data_row[40] = 44;
            if(!data_set.contains(data_row))
            data_set.add(data_row);
        }
    }
    
    private void getOLLDataExamples(){
        
        for(int alg = 1; alg<=57; alg++){
            for(int side = 0; side < 4; side++){
                RubiksCube cube = new RubiksCube();
                
                    
                switch(alg){
                    case 1:  OLL.A01(cube);     break;
                    case 2:  OLL.A_S02(cube);   break;
                    case 3:  OLL.A03(cube);     break;
                    case 4:  OLL.A_S04(cube);   break;
                    case 5:  OLL.A06(cube);     break;
                    case 6:  OLL.A05(cube);     break;
                    case 7:  OLL.A08(cube);     break;
                    case 8:  OLL.A07(cube);     break;
                    case 9:  OLL.A09(cube);     break;
                    case 10: OLL.A10(cube);     break;
                    case 11: OLL.A12(cube);     break;
                    case 12: OLL.A11(cube);     break;
                    case 13: OLL.A14(cube);     break;
                    case 14: OLL.A_S14(cube);   break;
                    case 15: OLL.A13(cube);     break;
                    case 16: OLL.A16(cube);     break;
                    case 17: OLL.A_S17(cube);   break;
                    case 18: OLL.A42(cube);     break;
                    case 19: OLL.A20(cube);     break;
                    case 20: OLL.A19(cube);     break;
                    case 21: OLL.A35(cube);     break;
                    case 22: OLL.A25(cube);     break;
                    case 23: OLL.A24(cube);     break;
                    case 24: OLL.A_S24(cube);   break;
                    case 25: OLL.A_S25(cube);   break;
                    case 26: OLL.A29(cube);     break;
                    case 27: OLL.A27(cube);     break;
                    case 28: OLL.A_S28(cube);   break;
                    case 29: OLL.A_S29(cube);   break;
                    case 30: OLL.A46(cube);     break;
                    case 31: OLL.A_S31(cube);   break;
                    case 32: OLL.A22(cube);     break;
                    case 33: OLL.A23(cube);     break;
                    case 34: OLL.A_S34(cube);   break;
                    case 35: OLL.A_S35(cube);   break;
                    case 36: OLL.A39(cube);     break;
                    case 37: OLL.A38(cube);     break;
                    case 38: OLL.A37(cube);     break;
                    case 39: OLL.A_S39(cube);   break;
                    case 40: OLL.A44(cube);     break;
                    case 41: OLL.A_S41(cube);   break;
                    case 42: OLL.A18(cube);     break;
                    case 43: OLL.A_S43(cube);   break;
                    case 44: OLL.A52(cube);     break;
                    case 45: OLL.A50(cube);     break;
                    case 46: OLL.A30(cube);     break;
                    case 47: OLL.A47(cube);     break;
                    case 48: OLL.A_S48(cube);   break;
                    case 49: OLL.A_S49(cube);   break;
                    case 50: OLL.A45(cube);     break;
                    case 51: OLL.A_S51(cube);   break;
                    case 52: OLL.A_S52(cube);   break;
                    case 53: OLL.A_S53(cube);   break;
                    case 54: OLL.A_S54(cube);   break;
                    case 55: OLL.A_S55(cube);   break;
                    case 56: OLL.A_S56(cube);   break;
                    case 57: OLL.A_S57(cube);   break;
                }
                
                switch(side){
                    case 1: cube.U(); break;
                    case 2: cube.U2(); break;
                    case 3: cube.U_prime(); break;
                }

                Integer[] data_row = OLLDataRow_p(cube,true);
                data_row[30] = alg;
                data_set.add(data_row);
                
//                for(Integer i : data_row)
//                    System.out.print(i + " ");
//                System.out.println();
            }
        }
    }
    
    private void getPLLDataExamples(){
        RubiksCube cube = new RubiksCube();
        for(int alg = 1; alg<= 21; alg++){
            for(int side = 0; side < 4; side++){

                switch(side){
                    case 1: cube.U(); break;
                    case 2: cube.U2(); break;
                    case 3: cube.U_prime(); break;
                }
                PLL.doTrainAlg(cube, alg);

                Integer[] data_row = PLLDataRow_p(cube,true);
                data_row[24] = alg;
                data_set.add(data_row);

                cube = new RubiksCube();
            }
        }
    }
    
    public void writePLLFile(){
        getPLLDataExamples();
        
        PrintWriter out = null;// = new BufferedWriter(new FileWriter(PLL_file));
        try {
            if(!PLL_file.exists()){
                PLL_file.createNewFile();
                out = new PrintWriter(new BufferedWriter(new FileWriter(PLL_file)));
            }
            else
                out = new PrintWriter(new BufferedWriter(new FileWriter(PLL_file,true)));
        } catch(IOException ex)
        {}
        
        for(Integer[] row: data_set){
            for(int cell : row)
                out.print(cell + " ");
            out.println();
        }
        
        out.close();
    }
    
    public void writeOLLFile(){
        getOLLDataExamples();
        
        PrintWriter out = null;// = new BufferedWriter(new FileWriter(PLL_file));
        try {
            if(!OLL_file.exists()){
                OLL_file.createNewFile();
                out = new PrintWriter(new BufferedWriter(new FileWriter(OLL_file)));
            }
            else
                out = new PrintWriter(new BufferedWriter(new FileWriter(OLL_file,true)));
        } catch(IOException ex)
        {}
        
        for(Integer[] row: data_set){
            for(int cell : row)
                out.print(cell + " ");
            out.println();
        }
        
        out.close();
    }
    
    public void writeF2LFile(){
        
        getF2LDataExamples();
        getF2LFailEx();
        ArrayList<String> data_strings = new ArrayList<String>();
        for(Integer[] row: data_set){
            String data = "";
            for(int cell : row)
                data += cell + " ";
           // if(!data_strings.contains(data))
                data_strings.add(data);
        }
        PrintWriter out = null;// = new BufferedWriter(new FileWriter(PLL_file));
        try {
            if(!F2L_file.exists()){
                F2L_file.createNewFile();
                out = new PrintWriter(new BufferedWriter(new FileWriter(F2L_file)));
            }
            else
                out = new PrintWriter(new BufferedWriter(new FileWriter(F2L_file,true)));
        } catch(IOException ex)
        {}
        
        for(String row: data_strings){
            
            out.print(row);
            out.println();
        }
        
        out.close();
    }
        
    public static void main(String[] args){
        CubeData cd = new CubeData();
        RubiksCube rc = new RubiksCube();
//        F2L.A01(rc);
//        CubeData.F2LDataRow_p(rc, false);
//        CubeVisualizer cvn = new CubeVisualizer(rc);
//        cd.getF2LFailEx();
        cd.writeF2LFile();
        

    }
}
