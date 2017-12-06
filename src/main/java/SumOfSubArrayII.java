/**
 * SumOfSubArray的升级版，
 * 求环形数组中的和最大的子数组
 * 解体思路：1.跟求数组中最大的子数组思路一样，只不过更加复杂，考虑到环形，所以从任意位置开始计算到队列尾之后不能结束，需要
 * 从头继续求和，直到进行到起始位置
 * set input = 【a, b, c, d, e】
 * 构造矩阵 A(5,5)= 【a, b, c, d, e】
 *                  【b, c, d, e, a】
 *                  【c, d, e, a, b】
 *                  【d, e, a, b, c】
 *                  【e, a, b, c, d】
 * 构造关系矩阵 K（5，5）=【1, 1, 1, 1, 1】
 *                        【0, 1, 1, 1, 1】
 *                        【0, 0, 1, 1, 1】
 *                        【0, 0, 0  1, 1】
 *                        【0, 0, 0, 0, 1】
 *
 * set C(5,5) = A * K = 【a,     b,     c,     d,     e】
 *                      【ab,    bc,    cd,    de,    ea】
 *                      【abc,   bcd,   cde,   dea,   eab】
 *                      【abcd,  bcde,  cdea,  deab,  eabc】
 *                      【abcde, bcdea, cdeab, deabc, eabcd】
 * 最大值 = Max（C[i,j]）, 数组下标= j ... j+i%N
 *
 * *  *  *  *  *  *  *  * Created by Peter.Wang on 2017/11/27.
 */
public class SumOfSubArrayII {
    public static void main(String[] args){
        int[] initArray = new int[]{-1, 9, 100, -94, 5, 2, 0, -109, 90, 44, -23, 109, -90};
        int size = initArray.length;
        int max = 0, pi =0, pj = 0;

        for(int i = 0; i < size; i++){
            int count = initArray[i];
            if(max < count){
                max = count;
                pi = i;
                pj = i;
            }
            int pos   = i+1;//目标的下标
            for(int j = 1; j < size; j++){ //总是加size-1次
                count += initArray[pos%size]; //j的步长累加超出数组边界后，要回到数组头部;
                if(max < count){
                    max = count;
                    pi = i;
                    pj = pos%size;
                }
                pos++;//需要在最后执行，否则pj的值会算错
            }
        }

        System.out.println("input is : " + MyPrint.printArray(initArray));
        System.out.println("max   = " + max);
        System.out.println("index = " + MyPrint.printRange(pi, pj, size));
    }


}
