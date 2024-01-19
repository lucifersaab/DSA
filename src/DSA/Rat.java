package DSA;

class Rat {
    private Maze maze;
    private Location location;

    public Rat(Maze maze){
        this.maze = maze;
        location = new Location(1,0);
    }

    public Location getLocation() throws CloneNotSupportedException {
        return (Location)location.clone();
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public boolean canMove(int direction){
        Location neighbor = location.adjacent(direction);
        return maze.isOpen(neighbor);
    }

    public void move(int direction){
        location.move(direction);
        maze.markMoved(location);
    }

    public boolean isOut(){
        return (location.getX()== maze.getWidth()-1 && location.getY()== maze.getHeight()-2);
    }
}
