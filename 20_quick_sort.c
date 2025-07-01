#include <stdio.h>
#include <conio.h>

#define MAX 100

int main()
{
    int arr[MAX], n, top = -1, start, end, pivot, i, j, temp;
    int stack[MAX][2];
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);
    printf("Enter the elements of the array: ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    stack[++top][0] = 0;
    stack[top][1] = n - 1;
    while (top >= 0)
    {
        start = stack[top][0];
        end = stack[top--][1];
        pivot = arr[end];
        i = start - 1;
        for (j = start; j < end; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        int pivot_index = i + 1;
        if (pivot_index - 1 > start)
        {
            stack[++top][0] = start;
            stack[top][1] = pivot_index - 1;
        }
        if (pivot_index + 1 < end)
        {
            stack[++top][0] = pivot_index + 1;
            stack[top][1] = end;
        }
    }
    printf("Sorted array: ");
    for (i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}