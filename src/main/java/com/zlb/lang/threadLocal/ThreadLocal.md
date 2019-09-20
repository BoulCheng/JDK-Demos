

- These variables differ from their normal counterparts in that each thread that accesses one (via its get or set method) has its own,  independently initialized copy of the variable. 
- 这些变量与正常的对应变量的不同之处在于，每个访问一个变量的线程(通过其get或set方法)都有自己独立初始化的变量副本。

- ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or Transaction ID).
- ThreadLocal实例通常是希望将状态与线程(例如，用户ID或事务ID)关联的类中的私有静态字段。


- 每个Thread 实例有一个 ThreadLocalMap实例 ，每个ThreadLocalMap实例 有一个 Entry 数组, 每个 ThreadLocal 实例都有相对与其他任何ThreadLocal实例(任何线程中的ThreadLocal实例)的一个唯一的 threadLocalHashCode, 每个 ThreadLocal 实例都唯一对应具体线程的ThreadLocalMap实例中Entry 数组中的一个元素(即Entry实例), 该元素的索引通过 threadLocalHashCode & (table.length - 1) 计算， 该Entry实例保存该ThreadLocal实例和该ThreadLocal实例initialValue方法返回的值
- 因此同一个线程中的同一个ThreadLocal实例只能对应一个值(ThreadLocal实例initialValue方法返回的值)
- 不同线程中的同一个ThreadLocal实例对应不同的值(ThreadLocal实例initialValue方法返回的值)