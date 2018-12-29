package Algorithms;

import Model.Lecture;
import Model.Period;
import Model.TimeProgram;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
         Comparator<TimeProgram> comparator = (TimeProgram o1, TimeProgram o2) -> {

            if (o1.Get_all_cost() < o2.Get_all_cost()) {
                return -1;
            }
            if (o1.Get_all_cost() > o2.Get_all_cost()) {
                return +1;
            }
            return 0;

            // return cost.get(o1) - o2.getManhattanDistance();
        };
        PriorityQueue<TimeProgram> queue  = new PriorityQueue<>(comparator);
        HashSet<Integer> hashSet = new HashSet<>();

        queue.add(grid);
        hashSet.add(grid.hashCode());
        
        while (!queue.isEmpty()) {
           
            this.NumberOfProgram++;
            

            TimeProgram cur = queue.poll();
            if (cur.isFinal() && cur.Get_all_cost() < 5000) {
                return cur;
            }
            
            List<TimeProgram> AllMoves = cur.getAllProgrm();
            for (TimeProgram u : AllMoves) {
                if (hashSet.contains(u.hashCode())) {
                    continue;
                }
                hashSet.add(u.hashCode());
                queue.add(u);
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
