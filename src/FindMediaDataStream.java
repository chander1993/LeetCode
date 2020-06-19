class MedianFinder {
    
    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(list.size() == 0) {
            list.add(num);
            return;
        }
        int low = 0;
        int high = list.size() - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(num == list.get(mid)) {
                low = mid;
                break;
            }
            
            if(num < list.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        list.add(low, num);
    }
    
    public double findMedian() {
        int size = list.size();
        if(size == 0) {
            return 0;
        }
        
        int med = size / 2;
        
        double res = 0.0;
        if(size % 2 == 0 ) {
            res = list.get(med - 1);
            res = (res + list.get(med)) / 2;
        } else {
            res = list.get(med);
        }
        //System.out.println(list);
        return res;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */