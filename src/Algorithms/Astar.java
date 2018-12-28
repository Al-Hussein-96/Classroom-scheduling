
package Algorithms;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.TimeProgram;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Al-Hussein
 */
public class Astar {

    private TimeProgram program;
        
    Map<Integer, Integer> g = new HashMap<>();
    Map<Integer, Integer> cost = new HashMap<>();
    
    private int NumberOfProgram = 0;

    public Astar(TimeProgram program) {
        this.program = program;
    }


    public TimeProgram Solve() {
        Comparator<TimeProgram> comparator = (TimeProgram o1, TimeProgram o2) -> {

            if (cost.get(o1.hashCode()) < cost.get(o2.hashCode())) {
                return -1;
            }
            if (cost.get(o1.hashCode()) > cost.get(o2.hashCode())) {
                return +1;
            }
            return 0;

            // return cost.get(o1) - o2.getManhattanDistance();
        };
        PriorityQueue<TimeProgram> queue = new PriorityQueue<>(comparator);
        HashSet<Integer> hashSet = new HashSet<>();
        queue.offer(program);

        hashSet.add(program.hashCode()); /// mark it visited
        
        cost.put(program.hashCode(), 0); /// cost : 0
        
        g.put(program.hashCode(), 0);    /// number of movment : 0
        
        while (!queue.isEmpty()) {
            this.NumberOfProgram++;
            TimeProgram cur = queue.poll();
            if (cur.isFinal()) {
                return cur;
            }

            List<TimeProgram> AllProgram = cur.getAllProgrm();

            for (TimeProgram u : AllProgram) {

                if (!hashSet.contains(u.hashCode())) {
                    g.put(u.hashCode(), g.get(cur.hashCode()) + 1);
                    
                    cost.put(u.hashCode(), g.get(u.hashCode()));
                    
                    hashSet.add(u.hashCode());
                    
                    queue.offer(u);
                } else {
                    int G = g.get(u.hashCode());
                    if (G < cost.get(u.hashCode())) {
                        cost.replace(u.hashCode(), G);
                        g.replace(u.hashCode(), g.get(cur.hashCode()) + 1);
                        queue.offer(u);
                    }
                }

//                if (!cost.containsKey(u)) {
//                    cost.put(u, Integer.MAX_VALUE);
//                    g.put(Integer.SIZE, Integer.MIN_VALUE)
//                }
////                if (hashSet.contains(u.hashCode())) {
////                    continue;
////                }
////                hashSet.add(u.hashCode());
//                System.out.println("Key: " + g.containsKey(cur.hashCode()));
//                int DistanceFromU = g.get(cur.hashCode()) + u.getManhattanDistance() + 1;
//
//                if (DistanceFromU < cost.get(u)) {
//                    cost.replace(u, DistanceFromU);
//                    g.replace(u.hashCode(), g.get(cur.hashCode()) + 1);
//                    map.put(u, cur);
//                    queue.offer(u);
//                }
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

    public TimeProgram getProgram() {
        return program;
    }

    public void setProgram(TimeProgram program) {
        this.program = program;
    }
    
    

   

}
