package me.antoniomarroquin;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Coordinate o) {
        if (this.x == o.x && this.y == o.y)
            return true;
        return false;
    }
}
