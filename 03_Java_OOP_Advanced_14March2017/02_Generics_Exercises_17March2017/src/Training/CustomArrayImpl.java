package Training;


public class CustomArrayImpl<P extends Comparable<P>> implements CustomArray<P> {
    private P firstElement;
    private P secondElement;

    public CustomArrayImpl() {

    }

    @Override
    public void addElement(P element) {
        if (this.firstElement == null) {
            this.firstElement = element;
            return;
        }

        if (this.secondElement == null) {
            this.secondElement = element;
            return;
        }

        throw new IllegalArgumentException("Some message");
    }

    @Override
    public P getFirstElement() {
        return this.firstElement;
    }

    @Override
    public P getSecondElement() {
        return this.secondElement;
    }

    private int compare() {
        return this.firstElement.compareTo(this.secondElement);
    }
}
