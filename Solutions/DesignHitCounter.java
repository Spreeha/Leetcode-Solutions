class HitCounter {
    //A queue can be used instead of arraylist to optimize space.
    //Each element from the front of the queue can be removed if it doesnt
    //fall under the current timestamp of the last 5 minutes.
    ArrayList<Integer> a=new ArrayList<>();
    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        a.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int i=0;
        for(i=0; i<a.size(); i++)
        {
            if(a.get(i)>timestamp-300)
                break;
        }
        return a.size()-i;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
