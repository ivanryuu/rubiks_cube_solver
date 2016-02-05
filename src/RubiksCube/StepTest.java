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
public class StepTest {
    
    NNPredict nn_pll = new NNPredict("PLL");
    NNPredict nn_oll = new NNPredict("OLL");
    NNPredict nn_f2l = new NNPredict("F2L");
   int[] g_algs = new int[45];
    
    public static void main(String[] args){
        StepTest st = new StepTest();
//        st.testF2L(1000);
//        st.testOLL(1000);
//        st.testPLL(1000);
        st.testCross(1000);
        
//        st.testCubeSolve(1000);
    }
    
    public void shuffle(RubiksCube cube, int set){
        Random rand = new Random();
        for(int i = 0; i < 20; i++){
            switch(set){
                case 0: F2L.doF2LAlg(cube, rand.nextInt(41)+1); break;
                case 1: OLL.doOLLAlg(cube, rand.nextInt(57)+1); break;
                case 2: PLL.doPLLAlg(cube, rand.nextInt(21)+1); break;
                case 3: Cross.shuffle(cube); break;
            }
        }
    }
    
    public void testPLL(int max_iter){
        double correct = 0;
            for(int i = 0; i < max_iter; i++){
                RubiksCube rc = new RubiksCube();
                shuffle(rc,2);
                //PLL.doTrainAlg(rc, t_a);
                //rc.U2();
                //rc.y();
                if(testPLL(rc,10))
                    correct++;
            
        }
        System.out.println("PLL accuracy: " + correct/max_iter*100.0);
    }
    
    public void testOLL(int max_iter){
        double correct = 0;
        for(int i = 0; i < max_iter; i++){
            RubiksCube rc = new RubiksCube();
            shuffle(rc,1);
            if(testOLL(rc,15))
                correct++;
        }
        System.out.println("OLL accuracy: " + correct/max_iter*100.0);
    }
    
    public void testF2L(int max_iter){
        double correct = 0;
        for(int i = 0; i < max_iter; i++){
            RubiksCube rc = new RubiksCube();
            shuffle(rc,0);
            if(testF2L(rc,20))
                correct++;
        }
        System.out.println("F2L accuracy: " + correct/max_iter*100.0);
    }
    
    public void testCross(int max_iter){
        double correct = 0;
        for(int i = 0; i < max_iter; i++){
            RubiksCube rc = new RubiksCube();
            shuffle(rc,3);
            if(testCross(rc,20))
                correct++;
        }
        System.out.println("Cross accuracy: " + correct/max_iter*100.0);
    }
    
    public void testCubeSolve(int max_iter){
        double correct = 0;
        for(int i = 0; i < max_iter; i++){
            RubiksCube rc = new RubiksCube();
            shuffle(rc,0);
            if(testCubeSolve(rc,20))
                correct++;
        }
        System.out.println("Cube solver accuracy: " + correct/max_iter*100.0);
    }
    
    private boolean testPLL(RubiksCube cube, int limit){
        
        int counter = 0;
        RubiksCube rc = new RubiksCube(cube.getCube());
        do {
            
            if(PLL.PLLSuccess(cube)){
                return true;
            }
            
            double[] X = CubeData.PLLDataRow(rc);
            int alg = nn_pll.nnPredict(X,15);
            PLL.doPLLAlg(rc, alg);
            if(!PLL.PLLSuccess(rc)){
                cube.U();
                counter++;
                if(counter > limit)
                    return false;
            }
            else{
                PLL.doPLLAlg(cube, alg);
            }
            rc = new RubiksCube(cube.getCube());
        }while(!PLL.PLLSuccess(rc));
        
        return true;
    }
    
    private boolean testOLL(RubiksCube cube, int limit){
        RubiksCube rc = new RubiksCube(cube.getCube());
        int counter = 0;
        double[] X = CubeData.OLLDataRow(rc);
        int alg = nn_oll.nnPredict(X);
        do {
            OLL.doOLLAlg(rc, alg);
            if(!OLL.OLLSuccess(rc)){
                cube.U();
                counter++;
                if(counter > limit)
                    return false;
            }
            else
                OLL.doOLLAlg(cube, alg);
            rc = new RubiksCube(cube.getCube());
        }while(!OLL.OLLSuccess(rc));
        return true;
    }
    
