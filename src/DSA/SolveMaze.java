package DSA;

import java.util.Stack;

public class SolveMaze{
    Maze maze;
    Rat rat;
    Stack<Location> stack;

    public SolveMaze(String file) throws CloneNotSupportedException {
        maze=new Maze(file);
        rat=new Rat(maze);
        stack=new Stack<>();
        maze.print();

         while (!rat.isOut()) {
             Location currentLocation = rat.getLocation();
             maze.markMoved(currentLocation);
             if (rat.canMove(Direction.NORTH)) {
                 rat.move(Direction.NORTH);
                 stack.push(currentLocation);
             }else if (rat.canMove(Direction.EAST)) {
                 currentLocation.adjacent(Direction.EAST);
                 rat.move(Direction.EAST);
                 stack.push(currentLocation);
             }else if (rat.canMove(Direction.SOUTH)) {
                 rat.move(Direction.SOUTH);
                 stack.push(currentLocation);
             }else if (rat.canMove(Direction.WEST)) {
                 rat.move(Direction.WEST);
                 stack.push(currentLocation);
             }else {
                 if (!stack.isEmpty()) {
                     maze.markTried(rat.getLocation());
                     rat.setLocation(stack.pop());
                 }
             }
         }
        System.out.println();
         if(rat.isOut()) {
             System.out.println("MAZE SOLVED!");
             System.out.println();
             maze.print();
         }
         else System.out.println("PATH CAN NOT BE FOUND.");

    }
}

