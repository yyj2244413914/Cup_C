/*题目2：创建矩阵运算工具类Matrix 
类似Java提供的Math类一样，编写一个Matrix类（其实是Library，只是用类这种
语法将相关的函数聚集在一起）， 用来处理与Matrix有关的操作，具体包含的函数原型
如下所示：  
public class Matrix { 
public static void print(int[ ][ ] m);   // 输出格式自行决定，但一定要整齐美观 
public static void print(double[ ][ ] m); 
public static boolean haveSameDimension(int[ ][ ] m1, int[ ][ ] m2);  
public static boolean haveSameDimension(double[ ][ ] m1, double[ ][ ] m2); 
public static int[ ][ ] add(int[ ][ ] m1, int[ ][ ] m2);  
//矩阵相加运算之前，要检查矩阵的维数是否一致，请使用已定义好的方法，尽量要复用。 
public static double[ ][ ] add(double[ ][ ] m1, double[ ][ ] m2); 
public static int[ ][ ] subtract(int[ ][ ] m1, int[ ][ ] m2); 
public static double[ ][ ] subtract(double[ ][ ] m1, double[ ][ ] m2); 
public static int[ ][ ] multiply(int[ ][ ] m1, int[ ][ ] m2); 
public static double[ ][ ] multiply(double[ ][ ] m1, double[ ][ ] m2); 
} 
要求： 
除了实现Matrix Library之外，还需要编写一个测试程序，用来验证Matrix中实现的各个函数的
正确性。*/

//(1)定义矩阵打印方法
//输出格式自行决定，但一定要整齐美观。
public class Matrix { 
    public static void print(int[ ][ ] m){
        int i=0,j=0;
        for(j=0;j<m.length;j++){
        for(i=0;i<m[0].length;i++){
                System.out.print(m[j][i]+" ");
            }
            System.out.println("\n");
        }
    };   
public static void print(double[ ][ ] m){
        int i=0,j=0;
        for(j=0;j<m[0].length;j++){
        for( i=0;i<m.length;i++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }; 
//(2)矩阵类型的布尔类型运算
//判断两个矩阵是否具有相同的维数。
public static boolean haveSameDimension(int[ ][ ] m1, int[ ][ ] m2){
        if(m1.length==m2.length && m1[0].length==m2[0].length){
            return true;
        }
        else{
            return false;
        }
};  
public static boolean haveSameDimension(double[ ][ ] m1, double[ ][ ] m2){
       if(m1.length==m2.length && m1[0].length==m2[0].length){
        return true;
       }
       else{
        return false;
       } 
};   
//(3)矩阵相加运算
//矩阵相加运算之前，要检查矩阵的维数是否一致，请使用已定义好的方法(haveSameDimension)，尽量要复用。 
public static int[ ][ ] add(int[ ][ ] m1, int[ ][ ] m2){
        if(haveSameDimension(m1,m2)==false){
            System.out.println("两个矩阵维数不一致，无法相加");
            return null;
        }
        int i=0,j=0;
        int[][] m3=new int[m1.length][m1[0].length];
        for(j=0;j<m1.length;j++){
        for(i=0;i<m1[0].length;i++){
                m3[j][i]=m1[j][i]+m2[j][i];
            } 
        }
        return m3;
};  
public static double[ ][ ] add(double[ ][ ] m1, double[ ][ ] m2){
    if(haveSameDimension(m1,m2)==false){
        System.out.println("两个矩阵维数不一致，无法相加");
        return null;
    }
    int i=0,j=0;
    double[][] m3=new double[m1.length][m1[0].length];
    for(j=0;j<m1.length;j++){
    for(i=0;i<m1[0].length;i++){
            m3[j][i]=m1[j][i]+m2[j][i];
        } 
    }
    return m3;
};  
//(4)矩阵相减运算
//矩阵相减运算之前，要检查矩阵的维数是否一致，请使用已定义好的方法(haveSameDimension)，尽量要复用。 
public static int[ ][ ] subtract(int[ ][ ] m1, int[ ][ ] m2){
    if(haveSameDimension(m1,m2)==false){
        System.out.println("两个矩阵维数不一致，无法相减");
        return null; 
    }
    int i=0,j=0;
    int[][] m3=new int[m1.length][m1[0].length];
    for(j=0;j<m1.length;j++){
    for(i=0;i<m1[0].length;i++){
            m3[j][i]=m1[j][i]-m2[j][i];
        } 
    }
    return m3;
}; 
public static double[ ][ ] subtract(double[ ][ ] m1, double[ ][ ] m2){
if(haveSameDimension(m1,m2)==false){
    System.out.println("两个矩阵维数不一致，无法相减");
    return null; 
}
int i=0,j=0;
double[][] m3=new double[m1.length][m1[0].length];
for(j=0;j<m1.length;j++){
for(i=0;i<m1[0].length;i++){
        m3[j][i]=m1[j][i]-m2[j][i];
    } 
}
return m3;
}; 
//（5）矩阵乘法运算
public static int[ ][ ] multiply(int[ ][ ] m1, int[ ][ ] m2){
    int[][] m3=new int[m1.length][m2[0].length];
    int i=0,j=0,k=0;
    for(i=0;i<m1.length;i++){
        for(j=0;j<m2[0].length;j++){
            for(k=0;(k<m1[0].length)&&(k<m2.length);k++){
                m3[i][j]+=m1[i][k]*m2[k][j]; 
            }
        } 
    }
    return m3;
}; 
public static double[ ][ ] multiply(double[ ][ ] m1, double[ ][ ] m2){
    double[][] m3=new double[m1.length][m2[0].length];
    int i=0,j=0,k=0;
    for(i=0;i<m1.length;i++){
        for(j=0;j<m2[0].length;j++){
            for(k=0;(k<m1[0].length)&&(k<m2.length);k++){
                m3[i][j]+=m1[i][k]*m2[k][j]; 
            }
        } 
    }
    return m3;
};
//(6)测试程序
public static void main(String[] args) {
    int[][] m1={{1,2,3},{4,5,6}};
    int[][] m2={{1,2,3},{4,5,6}};
    int[][] m3=add(m1,m2);
    print(m3);
    int[][] m4=subtract(m1,m2);
    print(m4);
    int[][] m5=multiply(m1,m2);
    print(m5);
    int[][] m6={{1,2},{3,4},{5,6}};//测试错误情况
    int[][] m7=add(m1,m6);//预期输出：维数不一致，无法相加
}
}
