// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    import java.lang.*;
    
      public class LRUDesign {
    
        public static void main(String[] args) throws IOException {
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
    
            int t = Integer.parseInt(read.readLine());
    
            while (t-- > 0) {
    
                int capacity = Integer.parseInt(read.readLine());
                int queries = Integer.parseInt(read.readLine());
                LRUCache cache = new LRUCache(capacity);
                String str[] = read.readLine().trim().split(" ");
                int len = str.length;
                int itr = 0;
    
                for (int i = 0; (i < queries) && (itr < len); i++) {
                    String queryType = str[itr++];
                    if (queryType.equals("SET")) {
                        int key = Integer.parseInt(str[itr++]);
                        int value = Integer.parseInt(str[itr++]);
                        cache.set(key, value);
                    }
                    if (queryType.equals("GET")) {
                        int key = Integer.parseInt(str[itr++]);
                        System.out.print(cache.get(key) + " ");
                    }
                }
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    /*
        DoublyLinkedList + HashMap solution
        Important carefull about pointer handling on move, add, remove and insertion and updation in map
    */
    class Pair{
        int key, value;
        Pair(int k, int v){
            key = k;
            value = v;
        }
    }
    
    class DoublyLinkedListNode{
        Pair pair;
        DoublyLinkedListNode next, prev;
        DoublyLinkedListNode(Pair p){
            pair = p;
            next = null;
            prev = null;
        }
    }
    
    class DoublyLinkedList{
        DoublyLinkedListNode head = null;
        DoublyLinkedListNode tail = null;
        HashMap<Integer, DoublyLinkedListNode> map = new HashMap<>();
        int cap;
        
        DoublyLinkedList(int capacity){
            cap = capacity;
        }
        
        void moveToLast(DoublyLinkedListNode dllNode){
            remove(dllNode);
            addToLast(dllNode);
        }
        
        void addToLast(DoublyLinkedListNode dllNode){
            if(head == null){
                head = tail = dllNode;
                dllNode.next = null;
                dllNode.prev = null;
            } else {
                tail.next = dllNode;
                dllNode.next = null;
                dllNode.prev = tail;
                tail = tail.next;
            }
            map.put(dllNode.pair.key,dllNode);
        }
        
        void set(int key, int value){
            DoublyLinkedListNode dllNode = map.get(key);
            if(dllNode != null){
                // update value
                dllNode.pair.value = value;
                moveToLast(dllNode);
            } else {
                if(map.size() == cap){
                    remove(head);
                }
                addToLast(new DoublyLinkedListNode(new Pair(key,value)));
            }
        }
        
        void remove(DoublyLinkedListNode node){
            if(head == null)
                return;
            if(head == tail){
                head = tail = null;
            } else {
                DoublyLinkedListNode prev = node.prev;
                DoublyLinkedListNode next = node.next;
                //remove and update head and tail if corner cases
                if(prev != null){
                    prev.next = next;
                } else {
                    head = next;
                }
                if(next != null){
                    next.prev = prev;
                } else {
                    tail = prev;
                }
            }
            // update map
            map.remove(node.pair.key);
        }
        
        int getValue(int key){
            DoublyLinkedListNode dllNode = map.get(key);
            if(dllNode != null){
                // update cache
                moveToLast(dllNode);
                return dllNode.pair.value;
            }
            return -1;
        }
    }
    
    class LRUCache
    {
        static int capacity;
        static DoublyLinkedList cache;
        
        LRUCache(int cap)
        {
            cache = new DoublyLinkedList(cap);
        }
    
        // This method works in O(1)
        public static int get(int key)
        {
            return cache.getValue(key);
        }
    
        // This method works in O(1)
        public static void set(int key, int value)
        {
            cache.set(key, value);
        }
    }
    