    private boolean testF2L(RubiksCube cube, int limit){
        int rotations = 0;
        RubiksCube rc = new RubiksCube(cube.getCube());
        int counter = 0;
        do{
            do {
                if(F2L.F2LComplete(cube)){
                    return true;
                }
                if(F2L.F2LSuccess(rc)){
                    rc.d();
                    continue;
                }
                counter++;
                if(counter > limit)
                    return false;
                
                rc = new RubiksCube(cube.getCube());
                double[] X = CubeData.F2LDataRow(rc);
                int alg = nn_f2l.nnPredict(X,20);
                
                if(alg >= 42){
                    if(rotations >= 4){
                        F2L.doF2LAlg(cube, alg);
                        rotations = 0;
                         
                    }
                    else {
                        rotations++;
                        rc.d();
                        //continue;
                    }
                    X = CubeData.F2LDataRow(rc);
                    alg = nn_f2l.nnPredict(X,20);

                }
                if(F2L.F2LSuccess(rc)){
                    rc.d();
                    continue;
                }
                
                g_algs[alg]++;
                //Get color of the front face
                String f_face = "" + rc.getColor(1, 1, 1);
                F2L.prepareF2L(rc);
                F2L.doF2LAlg(rc, alg);

                    while(!f_face.equals("" + rc.getColor(1, 1, 1))){
                        rc.y();
                    }

                    if(F2L.F2LSuccess(rc)){
                        cube = new RubiksCube(rc.getCube());
                    }
                    
                rc = new RubiksCube(cube.getCube());
            }while(!F2L.F2LSuccess(rc));
            
            if(!F2L.F2LComplete(cube)){
                cube.d();
            }
            
        }while(!F2L.F2LComplete(cube));
        return true;
    }
    
    private boolean testCross(RubiksCube cube, int limit){
        int counter = 0;
        int[] edges;
        if(Cross.crossSuccess(cube))
            return true;
        while(!Cross.crossSuccess(cube)){
            counter++;
            if(counter > limit)
                return false;
            
            edges = Cross.getCrossEdges(cube);
            
            if(Cross.containsCrossEdge(edges, 20, 4)){
                Cross.onTopFace(cube);
                edges = Cross.getCrossEdges(cube);
            }
            if(Cross.containsCrossEdge(edges, 8, 8)){
                Cross.onMiddleLayer(cube);
                edges = Cross.getCrossEdges(cube);
            }
            if(Cross.containsCrossEdge(edges,4,4) || Cross.containsCrossEdge(edges,16,4)){
                Cross.onLowerUpperLayer(cube);
                edges = Cross.getCrossEdges(cube);
            }
            if(!Cross.crossSuccess(cube) && Cross.onCrossEdgeCount(edges) == 4 && Cross.crossInOrder(edges)){
                Cross.rotateToPosition(cube);
            }
        }
        return true;
    }
    
    private boolean testCubeSolve(RubiksCube cube, int limit){
        RubiksCube rc = new RubiksCube(cube.getCube());
        testF2L(rc,limit);
        System.out.println(rc);
        testOLL(rc,limit);
        System.out.println(rc);
        testPLL(rc,limit);
        System.out.println(rc);
        return PLL.PLLSuccess(rc);
    }
    
    public void testF2L(){
        int[] suc_alg = new int[42];
        for(int x = 0; x< 50; x++){
            for(int t = 1; t <= 41; t++){
                RubiksCube cube = new RubiksCube();
                F2L.doTrainAlg(cube, t);
//                cube.U_prime();
                int[] alg_guess = new int[45];
                for(int i = 0; i<100; i++){
                    double[] X = CubeData.F2LDataRow(cube);
                    int guess = nn_f2l.nnPredict(X,10);
                    alg_guess[guess]++;
                }
                int max = 0;
                int alg = 0;
                for(int i = 1; i <= 44; i++){
                    if(alg_guess[i] > max){
                        max = alg_guess[i];
                        alg = i;
                    }
                }
                F2L.prepareF2L(cube);
                F2L.doF2LAlg(cube, alg);
                if(F2L.F2LSuccess(cube))
                    suc_alg[t]++;

            }
        }
        for(int i : suc_alg)
            System.out.print(i + " ");
    }
    
}
