import java.lang.reflect.Array;
import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        RadixSort(arr);
    }

    public static void RadixSort(int[] arr){
        //创建桶子
        int[][] bucket=new int[10][arr.length];
        //记录桶子中的数据条目
        int[] bucketElementsNums=new int[10];

        //进行第一轮放置
        for (int i=0;i<arr.length;i++) {
            //个位
            int digital = arr[i] % 10;
            //将其放入对应的桶中
            bucket[digital][bucketElementsNums[digital]] = arr[i];
            //准备放入下一个数据
            bucketElementsNums[digital]++;
        }
        //下面将进行第一次取出
        int index=0;
        for(int j=0;j< bucketElementsNums.length;j++){
            //先判断桶中是否为空
            if(bucketElementsNums[j]!=0){
                //不是空,则进行取出
                for(int i=0;i< bucketElementsNums[j];i++){
                    arr[index++]=bucket[j][i];
                }
            }
           bucketElementsNums[j]=0;
        }
        //第二次

        for (int i=0;i<arr.length;i++) {
            //十位
            int digital = arr[i]/10 % 10;
            //将其放入对应的桶中
            bucket[digital][bucketElementsNums[digital]] = arr[i];
            //准备放入下一个数据
            bucketElementsNums[digital]++;
        }
        //下面将进行第二次取出
        index=0;
        for(int j=0;j< bucketElementsNums.length;j++){
            //先判断桶中是否为空
            if(bucketElementsNums[j]!=0){
                //不是空,则进行取出
                for(int i=0;i< bucketElementsNums[j];i++){
                    arr[index++]=bucket[j][i];
                }
            }
            bucketElementsNums[j]=0;
        }

        //第三次

        for (int i=0;i<arr.length;i++) {
            //百位
            int digital = arr[i]/100;
            //将其放入对应的桶中
            bucket[digital][bucketElementsNums[digital]] = arr[i];
            //准备放入下一个数据
            bucketElementsNums[digital]++;
        }
        //下面将进行第三次取出
        index=0;
        for(int j=0;j< bucketElementsNums.length;j++){
            //先判断桶中是否为空
            if(bucketElementsNums[j]!=0){
                //不是空,则进行取出
                for(int i=0;i< bucketElementsNums[j];i++){
                    arr[index++]=bucket[j][i];
                }
            }
            bucketElementsNums[j]=0;
        }
        System.out.println(Arrays.toString(arr));
    }
}
