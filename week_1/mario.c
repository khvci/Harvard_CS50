#include <stdio.h>

void makePyramid(int levels);

void main(int argc, char const *argv[])
{
    int levels;
    do
    {
        printf("How many levels do you want to create? (max: 8) ");
        scanf("%i", &levels);

        if (levels < 1 || levels > 8) printf("Try again. Please provide a positive integer between 1 and 8.\n");
     
    } while (levels < 1 || levels > 8);
    
    makePyramid(levels);
}

void makePyramid(int levels)
{
    for (int i = 0; i < levels; i++)
    {
        for (int j = 1; j < levels - i; j++) 
            printf(" ");

        for (int k = 0; k <= i; k++) 
            printf("#");

        printf("\n");
    }
}
