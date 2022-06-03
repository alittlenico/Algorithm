package com.nico.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _68 {
    public static void main(String[] args) {
        _68 sol = new _68();

//        List<String> res = sol.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},
//                16);
        List<String> res = sol.fullJustify(new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"},
                16);
//        List<String> res = sol.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},
//                16);
        System.out.println(res);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int count = 0;//字符个数
        int wCount = 0;//单词个数
        int wordsLength = 0;//一行仅单词的长度
        List<String> rowWords = new ArrayList<String>();//一行的存放的单词
        List<String> res = new ArrayList<String>();//存放结果
        //贪心每行尽可能的多放置单词
        for(String str : words){
            int n = str.length();
            if(count + n > maxWidth){//当前单词无法放置 空格分配 n个单词有n-1个空隙
                int needSpace = maxWidth - wordsLength;
                StringBuilder sb = new StringBuilder();
                //当前行只放置一个单词 左对齐
                if(wCount == 1){
                    String spaceStr = getSpace(needSpace);
                    sb.append(rowWords.get(0)+spaceStr);
                }
                //正常情况
                else {
                    int averSpace = needSpace / (wCount - 1);//平均至少分配几个空格
                    int extra = needSpace - averSpace * (wCount - 1);//多出几个空格(不能平均分配则大于0 否则为0)
                    String spaceStr = getSpace(averSpace);
                    for(int i = 0;i < rowWords.size();++i){
                        sb.append(rowWords.get(i));
                        if(i != rowWords.size() - 1)
                            sb.append(spaceStr);
                        if(extra > 0){
                            sb.append(" ");
                            --extra;
                        }
                    }
                }
                res.add(sb.toString());
                rowWords.clear();
                //处理完一行 对记录清空
                count = 0;
                wCount = 0;
                wordsLength = 0;
            }
            wCount++;
            count = count + 1 + str.length();
            wordsLength += n;
            rowWords.add(str);
        }
        StringBuilder sb = new StringBuilder();
        //单独处理最后一行
        for(int i = 0;i < rowWords.size();++i){
            sb.append(rowWords.get(i));
            if(i != rowWords.size() - 1)
                sb.append(" ");
        }
        String spaceStr = getSpace(maxWidth - sb.length());
        //把一行结果存储到res中
        res.add(sb.toString()+spaceStr);
        return res;
    }

    String getSpace(int n){
        String str = "";
        for(int i = 0;i < n;++i) str += " ";
        return str;
    }
}
