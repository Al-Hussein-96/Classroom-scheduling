package Algorithms;

import Model.Lecture;
import Model.Period;
import Model.TimeProgram;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Al-Hussein
 */
public class BFS {

    private TimeProgram grid;
    private int NumberOfProgram = 0;

    public BFS(TimeProgram grid) {
        this.grid = grid;
    }

        public TimeProgram Solve() {
        Stack <TimeProgram> stack = new Stack();
        HashSet<Integer> hashSet = new HashSet<>();

        stack.add(grid);
        hashSet.add(grid.hashCode());
        
        while (!stack.isEmpty()) {
           System.out.println(NumberOfProgram);
            this.NumberOfProgram++;
            

            TimeProgram cur = stack.pop();
            if (cur.isFinal() && cur.Get_all_cost() < 5000) {
                return cur;
            }
            
            List<TimeProgram> AllMoves = cur.getAllProgrm();
            for (TimeProgram u : AllMoves) {
                if (hashSet.contains(u.hashCode())) {
                    continue;
                }
                hashSet.add(u.hashCode());
                stack.add(u);
            }
        }

        return null;
    }

    public int getNumberOfProgram() {
        return NumberOfProgram;
    }

    public void setNumberOfProgram(int NumberOfProgram) {
        this.NumberOfProgram = NumberOfProgram;
    }

}
