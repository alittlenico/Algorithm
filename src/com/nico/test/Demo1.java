package com.nico.test;

public class Demo1 {
    public static void main(String[] args) {

        System.out.println('a'+1);
//        System.out.println("hello world");
//        Integer integer = new Integer(28);
//        int i = integer.reverse(28);
//        System.out.println(i);
//        System.out.println(reverseInt(123));
//        System.out.println(getDoublePrimes(2));
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
}
