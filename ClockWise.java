/////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 ** @author : wanghx
 ** date ：2021-08-26 09:17:33
 ** 随机二维数组矩阵，顺/逆时针方向，由外向内遍历输出
 **/
public class ClockWise {
    private static int e;//右
    private static int w;//左
    private static int s;//下
    private static int n;//上
    private static int rowLength;//行数
    private static int colLength;//列数
    private static  String[] part;
    private static String[] arr;
    private static List<String> matrixRet = new ArrayList<>();

    public static void main(String[]args){
        System.out.println("please input matrix:");
        if(!toDo()){
            System.out.println(matrixRet);
            System.out.println(matrixRet.subList(0, colLength * rowLength));
        }
    }

    private static boolean toDo(){
        Scanner scanner = new Scanner(System.in);
        String arrStr = scanner.nextLine();
        //拆分二维数组
        part = arrStr.substring(2, arrStr.length()-2).split("],\\[");
        rowLength = part.length;//行数

        //获取第一行数据
        getValue(0);
        colLength = arr.length;//列数

        //初始化右和下的下标
        e = colLength - 1;
        s = rowLength - 1;
        return up();
    }

    private  static boolean up(){
        if(getValue(n)){
            for (int k = w; k <= e; k++) {
                matrixRet.add(arr[k]);
            }
        }else {
            return  false;
        }
        n++;//行数起始位置下移
        return   right();
    }

    private static  boolean right(){
        //遍历靠右边的一列
        for (int k = n; k <= s; k++) {
            if(getValue(k)){
                matrixRet.add(arr[e]);
            }else {
                return false;
            }
        }
        e--;
        return  down();
    }

    private static boolean down(){
        //遍历靠下面一行
        if(getValue(s)){
            for (int k = e; k >= w; k--) {
                matrixRet.add(arr[k]);
            }
        }else {
            return false;
        }
        s--;
        return  left();
    }

    private  static boolean left(){
        //遍历靠左边一列
        for (int k = s; k >= n; k--) {
            if(getValue(k)){
                matrixRet.add(arr[w]);
            }else {
                return false;
            }
        }
        w++;
        return  up();
    }

    private static boolean getValue(int i){
        if(matrixRet.size() != 0 && matrixRet.size() >= colLength * rowLength){
            return false;
        }
        arr = part[i].split(",");
        return  true;
    }
}