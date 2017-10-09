package Ex02_BlackBoxInteger;

public class BlackBoxInt {
    private int innerValue;

    public BlackBoxInt() {
        innerValue = 0;
    }

    private void add(int addend) {
        this.innerValue += addend;
    }

    private void subtract(int subtrahend) {
        this.innerValue -= subtrahend;
    }

    private void multiply(int multiplier) {
        this.innerValue *= multiplier;
    }

    private void divide(int divider) {
        this.innerValue /= divider;
    }

    private void leftShift(int shifter) {
        this.innerValue <<= shifter;
    }

    private void rightShift(int shifter) {
        this.innerValue >>= shifter;
    }
}
