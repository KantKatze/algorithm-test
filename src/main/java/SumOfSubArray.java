/**
 * 输入一个数组，找出其中和最大的子数组的下标
 * 解体思路：构造一个矩阵，N*N, 矩阵中每个元素的值都=sum{a[i]...a[j]},可以看出这个矩阵的对角线下方元素都是0，我们用到的
 * 仅仅是矩阵对角线上方的值。
 * 优化：后来发现其实可以不用保存矩阵，只需要按照规律不断就和的同时比较大小即可
 * 计算次数：n(n+1)/2
 * 例如：输入为{a , b , c ,d}
 * 那么计算出来的矩阵为：
 * a a+b a+b+c a+b+c+d
 *    b    b+c   b+c+d
 *          c     c+d
 *                 d
 */
public class SumOfSubArray {
    public static void main(String[] args){
        int[] initArray = new int[]{-1, 9, 100, -94, 5, 2, 0, -109, 90, 44, -23, 109, -90};
        int size = initArray.length;
//        int[][] count = new int[size][size];//可以不用保存矩阵

        int max = 0;
        int pi  = 0, pj = 0;
        for(int i=0; i < size; i++){
            int sum = 0;
            for(int j = i; j < size; j++){
                sum += initArray[j];
//                count[i][j] = sum;
                if(sum > max){
                    max = sum;
                    pi  = i;
                    pj  = j;
                }
            }
        }

        System.out.println("input is : " + MyPrint.printArray(initArray));
        System.out.println("max   = " + max);
        System.out.println("index = " + MyPrint.printRange(pi, pj));
    }

}
