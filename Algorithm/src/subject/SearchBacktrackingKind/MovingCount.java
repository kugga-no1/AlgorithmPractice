package subject.SearchBacktrackingKind;

/**
 * @program: MovingCount
 * @description: 机器人的活动范围
 * @author: liyifan
 * @create: 2021/08/23/10:07
 */
public class MovingCount {
    int res=0;
    boolean[][] used;
    public int movingCount(int m, int n, int k) {
        used=new boolean[m][n];
        dfs(0,0,m,n,k);
        return res;
    }

    public void dfs(int i,int j,int m,int n,int k){
        if(i>=m||j>=n||used[i][j]||
                (mathmethod(i)+mathmethod(j))>k){
            return ;
        }
        used[i][j]=true;
        res++;
        dfs(i+1,j,m,n,k);
        dfs(i,j+1,m,n,k);
        return ;
    }
    public int mathmethod(int i){
        return i%10+(i/10)%10+(i/100)%10;
    }
}
