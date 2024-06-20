package datastructure.array;

public class MyArray {

    public static void main(String[] args) {
        MyArray array = new MyArray();
        System.out.println(array);

        testAdd(array);

        testPop(array);

        testDelete(array);
    }

    private static void testPop(MyArray array) {
        System.out.println(array.pop());
        System.out.println(array);

        System.out.println(array.pop());
        System.out.println(array);

        System.out.println(array.pop());
        System.out.println(array);

        System.out.println(array.pop());
        System.out.println(array);
    }

    private static void testDelete(MyArray array) {
        System.err.println(array.delete(1));
        System.out.println(array);

        System.err.println(array.delete(1));
        System.out.println(array);

        System.err.println(array.delete(0));
        System.out.println(array);

        System.err.println(array.delete(1));
        System.out.println(array);
    }

    private static void testAdd(MyArray array) {
        array.push("Hi");
        System.out.println(array);

        array.push("You");
        System.out.println(array);

        array.push("!");
        System.out.println(array);
    }

    private int length;
    private Object data[];

    public MyArray() {
        this.length = 0;
        data = new Object[100];
    }

    public Object get(int index) {
        return data[index];
    }

    public int push(Object item) {
        data[length++] = item;
        return length;
    }

    public Object pop() {
        if (length == 0)
            return null;
        var item = data[length - 1];
        data[--length] = null;
        return item;
    }

    public Object delete(int index) {
        if (index >= length || index < 0) {
            return null;
        }
        var item = data[index];
        shiftItem(index);
        return item;
    }

    private void shiftItem(int index) {
        //[1, 2, 3]
        // i = 0
        // [2, 3, 3]
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--length] = null;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();

        sb.append(super.toString()).append(": length=").append(length).append(", data={");
        for (int i = 0; i < length; i++) {
            sb.append(data[i]).append(',');
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append('}');
        return sb.toString();
    }

}
