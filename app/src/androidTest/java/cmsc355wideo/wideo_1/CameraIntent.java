package cmsc355wideo.wideo_1;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by mantvu on 10/9/2016.
 */

public class CameraIntent {
    @Rule
    public IntentsTestRule<MainActivity> mainActivityRule = new IntentsTestRule<>(MainActivity.class);
    @Test
    public void cameraVerify(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.camera_preview)).check(matches(isDisplayed()));
    }
    @Test
    public void cameraIntentTest(){
        onView(withId(R.id.button)).perform(click());
        intended(toPackage("cmsc355wideo.wideo_1"));
    }

}
