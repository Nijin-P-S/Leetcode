class Solution {
    private void floodFill(int[][] image, int sr, int sc, int color, int ori){
        if(image[sr][sc] != ori || image[sr][sc] == color){
            return;
        }
        image[sr][sc] = color;
        
        if(sr+1 < image.length && image[sr+1][sc] == ori){
            floodFill(image, sr+1, sc, color, ori);
        }
        if(sr-1 >=0 && image[sr-1][sc] == ori){
            floodFill(image, sr-1, sc, color, ori);
        }
        if(sc+1 < image[0].length && image[sr][sc+1] == ori){
            floodFill(image, sr, sc+1, color, ori);
        }
        if(sc-1 >= 0 && image[sr][sc-1] == ori){
            floodFill(image, sr, sc-1, color, ori);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        floodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}