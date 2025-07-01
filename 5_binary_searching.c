#include <stdio.h>
#include <conio.h>
#include <string.h>

int main() {
	int n, i, arr[20], item, l=0, r, result=-1;
	printf("ENTER: ");
	scanf("%d", &n);
	printf(" ENTER: ");
	for(i=0; i<n; i++){
		scanf("%d", &arr[i]);
	}
	printf("SEARCH: ");
	scanf("%d", &item);
	r=n-1;
	while (l <= r){
		int m= l + (r-l)/2;
		if (arr[m] == item){
			result = m;
			break;
		}
		else if (arr[m] < item){
			l=m+1;
		}
		else {
			r=m-1;
		}
	}
	if (result == -1){
		printf("ELEMENT NOT FOUND\n");
	}
	else {
		printf("ELEMENT FOUND AT POSITION: %d\n", result + 1);
	}
	return 0;
}
