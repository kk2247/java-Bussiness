package sample;

import java.io.InputStream;

public class Food extends Goods{
    private String ownerName;
    private int ownerSchoolID;
    private int number;
    private String produceDay;
    private String deadLine;
    private String describe;
    private String ID;
    private InputStream foodPicture;
    private int times=0;


    public Food(String name, float price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Food{" +
                "ownerName='" + ownerName + '\'' +
                ", ownerSchoolID=" + ownerSchoolID +
                ", number=" + number +
                ", produceDay='" + produceDay + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", describe='" + describe + '\'' +
                ", ID='" + ID + '\'' +
                ", foodPicture=" + foodPicture +
                '}';
    }

    public void setTimes(int increase) {
       times+=increase;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerSchoolID() {
        return ownerSchoolID;
    }

    public void setOwnerSchoolID(int ownerSchoolID) {
        this.ownerSchoolID = ownerSchoolID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProduceDay() {
        return produceDay;
    }

    public void setProduceDay(String produceDay) {
        this.produceDay = produceDay;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public InputStream getFoodPicture() {
        return foodPicture;
    }

    public void setFoodPicture(InputStream foodPicture) {
        this.foodPicture = foodPicture;
    }

    public Food(String name, float price, String ownerName, int ownerSchoolID, int number, String produceDay, String deadLine, String describe, InputStream foodPicture) {
        super(name, price);
        this.ownerName = ownerName;
        this.ownerSchoolID = ownerSchoolID;
        this.number = number;
        this.produceDay = produceDay;
        this.deadLine = deadLine;
        this.describe = describe;
        this.foodPicture = foodPicture;
    }
}
