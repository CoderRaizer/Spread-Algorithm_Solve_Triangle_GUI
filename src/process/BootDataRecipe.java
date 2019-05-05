package process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BootDataRecipe {

    private static final String FILENAME = "D:\\zFile\\recipe.txt";
    ArrayList<String> listBoxRecipe;
    public ArrayList<String> listVariableInBoxRecipe;

    public BootDataRecipe(){
        listBoxRecipe = new ArrayList<>();
        listVariableInBoxRecipe = new ArrayList<>();
    }//End
    
    

    public ArrayList<String> getListBoxRecipe() {
		return listBoxRecipe;
	}



	public void setListBoxRecipe(ArrayList<String> listBoxRecipe) {
		this.listBoxRecipe = listBoxRecipe;
	}



	public ArrayList<String> getListVariableInBoxRecipe() {
		return listVariableInBoxRecipe;
	}



	public void setListVariableInBoxRecipe(ArrayList<String> listVariableInBoxRecipe) {
		this.listVariableInBoxRecipe = listVariableInBoxRecipe;
	}



	public void readDataRecipe(){

        BufferedReader br = null;
        FileReader fr = null;
        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                listBoxRecipe.add(currentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//End

    public boolean checkIsExistInListVariableBoxRecipe(ArrayList<String> listVariableInBoxRecipe , String operator){
        for (String member : listVariableInBoxRecipe){
            if (member.compareTo(operator) == 0){
                return true;
            }
        }
        return false;
    }//End

    public void pushDataToMapNode(MapBucketNoron mapBucketNoron , SolveTheOperator solveTheOperator){

        for (String recipeBox : listBoxRecipe){

            String description = "";
            ArrayList<String> listOperator = new ArrayList<>();
            int startElementIndex = 0;
            for (int i = 0 ; i < recipeBox.length() ; i++){
                if(recipeBox.charAt(i) == ':'){
                    solveTheOperator.listRecipe.add(description);
                    startElementIndex = i+1;
                    break;
                } else {
                    description += Character.toString(recipeBox.charAt(i));
                }
            } // Have Description Recipe

            String op = "";
            for (int i = startElementIndex ; i < recipeBox.length() ; i++){

                if (i == (recipeBox.length()-1)){
                    op = "";
                    int j = i;
                    while(recipeBox.charAt(j) != ' '){
                        op += Character.toString(recipeBox.charAt(j));
                        j--;
                    }
                    StringBuffer stringBuffer = new StringBuffer(op);
                    op = stringBuffer.reverse().toString();
                    listOperator.add(op);
                    if (checkIsExistInListVariableBoxRecipe(listVariableInBoxRecipe,op) == false){
                        listVariableInBoxRecipe.add(op);
                    }

                }
                if (recipeBox.charAt(i) == ' '){
                    listOperator.add(op);
                    if (checkIsExistInListVariableBoxRecipe(listVariableInBoxRecipe,op) == false){
                        listVariableInBoxRecipe.add(op);
                    }
                    op="";
                } else {
                    op += Character.toString(recipeBox.charAt(i));
                }

            }// Have listOperator for Recipe

            // Boot to mapNODE
            mapBucketNoron.getDataRecipe(description,listOperator);
            listOperator.clear();
        }
    }//End

    public void showListRecipe(){
        for (String x : listBoxRecipe) System.out.println(x);
    }

}
