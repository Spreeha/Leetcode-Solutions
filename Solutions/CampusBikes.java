class Solution {
    //sorting first on the basis of distance between 2 points, if dist is same,
    //sorting on the basis of worker index, if worker index is also same,
    //then sorting on the basis of bike index
    public int dist(int w[], int b[])
    {
        int d=Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
        return d;
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {

        int i,j,n,m;
        n=workers.length;
        m=bikes.length;

        //using a priority queue of arrays as a min heap to sort the elements.
        //The 0th index will store worker index, 1st index stores bike index,
        //and 2nd index stores dist between corresponding worker and bike coordinates
        PriorityQueue<int []> p=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int a[],int b[])
            {
                if(a[2]==b[2]) //if dist is same
                {
                    if(a[0]==b[0]) //if worker index is also same
                        return a[1]-b[1]; //then sorting on the basis of bike index
                    else
                        return a[0]-b[0]; //else sorting on the basis if worker index
                }
                else
                    return a[2]-b[2];
            }
        });

        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                //calculating distance between every pair of worker and bike
                int d=dist(workers[i],bikes[j]);
                p.add(new int[]{i,j,d});
            }
        }

        HashSet<Integer> visworkers=new HashSet<>(); //stores positions of visited workers                                                       //as was in the original workers[] array
        HashSet<Integer> visbikes=new HashSet<>(); //stores positions of visited bikes

        int res[]=new int[n]; //resultant array to be returned

        while(visworkers.size()<n)
        {
            int tem[]=p.poll();
            if(visworkers.contains(tem[0]) || visbikes.contains(tem[1]))
                continue;
            else
            {
                res[tem[0]]=tem[1]; //storing the index of the bike at worker index of res[]
                visworkers.add(tem[0]);
                visbikes.add(tem[1]);
            }
        }
        return res;
    }
}
