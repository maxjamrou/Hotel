package model;

public class Floor {
    private int floor;
    private int idRoom;

    public Floor(int floor){
        this.floor = floor;
        this.idRoom = 0;
    }

    public int getFloor(){return this.floor;}

    public int incrIdRoom(){return ++this.idRoom;}
}
