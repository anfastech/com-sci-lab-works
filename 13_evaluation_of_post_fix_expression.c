#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

struct stack
{
    int top;
    unsigned size;
    int *array;
};

struct stack *create_stack(unsigned size)
{
    struct stack *stack = (struct stack *)malloc(sizeof(struct stack));
    if (!stack)
        return NULL;
    stack->top = -1;
    stack->size = size;
    stack->array = (int *)malloc(stack->size * sizeof(int));
    if (!stack->array)
        return NULL;
    return stack;
}

int is_empty(struct stack *stack)
{
    return stack->top == -1;
}

char peek(struct stack *stack)
{
    return stack->array[stack->top];
}

char pop(struct stack *stack)
{
    if (!is_empty(stack))
    {
        return stack->array[stack->top--];
    }
    return '$';
}

void push(struct stack *stack, char op)
{
    stack->array[++stack->top] = op;
}

int evaluate_postfix(char *exp)
{
    struct stack *stack = create_stack(strlen(exp));
    int i;
    if (!stack)
        return -1;
    for (i = 0; exp[i]; i++)
    {
        if (isdigit(exp[i]))
        {
            push(stack, exp[i] - '0');
        }
        else
        {
            int val1 = pop(stack);
            int val2 = pop(stack);
            switch (exp[i])
            {
            case '+':
                push(stack, val2 + val1);
                break;
            case '-':
                push(stack, val2 - val1);
                break;
            case '*':
                push(stack, val2 * val1);
                break;
            case '/':
                push(stack, val2 / val1);
                break;
            }
        }
    }
    return pop(stack);
}

int main()
{
    char exp[20];
    printf("Enter the Postfix expression: ");
    gets(exp);
    printf("Postfix evaluation : %d ", evaluate_postfix(exp));

    return 0;
}