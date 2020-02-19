class Solution {
    //Alternative solution can be to sort all the points and then check for the
    //validity of the square using isValid(p1,p2,p3,p4) method


    //to calculate distance between 2 points
    public int dist(int p1[],int p2[])
    {
        return ((p2[0]-p1[0])*(p2[0]-p1[0]) + (p2[1]-p1[1])*(p2[1]-p1[1]));
    }

    //to check is a)if all the sides of square are equal
    //b)if the diagonals are equal
    public boolean isValid(int p1[],int p2[],int p3[],int p4[])
    {
        return dist(p1,p2)>0 && dist(p1,p2)==dist(p2,p3) && dist(p2,p3)==dist(p3,p4) && dist(p3,p4)==dist(p4,p1) && dist(p1,p3)==dist(p2,p4);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean a1,a2,a3;

        a1=isValid(p1,p2,p3,p4); //keeping 1-3 and 2-4 as diagonals
        a2=isValid(p1,p3,p2,p4); //keeping 1-2 and 3-4 as diagonals
        a3=isValid(p1,p2,p4,p3); //keeping 1-4 and 2-3 as diagonals

        return a1||a2||a3;
    }
}
