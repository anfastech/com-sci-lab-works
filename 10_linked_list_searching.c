#include <stdio.h>
#include <conio.h>
#include <malloc.h>

void create(int);
void search();

struct node {
    int data;
    struct node *next;
};

struct node *head;

int main() {
    int choice, item, loc;
    do {
        printf("\n 1. create \n 2. Search \n 3. Exit \n 4. Enter your Choice ? : ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("\n Enter the item : ");
                scanf("%d", &item);
                create(item);
                break;
            case 2:
                search();
                break;
            case 3:
                printf("\n Exiting.. \n");
                exit(0);
                break;
            default:
                printf("\n Invalid choice! \n");
        }
    } while (choice != 3);
    
    return 0;
}


void create(int item) {
    struct node *ptr = (struct node *)malloc(sizeof(struct node));

    if (ptr == NULL) {
        printf("\n OVERFLOW \n");
    } else {
        ptr->data = item;
        ptr->next = head;
        head = ptr;
        printf("\n Node Inserted \n");
    }
}

void search() {
    struct node *ptr;
    int item, i =0, flag;
    ptr= head;
    if(ptr==NULL) {
        printf("\n Empty List \n");
    } else {
        printf("\n Enter item which you want to search ? \n ");
        scanf("%d",&item);
        while (ptr!=NULL)
        {
            if(ptr->data == item){
                printf("\n Item found at location %d", i+1);
                flag=0;
                break;
            } else {
                flag=1;
            }
             i++;
             ptr = ptr->next;
        }
        if(flag==1){
            printf("\n Item not found \n");
        }
    }
}