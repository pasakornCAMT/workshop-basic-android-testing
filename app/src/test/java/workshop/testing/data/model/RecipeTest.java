package workshop.testing.data.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by CAMT on 17/4/2561.
 */
public class RecipeTest {
    InputStream inputStream;
    Recipe recipe;

    @Test
    public void readAll(){
        //Arrange
        inputStream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");

        //Action
        recipe = Recipe.readFromStream(inputStream);

        //Assert
        assertNotNull(recipe);
        assertEquals("water",recipe.id);
        assertEquals("Water",recipe.title);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.",recipe.description);

        //Arrange
        inputStream = RecipeTest.class.getResourceAsStream("/recipes/mixed.txt");

        //Action
        recipe = Recipe.readFromStream(inputStream);

        //Assert
        assertNotNull(recipe);
        assertEquals("punch",recipe.id);
        assertEquals("Punch",recipe.title);
        assertEquals("Juice of 3 lemons\n" +
                "1 orange\n" +
                "1 pint grape juice\n" +
                "1 cup sugar\n" +
                "1 cup water\n" +
                "1 pine apple juice\n" +
                "Mix all together and strain. Add large piece of ice.",recipe.description);

        //Arrange
        inputStream = RecipeTest.class.getResourceAsStream("/recipes/no_id.txt");

        //Action
        recipe = Recipe.readFromStream(inputStream);

        //Assert
        assertNotNull(recipe);
        assertEquals(null,recipe.id);
        assertEquals("Water",recipe.title);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.",recipe.description);

        //Arrange
        inputStream = RecipeTest.class.getResourceAsStream("/recipes/empty.txt");

        //Action
        recipe = Recipe.readFromStream(inputStream);

        //Assert
        assertNotNull(recipe);
        assertEquals("empty",recipe.id);
        assertEquals("Empty",recipe.title);
    }
}