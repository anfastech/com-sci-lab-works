// creating the linked list node
#include <stdio.h>
#include <malloc.h>
typedef struct node {
    int data;
    struct node *next;
} node;
node *newnode, *ptr, *first = NULL, *last = NULL;

node* createnode(int data) {
    newnode = (node*)malloc(sizeof(node));
    newnode->data = data;
    newnode->next = NULL;
    return newnode;
}
void insertnode(int n) {
    first = NULL, last = NULL;
    int i, data;
    for (i=0; i<n; i++){
        printf("Enter node %d : ", i+1);
        scanf("%d",&data);
        createnode(data);
        if (first==NULL) {
            first = last = newnode;
        } else {
            last->next = newnode;
            last = newnode;
        }
    }
    printf("\nNode Created Successfully!!!..\n");
}

void display() {
    printf("\nThe nodes are : ");
    for (ptr=first; ptr != NULL; ptr = ptr->next) {
        printf(" %d -> ", ptr->data);
    }
}

int main() {
    printf("Enter the number of nodes : ");
    int n;
    scanf("%d", &n);

    insertnode(n);
    display();

    return 0;
}