package com.nico.test;

import org.junit.Test;

import java.util.List;
import java.util.regex.Pattern;
import com.nico.CombinatorialMathmaticsStudy.*;

public class TestRegex {

    @Test
    public void test(){
        String str = "this is";
        String str1 = "this  is";
        String str2 = "thisis";
        String pattern1 = "this\\s+is";
        String pattern2 = "this\\s*is";
        boolean flag1 = Pattern.matches(pattern1,str);
        boolean flag2 = Pattern.matches(pattern1,str1);
        boolean flag3 = Pattern.matches(pattern2,str1);
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
    }

    @Test
    public void test1(){
        String str = "1 2 3";
        String[] strs = str.split("\\s+");
        for(String s : strs) System.out.println(s);
    }

    @Test
    public void test2(){
        char[][] test = {
                {'9','.','.','.','5','.','.','.','7'},
                {'.','.','.','9','.','7','.','.','.'},
                {'.','.','.','6','.','4','.','.','.'},
                {'.','1','3','.','2','.','8','9','.'},
                {'2','.','.','7','.','1','.','.','3'},
                {'.','9','6','.','4','.','7','2','.'},
                {'.','.','.','3','.','5','.','.','.'},
                {'.','.','.','4','.','9','.','.','.'},
                {'3','.','.','.','7','.','.','.','6'}
        };
        char[][] test1 = {
            {'.','9','.','.','.','.','.','4','.'},
            {'5','.','6','1','.','7','3','.','2'},
            {'.','3','.','.','2','.','.','1','.'},
            {'.','8','.','.','.','.','.','7','.'},
            {'.','.','7','.','.','.','5','.','.'},
            {'.','6','.','.','.','.','.','2','.'},
            {'.','5','.','.','6','.','.','9','.'},
            {'.','.','1','3','.','5','7','.','4'},
            {'.','.','.','.','.','.','.','5','.'}
        };
        List<char[][]> list = SolveShuDuAPI.solveSudoku(test);
//        List<char[][]> list1 = SolveShuDuAPI.solveSudoku(test1);
        System.out.println(list.size());
        for(int i = 0;i < list.size();++i){
            SolveShuDuAPI.print(list.get(i));
        }
//        System.out.println(list1.size());
//        for(int i = 0;i < list1.size();++i){
//            SolveShuDuAPI.print(list1.get(i));
//        }
    }

    @Test
    public void test3(){

    }
}
