#include <stdio.h>
#include <conio.h>
#include <malloc.h>

struct node {
    int data;
    struct node *next;
};

struct node *front;
struct node *rear;

void insert();
void dequeue();
void display();


int main() {
    int choice;

    printf("\n QUEUE OPERATIONS USING LINKED LIST ");
    printf("\n 1. Insert an element \n 2. Delete an element \n 3. Display the queue \n 4. Exit ");

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
    struct node *ptr;
    int item;
    ptr = (struct node*)malloc(sizeof(struct node));
    if (ptr == NULL) {
        printf("\n OVERFLOW \n");
        return;
    } else {
        printf("\n Enter value : ");
        scanf("%d",&item);
        ptr->data = item;
        if (front==NULL) {
            front = ptr;
            rear = ptr;
            front->next = NULL;
            rear->next = NULL;
        } else {
            rear -> next = ptr;
            rear = ptr;
            rear -> next = NULL;
        }
    }
}

void dequeue() {
    struct node *ptr;
    if(front == NULL) {
        printf("\n UNDERFLOW \n");
        return;
    } else {
        ptr = front;
        front = front -> next;
        free(ptr);
    }
}

void display() {
    struct node* ptr;
    ptr = front;
    if(front==NULL) {
        printf("\n Empty Queue \n");
    } else {
        printf("\n Element in the queue are : \n");
        while(ptr != NULL) {
            printf("\n %d \n", ptr -> data);
            ptr = ptr -> next;
        }
    }
}