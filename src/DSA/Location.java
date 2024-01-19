package DSA;
class Location implements Cloneable{
    private int x,y;

    public Location(int y,int x){
        this.x = x;
        this.y = y;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int direction){
        switch(direction){
            case Direction.NORTH ->
                    --y;
            case Direction.EAST ->
                    ++x;
            case Direction.SOUTH ->
                    ++y;
            case Direction.WEST ->
                    --x;
        }
    }

    public Location adjacent(int direction){
        switch(direction){

            case Direction.NORTH: return new Location(y-1,x);

            case Direction.EAST: return new Location(y,x+1);

            case Direction.SOUTH: return new Location(y+1,x);

            case Direction.WEST: return new Location(y,x-1);
        }
        return null;
    }

    public String toString(){
        return " (" + getX() + "," + getY() + ")";
    }
}