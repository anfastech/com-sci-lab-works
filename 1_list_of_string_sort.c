#include <stdio.h>
#include <conio.h>

int main(){
	char a[5][20];
	int i,j=0;
	printf("Enter Who are you, What you do.. \n Type: ");
	for (i=0; i<5 ; i++)
		scanf("%s", &a[i]);
		
	for( i=65; i<144; i++) {
		for (j=0; j<5; j++)
			if (a[j][0] == i){
				printf("%s \n", a[j]);
			}
	}
	
	return 0;
}
