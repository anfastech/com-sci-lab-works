#include <stdio.h>
#include <stdlib.h>
#include <malloc.h> // optional

typedef struct node {
    int data;
    struct node *next;
} node;

node *newnode, *temp, *ptr, *first=NULL, *last=NULL;

node* createnode(int data) {
    newnode = (node*)malloc(sizeof(node));
    newnode->data=data;
    newnode->next=NULL;
    return newnode;
}

void push(int data) {
    createnode(data);
    if (first==NULL) {
        first=last=newnode;
    } else {
        newnode->next=first;
        first=newnode;
    }
    printf("\nPUSHED : %d ",data);
} 

void pop() {
    if (first==NULL) {
        printf("\nThe stack is Empty!! Underflow..");
    } else {
        temp = first;
        first = first->next;
        if (first==NULL) last = NULL;
    }
    printf("\nPOPED - %d", temp->data);
    free(temp);
}

void display() {
    if (first==NULL) {
        printf("\nNothing in stack");
    } else {
        printf("\nThe Stack : ");
        for (ptr=first; ptr != NULL; ptr= ptr->next) {
            printf(" %d -> ", ptr->data);
        }
    }
}

int main() {
    push(10);
    push(2);
    push(50);
    push(40);
    display();
    pop();
    pop();
    display();
    return 0;
}