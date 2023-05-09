package com.nico.mianjing;

import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: https://www.nowcoder.com/discuss/484780549760987136
 * @date 2023/5/8 12:30
 */
public class Demo1 {



//    public static void main(String[] args) {
//        Demo1 sol = new Demo1();
//        List<Integer> query = new ArrayList<Integer>();
//        query.add(1);
//        query.add(2);
//        query.add(3);
//        query.add(4);
//        List<Integer> res = sol.xioamingSeq(1, 1, 4, query);
//        res.stream().forEach(System.out::println);
//    }

    /**
     * 小明了解了递归函数，十分喜欢递归这一概念。他用递归的概念定义了一个数列{an}，其中a0和a1均为1，对于i≥2，
     *
     *         ai=ai-1*A+ai-2*B。递归定义让小明十分开心，但是算起来却很痛苦，现在小明想让你帮他算一算。考虑到数列可能很大，小明觉得你告诉他对应项模上M之后的答案就可以了（数列中的每一个数叫做这个数列的项）。
     *
     *
     *
     *         输入描述
     *         第一行三个数A，B，M，含义见题面。
     *
     *         接下来一行一个数Q，表示小明询问次数。
     *
     *         接下来一行Q个数q1,q2,...,qQ，第i个数qi表示小明第i次询问数列第qi项模上数字M后的答案。
     *
     *         对于所有数据，1≤Q,qi≤50000，1≤A,B,M≤108
     *
     *         输出描述
     *         一行Q个数，依次表示每次答案。
     */
    public List<Integer> xioamingSeq(Integer A,Integer B,Integer M, List<Integer> query) {
        List<Integer> res = new ArrayList<>();
        Integer max = query.stream().max(Integer::compareTo).orElse(null);
        int[] arr = new int[max + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2;i < max + 1;++i) {
            arr[i] = arr[i-1] * A + arr[i-2] * B;
        }
        for (Integer x : query) {
            res.add(arr[x] % M);
        }
        return res;
    }

    /**
     * 最大最小值
     *         时间限制： 1000MS
     *         内存限制： 65536KB
     *         题目描述：
     *         有一个长度为n的序列，其中第i个元素ai，你现在可以对这个序列进行最多k次操作，每次可选择一个连续的区间将其中的元素删掉，但剩余的元素个数必须大于0。 现在想让剩余元素的最小值尽可能大，求上述情况下的最大值。
     *
     *
     *
     *         输入描述
     *         第一行两个正整数n和k，分别表示初始序列中元素的个数以及最多的操作次数。
     *
     *         接下来1行，n个正整数，其中第i个数为ai。
     *
     *         对于所有数据，1<=n<=10^5，0<=k<=10^5，1<=ai <=10^6。
     *
     *         输出描述
     *         输出仅包含一个正整数，表示答案。
     *
     *
     *         样例输入
     *         8 1
     *         58 57 86 89 25 26 61 42
     *         样例输出
     *         58
     */
    public Integer maxMinValInArray(int n, int k, List<Integer> nums) {


        return -1;
    }

//    static final int INF = (int)1e9;
//    static int n, k;
//    static int[] a;
//
//    static boolean check(int mid) {
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            if (a[i] < mid) {
//                int j = i;
//                while (j < n && a[j] < mid) j++;
//                cnt += j - i - k + 1;
//                i = j;
//            }
//        }
//        return cnt <= 0;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        k = scanner.nextInt();
//        a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//        int l = 1, r = INF;
//        while (l < r) {
//            int mid = (l + r + 1) / 2;
//            if (check(mid)) {
//                l = mid;
//            } else {
//                r = mid - 1;
//            }
//        }
//        System.out.println(l);
//    }


        public static void main(String []args) {
            Scanner input = new Scanner(System.in);
            int n, k;
            int[] a = new int[1000005];
            n = input.nextInt(); k = input.nextInt();
            int minv = 0x3f3f3f3f, minp = 0, maxv = 0, maxp = 0;
            //记录最大最小值及下标
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                if (minv > a[i]) {
                    minv = a[i];
                    minp = i;
                }
                if (maxv < a[i]) {
                    maxv = a[i];
                    maxp = i;
                }
            }
            //如果可操作次数大于2 可使用两次操作 把最大值右边区间移除 把最大值左边区间移除
            if (k >= 2) {
                System.out.println(maxv);
            } else if (k == 0) {
                // 可操作数为0 不可移除任何数
                System.out.println(minv);
            } else {
                //k == 1 如果最大值在端点处 可移除最大值一侧区间
                if (maxp == 0 || maxp == n - 1) {
                    System.out.println(maxv);
                } else {
                    //
                    if (minp > maxp) {
                        int secondsmall = 0x3f3f3f3f;
                        for (int i = 0; i < n; i++) {
                            if (a[i] < secondsmall && a[i] != minv) {
                                secondsmall = a[i];
                            }
                        }
                        int boundv = Math.max(a[0], a[n - 1]);
                        if (boundv > secondsmall) {
                            System.out.println(boundv);
                        } else {
                            int maxx = 0;
                            for (int i = 0; i < maxp; i++) {
                                if (maxx < a[i]) {
                                    maxx = a[i];
                                }
                            }
                            System.out.println(maxx);
                        }
                    } else if (minp < maxp) {
                        //
                        int secondsmall = 0x3f3f3f3f;
                        for (int i = 0; i < n; i++) {
                            if (a[i] < secondsmall && a[i] != minv) {
                                secondsmall = a[i];
                            }
                        }
                        int boundv = Math.max(a[0], a[n - 1]);
                        if (boundv > secondsmall) {
                            System.out.println(boundv);
                        } else {
                            int maxx = 0;
                            for (int i = maxp + 1; i < n; i++) {
                                if (maxx < a[i]) {
                                    maxx = a[i];
                                }
                            }
                            System.out.println(maxx);
                        }
                    } else {
                        System.out.println(maxv);
                    }
                }
            }
            input.close();
        }



}
