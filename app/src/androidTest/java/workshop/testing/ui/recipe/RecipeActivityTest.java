package workshop.testing.ui.recipe;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import workshop.testing.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import static workshop.testing.ui.recipe.RecipeActivity.KEY_ID;

/**
 * Created by CAMT on 17/4/2561.
 */
public class RecipeActivityTest {

    @Rule
    public ActivityTestRule<RecipeActivity> activity = new ActivityTestRule<>(RecipeActivity.class,true,false);

    @Test
    public void openActivityByDefaultShouldShowRecipeNotFound(){
        activity.launchActivity(new Intent());
        onView(withId(R.id.description))
                .check(matches(withText("Recipe not found.")));
    }

    @Test
    public void success(){
        Intent intent = new Intent();
        intent.putExtra(KEY_ID,"chocolate_pudding");
        activity.launchActivity(intent);

        onView(withId(R.id.title))
                .check(matches(withText("Chocolate Pudding")));
    }

}