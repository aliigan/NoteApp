package props;

public class Notes {
    private int nid;
    private String title;
    private String detail;
    private String date;

    public Notes() {
    }

    public Notes(int nid, String title, String detail, String date) {
        this.nid = nid;
        this.title = title;
        this.detail = detail;
        this.date = date;
    }

    public Notes(String title, String detail, String date) {
        this.title = title;
        this.detail = detail;
        this.date = date;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
