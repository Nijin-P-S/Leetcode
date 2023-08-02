class RandomizedSet {

    HashSet<Integer> hashSet;
    Random rand = new Random();
    public RandomizedSet() {
        hashSet = new HashSet<>();
    }
    
    public boolean insert(int val) {
        boolean pres = hashSet.contains(val);
        if(!pres)
            hashSet.add(val);
        return !pres;
            
    }
    
    public boolean remove(int val) {
        boolean pres = hashSet.contains(val);
        if(pres)
            hashSet.remove(val);
        return pres;
    }
    
    public int getRandom() {
        int ind = rand.nextInt(hashSet.size());
        
        for(int val : hashSet){
            if(ind == 0)
                return val;
            ind--;
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */