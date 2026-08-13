class LRUCache {
    HashMap<Integer,Integer>map=new HashMap<>();
    ArrayDeque<Integer>q=new ArrayDeque<>();
    int sz;
    public LRUCache(int capacity) {
        sz=capacity;
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        q.remove(key);
        q.addLast(key);
        return map.get(key);
    }
    public void put(int key, int value) {
        if(map.containsKey(key)) q.remove(key);
        map.put(key,value);
        q.addLast(key);
        if(map.size()>sz){
            map.remove(q.pollFirst());
        }
    }
}