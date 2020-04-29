// PROBLEM

class FirstUnique {
    Set<Integer> set = new LinkedHashSet<>();
    Set<Integer> duplicates = new HashSet<>();
    public FirstUnique(int[] nums) {
        for(int i : nums) {
            if(set.contains(i)) {
                set.remove(i);
                duplicates.add(i);
            } else if(!duplicates.contains(i)) {
                set.add(i);
            }
        }
    }
    
    public int showFirstUnique() {
        if(set.isEmpty()) {
            return -1;
        }
        return this.set.iterator().next();
    }
    
    public void add(int value) {
         if(set.contains(value)) {
                set.remove(value);
            } else if(!duplicates.contains(value)) {
                set.add(value);
            }
    }
}



/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */