#include <stdio.h>

// 交换两个元素的值
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// 生成全排列
void permute(int *arr, int start, int end, int srr[1000][10], int *count) {
    if (start == end) {
        // 将当前排列存储到 srr 中
        for (int i = 0; i <= end; i++) {
            srr[*count][i] = arr[i];
        }
        // 排列数量加 1
        (*count)++;
    } else {
        for (int i = start; i <= end; i++) {
            swap(&arr[start], &arr[i]);
            permute(arr, start + 1, end, srr, count);
            swap(&arr[start], &arr[i]);
        }
    }
}

int main() {
    int count = 0;
    int n;
    // 输入元素个数
    scanf("%d", &n);
    int arr[10];
    // 初始化数组
    for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
    }
    int srr[1000][10];
    // 调用 permute 函数生成全排列
    permute(arr, 0, n - 1, srr, &count);
    // 输出所有全排列
    for (int i = 0; i < count; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", srr[i][j]);
        }
        printf("\n");
    }
    // 去除重复
    for(int i=0;i<count;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(srr[i][j]==j+1)
            {
               for(int k=0;k<n;k++)
               srr[i][k]=0; 
            }
        }
    }
    for(int i=0;i<count;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(srr[i][j]!=0)
            {
                printf("%d ",srr[i][j]);
            }
        }
        printf("      ");
    }
    return 0;
}
