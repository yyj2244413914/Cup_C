#include<stdio.h>

void quick_sort(int q[],int l,int r)
{
    
    int temp;
    if (l>=r)
    {
        return;
    }
    int center = q[(l+r)/2];
    int lp = l;
    int rp = r;
    while(lp<=rp)
    {
    while(q[lp]<center&&lp<=rp)
    {
        lp++;
    }
    while(center<q[rp]&&lp<=rp)
    {
        rp--;
    }
    if(lp<=rp){
    temp = q[lp];
    q[lp]= q[rp];
    q[rp]= temp;
    lp++;
    rp--;
    }
    }
    quick_sort(q,l,rp);
    quick_sort(q,lp,r);
    return;
}
    
    
    
    

int main()
{
    int i;
    int n;
    scanf("%d",&n);
    int q[n];
    for(i=0;i<n;i++)
    {
        scanf("%d",&q[i]);
    }
    quick_sort(q,0,n-1);
    for(i=0;i<n;i++)
    {
        printf("%d ",q[i]);
    }
    return 0;
    
}
