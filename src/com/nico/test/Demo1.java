package com.nico.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        Demo1 sol = new Demo1();
        System.out.println(sol.digitSum("11111222223",3));
        System.out.println(sol.digitSum("111113123131222223",5));
        System.out.println(sol.digitSum("11111222223",3));
        System.out.println(sol.digitSum("11111222223",3));
    }

    @Test
    public void test1001() {
        double a = 0.47;
        double b = 0.44;
        double c = 0.19;
        double d = 0.5;//.1
        System.out.println(a + b + c);
        System.out.println(a + b + c == 1.0);
    }

    public static String reverseInteger(){
        return "";
    }

    public static String getSecurityLevel (String password) {
        // write code here
        return "";
    }

    public static int getDoublePrimes (int index) {
        // write code here
        if(index>200||index<1){
            return -1;
        }
        int count = 0;//记录双素数个数
        int i =1;//被检查的数
        while (count!=index){
            i++;
            int flag = 0;//判断一个数除1和自身是否还可以被其他数整除
            int z =0;
            for(z=2;z<=i/2;z++){
                if(i%z==0){
                    flag++;
                    break;
                }
            }
            if(flag!=0||z==2){
                continue;
            }
            //反转整数
            if(i<10){
                continue;
            }
            StringBuffer sb = new StringBuffer();
            int number = i;
            while(number!=0){
                int temp = number%10;
                number = number/10;
                sb.append(temp);
            }
            int _i = Integer.parseInt(sb.toString());
            if(i==_i){
                continue;
            }
            for(int j=2;j<=_i/2;j++){
                if(_i%j==0){
                    flag++;
                    break;
                }
            }
            if(flag==0){
                count++;
            }
        }
        return i;

    }

    public static int reverseInt(int number){
        if(number<10){
            return number;
        }
        int sum = 0;
        int count = 0;
        StringBuffer sb = new StringBuffer();
        while(number!=0){
            int temp = number%10;
            number = number/10;
            sb.append(temp);
        }
//        System.out.println(Integer.parseInt(sb.toString()));
        return Integer.parseInt(sb.toString());
    }

    @Test
    public void test(){
//        int a = 3;int b = 5;
//        double res = (double) (a / b);
//        System.out.println(res);
//        res = (double) a / b;
//        System.out.println(res);
        int[] arr = {2,3,3};
        int mid = 2;
        while (mid >= 0 && arr[mid] == 3){--mid;}
        System.out.println(mid);
        arr.clone();
    }

    @Test
    public void test1(){
        int a = 3;int b = 5;
        String str1 = a + " " + b;
        int x = 3;int y = 5;
        String str2 = x + " " + y;
        System.out.println(str1.hashCode() == str2.hashCode());
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(str1,5);
        hm.put(str2,5);
        System.out.println(hm.size());
    }

    @Test
    public void test2(){
        char[][] src = {
            {'.','4','.','.','.','.','.','9','.'},
            {'9','.','5','8','.','6','2','1','1'},
            {'.','2','.','.','3','.','.','8','.'},
            {'.','8','.','.','.','.','.','5','.'},
            {'.','.','1','.','.','.','6','.','.'},
            {'.','7','1','.','.','.','.','1','.'},
            {'.','9','.','.','5','.','.','2','.'},
            {'3','.','7','4','.','9','5','.','.'},
            {'.','6','.','.','.','.','.','.','.'}
        };
        char[][] tar = {
            {'.','.','.','.','.','.','.','.','.'},
            {'5','.','6','1','.','7','3','.','2'},
            {'.','3','.','.','2','.','.','1','.'},
            {'.','8','.','.','.','.','.','7','.'},
            {'.','.','7','.','.','.','5','.','.'},
            {'.','6','.','.','.','.','.','2','.'},
            {'.','5','.','.','6','.','.','9','.'},
            {'.','.','1','3','.','5','7','.','4'},
            {'.','.','.','.','.','.','.','5','.'}
        };
        for(int i = 0;i < src.length;++i) {
            tar[i] = src[i].clone();
        }
        print(src);
        System.out.println("----------");
        print(tar);
        System.out.println("改变后");
        tar[0][0] = '+';
        System.out.println("----------");
        print(src);
        System.out.println("----------");
        print(tar);
    }

    public void print(char[][] board){
        for(int i = 0;i < board.length;++i){
            for(int j = 0;j < board[i].length;++j){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void test3(){
        Demo1 sol = new Demo1();
        System.out.println(sol.countNumber(35));
    }

    int countNumber(int x){
        int res = 0;
        while(x != 0){
            res = res + x % 10;
            x /= 10;
        }
        return res;
    }

    @Test
    public void test4(){
        int[] a = {1,2};
        int[] b = a;
        b[0] += 1;
    }

    @Test
    public void test5() {
        String s = "123";
        System.out.println(Integer.parseInt(s.charAt(1)+""));
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(1);
    }

    public String digitSum(String s, int k) {
        while(s.length() > k) {
            StringBuilder stringBuilder = new StringBuilder();
            int tempV = 0;
            int i = 0;
            for(i = 0;i < s.length();++i) {
                tempV = tempV + Integer.parseInt(s.charAt(i) + "");
                if((i + 1) % k == 0) {
                    stringBuilder.append(tempV+"");
                    tempV = 0;
                }
            }
            if(i % k != 0) {
                stringBuilder.append(tempV);
            }
            s = stringBuilder.toString();
        }
        return s;
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int level : tasks) {
            map.put(level,map.getOrDefault(level,0)+1);
        }
        int ans = 0;
        for(Integer value : map.values()) {
            if(value == 1) {
                return -1;
            }
            int mod = value % 3;
            if(mod == 1) {
                value -= 4;
                ans += 2;
            }else if(mod == 2) {
                value -= 2;
                ans += 1;
            }
            ans += value / 3;
        }
        return ans;
    }

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //前缀和记录当前坐标的因数2和5的个数
        int[][] row2 = new int[m+1][n+1];
        int[][] row5 = new int[m+1][n+1];
        int[][] column2 = new int[m+1][n+1];
        int[][] column5 = new int[m+1][n+1];
        for(int i = 1;i <= m; ++i) {
            for(int j = 1;j <= n; ++j) {
                int x = grid[i-1][j-1];
                int two = 0;
                int five = 0;
                while(x % 2 == 0) {
                    x /= 2;
                    ++two;
                }
                while(x % 5 == 0) {
                    x /= 5;
                    ++five;
                }
                row2[i][j] = row2[i][j-1] + two;
                column2[i][j] = column2[i-1][j] + two;
                row5[i][j] = row5[i][j-1] + five;
                column5[i][j] = column5[i-1][j] + five;
            }
        }
        int ans = 0;
        for (int i = 1;i <= m; ++i){
            for(int j = 1;j <= n; ++j) {
                //左上
                ans = Math.max(ans,Math.min(row2[i][j]+column2[i-1][0],row5[i][j]+column5[i-1][0]));
                //左下
                ans = Math.max(ans,Math.min(row2[i][j]+column2[m][0]-column2[i][0],row5[i][j]
                        +column5[m][0]-column5[i][0]));
                //右上
                ans = Math.max(ans,Math.min(row2[i][n]-row2[i][j-1]+column2[i-1][n],
                        row5[i][n]-row5[i][j-1]+column5[i-1][n]));
                //右下
                ans = Math.max(ans,Math.min(row2[i][n]-row2[i][j-1]+column2[m][n]-column2[i][n],
                        row5[i][n]-row5[i][j-1]+column5[m][n]-column5[i][n]));
            }
        }
        return ans;
    }


    @Test
    public void test288() {
        for(int i = 0;i < 5;++i) {
            if(i == 2) {
                break;
            }
            System.out.println(i);
        }
    }

    /**
     * 把中文键值对转为对象
     */
    @Test
    public void test11() {
        String zhStr = "正向有功总电能(kWh):10.28\r\n正向有功费率1电能(kWh):5.94\r\n正向有功费率2电能(kWh):0.17\r\n正向有功费率3电能(kWh):0.66\r\n正向有功费率4电能(kWh):3.51\r\n正向无功总电能(kvarh):0.00\r\n正向无功费率1电能(kvarh):0.00\r\n正向无功费率2电能(kvarh):0.00\r\n正向无功费率3电能(kvarh):0.00\r\n正向无功费率4电能(kvarh):0.00\r\n反向有功总电能(kWh):19.56\r\n反向有功费率1电能(kWh):0.66\r\n反向有功费率2电能(kWh):14.28\r\n反向有功费率3电能(kWh):3.32\r\n反向有功费率4电能(kWh):1.30\r\n反向无功总电能(kvarh):0.00\r\n反向无功费率1电能(kvarh):0.00\r\n反向无功费率2电能(kvarh):0.00\r\n反向无功费率3电能(kvarh):0.00\r\n反向无功费率4电能(kvarh):0.00\r\nA相电压(V):216.7\r\nB相电压(V):0\r\nC相电压(V):0\r\nA相电流(A):0.000\r\nB相电流(A):0\r\nC相电流(A):0\r\n总有功功率(kW):0.0000\r\nA相有功功率(kW):0.0000\r\nB相有功功率(kW):0\r\nC相有功功率(kW):0\r\n总无功功率(kW):0.0000\r\nA相无功功率(kW):0.0000\r\nB相无功功率(kW):0.0000\r\nC相无功功率(kW):0.0000\r\n总功率因素:1.000\r\nA相功率因素:1.000\r\nB相功率因素:0\r\nC相功率因素:0\r\n总视在功率:0.0000\r\nA相视在功率:0.0000\r\nB相视在功率:0.0000\r\nC相视在功率:0.0000\r\n";
        String fields = "zxygzdn,zxygfl1dn,zxygfl2dn,zxygfl3dn,zxygfl4dn,zxwgzdn,zxwgfl1dn,zxwgfl2dn,zxwgfl3dn,zxwgfl4dn,fxygzdn,fxygfl1dn,fxygfl2dn,fxygfl3dn,fxygfl4dn,fxwgzdn,fxwgfl1dn,fxwgfl2dn,fxwgfl3dn,fxwgfl4dn,axdy,bxdy,cxdy,axdl,bxdl,cxdl,zyggl,axyggl,bxyggl,cxyggl,zwggl,axwggl,bxwggl,cxwggl,zglys,axgglys,bxgglys,cxgglys,zszgl,axszgl,bxszgl,cxszgl";
        String[] split = zhStr.split("\r\n");
        //中文串:字段
        Map<String, String> map = new TreeMap<String, String>();
        String[] split1 = fields.split(",");
        for (int i = 0;i < split.length; ++i) {
            String[] zhKeyV = split[i].split(":");
            map.put(zhKeyV[0], split1[i]);
        }
        //要处理字符串
        String dataValue = zhStr;
        for (String key : map.keySet()) {
            dataValue = dataValue.replace(key, map.get(key));
        }
        StringBuilder sb = new StringBuilder();
        String[] split3 = dataValue.split("\r\n");
        sb.append("{");
        for(String str : split3) {
            String[] fieldKeyV = str.split(":");
            sb.append("\"");
            sb.append(fieldKeyV[0]);
            sb.append("\"");
            sb.append(":");
            sb.append("\"");
            sb.append(fieldKeyV[1]);
            sb.append("\"");
            sb.append(",");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append("}");
        String json = sb.toString();
        MeterData meterData = JSONObject.parseObject(json, MeterData.class);
        System.out.println(meterData.toString());
    }

    @Test
    public void test22() {
        String dataValue = "{\"cxszgl\":\"0.0000\",\"zwggl\":\"0.0000\",\"zyggl\":\"0.0000\",\"bxdy\":\"0\",\"bxwggl\":\"0.0000\",\"bxyggl\":\"0\",\"zxwgzdn\":\"0.00\",\"axdl\":\"0.000\",\"axgglys\":\"1.000\",\"cxdl\":\"0\",\"axszgl\":\"0.0000\",\"bxgglys\":\"0\",\"id\":1,\"fxwgzdn\":\"0.00\",\"zglys\":\"1.000\",\"fxygfl1dn\":\"0.66\",\"axdy\":\"214.8\",\"fxygfl3dn\":\"3.32\",\"zxygfl4dn\":\"3.51\",\"fxygfl2dn\":\"14.28\",\"cxdy\":\"0\",\"zxygfl2dn\":\"0.17\",\"zxygfl3dn\":\"0.66\",\"zxwgfl1dn\":\"0.00\",\"zxygfl1dn\":\"5.94\",\"cxwggl\":\"0.0000\",\"zxwgfl3dn\":\"0.00\",\"zxwgfl2dn\":\"0.00\",\"cxyggl\":\"0\",\"zszgl\":\"0.0000\",\"zxwgfl4dn\":\"0.00\",\"fxygfl4dn\":\"1.30\",\"bxszgl\":\"0.0000\",\"zxygzdn\":\"10.28\",\"bxdl\":\"0\",\"axyggl\":\"0.0000\",\"axwggl\":\"0.0000\",\"createTime\":\"2022-05-24 11:30:56\",\"meterId\":\"123456789077\",\"fxwgfl1dn\":\"0.00\",\"cxgglys\":\"0\",\"fxwgfl3dn\":\"0.00\",\"fxwgfl2dn\":\"0.00\",\"fxygzdn\":\"19.56\",\"fxwgfl4dn\":\"0.00\"}";
        String zhStr = "正向有功总电能(kWh):10.28\r\n正向有功费率1电能(kWh):5.94\r\n正向有功费率2电能(kWh):0.17\r\n正向有功费率3电能(kWh):0.66\r\n正向有功费率4电能(kWh):3.51\r\n正向无功总电能(kvarh):0.00\r\n正向无功费率1电能(kvarh):0.00\r\n正向无功费率2电能(kvarh):0.00\r\n正向无功费率3电能(kvarh):0.00\r\n正向无功费率4电能(kvarh):0.00\r\n反向有功总电能(kWh):19.56\r\n反向有功费率1电能(kWh):0.66\r\n反向有功费率2电能(kWh):14.28\r\n反向有功费率3电能(kWh):3.32\r\n反向有功费率4电能(kWh):1.30\r\n反向无功总电能(kvarh):0.00\r\n反向无功费率1电能(kvarh):0.00\r\n反向无功费率2电能(kvarh):0.00\r\n反向无功费率3电能(kvarh):0.00\r\n反向无功费率4电能(kvarh):0.00\r\nA相电压(V):216.7\r\nB相电压(V):0\r\nC相电压(V):0\r\nA相电流(A):0.000\r\nB相电流(A):0\r\nC相电流(A):0\r\n总有功功率(kW):0.0000\r\nA相有功功率(kW):0.0000\r\nB相有功功率(kW):0\r\nC相有功功率(kW):0\r\n总无功功率(kW):0.0000\r\nA相无功功率(kW):0.0000\r\nB相无功功率(kW):0.0000\r\nC相无功功率(kW):0.0000\r\n总功率因素:1.000\r\nA相功率因素:1.000\r\nB相功率因素:0\r\nC相功率因素:0\r\n总视在功率:0.0000\r\nA相视在功率:0.0000\r\nB相视在功率:0.0000\r\nC相视在功率:0.0000\r\n";
        String fields = "zxygzdn,zxygfl1dn,zxygfl2dn,zxygfl3dn,zxygfl4dn,zxwgzdn,zxwgfl1dn,zxwgfl2dn,zxwgfl3dn,zxwgfl4dn,fxygzdn,fxygfl1dn,fxygfl2dn,fxygfl3dn,fxygfl4dn,fxwgzdn,fxwgfl1dn,fxwgfl2dn,fxwgfl3dn,fxwgfl4dn,axdy,bxdy,cxdy,axdl,bxdl,cxdl,zyggl,axyggl,bxyggl,cxyggl,zwggl,axwggl,bxwggl,cxwggl,zglys,axgglys,bxgglys,cxgglys,zszgl,axszgl,bxszgl,cxszgl";
        String[] split = zhStr.split("\r\n");
        //字段:中文
        Map<String, String> map = new TreeMap<String, String>();
        String[] split1 = fields.split(",");
        for (int i = 0;i < split.length; ++i) {
            String[] zhKeyV = split[i].split(":");
            map.put(split1[i], zhKeyV[0]);
        }
        for (String key : map.keySet()) {
            dataValue = dataValue.replace(key, map.get(key));
        }
        Map<String,String> mapKV = JSONObject.parseObject(dataValue, Map.class);
        System.out.println(mapKV);
    }

}
