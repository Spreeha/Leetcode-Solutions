class Solution {
    //Sorting by column values
    public int minAreaRect(int[][] points) {
        Map <Integer,ArrayList<Integer>> h=new TreeMap();
        int i,j;
        int min=Integer.MAX_VALUE;

        for(i=0;i<points.length;i++)
        {
            int x=points[i][0];
            int y=points[i][1];
            h.computeIfAbsent(x,z->new ArrayList()).add(y);
        }

        //hashmap to store the unique codes accorsing to x coordinate value
        HashMap<Integer,Integer> hashval=new HashMap<>();
        for(int ind : h.keySet())
        {
            List<Integer> row=h.get(ind);
            //sorting the rows on the basis of columns
            Collections.sort(row);

            for(i=0;i<row.size();i++)
            {
                for(j=i+1;j<row.size();j++)
                {
                    //getting the column values for the column values against index ind
                    int c1=row.get(i);
                    int c2=row.get(j);
                    //generating a hash code for the specific coordinate
                    //50000 value is randomly taken because the values of the
                    //points vary in the range 0 to 40000 and 50000>40000
                    int code=50000*c1+c2;

                    if(hashval.containsKey(code))
                    {
                        //ind and hashval.(code) represent x coordinates and
                        //c1 and c2 represent y coordinates of the points
                        min=Math.min(min,(ind-hashval.get(code))*(c2-c1));
                    }
                    //putting the index(x coord) against the generated code
                    //from the y coordinates of the corresponding x coordinate
                    hashval.put(code,ind);
                }
            }
        }

        if(min<Integer.MAX_VALUE)
            return min;
        else
            return 0;
    }
}
