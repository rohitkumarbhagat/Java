/*

Codechef program for FlipCoin


*/

#include<iostream>
#include<cstdio>
using namespace std;
long tail[1000001];
bool update[1000001];
long hval(long node,long l,long r)
{
    return (update[node])?r-l+1-tail[node]:tail[node];
}
void flip(long node,long s,long e,long a,long b)
{
     if(a>e||b<s)
     return;
     if(s>=a&&e<=b)
     {
                   update[node]^=1;
                   return;
     }
     if(update[node])
     {
                     update[2*node]^=1;
                     update[2*node+1]^=1;
                     update[node]=false;
     }
     flip(2*node,s,(s+e)/2,a,b);
     flip(2*node+1,(s+e)/2+1,e,a,b);
     tail[node]=hval(2*node,s,(s+e)/2)+hval(2*node+1,(s+e)/2+1,e);
}
long query(long node,long s,long e,long a,long b)
{
     if(a>e||b<s)
     return 0;
     if(s>=a&&e<=b)
     return hval(node,s,e);
     if(update[node])
     {
                     update[2*node]^=1;
                     update[2*node+1]^=1;
                     update[node]=false;
     }
     tail[node]=hval(2*node,s,(s+e)/2)+hval(2*node+1,(s+e)/2+1,e);
     return query(2*node,s,(s+e)/2,a,b)+query(2*node+1,(s+e)/2+1,e,a,b);
}
int main()
{
    long n,k,i,c,a,b;
    scanf("%ld%ld",&n,&k);
    for(i=0;i<k;i++)
    {
                    scanf("%ld%ld%ld",&c,&a,&b);
                    if(c)printf("%ld\n",query(1,0,n-1,a,b));
                    else flip(1,0,n-1,a,b);
    }
    return 0;
}