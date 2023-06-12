package leetcode.editor.cn;//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 2138 👎 0


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
//class LRUCache extends LinkedHashMap<Integer, Integer>{

//    private int capacity;
//
//    public LRUCache() {}
//
//    public LRUCache(int capacity) {
//        //按访问排序
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return getOrDefault(key, -1);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }


    class LRUCache{


    //自定义双向链表
    class MyLinkedNode {
        //键
        int key;
        //值
        int value;
        MyLinkedNode pre;
        MyLinkedNode next;
        public MyLinkedNode() {

        }

        public MyLinkedNode(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, MyLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    //dummy node
    private MyLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new MyLinkedNode();
        tail = new MyLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        MyLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        //移动节点到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        MyLinkedNode node = cache.get(key);
        if(node == null) {
            MyLinkedNode newNode = new MyLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity) {
                MyLinkedNode tailNode = removeTailNode();
                cache.remove(tailNode.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }


    /**
     * 添加节点到头部
     * @param node
     */
    private void addToHead(MyLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 移动节点到头部
     * @param node
     */
    private void moveToHead(MyLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除节点
     */
    private void removeNode(MyLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 删除尾节点
     */
    private MyLinkedNode removeTailNode() {
        MyLinkedNode res = tail.pre;
        removeNode(tail.pre);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
