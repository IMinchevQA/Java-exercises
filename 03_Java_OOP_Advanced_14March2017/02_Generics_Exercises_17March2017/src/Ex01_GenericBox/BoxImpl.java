package Ex01_GenericBox;


public class BoxImpl<P> implements Box<P> {
    private P str;

    public BoxImpl(P str) {
        this.str = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.str.getClass().toString().substring(6))
                .append(": ")
                .append(str.toString());
        return sb.toString();
    }


}
