package stage_6;

import java.util.Scanner;

public class b_25206 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    float result = 0;
    float gradeSum = 0;
    String[] subject = new String[20];
    float[] point = new float[20];
    String[] gradeArr = new String[20];
    for(int i=0; i<20; i++) {
      float sum = 0;
      subject[i] = scan.next();
      point[i] = scan.nextFloat();
      String grade = scan.next();
      gradeArr[i] = grade;
      float gradePoint = 0;
      switch (grade) {
        case "A+" :
          gradePoint = 4.5F;
          break;
        case "A0" :
          gradePoint = 4.0F;
          break;
        case "B+" :
          gradePoint = 3.5F;
          break;
        case "B0" :
          gradePoint = 3.0F;
          break;
        case "C+" :
          gradePoint = 2.5F;
          break;
        case "C0" :
          gradePoint = 2.0F;
          break;
        case "D+" :
          gradePoint = 1.5F;
          break;
        case "D0" :
          gradePoint = 1.0F;
          break;
        default:
          gradePoint = 0;
      }
      sum = point[i] * gradePoint;
      result += sum;
    }
    for(int j=0; j<gradeArr.length; j++) {
      if(gradeArr[j].contains("P")) {
        continue;
      }
      gradeSum += point[j];
    }
    System.out.println(result/gradeSum);
  }
}
