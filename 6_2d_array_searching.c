#include <stdio.h>
#include <conio.h>

#define ROW 3
#define COL 3

// function to search an element in a 2D sorted array

void searchElement(int arr[ROW][COL], int target)
{
    int row = 0, col = COL - 1;
    while (row < ROW && col >= 0)
    {
        if (arr[row][col] == target)
        {
            printf("Element found at position (%d, %d)\n", row + 1, col + 1);
            return;
        }
        if (arr[row][col] < target)
            row++;
        else
            col--;
    }
    printf("Element not found in the array.\n");
}

int main()
{
    int arr[ROW][COL] = {
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9}
    };
    int target;

    printf("Enter the element to search: ");
    scanf("%d", &target);

    searchElement(arr, target);

    return 0;
}