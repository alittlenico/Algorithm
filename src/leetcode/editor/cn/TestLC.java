package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ly
 * @Date: 2022/01/22/19:12
 * @Description:
 */
public class TestLC {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>(10);
        map.put(1,2);
        map.put(1,3);
        System.out.println(map.get(1));
    }
}
