#include <stdio.h>

int removeDuplicates(int* nums, int numsSize){
    if (numsSize <= 1)
    {
        return numsSize;
    }
    
    int offset = 0;
    for (int i = 1; i < numsSize; i++) {
        if (nums[i] != nums[offset]) {
            offset++;
            nums[offset] = nums[i];
        }
    }

    return offset + 1;
}

int main() {
    int list[10] = {0,0,1,1,1,2,2,3,3,4};
    // int list[3] = {0,0,1};
    int len = removeDuplicates(list, 10);
    printf("len ==> %d\n", len);
    for (int i = 0; i < 10; i++)
    {
        printf("%d", list[i]);
    }
    
    return 0;
}