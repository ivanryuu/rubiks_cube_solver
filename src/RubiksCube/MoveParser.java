/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ivan
 */
public class MoveParser {
    
    private String moves;
    private LinkedList<String> move_list = null;
    
    public MoveParser(){
        moves = "";
    }
    
    public MoveParser(String moves){
        this.moves = moves;
        initialize();
    }
    
    public void clear(String moves){
        move_list = null;
        
        move_list = new LinkedList<String>();
        this.moves = moves;
        initialize();
    }
    
    private void initialize(){
//        move_list = null;
        move_list = new LinkedList<String>();
        String[] lines = moves.split("\n");
        String moves_strip = "";
        for(String line : lines){
            if(line.length() < 2)
                continue;
            if(line.contains(":"))
                moves_strip += line.split(":")[1];
            else
                moves_strip += line;
        }
//        System.out.println(moves_strip);
//        String mov = "";
//        Pattern pattern = Pattern.compile("\\w(2|')?");
//        Matcher matcher = pattern.matcher(moves_strip);
//        while(matcher.find())
//            mov += moves_strip.subSequence(matcher.start(),matcher.end()).toString() + " ";
////            move_list.add(moves_strip.subSequence(matcher.start(),matcher.end()).toString());
//        String[] moves_arr = mov.split(" ");
//        for(int i = 0, j = 1; i < moves_arr.length; ){
//            int counter = moveValue(moves_arr[i]);
//            
//            while(j < moves_arr.length && moves_arr[i].charAt(0) == moves_arr[j].charAt(0)){
//                counter += moveValue(moves_arr[j++]);
//            }
//            switch(counter % 4){
//                case 1: move_list.add("" + moves_arr[i].charAt(0)); break;
//                case 2: move_list.add("" + moves_arr[i].charAt(0) + "2"); break;
//                case 3: move_list.add("" + moves_arr[i].charAt(0) + "'"); break;
//            }
//            i = j++;
//            
//        }
        String[] moves_arr = compressMoves(moves_strip).split(" ");
        for(String m : moves_arr)
            move_list.add(m);
    }
    
    public String compressMoves(String m){
        String mov = "";
        String moves = "";
        Pattern pattern = Pattern.compile("\\w(2|')?");
        Matcher matcher = pattern.matcher(m);
        while(matcher.find())
            mov += m.subSequence(matcher.start(),matcher.end()).toString() + " ";
//            move_list.add(moves_strip.subSequence(matcher.start(),matcher.end()).toString());
        String[] moves_arr = mov.split(" ");
        for(int i = 0, j = 1; i < moves_arr.length; ){
            int counter = moveValue(moves_arr[i]);
            
            while(j < moves_arr.length && moves_arr[i].charAt(0) == moves_arr[j].charAt(0)){
                counter += moveValue(moves_arr[j++]);
            }
            switch(counter % 4){
                case 1: moves += moves_arr[i].charAt(0) + " "; break;
                case 2: moves += moves_arr[i].charAt(0) + "2 "; break;
                case 3: moves += moves_arr[i].charAt(0) + "' "; break;
            }
            i = j++;
        }
        return moves;
    }
    
    private int moveValue(String s){
        if(s.length() == 1) return 1;
        else if(s.charAt(1) == '2') return 2;
        else return 3;
    }
    
    public void print(){
//        Iterator iterator = move_list.iterator();
        move_list.start();
        while(move_list.EOL())
            System.out.println(move_list.next());
    }
    
    public String getMoves(){
        String m = "";
        move_list.start();
        while(hasNext())
            m += move_list.next() + " ";
        move_list.start();
        return m;
    }
    
    private int parseMove(String move, boolean reverse){
        int parsed_move = 0;
        switch(move.charAt(0)){
            case 'R': parsed_move = 1; break;
            case 'U': parsed_move = 2; break;
            case 'F': parsed_move = 3; break;
            case 'L': parsed_move = 4; break;
            case 'D': parsed_move = 5; break;
            case 'B': parsed_move = 6; break;
            case 'r': parsed_move = 7; break;
            case 'u': parsed_move = 8; break;
            case 'f': parsed_move = 9; break;
            case 'l': parsed_move = 10; break;
            case 'd': parsed_move = 11; break;
            case 'b': parsed_move = 12; break;
            case 'x': parsed_move = 13; break;
            case 'y': parsed_move = 14; break;
            case 'z': parsed_move = 15; break;
            case 'M': parsed_move = 16; break;
            case 'E': parsed_move = 17; break;
            case 'S': parsed_move = 18; break;
        }
        if(move.length() > 1)
            parsed_move += move.charAt(1) == '2' ? 20 : 40;
        
        if(reverse){
            if(parsed_move < 20)
                parsed_move += 40;
            else if(parsed_move > 40)
                parsed_move -= 40;
        }
        return parsed_move;
    }
    
