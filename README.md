# General-Purpose-Heap
This project implements a generic GeneralPurposeHeap class in Java, which can be used to manage heap-based data structures like min-heaps. The project also includes two supporting classes: MoltDriver and MoltOrder, which represent drivers and orders respectively in a delivery system. These classes can be inserted into the heap for scheduling purposes based on their priority and availability.

Features

GeneralPurposeHeap:
A generic implementation of a min-heap data structure that supports:
Insertion of elements while maintaining heap order.
Percolate Up/Down operations for adjusting heap structure.
Find Minimum to retrieve the minimum element (root of the heap).
Delete Minimum to remove the root element and re-adjust the heap.
Dynamic Resizing to expand the heap array when it exceeds capacity.
Merge Heaps to combine two heaps into one.
MoltDriver:
Represents a driver in a delivery system with attributes such as:
id: A unique identifier for the driver.
name: The driver's name.
nextAvailableTimeForDelivery: When the driver is next available.
numberOfDeliveries: The total number of deliveries completed.
Implements Comparable<MoltDriver> to allow comparison based on the nextAvailableTimeForDelivery.
MoltOrder:
Represents an order with attributes such as:
name: The name of the customer or order.
orderDescription: A description of the order.
orderReadyTime: The time the order is ready for delivery.
timeNeededToDeliver: The estimated time required for delivery.
priority: A priority value for order scheduling.
Implements Comparable<MoltOrder> to allow comparison based on the priority field.
Usage

GeneralPurposeHeap
You can create a heap using one of the following constructors:

Default Constructor: Initializes a heap with a default capacity of 10.
Capacity-Based Constructor: Allows you to set an initial capacity.
Array-Based Constructor: Initializes the heap with an existing array and converts it into a valid heap.
Methods:

insert(T element): Insert an element into the heap and maintain heap order.
findMin(): Retrieve the smallest element (root) in the heap.
deleteMin(): Remove the smallest element from the heap.
mergeHeap(GeneralPurposeHeap<T> otherHeap): Merge another heap into the current heap.
MoltDriver
The MoltDriver class provides the following functionality:

Create a driver with their ID, name, and delivery details.
Use compareTo to sort drivers based on their nextAvailableTimeForDelivery.
Example:

java

MoltDriver driver1 = new MoltDriver(1, "John", 10, 5);
MoltDriver driver2 = new MoltDriver(2, "Jane", 5, 8);
GeneralPurposeHeap<MoltDriver> driverHeap = new GeneralPurposeHeap<>();
driverHeap.insert(driver1);
driverHeap.insert(driver2);
System.out.println(driverHeap.findMin()); // Should return Jane
MoltOrder
The MoltOrder class helps manage orders by sorting them based on their priority.

Example:

java

MoltOrder order1 = new MoltOrder("John", "Pizza", 12, 30, 1);
MoltOrder order2 = new MoltOrder("Jane", "Burger", 14, 20, 2);
GeneralPurposeHeap<MoltOrder> orderHeap = new GeneralPurposeHeap<>();
orderHeap.insert(order1);
orderHeap.insert(order2);
System.out.println(orderHeap.findMin()); // Should return the order with the highest priority
How to Run

To run the project:

1.Compile the Java files:
javac GeneralPurposeHeap.java MoltDriver.java MoltOrder.java

2.Run the GeneralPurposeHeap or MoltOrder class with test cases.
java GeneralPurposeHeap


Future Improvements:

Add error handling for edge cases (e.g., null values, heap underflow).
Implement additional heap operations such as heap sort.
Extend the functionality of MoltDriver and MoltOrder classes for a full scheduling system.
