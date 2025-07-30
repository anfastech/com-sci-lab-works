#include <stdio.h>
#include <conio.h>

int stack[100], choice, n, top=-1, x, i;

void push(){
    if (top>=n-1){
        printf("\n STACK is Overflow ");
    } else {
        printf("Enter a value to be pushed : ");
        scanf("%d",&x);
        top++ ;
        stack[top] =  x;
    }
}

void pop() {
    if (top<0) {
        printf("\nUnderflow");
    } else {
        printf("\nThe popped elements is %d ", stack[top]);
        top--;
    }
}

void display() {
    if (top >=0 ){
        printf("\n The elements in STACK \n");
        for (i=top; i>=0 ; i--){
            printf("\n %d ", stack[i]);
        } 
    } else {
        printf("\n The STACK is empty");
    }
}

int main() {
    printf("\n Enter the size of the STACK : ");
    scanf("%d", &n);
    printf("\n STACK OPERATIONS USING ARRAY ");
    printf("\n 1. PUSH \n 2. POP \n 3. DISPLAY \n 4. EXIT");

    do {
        printf("\n Enter the Choices : ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            push();
            break;
        case 2:
            pop();
            break;
        case 3:
            display();
            break;
        case 4:
            printf("\n Existing... ");
            break;
        
        default:
            printf("\n PLease Enter a valid Choice");
            break;
        }   
    } while (choice != 4);

    return 0;
}

