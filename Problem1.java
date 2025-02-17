package DFS2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Since we can move from each 1s horizontally or vertically to form an island, start traversing the entire matrix and whenever
 * we encounter a 1 we try to create an island with its neighbours using BFS and increment count. 
 * 
 * Time Complexity : O(mn) where m is no of rows and n is cols (each cell is covered only once)
 * 
 * 
 * Space Complexity : O(mn) since we use a queue
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
	   int[][]dirs= {{1,0},{0,1},{0,-1},{-1,0}};
	    public int numIslands(char[][] grid) {
	        int count=0;
	        Queue <int []> q=new LinkedList<>();

	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j]=='1'){
	                    q.add(new int [] {i,j});
	                    grid[i][j]=(char)-1;

	                    while(!q.isEmpty()){
	                        int[] curr=q.poll();
	                        for(int k=0;k<dirs.length;k++){
	                            int targetRow=curr[0]+dirs[k][0];
	                            int targetCol=curr[1]+dirs[k][1];

	                            if(targetRow>=0 && targetRow<grid.length && targetCol>=0 && 
	                                 targetCol < grid[0].length && grid[targetRow][targetCol]=='1'){
	                                 grid[targetRow][targetCol]=(char)-1;
	                                 q.add(new int[] {targetRow, targetCol});
	                            }
	                         }
	                    }
	                    count++;

	                }
	            }
	        }

	        return count;
	    }
}