    private void doMove(RubiksCube cube, String move, boolean reverse){
        int parsed_move = parseMove(move, reverse);
        switch(parsed_move){
            case 1:  cube.R(); break;
            case 2:  cube.U(); break;
            case 3:  cube.F(); break;
            case 4:  cube.L(); break;
            case 5:  cube.D(); break;
            case 6:  cube.B(); break;
            case 7:  cube.r(); break;
            case 8:  cube.u(); break;
            case 9:  cube.f(); break;
            case 10: cube.l(); break;
            case 11: cube.d(); break;
            case 12: cube.b(); break;
            case 13: cube.x(); break;
            case 14: cube.y(); break;
            case 15: cube.z(); break;
            case 16: cube.M(); break;
            case 17: cube.E(); break;
            case 18: cube.S(); break;
            case 21: cube.R2(); break;
            case 22: cube.U2(); break;
            case 23: cube.F2(); break;
            case 24: cube.L2(); break;
            case 25: cube.D2(); break;
            case 26: cube.B2(); break;
            case 27: cube.r2(); break;
            case 28: cube.u2(); break;
            case 29: cube.f2(); break;
            case 30: cube.l2(); break;
            case 31: cube.d2(); break;
            case 32: cube.b2(); break;
            case 33: cube.x2(); break;
            case 34: cube.y2(); break;
            case 35: cube.z2(); break;
            case 36: cube.M2(); break;
            case 37: cube.E2(); break;
            case 38: cube.S2(); break;
            case 41: cube.R_prime(); break;
            case 42: cube.U_prime(); break;
            case 43: cube.F_prime(); break;
            case 44: cube.L_prime(); break;
            case 45: cube.D_prime(); break;
            case 46: cube.B_prime(); break;
            case 47: cube.r_prime(); break;
            case 48: cube.u_prime(); break;
            case 49: cube.f_prime(); break;
            case 50: cube.l_prime(); break;
            case 51: cube.d_prime(); break;
            case 52: cube.b_prime(); break;
            case 53: cube.x_prime(); break;
            case 54: cube.y_prime(); break;
            case 55: cube.z_prime(); break;
            case 56: cube.M_prime(); break;
            case 57: cube.E_prime(); break;
            case 58: cube.S_prime(); break;
        }
    }
    
    public boolean hasNext(){
        return move_list.EOL();
    }
    
    public int currentLength(){
        return move_list.current().length();
    }
    
    public int previousLength(){
        return move_list.previousPeek().length();
    }
    
    public void next(RubiksCube cube){
        if(move_list.index() == -1)
            move_list.start();
        if(move_list.EOL())
            doMove(cube, move_list.next(), false);
    }
    
    public void previous(RubiksCube cube){
//        if(move_list.index() == -1)
//            move_list.start();
        if(move_list.SOL())
            doMove(cube, move_list.previous(), true);
    }
    
    public void testPrevious(){
        String s = "";
        move_list.start();
        s += parseMove(move_list.next(),false) + " ";
        s += parseMove(move_list.previous(),true);
//        s += move_list.next();
        
//        s += move_list.previous();
        System.out.println(s);
    }
    
    public static void main(String[] args){
        String moves = "Shuffle: RU'R' d R'U2 RU2 R'URU2d R'URU' R'U'RdU2 RU'R' y L'U' L\n" +
"\n" +
"F2L: d URUR'U' RUR'\n" +
"d RU'R' d RU2 RU2 R'UR\n" +
"U'RUR'\n" +
"\n" +
"OLL: U2r'U' RU' R'URU' R'U2 r\n" +
"PLL: U'x R'UR' D2 RU'R' D2 R2 x'";
        String moves2 = "R' D2 U' B R2 F2 R2 B2 R F L' D U' B U2 L2 R2 L B' L' R L B' U2 R2 F2";
        MoveParser mp2 = new MoveParser(moves2);
        
        System.out.println(mp2.getMoves());
        //MoveParser mp = new MoveParser(moves);
        //mp.testPrevious();
    }

}
