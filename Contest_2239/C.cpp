#include<bits/stdc++.h>
#define cint const int
#define uint unsigned int
#define cuint const unsigned int
#define ll long long
#define cll const long long
#define ull unsigned long long
#define cull const unsigned long long
#define sh short
#define csh const short
#define ush unsigned short
#define cush const unsigned short
using namespace std;
namespace FastIO
{
    const int BUF_SIZE=1<<20;
    char in_buf[BUF_SIZE],out_buf[BUF_SIZE];
    char* in_ptr=in_buf+BUF_SIZE;
    char* out_ptr=out_buf;
    char get_char()
    {
        if(in_ptr==in_buf+BUF_SIZE)
        {
            in_ptr=in_buf;
            fread(in_buf,1,BUF_SIZE,stdin);
        }
        return *in_ptr++;
    }
    void put_char(char c)
    {
        if(out_ptr==out_buf+BUF_SIZE)
        {
            fwrite(out_buf,1,BUF_SIZE,stdout);
            out_ptr=out_buf;
        }
        *out_ptr++=c;
    }
    struct Flusher
    {
        ~Flusher()
        {
            if(out_ptr!=out_buf)
            {
                fwrite(out_buf,1,out_ptr-out_buf,stdout);
            }
        }
    } flusher;
}
#define getchar FastIO::get_char
#define putchar FastIO::put_char
inline ll read()
{
    ll x=0;
    bool zf=1;
    char ch=getchar();
    while(ch<'0'||ch>'9')
    {
        if(ch=='-')
        {
            zf=0;
        }
        ch=getchar();
    }
    while(ch>='0'&&ch<='9')
    {
        x=(x<<1)+(x<<3)+(ch^48);
        ch=getchar();
    }
    return zf?x:-x;
}
void print(cint x)
{
    if(x==0)
    {
        putchar('0');
        return;
    }
    char buf[12];
    int len=0,y=x;
    if(y<0)
    {
        putchar('-');
        y=-y;
    }
    while(y)
    {
        buf[len++]=(y%10)+'0';
        y/=10;
    }
    while(len--)
    {
        putchar(buf[len]);
    }
}
inline void princh(cint x,const char ch)
{
    print(x);
    putchar(ch);
}
cint N=1e6;
int n;
ll val[N+1];
char type[N+1];
int ans[N+1];
struct Binary_Index_Tree{
    int a[N+1];
    void clear()
    {
        for(int i=1;i<=n;++i)a[i]=0;
    }
    inline void add(cint x,cint y)
    {
        for(int i=x;i<=n;i+=(i&-i))a[i]+=y;
    }
    inline int ask(cint x)
    {
        int s=0;
        for(int i=x;i;i-=(i&-i))s+=a[i];
        return s;
    }
    inline int find(int x)
    {
        int res=0;
        for(int len=1<<__lg(n);len;len>>=1)
        {
            if(res+len>n)continue;
            if(a[res+len]<=x)
            {
                res+=len;
                x-=a[res];
            }
        }
        return res+1;
    }
}T;
int lst[N+1];
void solve()
{
    n=read();
    T.clear();
    for(int i=1;i<=n;++i)
    {
        char ch=getchar();
        while(ch!='p'&&ch!='s')ch=getchar();
        type[i]=ch;
        val[i]=read();
        if(type[i]=='p')ans[i]=val[i];
        else val[i]=1ll*i*(i-1)/2-val[i];
    }
    for(int i=1;i<=n;++i)lst[i]=(type[i]=='s'?i:lst[i-1]);
    for(int i=1;i<=n;++i)T.add(i,1);
    for(int i=lst[n]+1;i<=n;++i)T.add(ans[i],-1);
    for(int i=lst[n];i;i=lst[i-1])
    {
        cint p=lst[i-1];
        ll d=val[i]-val[p];
        for(int j=i-1;j>p;--j)
        {
            d-=T.ask(ans[j]-1);
            T.add(ans[j],-1);
        }
        d+=i-p-1;
        for(int j=i-1;j>p;--j)T.add(ans[j],2);
        ans[i]=T.find(d);
        for(int j=i-1;j>p;--j)T.add(ans[j],-2);
        T.add(ans[i],-1);
    }
    for(int i=1;i<=n;++i)
    {
        princh(ans[i]," \n"[i==n]);
    }
}
int main()
{
    //freopen(".in","r",stdin);
    //freopen(".out","w",stdout);
    int T=read();
    while(T--)solve();
    return 0;
}
