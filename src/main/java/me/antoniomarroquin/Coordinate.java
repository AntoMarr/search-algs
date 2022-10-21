package me.antoniomarroquin;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        Coordinate o = (Coordinate) object;
        if (this.x == o.x && this.y == o.y)
            return true;
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        y++;
    }

    public void moveDown() {
        y--;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public Coordinate getUp() {
        return new Coordinate(x, y + 1);
    }

    public Coordinate getDown() {
        return new Coordinate(x, y - 1);
    }

    public Coordinate getLeft() {
        return new Coordinate(x - 1, y);
    }

    public Coordinate getRight() {
        return new Coordinate(x + 1, y);
    }
}
