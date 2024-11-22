package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes(){
        /*
            RecipeFileHandlerクラスをインスタンス化し
            recipeFileHandler.readRecipes()メッソドを呼び出し、
            返ってきたArrayListの要素をカンマで区切る。
            その際、ArrayListにはレシピと具材が一緒に要素として入っているので
            レシピ名と具材を2分割し、配列に代入する。
         * for文でレシピを表示させる。
         */

        //
        fileHandler = new RecipeFileHandler();

        if(fileHandler.readRecipes().size() > 1){
            System.out.println("Recipes:");
            for(String recipes : fileHandler.readRecipes()){

                String[] recipe = recipes.split(",", 2);

                System.out.println("-----------------------------------");
                System.out.println("Recip Name: " + recipe[0]);

                for(int i = 1; i < recipe.length; i++){
                    System.out.println("Main Ingredients: " + recipe[i]);
                }
            }
        }else{
            System.out.println("No recipes available.");
        }
        
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        /* RecipeFileHandlerをインスタンス化する。
            レシピ、具材をユーザーから入力してもらう
            入力を受け付けたものを、recipeFileHandler.addRecipe()メソッドの引数に代入.
         *
         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RecipeFileHandler recipeFileHandler = new RecipeFileHandler();
        try{
            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine();

            System.out.print("Enter main ingredients (comma separated):");
            String ingredients = reader.readLine();

            recipeFileHandler.addRecipe(recipeName, ingredients);
            System.out.println("Recipe added successfully.");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        

    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {
        /* RecipeFileHandlerをインスタンス化する。
         *  recipeFileHandler.readRecipes()メッソドを呼び出し、
         * recipeリストを取得する。
         * ユーザーから入力をうけた検索クエリを受ける。
         * 受けた検索クエリとrecipeリストを照らし合わせて、
         * 一致するものを表示させる。
         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(null));
        System.out.println("Enter search query (e.g., 'name=Tomato&ingredient=Garlic'):");
        String serchQuery = reader.readLine();
        String[] queary = serchQuery.split("&");
       // String[] 
       // RecipeFileHandler recipeFileHandler = new RecipeFileHandler();
        /*  while (recipeFileHandler.readRecipes() != null) {

            for(String recipes : recipeFileHandler.readRecipes()){

                String[] recipe = recipes.split(",");


            }*/
            
        }
}



