package flightDemo;

import java.util.Date;

public class FlightData {

    private String src;
    private String dest;
    private Date jDate;
    private int cost;
    private String type;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FlightData(String src, String dest, Date jDate, int cost, String type, int id) {
        this.src = src;
        this.dest = dest;
        this.jDate = jDate;
        this.cost = cost;
        this.type = type;
        this.id =id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Date getjDate() {
        return jDate;
    }

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "src='" + src + '\'' +
                ", dest='" + dest + '\'' +
                ", jDate=" + jDate +
                ", cost=" + cost +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}
