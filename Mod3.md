Let's go through the key concepts in this module to prepare you for your exam. This module covers **Transaction Management and Concurrency Control** [1].

### Transaction

A **transaction** is defined as a set of logically related operations [2]. It contains a group of tasks and represents an action or series of actions performed by a single user to access and possibly modify the contents of a database [2]. Essentially, a transaction is a **single logical unit of work** that accesses data using **read and write operations** [2].

For example, if an employee transfers Rs 800 from account X to account Y, this involves several low-level tasks for both accounts, such as opening accounts, reading old balances, calculating new balances, writing new balances, and closing accounts [2].

### TRANSACTION PROPERTY (ACID)

Transactions have four properties, collectively known as **ACID properties**, which are crucial for maintaining consistency in a database before and after the transaction [3].

The ACID properties are:
1.  **Atomicity** [3, 4]
2.  **Consistency** [3, 5]
3.  **Isolation** [3, 6]
4.  **Durability** [3, 7]

Let's look at each in detail:

*   **Atomicity:** This property dictates that **all operations of a transaction must take place at once, or if not, the entire transaction is aborted** [3, 4]. There is "no midway"; a transaction cannot occur partially. Each transaction is treated as one unit and either runs to completion or is not executed at all [4]. Atomicity involves two key operations:
    *   **Abort:** If a transaction aborts, all changes made are **not visible** [4].
    *   **Commit:** If a transaction commits, all changes made **are visible** [4].
    *   **Example:** Imagine transferring Rs 100 from account A (Rs 600) to account B (Rs 300). If the transfer (Transaction T) fails after deducting from A (T1 completes) but before adding to B (T2 fails), account A will have Rs 500, but B will still have Rs 300. The total amount is no longer Rs 900. This is an inconsistent database state. To ensure correctness, the transaction must be executed in its entirety [8].

*   **Consistency:** This property ensures that **integrity constraints are maintained**, so the database remains consistent before and after the transaction [3, 5]. The execution of a transaction will leave the database in either its prior stable state or a new stable state [5]. Every transaction sees a consistent database instance, and the transaction transforms the database from one consistent state to another [5].
    *   **Example:** In the transfer example, the total amount (A+B) should remain 900 (600+300) before and after the transaction (500+400). If T1 completes but T2 fails, inconsistency occurs [5].

*   **Isolation:** This property ensures that **multiple transactions can occur concurrently without leading to inconsistency** of the database state [3, 6]. Transactions occur independently without interference [3, 6]. Changes occurring in a particular transaction will **not be visible to any other transaction until that particular change in that transaction is written to memory or has been committed** [6]. This property guarantees that concurrent execution of transactions will result in a state equivalent to a state achieved if these transactions were executed serially in some order [6].
    *   **Example:** If transaction T1 is executing and using data item X, then data item X cannot be accessed by any other transaction (T2) until transaction T1 ends [6].

*   **Durability:** This property ensures that once a transaction has **completed execution, its updates and modifications to the database are stored and written to disk, and they persist even if a system failure occurs** [3, 7]. These updates become permanent and are stored in non-volatile memory, meaning the effects of the transaction are never lost [7].

### Transaction States in DBMS

A transaction goes through various states during its lifetime, which indicate its current status and govern its fate (whether it will commit or abort) [9].

The main states are:
*   **Active State:** The transaction is in the active state when its instructions are running [10].
*   **Partially Committed State:** If all read and write operations are performed without error, the transaction goes to this state. Changes are made in main memory or a local buffer [10].
*   **Failed State:** A transaction enters this state if any instruction fails or if failure occurs while making permanent changes to the database [10].
*   **Aborted State:** After any type of failure (from the failed state), the transaction enters the aborted state. In this state, changes made only to a local buffer or main memory are deleted or rolled back [11].
*   **Committed State:** This is the stage when the changes are made permanent on the database, and the transaction is complete [11].
*   **Terminated State:** If there is any rollback or the transaction comes from a "committed state," the system is consistent and ready for a new transaction, and the old transaction is terminated [11].

