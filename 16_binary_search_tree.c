#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *left, *right;
};

struct node* insert(struct node* root, int key) {
    if (root == NULL) {
        struct node* temp = (struct node*)malloc(sizeof(struct node));
        temp->data = key;
        temp->left = temp->right = NULL;
        return temp;
    }
    if (key < root->data)
        root->left = insert(root->left, key);
    else if (key > root->data)
        root->right = insert(root->right, key);
    return root;
}

struct node* minValueNode(struct node* node) {
    struct node* current = node;
    while (current && current->left != NULL)
        current = current->left;
    return current;
}

struct node* deleteNode(struct node* root, int key) {
    if (root == NULL)
        return root;
    if (key < root->data)
        root->left = deleteNode(root->left, key);
    else if (key > root->data)
        root->right = deleteNode(root->right, key);
    else {
        if (root->left == NULL) {
            struct node* temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL) {
            struct node* temp = root->left;
            free(root);
            return temp;
        }
        struct node* temp = minValueNode(root->right);
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);
    }
    return root;
}

void inorder(struct node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

int main() {
    struct node* root = NULL;
    int choice, item;
    while (1) {
        printf("\n-- Binary Search Tree Operations menu --");
        printf("\n 1. Insert \n 2. Delete \n 3. Display (Inorder) \n 4. Exit \n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &item);
                root = insert(root, item);
                printf("Inserted: %d\n", item);
                break;
            case 2:
                printf("Enter value to delete: ");
                scanf("%d", &item);
                root = deleteNode(root, item);
                printf("Deleted: %d\n", item);
                break;
            case 3:
                printf("BST (Inorder): ");
                inorder(root);
                printf("\n");
                break;
            case 4:
                printf("Exiting...\n");
                exit(0);
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }
    return 0;
}