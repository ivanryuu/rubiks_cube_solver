/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

import Jama.Matrix;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class NNPredict {
    
    private Matrix[] theta;
    private Matrix mu, sigma;
    
    public NNPredict(String prefix){
//        File[] weights = {new File("data/"+prefix+"_weight_Theta1.txt"),
//                    new File("data/"+prefix+"_weight_Theta2.txt")};
        String[] weights = {"data/"+prefix+"_weight_Theta1.txt",
                    "data/"+prefix+"_weight_Theta2.txt"};
        loadWeigths(weights);
        loadNormalization(prefix);
    }
    
    public int nnPredict(double[] X){
        int p = 10;
        double[] X_mf = polyFeatures(X, p);
        
        for(int i = 0; i < X_mf.length; i++)
            X_mf[i] = (X_mf[i] - mu.get(0, i))/sigma.get(0,i); 
        return predict(X_mf);
    }
    
    public int nnPredict(double[] X, int p){
        double[] X_mf = polyFeatures(X, p);
        
        for(int i = 0; i < X_mf.length; i++)
            X_mf[i] = (X_mf[i] - mu.get(0, i))/sigma.get(0,i); 
        return predict(X_mf);
    }
    
    private int predict(double[] X){
        double[][] X_m = new double[1][X.length];
        System.arraycopy(X, 0, X_m[0], 0, X.length);
        int[] pred = predict(new Matrix(X_m));
        return pred[0];
    }
    
    private int[] predict(Matrix X){
//        h1 = sigmoid([ones(m, 1) X] * Theta1');
//        h2 = sigmoid([ones(m, 1) h1] * Theta2');
//        [dummy, p] = max(h2, [], 2);
        
        Matrix h1 = sigmoid(addBiasLayer(X).times(theta[0].transpose()));
        Matrix h2 = sigmoid(addBiasLayer(h1).times(theta[1].transpose()));
        
        //h2.print(h2.getRowDimension(), h2.getColumnDimension());
        return max(h2.getArray());
        
    }
    
    private int[] max(double[][] m){
        int[] max_i = new int[m.length];
        double[] max_v = new double[m.length];
        
        for(int row = 0; row < m.length; row++)
            for(int col = 0; col < m[0].length; col++){
                if(max_v[row] < m[row][col]){
                    max_v[row] = m[row][col];
                    max_i[row] = col+1; 
                }
            }
        
        return max_i;
    }
    
    private Matrix addBiasLayer(Matrix X){
        double[][] m = new double[X.getRowDimension()][X.getColumnDimension()+1];
        for(int i = 0; i<m.length; i++){
            m[i][0] = 1;
            for(int j = 1; j < m[0].length; j++)
                m[i][j] = X.get(i, j-1);
        }
        return new Matrix(m);
    }
    
    private Matrix sigmoid(Matrix z){
        int r = z.getRowDimension();
        int c = z.getColumnDimension();
        Matrix g = new Matrix(r, c, 1.0);
        g.arrayRightDivideEquals(exp(neg(z)).plus(new Matrix(r,c,1.0)));
        return g;
    }
    
    private double[] polyFeatures(double[] X, int p){
        double[] X_poly = new double[X.length*p];
        for(int j = 0,k = 1; j < X_poly.length; j+= X.length, k++)
            for(int i = 0; i < X.length; i++)
                X_poly[i+j] = Math.pow(X[i], k);
        
        return X_poly;
    }
    
//    private void loadWeigths(File[] weights){
//        theta = new Matrix[weights.length];
//        BufferedReader in = null;
//        for(int i = 0; i < weights.length; i++){
//            try {
//                in = new BufferedReader(new FileReader(weights[i]));
//                theta[i] = Matrix.read(in);
//            } catch (Exception ex) {}
//            finally {
//                try {
//                    if(in != null)
//                        in.close();
//                } catch (IOException ex) {}
//            }
//        }
//    }
    
    private void loadWeigths(String[] weights){
        theta = new Matrix[weights.length];
        BufferedReader in = null;
        for(int i = 0; i < weights.length; i++){
            try {
                InputStream is = this.getClass().getResourceAsStream(weights[i]);
                in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                //in = new BufferedReader(new FileReader(weights[i]));
                theta[i] = Matrix.read(in);
            } catch (Exception ex) {}
            finally {
                try {
                    if(in != null)
                        in.close();
                } catch (IOException ex) {}
            }
        }
    }
    
    private void loadNormalization(String prefix){
        BufferedReader in = null;
        try {
            //File mu_file = new File("data/"+ prefix +"_norm_mu.txt");
            //in = new BufferedReader(new FileReader(mu_file));
            InputStream is = this.getClass().getResourceAsStream("data/"+ prefix +"_norm_mu.txt");
            in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            mu = Matrix.read(in);
            
            //File sigma_file = new File("data/"+ prefix +"_norm_sigma.txt");
            //in = new BufferedReader(new FileReader(sigma_file));
            is = this.getClass().getResourceAsStream("data/"+ prefix +"_norm_sigma.txt");
            in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            sigma = Matrix.read(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
            try {
                if(in != null)
                    in.close();
            } catch (IOException ex) {}
        }
    }
    
    public Matrix neg(Matrix m){
        return m.times(-1.0);
    }
    
    public Matrix exp(Matrix matrix){
        double[][]m = matrix.getArray();
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[0].length; j++)
                m[i][j] = Math.exp(m[i][j]);
        return new Matrix(m);
    }
    
    public static void main(String[] args){
        NNPredict nnp = new NNPredict("PLL");
        double[] X = {87, 87, 89, 79, 89, 82, 87, 82, 89, 82, 79, 79, 86393, 78760, 86238, 81330, 2786, 2841, 2621, 2536};
        System.out.println(nnp.nnPredict(X));
    }
}
