package buinz.caka.gamexephinh.model;

public class HistoryModel {
    private int id;
    private String type;
    private String time;
    private String moves;

    public HistoryModel(int id, String type, String time, String moves) {
        this.id = id;
        this.type = type;
        this.time = time;
        this.moves = moves;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }
}
