package Algorithms;

import Model.Lecture;
import Model.Period;
import Model.TimeProgram;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        
        Map<Integer, Integer> best_solve = new HashMap<>();
        int temp = grid.Get_all_cost();
        best_solve.put(grid.hashCode(), temp); /// cost : 0
        
        TimeProgram best = null;
        
        queue.add(grid);
        hashSet.add(grid.hashCode());
        
        while (!queue.isEmpty()) {
            
            if(this.NumberOfProgram > 20000 && best != null)
            {
                System.out.println("MY COST : " +best.Get_all_cost()+"");
                best.print_WeakConstraints();
                if(best != null)
                {
                    return best;
                }
            }
            this.NumberOfProgram++;
            TimeProgram cur = queue.poll();
            int Cost_Cur = cur.Get_all_cost();
            int level = cur.getLectures().size();
            if(best_solve.get(level)!=null)
            {
                int H = best_solve.get(level);
                if(Cost_Cur > H)
                {
                    continue;
                }
                best_solve.put(level , Cost_Cur);
            }
            else 
            {
                best_solve.put(level , Cost_Cur);
            }
            if (cur.isFinal()) {
                System.out.println("Final : "+cur.Get_all_cost());
                if(best == null)
                    best = cur;
                else
                {
                    if(best.Get_all_cost() > cur.Get_all_cost())
                    {
                        best = cur;
                    }
                }
           ///     return cur;
            }
            
            List<TimeProgram> AllMoves = cur.getAllProgrm();
            for (TimeProgram u : AllMoves) {
                if (hashSet.contains(u.hashCode())) {
                    continue;
                }
                hashSet.add(u.hashCode());
                if(queue.size() < 1000)
                queue.add(u);
            }
        }

        return best;
    }

    public int getNumberOfProgram() {
        return NumberOfProgram;
    }

    public void setNumberOfProgram(int NumberOfProgram) {
        this.NumberOfProgram = NumberOfProgram;
    }

}
