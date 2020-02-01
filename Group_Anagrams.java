class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        int i;
        //Storing the group of anagrams in a list as value where the
        //sorted form of each of those strings acts as the key
        HashMap<String,List> h=new HashMap<String,List>();

        for(i=0; i<strs.length; i++)
        {
            char c[]=strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(h.containsKey(s)==false)
            {
                h.put(s,new ArrayList());
            }
            //if the sorted form of the string exists as akey in the map
            //then it is added into the list corresponding to that key
            h.get(s).add(strs[i]);
        }

        //A list of lists is returned finally
        return new ArrayList(h.values());
    }
}
