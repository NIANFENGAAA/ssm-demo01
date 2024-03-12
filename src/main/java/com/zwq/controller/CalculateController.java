package com.zwq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class CalculateController {

    @RequestMapping("goCalculatePage")
    public String goCalculatePage(){
        return "matrixAddition";
    }

    @RequestMapping("matrixAddition")
    public String matrixAddition(@RequestParam(value = "row1") int row1, @RequestParam(value = "row2") int row2,
                       @RequestParam(value = "colum1") int colum1, @RequestParam(value = "colum2") int colum2,
                       @RequestParam(value = "body1") String body1, @RequestParam(value = "body2") String body2,
                                 HttpServletRequest request){
        HttpSession session=request.getSession();

        System.out.println(body1);
        System.out.println(body2);

        String[] x1 = body1.split(",");
        String[] x2 = body2.split(",");

        System.out.println(x1);
        System.out.println(x2);

        int[] y1 = new int[x1.length];
        int[] y2 = new int[x2.length];

        //将两个数组转为int类型
        for (int i = 0; i < x1.length; i++) {
            y1[i] = Integer.parseInt(x1[i]);
        }
        for (int i = 0; i < x2.length; i++) {
            y2[i] = Integer.parseInt(x2[i]);
        }

        int [] sum = new int[y1.length];
        for (int i = 0; i < y1.length; i++) {
            sum[i] = y1[i] + y2[i];
        }
        System.out.println(sum.length);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < row1; i++) {
            String s = "";
            for (int i1 = 0; i1 < colum1; i1++) {
                s = s + sum[i1];
                if (i1 != (colum1-1))
                    s = s + " * ";
            }
            list.add(s);
        }

        session.setAttribute("list",list);

        System.out.println(list);



//        //创建矩阵
//        double[][] array1 = new double[row1][colum1];
//        double[][] array2 = new double[row2][colum2];
//        Matrix matrix1 = new Matrix(array1);
//        Matrix matrix2 = new Matrix(array2);
//
//        //给矩阵设置值
//        int z1 = 0 ,z2 = 0;
//        for (int i = 0; i < row1; i++) {
//            for (int i1 = 0; i1 < colum1; i1++) {
//                matrix1.set(i,i1,y1[z1]);
//                z1++;
//            }
//        }
//
//        for (int i = 0; i < row2; i++) {
//            for (int i1 = 0; i1 < colum2; i1++) {
//                matrix2.set(i,i1,y2[z2]);
//                z2++;
//            }
//        }
//
//        Matrix matrix3 = matrix1.plus(matrix2);
//
//        matrix3.print(row1,1);

//
//
//        //将矩阵转为字符串
//        for (int i = 0; i < row1; i++) {
//            String row = "";
//            for (int i1 = 0; i1 < colum1; i1++) {
//                row = row + matrix3.getMatrix(row1,row1,0,colum1);
//                list.add(row);
//            }
//        }


        return "matrixAddition";
    }


    @RequestMapping("goMultiplication")
    public String goMultiplication(){
        return "matrixMultiplication";
    }

    @RequestMapping("matrixMultiplication")
    public String matrixMultiplication(@RequestParam(value = "row1") int row1, @RequestParam(value = "row2") int row2,
                                       @RequestParam(value = "colum1") int colum1, @RequestParam(value = "colum2") int colum2,
                                       @RequestParam(value = "body1") String body1, @RequestParam(value = "body2") String body2,
                                       HttpServletRequest request) {
        HttpSession session = request.getSession();


        String[] x1 = body1.split(",");
        String[] x2 = body2.split(",");


        int[] y1 = new int[x1.length];
        int[] y2 = new int[x2.length];

        //将两个数组转为int类型
        for (int i = 0; i < x1.length; i++) {
            y1[i] = Integer.parseInt(x1[i]);
        }
        for (int i = 0; i < x2.length; i++) {
            y2[i] = Integer.parseInt(x2[i]);
        }

        //打印
        for (int i = 0; i < y1.length; i++) {
            System.out.println(y1[i]);
        }
        for (int i = 0; i < y2.length; i++) {
            System.out.println(y2[i]);
        }

        System.out.println("--------------");

        int[][] a = new int[row1][colum1];
        int[][] b = new int[row2][colum2];
        int[][] c = new int[row1][colum2];

        System.out.println("row2:" + row2);
        System.out.println("colum2:" + colum2);
        System.out.println("---------");


        int count1 = 0;
        for (int i = 0; i < row1; i++) {

            for (int j = 0; j < colum1; j++) {
                a[i][j] = y1[count1];
                count1++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < a[i].length; i1++) {
                System.out.print(a[i][i1] + "   ");
            }
            System.out.println();
        }

        int count2 = 0;
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < colum2; j++) {
                System.out.println("y2[count2]:   "+y2[count2]);
                System.out.println("------");
                b[i][j] = y2[count2];
                System.out.println(b[i][j]);
                count2++;
            }
        }

        System.out.println("b:  ----------------");



        for (int i = 0; i < b.length; i++) {
            for (int i1 = 0; i1 < b[i].length; i1++) {
                System.out.print(b[i][i1] + "   ");
            }
            System.out.println();
        }

        //根据规律用三个for循环实现矩阵相乘
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        //打印
        for (int i = 0; i < c.length; i++) {
            for (int i1 = 0; i1 < c[i].length; i1++) {
                System.out.println(c[i][i1]);
            }
        }


        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < row1; i++) {
            String s = "";
            for (int i1 = 0; i1 < colum2; i1++) {
                s = s + c[i][i1];
                if (i1 != (colum2-1))
                    s = s + " * ";
            }
            list.add(s);
        }

        session.setAttribute("list",list);

        System.out.println(list);


        return "matrixMultiplication";
    }

    @RequestMapping("goMatrixTranspose")
    public String goMatrixTranspose(){
        return "matrixTranspose";
    }

    @RequestMapping("matrixTranspose")
    public String matrixTranspose(@RequestParam(value = "row1") int row1,
                                       @RequestParam(value = "colum1") int colum1,
                                       @RequestParam(value = "body1") String body1,
                                       HttpServletRequest request){

        HttpSession session=request.getSession();

        String[] x1 = body1.split(",");

        int[] y1 = new int[x1.length];

        //将数组转为int类型
        for (int i = 0; i < x1.length; i++) {
            y1[i] = Integer.parseInt(x1[i]);
        }

        for (int i = 0; i < y1.length; i++) {
            System.out.println("y的数组："+y1[i]);
        }
        System.out.println("-----------------------");


        int [][] result1 = new int[row1][colum1];
        int [][] result2 = new int[colum1][row1];

        int count = 0;
        for (int i = 0; i < row1; i++) {
            for (int i1 = 0; i1 < colum1; i1++) {
                result1[i][i1] = y1[count];
                count++;
            }
        }

        System.out.println("转置前的矩阵：");
        for (int i = 0; i < result1.length; i++) {
            for (int j = 0; j < result1[i].length; j++) {
                System.out.print(result1[i][j] + "  ");
            }
            System.out.println();
        }

/*
* 转置操作
* */
        int count1 = 0;
        for(int i=0;i<row1;i++)
        {
            for(int j=0;j<colum1;j++)
            {
                result2[j][i] = y1[count1];
                System.out.print(result2[j][i] + "  ");
                count1++;
            }
        }

        System.out.println("转置后的矩阵：");
        for (int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2[i].length; j++) {
                System.out.print(result2[i][j] + "  ");
            }
            System.out.println();
        }


        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < colum1; i++) {
            String s = "";
            for (int i1 = 0; i1 < row1; i1++) {
                s = s + result2[i][i1];
                if (i1 != (row1-1))
                    s = s + " * ";
            }
            list.add(s);
        }

        session.setAttribute("list",list);

        System.out.println(list);



        return "matrixTranspose";
    }

}
