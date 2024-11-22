package data;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes()  {
        // recipe.txtからレシピを読み取り、
        // 読み取ったレシピをArrayListに一行づつ、追加していく処理。
        // 呼び出し元にArrayListを返す。
        // もし、不都合がおきれば、呼び出し元にエラー文を表示させる

        ArrayList<String> recipes = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath));) {

            if(reader.readLine() != null){
                String line;
                while((line = reader.readLine()) != null){
                    recipes.add(line);
                }
            }

            return recipes;
                
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }

        return null;
        
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
        /* 受け取ったレシピで上書きされないように、new FileWriterの第2引数にtureを渡す
         * そこから受け取ったレシピと材料をファイルに記述させる。
         * 
         */
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String newRecipe = recipeName + "," + ingredients;

            writer.write(newRecipe);
            writer.newLine();
        
        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
