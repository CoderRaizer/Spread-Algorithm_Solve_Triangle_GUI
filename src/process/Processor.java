package process;

import java.util.ArrayList;

public class Processor {
	
    SolveTheOperator solveTheOperator;
    ManagerVariable<String,Double> managerVariable;
    BootDataRecipe bootDataRecipe;
    MapBucketNoron mapBucketNoron;
    
    int soluongBien;
    String [] arrNameVariableInBoxRecipe;
    int [][] matrixSpread;
    int quantityKnown;
//    String [] arrayVarKnown;
    ArrayList<String> arrayVarKnown = new ArrayList<>();
    String findResult;
    
    
    /*-----------------------------------------------*/
    
    public void reset() {
    	managerVariable.collectionVariable.clear();
    	arrNameVariableInBoxRecipe = null;
    	matrixSpread = null;
    	quantityKnown = 0;
    	arrayVarKnown = null;
    	findResult = "";
    }
    
	public Processor() {
    	solveTheOperator = new SolveTheOperator();
    	managerVariable = new ManagerVariable<>();
    	bootDataRecipe = new BootDataRecipe();
    	mapBucketNoron = new MapBucketNoron();
    }

	public int getQuantityKnown() {
		return quantityKnown;
	}

	public void setQuantityKnown(int quantityKnown) {
		this.quantityKnown = quantityKnown;
	}

	public String getFindResult() {
		return findResult;
	}

	public void setFindResult(String findResult) {
		this.findResult = findResult;
	}

	public void setarrayVarKnown() {
//		arrayVarKnown = new String[quantityKnown];
		arrayVarKnown = new ArrayList<>();
	}
	
	public void setVariableToArrayVarKnow(String key , Double val) {
		managerVariable.add(key,val);
//		arrayVarKnown[managerVariable.collectionVariable.size() - 1] = key;
		arrayVarKnown.add(key);
	}
	
    
    public void  TurnOn() {
        bootDataRecipe.readDataRecipe();
        bootDataRecipe.pushDataToMapNode(mapBucketNoron,solveTheOperator);
        mapBucketNoron.display();

        /*-----------------------------------------------*/
        /* Show list recipe in Solve Operator */
        solveTheOperator.showListRecipeInSolveOperator();
        /* Show list recipe in Solve Operator */

        // Copy List variable in Box Recipe
        soluongBien = bootDataRecipe.listVariableInBoxRecipe.size();
        arrNameVariableInBoxRecipe = new String[soluongBien];
        int r = 0;
        for (String x : bootDataRecipe.listVariableInBoxRecipe){
            arrNameVariableInBoxRecipe[r] = x;
            r++;
        }
        for (int i = 0 ; i < r ; i++) {
        	System.out.println(arrNameVariableInBoxRecipe[i] + "_");
        }

        /* ----- TODO : CREATE MATRIX SPREAD ----- */
        
        matrixSpread = new int[soluongBien][mapBucketNoron.mapNODE.size()];
        firstInitMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());
//        showMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());
        System.out.println("--------------------------------");

        /* ----- TODO : SETUP MATRIX AVAILABLE ZONE RECIPE ----- */
        mapBucketNoron.setupMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),arrNameVariableInBoxRecipe);
//        showMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());
    }
    
    
    public String Calculating(String type) {
    	mapBucketNoron.activatedNodeAlreadyKnown(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),arrayVarKnown,arrNameVariableInBoxRecipe);
        showMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size());
        /* ----- TODO : RUN TO SOLVE ----- */
        if (type.compareTo("normal") == 0) {
        	return mapBucketNoron.runAroundMatrixSpread(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),findResult,arrNameVariableInBoxRecipe,solveTheOperator,managerVariable);
        }
        return mapBucketNoron.runAroundMatrixSpreadFilterResult(matrixSpread,soluongBien,mapBucketNoron.mapNODE.size(),findResult,arrNameVariableInBoxRecipe,solveTheOperator,managerVariable);
    }
    
    
    
    
    
    
    
    
    
    
    
    /**************SUPPORT****************/
//    public  void inputVariable(String [] arrNameVariableInBoxRecipe){
//
//        Scanner o = new Scanner(System.in);
//        String nameVariable;
//        for (int i = 0 ; i < arrNameVariableInBoxRecipe.length ; i++){
//            System.out.print("Input Var : ");
//            nameVariable = o.nextLine();
//            arrNameVariableInBoxRecipe[i] = nameVariable;
//        }
//    }

    public  void firstInitMatrixSpread(int [][] matrixSpread, int height, int width){
        for (int i = 0 ; i < height ; i++){
            for (int j = 0 ; j < width ; j++){
                matrixSpread[i][j] = 0;
            }
        }
    }

    public  void showMatrixSpread(int [][] matrixSpread, int height, int width){
        for (int i = 0 ; i < height ;i++){
            for (int j = 0 ; j < width ; j++){
                System.out.print(matrixSpread[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
