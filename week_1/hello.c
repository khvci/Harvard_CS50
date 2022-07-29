#include <stdio.h>


int main(int argc, char const *argv[])
{
    printf("Your name: ");
    char name[30];
    scanf("%s", name);
    printf("Hello, %s!\n", name);
    return 0;
}

/* 

terminal commands:

make hello
./hello

*/



