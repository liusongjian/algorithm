package common;

public class BitMap {
    private int[] data;
    private int size;

    public BitMap(int size) {
        this.size = size;
        data = new int[(size >> 5) + 1];
    }

    /**
     * 添加数据
     */
    private void add(int bitIndex){
        if(bitIndex > size - 1 || bitIndex < 0) throw new IndexOutOfBoundsException();
        data[bitIndex >> 5] |= 1 << bitIndex % 31;
    }

    /**
     * 查找数据
     */
    private boolean find(int bitIndex){
        if(bitIndex > size - 1 || bitIndex < 0) throw new IndexOutOfBoundsException();
        return (data[bitIndex >> 5] & 1 << bitIndex % 31) > 0;
    }
    /**
     * 删除数据
     */
    private void delete(int bitIndex){
        if(bitIndex > size - 1 || bitIndex < 0) throw new IndexOutOfBoundsException();
        data[bitIndex >> 5] &= ~(1 << bitIndex % 31);
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(64);
        bitMap.add(31);
        bitMap.add(1);
        System.out.println("查找31：" + bitMap.find(31));
        System.out.println("查找1：" + bitMap.find(1));
        System.out.println(bitMap.data[0]);
        bitMap.delete(31);
//        bitMap.delete(19);
        System.out.println("查找31：" + bitMap.find(31));
        System.out.println(bitMap.data[0]);
        System.out.println(bitMap.data[0]&=~(1<<19%31));

    }
}
