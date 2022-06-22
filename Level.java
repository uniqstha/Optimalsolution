public class Level {
    public int trapRainWater(int height[]){
        int water=0;
        int a=height.length;

        int leftmax[]=new int[a];
        leftmax[0]=height[0];
        for (int i=1;i<a;i++){
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }
        int rightmax[]=new int[a];
        rightmax[a-1]=height[a-1];
        for(int j=a-2;j>=0;j--){
            rightmax[j]=Math.max(height[j],rightmax[j+1]);
        }
        for (int k=0;k<a;k++){
            water=water+(Math.min(leftmax[k],rightmax[k]))-height[k];
        }
        return water;
    }

    public static void main(String[] args) {
        Level a=new Level();
        int height []={3,2,0,2,4};
        int trappedwater=a.trapRainWater(height);
        System.out.println(trappedwater);
    }
}