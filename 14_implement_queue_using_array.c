#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

void insert();
void dequeue();
void display();

int front = -1 , rear = -1, maxsize ;
int queue[100];

int main() {
    int choice;
    printf("Enter the size of the QUEUE : ");
    scanf("%d", &maxsize);

    printf("\n QUEUE OPERATIONS USING ARRAY ");
    printf("\n 1. Insert \n 2. Delete an element \n 3. Display the queue \n 4. Exit ");

    while(choice!=4){
        printf("\n Enter your choice : ");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1:
            insert();
            break;
        case 2:
            dequeue();
            break;
        case 3:
            display();
            break;
        case 4:
            exit(0);
            break;
        
        default:
            printf("\n Enter valid choice !!. \n");
            break;
        }
    }
    return 0;
}

void insert() {
    int item;
    printf("\n Enter the element : ");
    scanf("%d", &item);
    if(rear==maxsize) {
        printf("\n OVERFLOW \n");
        return;
    }
    if (front == -1 && rear == -1 ) {
        front = 0;
        rear = 0;
    } else {
        rear = rear+1;
    }
    queue[rear] = item;
    printf("\n Value Inserted \n");
}


void dequeue() {
    int item;
    if(front==-1 || front >rear) {
        printf("\n UNDERFLOW \n");
        return;
    } else {
        item =  queue[front];
        if(front==rear) {
            front = -1;
            rear = -1; 
        } else {
            front = front+1;
        }
        printf("\n value delected \n ");
    }
}


void display() {
    int i;
    if (rear==-1){
        printf("\n Empty Queue \n ");
    } else {
        printf("\n Element in the queue are \n ");
        for (i=0; i<=rear ; i++) {
            printf("\n %d ", queue[i]);
        }
    }
}