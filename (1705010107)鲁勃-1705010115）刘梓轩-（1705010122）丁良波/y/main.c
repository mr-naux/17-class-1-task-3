#include <stdio.h>
#include <stdlib.h>

int rabl(int a,int b,int *r)
{
    int l,k,m,i,p;
    k=b-a+1;
    l=2;
    while(i<=1)
    {
        k=k+k+k+k+k;
        k=k%m;
        l=k/4+a;
        if(l<=b)
        {
            p=l;
            i=i+1;
        }
    }
    *r=k;
    return(p);
}
int max(int T[10][10])
{
    int t=0;
    if(T[0][0]>T[1][0])
        t=T[0][0];
    else t=T[1][0];
    if(t<T[2][0])
        t=T[2][0];
    return t;
}
int E1(int T[10][10])
{
    if(T[0][1]==T[1][1]&&T[1][1]==T[2][1])
        return 1;
    else  return 0;
}
int E2(int T[10][10])
{
    int q=0;
    if(((max(T[10][10])-1)==T[0][0]||(max(T[10][10])-1)==T[1][0]||(max(T[10][10])
            -1)==T[2][0])&&((max(T[10][10])-2)==T[0][0]||(max(T[10][10])-2)==T[1][0]||
                            (max(T[10][10])-2)==T[2][0])) // if(q=max(T[][10]))
        return 1;
    else
        return 0;
}
int E3(int T[10][10])
{
    if(T[0][0]==T[1][0]==T[2][0])
        return 1;
    else return 0;
}
int E4(int T[10][10])
{
    if(T[0][0]==T[1][0]&&T[0][0]!=T[2][0])
        return 1;
    else if(T[0][0]==T[2][0]&&T[0][0]!=T[1][0])
        return 1;
    else if(T[1][0]==T[2][0]&&T[1][0]!=T[0][0])
        return 1;
    else return 0;
}
void main()
{
    int times=0,e1=0,e2=0,e3=0,e4=0,e5=0;
    int A[10][10],B[10][10];
    int r1=2,r2=3;
    int i,j;
    printf("��������Ϸ�Ĵ���\n");
    scanf("%d",&times);
    for( j=0; j<times; j++)
    {
        for( i=0; i<3; i++)
        {
            A[i][0]=rabl(1,13,&r1);
            A[i][1]=rabl(14,17,&r2);
            B[i][0]=rabl(1,13,&r1);
            B[i][1]=rabl(14,17,&r2);
        }
        if(E1(A[][10])>E1(B[][10]))
        {
            e1++;
            printf("AӮ��ͬ��˳\n");
        }
        else if(E1(A[][10])<E1(B[][10]))
        {
            e1++;
            printf("BӮ��ͬ��˳\n");
        }
        else if(E1(A[][10])==E1(B[][10])&&E1(B[][10])==1)
        {
            e1++;
            if(max(A[][10])>max(B[][10]))
                printf("AӮ��ͬ��˳\n");
            else
                printf("BӮ��ͬ��˳\n");
        }
        else if(E2(A[][10])>E2(B[][10]))
        {
            e2++;
            printf("AӮ��˳��\n");
        }
        else if(E2(A[][10])<E2(B[][10]))
        {
            e2++;
            printf("BӮ��˳��\n");
        }
        else if(E2(A[][10])==E2(B[][10])&&E2(B[][10])==1)
        {
            e2++;
            if(max(A[][10])>max(B[][10]))
                printf("AӮ��˳��\n");
            else
                printf("BӮ��˳��\n");
        }
        else if(E3(A[][10])>E3(B[][10]))
        {
            e3++;
            printf("AӮ��ͬ��\n");
        }
        else if(E3(A[][10])<E3(B[][10]))
        {
            e3++;
            printf("BӮ��ͬ��\n");
        }
        else if(E3(A[][10])==E3(B[][10])&&E3(B[][10])==1)
        {
            e3++;
            if(max(A[][10])>max(B[][10]))
                printf("AӮ��ͬ��\n");
            else
                printf("BӮ��ͬ��\n");
        }
        else if(E4(A[][10])>E4(B[][10]))
        {
            e4++;
            printf("AӮ������\n");
        }
        else if(E4(A[][10])>E4(B[][10]))
        {
            e4++;
            printf("BӮ������\n");
        }
        else if(E4(A[][10])==E4(B[][10])&&E4(B[][10])==1) ;
        {
            e4++;
            if(max(A[][10])>max(B[][10]))
                printf("AӮ������\n");
            else
                printf("BӮ������\n");
        }
        else
        {
            if(max(A [][10])>max(B[][10]))
                printf("AӮ������\n");
            else
                printf("BӮ������\n");
        }
    }
    printf("ͬ��˳Ӯ�Ƹ���Ϊ%d��˳��Ӯ�Ƹ���Ϊ%d��ͬ��Ӯ�Ƹ���Ϊ%d������Ӯ�Ƹ���Ϊ%d������Ӯ�Ƹ���Ϊ%d",e1/times,e2/times,e3/times,e4/times,e5/times);
}

