#include <stdio.h>
#include <conio.h>
#include <malloc.h>

struct node {
    int value;
    struct node *next;    
};

typedef struct node snode;
snode *newnode, *ptr;
snode *first = NULL, *last = NULL;
snode* create_node(int);
snode* insert_node(int);
void display();

int main() {
    int ch = 0, n;
    while (ch != 3){
        printf("\n-- Linked List Opertations --");
        printf("\n 1. Create List \n 2. Display List \n 3. Exit \n");
        printf("\n Enter your choice : ");
        scanf("%d", &ch);
        switch (ch){
            case 1: 
                printf("\n Enter the number of nodes to be created : ");
                scanf("%d", &n);
                insert_node(n);
                break;
            case 2:
                printf("\n The Element in the List are : ");
                display();
                break;
            case 3:
                printf("\n Exiting.. \n");
                break;
            default:
                printf("\n Invalid choice! \n");
                break;
        }
    }

    return 0;
}

snode* create_node(int n) {
    newnode = (snode*)malloc(sizeof(snode));
    newnode->value = n;
    newnode->next = NULL;
    return newnode;
}

snode* insert_node(int n) {
    first = NULL;
    last = NULL;
    int i, value;
    for (i = 0; i < n; i++) {
        printf("\n Enter the value of node %d : ", i + 1);
        scanf("%d", &value);
        newnode = create_node(value);
        if (first == NULL && last == NULL) {
            first = last = newnode;
            first->next = NULL;
            last->next = NULL;
        } else {
            last->next = newnode;
            last = newnode;
            last->next = NULL;
        }
    }
    printf("\n Linked List Created. \n");
}

void display() {
    if (first == NULL ) {
        printf("\n No Nodes in the list to display \n");
    } else {
        for (ptr = first; ptr != NULL; ptr = ptr->next) {
            printf("%d ", ptr->value);
        }
        printf("\n");
    }
}