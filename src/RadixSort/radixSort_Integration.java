package RadixSort;

import java.util.Arrays;

public class radixSort_Integration {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        int[] arr=new int[8000000];
        for(int i=0;i< arr.length;i++){
            arr[i]= (int) (Math.random()* arr.length);
        }
        radixSort(arr);
        System.out.println(System.currentTimeMillis());
    }

    public static void radixSort(int[] arr){
        //判断最大数
        int Max=arr[0];
        for (int i=1;i< arr.length;i++){
            if(arr[i]>Max){
                Max=arr[i];
            }
        }
        //System.out.println(Max);

        //判断最大数的最大位数
        int MaxLength=(Max+"").length();
        //System.out.println(MaxLength);

        int[][] bucket=new int[10][arr.length];//创建bucket
        int[] bucketCounts=new int[10];//对桶内数据进行计数

        //对其位数进行判断循环,多少位就有多少轮
        for(int i=0,n=1;i<MaxLength;i++,n*=10){
            //将检索到的位数进行切分,第几轮就是第几位
            for(int j=0;j< arr.length;j++){
                int digital=arr[j]/n%10;//记录位数
                bucket[digital][bucketCounts[digital]]=arr[j];//将相应位数放入相应的桶
                bucketCounts[digital]++;
            }
            int index=0;
            //放置成功后进行取出,取回到原来的arr数组中
            for(int k=0;k< bucketCounts.length;k++){
                //先判断bucket内是否为空
                if(bucketCounts[k]!=0){
                    //再进入桶子内部进行搜索
                    for(int g=0;g<bucketCounts[k];g++){
                        arr[index++]=bucket[k][g];
                    }
                }
                bucketCounts[k]=0;//取出后为下一轮留出空间,所以置零
            }
//            System.out.println("第"+(i+1)+"轮的排序结果为:"+ Arrays.toString(arr));
        }
    }
}
