package Algorithms;

import Model.Lecture;
import Model.Period;
import Model.TimeProgram;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Al-Hussein
 */
public class BFS {

    private TimeProgram program;
    private int NumberOfProgram = 0;

    public BFS(TimeProgram grid) {
        this.program = grid;
    }

    public TimeProgram Solve() {
        List<Lecture> lectures = new ArrayList<>();

        for (Lecture l : Lecture.All_Lectures) {
            try {
                lectures.add((Lecture) l.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Queue<Lecture> queue = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        Lecture start;
        try {
            start = (Lecture) lectures.get(0).clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        int day = 1, time = 1;
        start.setPeriod(new Period(day, time));

        queue.offer(start);
        hashSet.add(start.hashCode());
        // program.addLecture(start);

        while (!queue.isEmpty()) {
            // System.out.println("Size Queue: " + queue.size());
            this.NumberOfProgram++;

            Lecture cur = queue.poll();

            time++;
            if (time > 4) {
                day++;
                time = 1;
            }
            this.program.addLecture(cur);

            List<Lecture> AllMoves = lectures;
            for (Lecture u : AllMoves) {
                if (hashSet.contains(u.hashCode())) {
                    continue;
                }
                if (this.program.canAddLecture(u, new Period(day, time)));
                {

                    hashSet.add(u.hashCode());
                    queue.offer(u);
                }

            }
        }
        return program;
    }

    public int getNumberOfProgram() {
        return NumberOfProgram;
    }

    public void setNumberOfProgram(int NumberOfProgram) {
        this.NumberOfProgram = NumberOfProgram;
    }

}
