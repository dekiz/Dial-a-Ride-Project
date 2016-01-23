/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kapgelproject;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelRead{
    
    public static String[] ExcelRead(String excel) throws Exception{
    
//    File f=new File("C:\\Users\\asus\\Documents\\MATLAB\\testsample.xls");
    File f = new File(excel);
    
    Workbook wb = Workbook.getWorkbook(f);
    Sheet s=wb.getSheet(0);
    
    int col=s.getColumns();
    int row =s.getRows();
    
    double DestinationLat[]=new double[row];
    double DestinationLong[]=new double[row];
    double OriginLat[]=new double[row];
    double OriginLong[]=new double[row];
    String timestamp[]=new String[row];
    
    for (int j=1; j<row; j++)
    {
        Cell A=s.getCell(2,j);
        String stringA = A.getContents();
//        System.out.println(stringA.substring(0, stringA.length()));
        DestinationLat[j]=Double.parseDouble(stringA);
        
               
        Cell B=s.getCell(3,j);
        String stringB = B.getContents();
        
        DestinationLong[j]=Double.parseDouble(stringB);
//        System.out.println(DestinationLong[j]);
        
        Cell C=s.getCell(4,j);
        String stringC = C.getContents();
               
//        System.out.println(stringA.substring(0, stringA.length()));
        OriginLat[j]=Double.parseDouble(stringC);
        
        Cell D=s.getCell(5,j);
        String stringD = D.getContents();
        
        OriginLong[j]=Double.parseDouble(stringD);
        
        
        // read timestamp
        
        Cell E = s.getCell(1,j);
        String stringE=E.getContents();
        timestamp[j]=stringE;
       
        
        

    }
    
        String times[]=new String[row-1];
        for (int i=1; i<row; i++){
            times[i-1]=timestamp[i];
        }
    
        double coordinates[] = new double [4*row-4];
        for (int i=1; i<row; i++){
            coordinates[i-1]=DestinationLat[i];
        }
        for (int i=1; i<row; i++){
            coordinates[i+row-2]=DestinationLong[i];
        }
        for (int i=1; i<row; i++){
            coordinates[i+2*row-3]=OriginLat[i];
        }

        for (int i=1; i<row; i++){
            coordinates[i+3*row-4]=OriginLong[i];
        }

        for (int i=0; i<coordinates.length; i++){
//            System.out.println(coordinates[i]);
        }

return times;

}

}
