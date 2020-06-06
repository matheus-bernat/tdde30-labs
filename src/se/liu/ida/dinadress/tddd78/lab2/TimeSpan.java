package se.liu.ida.dinadress.tddd78.lab2;

public class TimeSpan {

    private TimePoint start;
    private TimePoint end;

    public TimeSpan(final TimePoint start, final TimePoint end) {
        this.start = start;
        this.end = end;
    }

    public TimePoint getStart() {
        return start;
    }

    public TimePoint getEnd() {
        return end;
    }

    public String toString() {
        return getStart() + "-" + getEnd();
    }


}
