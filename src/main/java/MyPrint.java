/**
 * *  *  *  *  *  *  *  * Created by Peter.Wang on 2017/11/27.
 */
public class MyPrint {
    public final static String printArray(int[] array){
        StringBuffer str = new StringBuffer("");
        for(int item:array){
            str.append(item + " ");
        }
        return str.toString();
    }

    public final static String printRange(int start, int end){
        StringBuffer str = new StringBuffer("");
        for(int i = start; i <= end; i++){
            str.append(i + " ");
        }
        return str.toString();
    }
}
