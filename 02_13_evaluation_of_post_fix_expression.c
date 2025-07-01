#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

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
} 

int pop() {
    int popped;
    if (first==NULL) {
        printf("\nThe stack is Empty!! Underflow..");
    } else {
        temp = first;
        first = first->next;
        if (first==NULL) last = NULL;
    }
    popped = temp->data;
    free(temp);
    return popped;
}

int evaluate_postfix(char *exp){
    for(int i=0; exp[i]; i++){
        if (isdigit(exp[i])) {
            push(exp[i] - '0');
        } else if (exp[i] == '+' || exp[i] == '-' || exp[i] == '*' || exp[i] == '/' ) {
            int val1 = pop();
            int val2 = pop();
            switch (exp[i]) {
                case '+':
                    push(val2+val1);
                    break;
                case '-':
                    push(val2-val1);
                    break;
                case '*':
                    push(val2*val1);
                    break;
                case '/':
                    push(val2/val1);
                    break;
            }
        }
    }
    return pop();
}

int main() {
    char exp[20];
    printf("Enter Postfix Expression : ");
    gets(exp);
    int result = evaluate_postfix(exp);
    printf("\nResult: %d\n", result);

    return 0;
}