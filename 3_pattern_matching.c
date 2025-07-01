#include <stdio.h>
#include <conio.h>
#include <string.h>

int main() {
	char text[20], pat[20];
	int a,b;
	printf("ENTER THE STRING : ");
	gets(text);
	printf("ENTER THE PATTERN TO FIND : ");
	gets(pat);
	a = strlen(pat);
	b = strlen(text);
	
	int i, j;
	for (i=0; i<=b-a; i++){
		for (j=0; j<a; j++) {
			if (text[i+j] != pat[j])
				break;
		}
		if (j==a) {
			printf("PATTERN FOUND AT Pos: %d", i+1);
		}
	}
	
	return 0;
}p
