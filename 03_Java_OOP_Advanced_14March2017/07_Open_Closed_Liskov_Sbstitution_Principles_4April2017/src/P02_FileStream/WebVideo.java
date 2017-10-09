package P02_FileStream;

public class WebVideo implements Streamable {

    private int length;
    private int bytesSent;


    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
