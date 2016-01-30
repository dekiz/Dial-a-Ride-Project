/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
///////////////////////////////////////////////////////////////////////////
// Warning !!! Algorithm is not completed. Some constraints are missing. //
///////////////////////////////////////////////////////////////////////////
package kapgelproject;

import ilog.concert.*;
import ilog.cplex.*;

/**
 *
 * @author asus
 */
public class TSP {
    
    public static void SolveMe(int n){
        
        double[] xPos = new double[n];
        double[] yPos = new double[n];
        
        for (int i=0; i<n; i++){
            xPos[i] = Math.random()*100;
            yPos[i] = Math.random()*100;
        }
        
        double[][] c = new double[n][n];
        for (int i=0; i<n; i++){
            
            for (int j=0; j<n; j++){
                c[i][j]=Math.sqrt(Math.pow(xPos[i]-xPos[j], 2 )+Math.pow(yPos[i]-yPos[j],2));
            }
        }
        
        //model 
        
        try{
            IloCplex cplex = new IloCplex();
            
            // variables 
            
            IloNumVar[][] x = new IloNumVar[n][];
            
            for (int i=0; i<n; i++){
                
                x[i] = cplex.boolVarArray(n);
            }
            
            IloNumVar[] u= cplex.numVarArray(n, 0, Double.MAX_VALUE);
            
            //Objective
            
            IloLinearNumExpr obj = cplex.linearNumExpr();
            for (int i=0; i<n; i++){
                
                for ( int j=0; j<n; j++){
                    
                    if(j!=i){
                        obj.addTerm(c[i][j], x[i][j]);
                    }
                }
            }
           cplex.addMinimize(obj);
           
           //constraints
           
           //solve model
           
           if(cplex.solve()){
               
            cplex.output().println("Solution status ="+ cplex.getStatus());
            cplex.output().println("Objective value ="+ cplex.getObjValue());               
 
            for (int i=0; i<n; i++) {
    for (int j=0; j<n; j++) {
        System.out.println(cplex.getValue(x[i][j]));
    }
}
           }
           
           
            
        }catch(IloException e){
            e.printStackTrace();
            
            
        }
    }
    
}
