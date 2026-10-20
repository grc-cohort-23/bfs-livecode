
import java.lang.reflect.AccessFlag;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Search {
     /**
      * TODO: change coment to reflect that we'er returning path instead of fimal location now
     * Finds the location of the nearest reachable cheese from the rat's position.
     * Returns a 2-element int array: [row, col] of the closest 'c'. If there are multiple
     * cheeses that are tied for the same shortest distance to reach, return
     * any one of them.
     * 
     * 'R' - the rat's starting position (exactly one)
     * 'o' - open space the rat can walk on
     * 'w' - wall the rat cannot pass through
     * 'c' - cheese that the rat wants to reach
     * 
     * If no rat is found, throws EscapedRatException.
     * If more than one rat is found, throws CrowdedMazeException.
     * If no cheese is reachable, throws HungryRatException
     *
     * oooocwco
     * woowwcwo
     * ooooRwoo
     * oowwwooo
     * oooocooo
     *
     * The method will return [0,4] as the nearest cheese.
     *
     * @param maze 2D char array representing the maze
     * @return int[] location of the closest cheese in row, column format
     * @throws EscapedRatException if there is no rat in the maze
     * @throws CrowdedMazeException if there is more than one rat in the maze
     * @throws HungryRatException if there is no reachable cheese
     */

    char[][] grid = {
        {'o', 'o', 'o', 'o', 'c', 'w', 'c', 'o'},
        {'w', 'o', 'o', 'w', 'w', 'c', 'w', 'o'},
        {'o', 'o', 'o', 'o', 'R', 'w', 'o', 'o'},
        {'o', 'o', 'w', 'w', 'w', 'o', 'o', 'o'},
        {'o', 'o', 'o', 'o', 'c', 'o', 'o', 'o'}
        };
        System.out.println();
    public static List<Location> nearestCheese(char[][] maze) throws EscapedRatException, CrowdedMazeException, HungryRatException {
        Set<Location> hasBeenQueued = new HashSet<>();
        Queue<Location> queue = new ArrayDeque<>();
        Map<Location, Location> prevs = new HashMap();
            
    
        queue.add(start);
        while(!queue.isEmpty()){
            Location current = queue.remove();
            if(hasBeenQueued.contains(current))continue;

            if(maze[current.row()][current.column()] == c){
                List<Location> path = new LinkedList<>();
                Location steps = current;
                while(steps != null){
                    path.addFirst(steps);
                    steps = prevs.get(steps);

                }
                return path;
                //return new int[]{current.row(), current.column()};
            }
            List<Location> neighbors = possibleMoves(maze , current);
            for(Location neighbor : neighbors){
                if(!prevs.keySet().contains(neighbor)){
                    prevs.put(neighbor, current);
                    queue.add(neighbor);
                }
                
            }
        }
        throw new HungryRatException();
    
    }
    public static List<Location> possibleMoves(char[][] maze,Location current){

    }
}