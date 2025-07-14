/*
 * Bitmask DP Problem: Minimum Cost to Cover All Tasks
🔍 Problem Statement:
You are given n tasks and m workers. Each worker can do a subset of tasks and has a cost. Your goal is to assign workers such that all tasks are covered and the total cost is minimized.
 */
package com.hcl.tokens.operators;
import java.util.*;

public class MinCostTaskCover {
    static class Worker {
        int cost;
        int[] tasks;

        Worker(int cost, int[] tasks) {
            this.cost = cost;
            this.tasks = tasks;
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of tasks
        Worker[] workers = {
            new Worker(10, new int[]{0, 1}),
            new Worker(15, new int[]{1, 2}),
            new Worker(20, new int[]{0, 2})
        };

        int m = workers.length;
        int fullMask = (1 << n) - 1; // All tasks covered
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // No tasks covered, cost is 0

        for (Worker w : workers) {
            int taskMask = 0;
            for (int t : w.tasks) {
                taskMask |= (1 << t); // Set bits for tasks this worker can do
            }

            // Update DP table
            for (int mask = fullMask; mask >= 0; mask--) {
                if (dp[mask] != Integer.MAX_VALUE) {
                    int newMask = mask | taskMask;
                    dp[newMask] = Math.min(dp[newMask], dp[mask] + w.cost);
                }
            }
        }

        System.out.println("Minimum cost to cover all tasks: " + dp[fullMask]); // Output: 25
    }
}
