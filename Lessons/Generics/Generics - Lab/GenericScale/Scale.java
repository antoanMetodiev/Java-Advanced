package GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int result = this.right.compareTo(this.left);
        if (result > 0) {
            return this.right;
        } else if (result < 0) {
            return this.left;
        } else {
            return null;
        }
    }
}
