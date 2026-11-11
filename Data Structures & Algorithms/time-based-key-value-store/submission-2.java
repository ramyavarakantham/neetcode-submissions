class TimeMap {
    HashMap<String, List<Pair<Integer, String>>> hm;

    public TimeMap() {
        hm = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            List<Pair<Integer, String>> valueStamps = hm.get(key);
            valueStamps.add(new Pair(timestamp, value));
        } else {
            List<Pair<Integer, String>> valueStamps = new ArrayList<>();
            valueStamps.add(new Pair(timestamp, value));
            hm.put(key, valueStamps);
        }
    }
    
    public String get(String key, int timestamp) {
        if(hm.containsKey(key)){
            List<Pair<Integer, String>> valueStamps = hm.get(key);
            if(valueStamps.size() == 0){
                return "";
            }
            if(timestamp < valueStamps.get(0).getKey()){
                return "";
            }
            int low = 0;
            int high = valueStamps.size()-1;
            int resIndex = 0;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(valueStamps.get(mid).getKey() == timestamp){
                    return valueStamps.get(mid).getValue();
                } else if(valueStamps.get(mid).getKey() > timestamp) {
                    high = mid-1;
                } else {
                    resIndex = mid;
                    low = mid+1;
                }
            }
            return valueStamps.get(resIndex).getValue();
        }
        return "";
    }

    private class Pair<K, V>{
        final K timestamp;
        final V value;

        Pair(K timestamp, V value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        K getKey(){
            return timestamp;
        }

        V getValue() {
            return value;
        }

    }
}
