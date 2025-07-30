#include <stdio.h>

int stack[100], top=-1, i, j, n=8, value; 

void push() {
    if(top>=n-1) {
        printf("\nOverflow!!!");
    } else {
        printf("\nEnter the value to add : ");
        scanf("%d", &value);
        top++;
        stack[top] = value;
    }
}

void display() {
    if (top>=0) {
        for (i=top; i>=0; i--) {
            printf("\n -> %d ", stack[i]);
        }
    } else {
        printf("\nThe Stack is Empty!!");
    }
}

void pop() {
    if (top<0) {
        printf("\nUnderFLow !!");
    } else {
        printf("\nThe delected element -> %d ", stack[top]);
        top--;
    }
}

int main (){
    push();
    push();
    display();
    pop();
    display();
    
    // do { } while ( choice != 4);
}