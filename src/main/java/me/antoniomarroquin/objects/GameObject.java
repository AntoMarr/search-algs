package me.antoniomarroquin.objects;

import me.antoniomarroquin.Coordinate;

public abstract class GameObject {
    public Coordinate coordinate;

    public GameObject(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public abstract boolean equals(Object object);
}