Key commands related to these states are:
*   **COMMIT:** If everything is in order with all statements within a single transaction, all changes are recorded together in the database. The COMMIT command saves all transactions to the database since the last COMMIT or ROLLBACK command [12].
*   **ROLLBACK:** If any error occurs with any SQL grouped statements, all changes need to be aborted. This is the process of reversing changes. The ROLLBACK command can only undo transactions since the last COMMIT or ROLLBACK command was issued [12].
*   **SAVEPOINT:** Creates points within groups of transactions where you can roll the transaction back to a certain point without rolling back the entire transaction [12].

### Concurrency Control Problems

When multiple transactions are executed simultaneously (concurrently) in an uncontrolled or unrestricted manner, it can lead to problems that affect the transaction result [13]. Maintaining the order of execution of these transactions is highly important [13]. These issues are commonly referred to as **concurrency problems** in a database environment [13].

The three common problems are:
1.  **Lost updates** [13, 14]
2.  **Dirty read** [13]
3.  **Unrepeatable read** [13]

Let's focus on the **Lost Update Problem**:
*   In the lost update problem, an update made to a data item by one transaction is **lost as it is overwritten by an update done by another transaction** [14, 15].
*   **Example:** Transaction T1 reads data item X and calculates `X = X + N`. Simultaneously, Transaction T2 calculates `X = X + 10` and writes it. If T1 then writes its updated `X`, T2's update is lost because T1 overwrites it [14, 15].

### Concurrency Control Protocols

**Concurrency control protocols** are designed to ensure **atomicity, isolation, and serializability** of concurrent transactions [16].

There are two main categories of concurrency control protocols:
1.  **Lock-based protocol** [16, 17]
2.  **Time-stamp protocol** [16]

Let's elaborate on **Lock-Based Protocols**:
*   A **lock** is a mechanism important in concurrent control; it controls concurrent access to a data item [17]. It assures that one process should not retrieve or update a record while another process is updating [17]. Similar to traffic signals, only one transaction is performed at a time while others are locked [17]. If locking is not done properly, it can lead to inconsistent and corrupt data [17].

*   **Types of Locks:**
    *   **Shared lock:** Also known as a Read-only lock. A data item can only be read by the transaction holding a shared lock. It can be shared between transactions because the transaction holding it cannot update the data [18].
    *   **Exclusive lock:** In an exclusive lock, the data item can be both read and written by the transaction. This lock is exclusive, meaning multiple transactions do not modify the same data simultaneously [18].

*   **Types of Lock Protocols:** There are four types of lock protocols:
    1.  **Simplistic lock protocol:** This is the simplest way of locking data while a transaction. Simplistic lock-based protocols allow all transactions to get the lock on the data before insert or delete or update on it. The data item is unlocked after completing the transaction [19].
    2.  **Pre-claiming Lock Protocol:** These protocols evaluate the transaction to list all data items on which they need locks. Before initiating execution, the transaction requests DBMS for all the locks on those data items. If all locks are granted, the transaction begins; when completed, it releases all locks. If locks are not granted, the transaction rolls back and waits until all locks are granted [19].
    3.  **Two-phase locking (2PL):** This protocol divides the execution phase of a transaction into three parts [20].
        *   In the first part (or **Growing phase**), when execution starts, the transaction seeks permission for the locks it requires and acquires new locks, but none can be released [20, 21].
        *   In the second part, the transaction acquires all the locks [20].
        *   The third phase (**Shrinking phase**) starts as soon as the transaction releases its first lock. In this phase, the transaction cannot demand any new locks; it only releases the acquired locks [20, 21].
    4.  **Strict Two-phase locking (Strict-2PL):** The first phase of Strict-2PL is similar to 2PL: after acquiring all locks, the transaction continues to execute normally [22]. The key difference is that Strict-2PL **does not release a lock after using it**. Strict-2PL waits until the **whole transaction commits**, and then it releases all the locks at a time. It does not have a shrinking phase of lock release [22].

I hope this comprehensive overview helps you prepare for your exam! Good luck!
