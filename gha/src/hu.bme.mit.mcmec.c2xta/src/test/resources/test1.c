#include <stdio.h>
#include <threads.h>
#include <stdatomic.h>

mtx_t mutex;

_Atomic int global;

int firstThread()
{
    int r1 = atomic_load_explicit(&global, memory_order_relaxed);
    atomic_store_explicit(&global, r1*2, memory_order_relaxed);

    return 0;
}

int secondThread()
{
    atomic_store_explicit(&global, 2, memory_order_relaxed);
    int r1 = atomic_load_explicit(&global, memory_order_relaxed);
    
    return 0;
}

int main()
{
    mtx_init(&mutex);
    thrd_t firstThreadId, secondThreadId;
    atomic_store_explicit(&global, 2, memory_order_relaxed); 
    thrd_create(&firstThreadId, firstThread, NULL);
    thrd_create(&secondThreadId, secondThread, NULL);
    thrd_join(secondThreadId, NULL);
    thrd_join(firstThreadId, NULL);
    
    printf("%d\n", global);
    
    return 0;
}
