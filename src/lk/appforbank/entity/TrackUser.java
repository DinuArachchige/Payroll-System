package lk.appforbank.entity;

public class TrackUser implements SuperEntity {
    private int trackID;
    private int tid;
    private String userd;

    public TrackUser(int trackID, int tid, String userd) {
        this.trackID = trackID;
        this.tid = tid;
        this.userd = userd;
    }

    public TrackUser() {
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getUserd() {
        return userd;
    }

    public void setUserd(String userd) {
        this.userd = userd;
    }

    @Override
    public String toString() {
        return "TrackUser{" +
                "trackID=" + trackID +
                ", tid=" + tid +
                ", userd='" + userd + '\'' +
                '}';
    }
}
