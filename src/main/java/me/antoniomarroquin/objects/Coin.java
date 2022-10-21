package me.antoniomarroquin.objects;

import me.antoniomarroquin.Coordinate;

public class Coin extends GameObject {

    private boolean pickedUp;

    public Coin(Coordinate coordinate) {
        super(coordinate);
        this.pickedUp = false;
    }

    public Coin(Coordinate coordinate, boolean pickedUp) {
        super(coordinate);
        this.pickedUp = pickedUp;
    }

    public boolean pickUp() {
        if (pickedUp == true)
            return false;
        pickedUp = true;
        return true;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Coin)) 
            return false;
        Coin o = (Coin) object;

        if (coordinate.equals(o.coordinate) && this.isPickedUp() == o.isPickedUp()) {
            return true;
        }

        return false;
    }
    
}
