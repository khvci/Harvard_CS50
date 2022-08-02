#include <stdio.h>
#include <math.h>
int getChange(float input);
int calculateCents(float input); 

int main(int argc, char const *argv[])
{
    float input;
    do
    {
        printf("What is the remainder? ");
        scanf("%f", &input);
        if (input < 0)
        {
            printf("Remainder can't be negative. ");
        }
    } while (input < 0);
    
    int rounded = calculateCents(input);
    
    printf("%d\n", getChange(rounded));
    
    return 0;
}

int calculateCents(float input) 
{
    int rounded;
    if ((int)(input * 1000) % 10 >= 5) rounded = (int)(input * 100) + 1;
    else rounded = (int)(input * 100);

    return rounded;
}

int getChange(float total)
{
    int counter = 0;

    while (total > 0)
    {
        if (total >= 25)
        {
            total -= 25;
            counter++;
        } 
        
        else if (total >= 10)
        {
            total -= 10;
            counter++;
        }

        else if (total >= 5)
        {
            total -= 5;
            counter++;
        }

        else if (total >= 1)
        {
            total -= 1;
            counter++;
        }
    }

    return counter;
}
