class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
         int closestx=Math.max(x1,Math.min(x2,xCenter));
         int closesty=Math.max(y1,Math.min(y2,yCenter));

         int distancex=xCenter-closestx;
         int distancey=yCenter-closesty;

         int pyth = distancex * distancex + distancey * distancey;
         return pyth <= radius * radius;
    }
}