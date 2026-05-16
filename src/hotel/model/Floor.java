package model;

public class Floor {
    private static int i = 0;
    private int floor;
    private int idRoom;

    public Floor(int floor){
        this.floor = floor;
        this.idRoom = ++i;
    }

    public int getFloor(){return this.floor;}

    public int getIdRoom(){return this.idRoom;}

    public String numeroChambre(){
        String strIdRoom = this.idRoom + "";
        if(idRoom<10){strIdRoom = "0" + strIdRoom;}
        return this.floor + "-" + strIdRoom;}
}
