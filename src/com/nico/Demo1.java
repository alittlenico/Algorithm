package com.nico;

import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Demo1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[3][2];
        int[] res = new int[3];
        for(int i = 0;i < 3; ++i) {
            res[i] = scanner.nextInt();
        }
        for(int x : res) {
            System.out.println(x);
        }
    }

    @Test
    public void test7() {
        int a = 1;
        System.out.println(~a);
    }

    @Test
    public void test6() {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[3][2];
        for(int i = 0;i < 3; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
        }
        for(int i = 0;i < 3;++i){
            System.out.println("a:"+arr[i][0]+",b:"+arr[i][1]);
        }
    }

    @Test
    public void test5() {
        String dateStr = "2022-05-24 11:30:56";
        String substring = dateStr.substring(11, 16);
        System.out.println(substring);
    }

    @Test
    public void test4() {
        int len = 3;
        while(--len >= 0) {
            System.out.println(len);
        }
    }

    @Test
    public void test3() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{3,4});
        list.add(new int[]{5,6});
        list.get(2)[1] = 100;
        list.stream().forEach(o->{
            System.out.println(o[0]+", "+o[1]);
        });
        int[][] a = new int[list.size()][2];
        list.toArray(a);
        for(int[] x : a) {
            System.out.println(x[0] +", "+ x[1]);
        }
    }

    @Test
    public void test() {
        String ids = "1,2,3,44";
        Long[] l1 = Arrays.stream(ids.split(",")).toArray(Long[]::new);
        for(Long l : l1) {
            System.out.println(l1);
        }
    }

    @Test
    public void test1() {
        String imgUrl = "/profile/upload/2022/03/22/1.png";
        imgUrl = "e:/ruoyi/uploadPath" + imgUrl.substring(8);
        if(File.separator.equals("\\")){//window系统
            imgUrl = imgUrl.replaceAll("/", Matcher.quoteReplacement(File.separator));
        }
        System.out.println(imgUrl);
        File file = new File(imgUrl);
        boolean delete = file.delete();
        System.out.println(delete);
    }

    @Test
    public void test2() {
        System.out.println("/");
    }

//    public static String path(String path){
//        String p = StringUtils.replace(path, "\\", "/");
//        p = StringUtils.join(StringUtils.split(p, "/"), "/");
//        if (!StringUtils.startsWithAny(p, "/") && StringUtils.startsWithAny(path, "\\", "/")){
//            p += "/";
//        }
//        if (!StringUtils.endsWithAny(p, "/") && StringUtils.endsWithAny(path, "\\", "/")){
//            p = p + "/";
//        }
//        if (path != null && path.startsWith("/")){
//            p = "/" + p; // linux下路径
//        }
//        return p;
//    }
}
