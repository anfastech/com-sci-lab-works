#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

typedef struct node snode;
snode* create_node(int data) {
    snode* newnode = (snode*)malloc(sizeof(snode));
    if (newnode == NULL){
        return NULL;
    }
    newnode->data = data;
    newnode->next = NULL;
    return newnode;
}

int insert_before_head(snode** head, int data) {
    snode* newnode = create_node(data);
    if(!newnode){
        return -1;
    }
    if (*head == NULL) {
        *head = newnode;
        return 0;
    } 

    newnode->next = *head;
    *head = newnode;
    return 0;
}

int delete_head(snode** head) {
    snode* temp=  *head;
    *head = (*head)->next;
    free(temp);
    return 0;
}

int is_empty(snode** stack) {
    return *stack == NULL;
}

void push( snode** stack, int data) {
    if(insert_before_head(stack,data)){
        printf("Stack Overflow \n");
    }
}

void pop(snode** stack) {
    if(is_empty(stack)) {
        printf("Stack Underflow \n");
        exit(0);
    }
    delete_head(stack);
}

int peek(snode** stack) {
    snode* temp = *stack;
    while (temp!=NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
}


int main() {
    snode* stack = NULL;
    push(&stack, 10);
    push(&stack, 20);
    push(&stack, 30);
    push(&stack, 40);
    push(&stack, 50);
    printf("\n Stack : ");
    peek(&stack);
    printf(" (After pushing 5 Values )");
    pop(&stack);
    pop(&stack);
    printf("\n Stack : ");
    peek(&stack);
    printf(" (After popping 2 Values )");
    return 0;
}