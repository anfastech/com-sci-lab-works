#include <stdio.h>
#include <conio.h>

int main() {
	int n, i, arr[20], item, l, r, mid, result=-1;
	printf("Enter number of Elements : ");
	scanf("%d", &n);
	printf("\nEnter Elements : ");
	for(i=0; i<n; i++){
		scanf("%d", &arr[i]);
	}
	printf("\nElements to Search : ");
	scanf("%d", &item);

	l=0, r=n-1;
	while (l <= r){
		mid = l + (r-l)/2;
		if (arr[mid] == item){
			result = mid;
			break;
		}
		else if (item > arr[mid]){
			l=mid+1;
		}
		else {
			r=mid-1;
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
