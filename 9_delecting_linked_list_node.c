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
void delete_node(int);

int main() {
    int ch=0, n, item;
    while (ch != 4)
    {
        printf("\n-- Linked List Operations --");
        printf("\n 1. Create List \n 2. Display List \n 3. Delete Node \n 4. Exit \n");
        printf("\n Enter your choice : ");
        scanf("%d", &ch);
        switch (ch) {
            case 1:
                printf("\n Enter the number of nodes to be created : ");
                scanf("%d", &n);
                insert_node(n);
                break;
            case 2:
                printf("\n The Elements in the List are : ");
                display();
                break;
            case 3:
                printf("\n Enter the value of node to delete: ");
                scanf("%d", &item);
                delete_node(item);
                break;
            case 4:
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
    first = NULL, last = NULL;
    int i, value;
    for (i = 0; i < n; i++) {
        printf("\n Enter the value of node %d : ", i + 1);
        scanf("%d", &value);
        newnode = create_node(value);
        if (first == NULL && last == NULL) {
            first = last = newnode;
            first->next = NULL;
        } else {
            last->next = newnode;
            last = newnode;
            last->next = NULL;
        }
    }
    printf("\n Linked list created \n");
}

void display() {
    if (first == NULL) {
        printf("\n No nodes in the list to display \n");
    } else {
        for(ptr=first; ptr!=NULL; ptr=ptr->next){
            printf("%d ", ptr->value);
        }
        printf("\n");
    }
}

void delete_node(int item){
    int i, pos=0;
    struct node *temp, *ptr= first;
    if (first==NULL) {
        printf("\n The List is Empty: \n");
    }else {
        while (ptr != NULL) {
            if (ptr->value == item) {
                break;
            }
            pos++;
            ptr = ptr->next;
        }
        if(pos == 0) {
            ptr = first;
            first = first->next;
            printf("\n The deleted element is %d \n", ptr->value);
            free(ptr);
        } else {
            ptr = first;
            for (i = 0; i < pos; i++) {
                temp = ptr;
                ptr = ptr->next;
            }
            temp->next = ptr->next;
            printf("\n The deleted element is %d \n", ptr->value);
            free(ptr);
        }
    }
}