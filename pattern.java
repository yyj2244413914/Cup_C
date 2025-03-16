import java.util.Scanner;
public class pattern  {
    public static void patternprint(char a, int n){
        System.out.println("你要打印的图案：\n");
        char[] choices={'a','b','c','d','e','f','g'};
        if(a==choices[0]){
            int j=0,k=0;
            for(j=0;j<n;j++){
                for(k=0;k<j;k++){
                        System.out.print("  ");
                    }
                for(k=0;k<2*n-((j+1)*2-1);k++){
                        System.out.print("# ");
                    }
                System.out.println();
                }
            }
        if(a==choices[1]){
                int j=0,k=0;
                for(j=0;j<n;j++){
                    for(k=0;k<n-1-j;k++){
                            System.out.print("  ");
                        }
                    }
                    for(k=0;k<(j+1)*2-1;k++){
                            System.out.print("# ");
                        }
                        System.out.println();
                    }
        if(a==choices[2]){
            if(n%2==0){
                System.out.println("输入必须为奇数！");
                return;
                }
            else{
                int j=0,k=0;
                for(j=0;j<(n+1)/2;j++){
                    for(k=0;k<(n+1)/2-1-j;k++){
                            System.out.print("  ");
                        }
                    for(k=0;k<(j+1)*2-1;k++){
                            System.out.print("# ");
                        }
                        System.out.println();
                    }

                for(j=0;j<(n-1)/2;j++){
                    System.out.print("  ");
                    for(k=0;k<j;k++){
                            System.out.print("  ");
                        }
                    for(k=0;k<n-(j+1)*2;k++){
                            System.out.print("# ");
                        }
                        System.out.println();
                    }
                }
            }
        if(a==choices[3]){
            int j=0,k=0;
            for(j=0;j<n;j++){
                for(k=0;k<=j;k++){
                        System.out.print((k+1)+" ");
                    } 
                System.out.println();
                }
            }
        if(a==choices[4]){
            int j=0,k=0;
            for(j=0;j<n;j++){
                for(k=0;k<j;k++){
                        System.out.print(" ");
                    }
                for(k=0;k<n-j;k++){
                        System.out.print((k+1)+" ");
                    }
                System.out.println();
                }
            }
        if(a==choices[5]){
            int j=0,k=0;
            for(j=0;j<n;j++){
                for(k=0;k<n-j-1;k++){
                        System.out.print(" ");
                    }
                for(k=j+1;k>0;k--){
                        System.out.print(k+" ");
                    }
                System.out.println();
                }
            }
        if(a==choices[6]){
            int j=0,k=0;
            for(j=0;j<n;j++){
                for(k=n-j;k>0;k--){
                        System.out.print(k+" ");
                    }   
                System.out.println();
            }
        }
 }

    public static void main(String[] args) {
        System.out.println("请输入你要的图案：");
        Scanner scanner=new Scanner(System.in);
        char a=scanner.next().charAt(0);
        System.out.println("请输入你要的行数：");
        int n=scanner.nextInt();
        patternprint(a,n);
    }
}
  
