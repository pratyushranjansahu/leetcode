package practiceinorder.p_161;

import java.util.*;
/*
    https://leetcode.com/problems/time-based-key-value-store/
    https://www.youtube.com/watch?v=Y6ZtxsrnJEs&t=3s
 */
public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo","bar",1);
        obj.set("foo","bar2",2);
        String param_2 = obj.get("foo",3);
        System.out.println(param_2);
    }

    static class TimeMap {
        Map<String, List<Pair>> _map;
        public TimeMap() {
            _map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            // _map[key].push_back({timestamp, value});
            if(_map.containsKey(key)){
                Pair pair = new Pair(timestamp,value);
                List<Pair> pList = _map.get(key);
                pList.add(pair);
                _map.put(key,pList);
            }else{
                Pair pair = new Pair(timestamp,value);
                List<Pair> pList = new ArrayList();
                pList.add(pair);
                _map.put(key,pList);
            }

        }

        public String get(String key, int timestamp) {
            if(_map.get(key) == null){
                return "";
            }
            int n = _map.get(key).size();
            int l = 0, r = n-1;
            while(l <= r){
                int mid = l + (r-l)/2;

                if(_map.get(key).get(mid).timeStamp < timestamp){
                    if(mid == r || _map.get(key).get(mid+1).timeStamp > timestamp)
                        return _map.get(key).get(mid).value;
                    l = mid + 1;
                } else if(_map.get(key).get(mid).timeStamp > timestamp)
                    r = mid-1;
                else
                    return _map.get(key).get(mid).value;
            }
            return "";
        }
        class Pair<I extends Number, S> {
            int timeStamp;
            String value;
            Pair(int timeStamp,String value){
                this.timeStamp = timeStamp;
                this.value = value;
            }
        }
    }

}
