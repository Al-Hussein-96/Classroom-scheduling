package Algorithms;

import Model.TimeProgram;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Queue<TimeProgram> queue = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        queue.offer(grid);
        hashSet.add(grid.hashCode());

        while (!queue.isEmpty()) {
            this.NumberOfProgram++;

            TimeProgram cur = queue.poll();
            if (cur.isFinal()) {
                return cur;
            }

            List<TimeProgram> AllMoves = cur.getAllProgrm();
            for (TimeProgram u : AllMoves) {
                if (hashSet.contains(u.hashCode())) {
                    continue;
                }
                hashSet.add(u.hashCode());
                queue.offer(u);
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
