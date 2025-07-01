#include <stdio.h>
#include <conio.h>
#include <string.h>

int main() {
	char str[100];
	int len,i;
	char *begin, *end, ch;
	printf("Enter the string : \n Type : ");
	gets(str);
	len = strlen(str);
	begin = str;
	end = str;
	for (i=0; i< len-1; i++){
		end++;
	}
	for (i=0; i<len/2; i++){
		ch = *end;
		*end = *begin;
		*begin = ch;
		
		end--;
		begin++;
	}
	
	printf("\n\n THE REVERSE : %s",str);
	
	return 0;
}
