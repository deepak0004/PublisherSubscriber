# Publisher & Subscriber Implementation
```
Explaining the solution -
a. Publisher and Consumer are leveraging Runnable, which are executed via the threads.
b. Each thread of publisher is producing random elements in the range 0 - 999, and persisting the same into the queue storage.
c. Each thread of subscriber is reading from the queue, and printing the same.
d. I have leveraged ExecutorService, allowing the threads to be executed asynchronously.
e. There is another variant - LinkedBlockingQueue, which blocks the accessing thread if it is full (assuming it to be capped) or becomes empty. It has thread safe push and pop - https://stackoverflow.com/questions/2695426/are-linkedblockingqueues-insert-and-remove-methods-thread-safe. Have added that variant as well.
```

## How to run?
0. Run ```cd PublisherSubscriber```
1. Run ```javac javac MainInvoker.java```
2. Run ```java MainInvoker```

## Demo visualization
![Alt text](Demo/DemoImg.png?raw=true "Title")
