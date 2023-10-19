package leetcode;

import java.util.ArrayList;
import java.util.Stack;


public class no207 {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int pair[] : prerequisites){
            adj.get(pair[0]).add(pair[1]);
        }
        int vis[] = new int[numCourses];
        int dfsVis[] = new int[numCourses];
        for(int i=0 ; i<numCourses ; i++){
            if(vis[i] == 0){
                if(check(i,adj,vis,dfsVis) == true){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean check(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]){
        vis[node] = 1;
        dfsVis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(check(it,adj,vis,dfsVis) == true){
                    return true;
                }
            }
            else if(dfsVis[it] == 1){
                return true;
            }
        }
        dfsVis[node] = 0;
        return false;
    }

	public static void main(String[] args) {
		int[][] A = {{1,0}, {0,1}, {2, 1}};
		//int[][] A = {{1,0}, {0,1}, {2, 1}, {0, 3}}
		
		boolean R = canFinish(3, A);
		
		System.out.println(R);
	}
}
