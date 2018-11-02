#include<stdatomic.h>
#include<threads.h>
#include<stdio.h>

_Atomic int g_sharedInt;

int threadFunc2()
{
//    for (int i = 0; i < 10000000; i++)
//    {
        atomic_store_explicit(&g_sharedInt, i, memory_order_relaxed);
//    }
    return 0;
}

int threadFunc1()
{
//    for (int i = 0; i < 10000000; i++)
//    {
        atomic_store_explicit(&g_sharedInt, i, memory_order_relaxed);
//    }
    return 0;
}


int main()
{
    g_sharedInt = 0;
    thrd_t threadFunc1Id, threadFunc2Id;
    thrd_create(&threadFunc1Id, threadFunc1, NULL);
    thrd_create(&threadFunc2Id, threadFunc2, NULL);
    thrd_join(threadFunc1Id, NULL);
    thrd_join(threadFunc2Id, NULL);
    return 0;
}

