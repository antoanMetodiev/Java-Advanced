package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> nums = new Scale<>(20, 9);
        System.out.println(nums.getHeavier());
    }
}
