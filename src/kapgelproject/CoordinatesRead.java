/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kapgelproject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author dileka
 */
public class CoordinatesRead {
        public static double[][] CoordinatesRead(){
        int n = 12;
        double[] destination_lat  = new double[n];
        double[] destination_long = new double[n];
        double[] origin_lat       = new double[n];
        double[] origin_long      = new double[n];

	int list_counter = 0;

	BufferedReader in = null;
	try {
	    in = new BufferedReader(new FileReader("C:\\Users\\IBM_ADMIN\\Documents\\NetBeansProjects\\java\\read.csv"));
	    String read = null;
	    while ((read = in.readLine()) != null) {
		String[] splited = read.split(",");
		int column_num = 0;
		for (String part : splited) {
		    if(column_num == 2){
			//System.out.println(part);
			double value = Double.parseDouble(part);
			destination_lat[list_counter] = value;
		    }
		    if(column_num == 3){
			//System.out.println(part);
			double value = Double.parseDouble(part);
			destination_long[list_counter] = value;
		    }
		    if(column_num == 4){
			//System.out.println(part);
			double value = Double.parseDouble(part);
			origin_lat[list_counter] = value;
		    }
		    if(column_num == 5){
			//System.out.println(part);
			double value = Double.parseDouble(part);
			origin_long[list_counter++] = value;
		    }
		    column_num++;
		}
		//System.out.println("*********************");
	    }
	} catch (IOException e) {
	    System.out.println("There was a problem: " + e);
	    e.printStackTrace();
	} finally {
	    try {
		in.close();
	    } catch (Exception e) {
	    }
	}
        
//        for (int i=0; i<150; i++){
//            System.out.println(destination_long[i]);
//        }
	
        double pickupcoordinates[][] = {origin_lat,origin_long};
        double [][] coordinates = new double[2*(pickupcoordinates[0].length)+2][2];
         coordinates[0][0] = 41.041999;
         coordinates[0][1] = 28.961532;
         coordinates[2*(pickupcoordinates[0].length)+1][0] = 41.041999;
         coordinates[2*(pickupcoordinates[0].length)+1][1] = 28.961532;
        for (int i = 1; i < pickupcoordinates[0].length+1; i++){
             coordinates[i][0] = origin_lat[i-1];
             coordinates[i][1] = origin_long[i-1];
             coordinates[i+pickupcoordinates[0].length][0]=destination_lat[i-1];
             coordinates[i+pickupcoordinates[0].length][1]=destination_long[i-1];
         
    }
        
//        System.out.println(pickupcoordinates[0].length);
//            for (int i=0; i< (2*(pickupcoordinates[0].length)+2); i++){
//            for (int j=0; j<2; j++){
//                System.out.println(coordinates[i][j]);
//            }
//            }
            
return coordinates;
        }
        
}