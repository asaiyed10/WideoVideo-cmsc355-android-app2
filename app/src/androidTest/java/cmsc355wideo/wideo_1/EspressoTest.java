package cmsc355wideo.wideo_1;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class EspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public EspressoTest(){
        super(MainActivity.class);
    }
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }
    public void testRecordButtonIsDisplayed(){
        onView(withId(R.id.button))
                .check(matches(isDisplayed()));
    }
    public void testGalleryButtonIsDisplayed(){
        onView(withId(R.id.button2))
                .check(matches(isDisplayed()));
    }
    public void testSettingsButtonIsDisplayed(){
        onView(withId(R.id.button3))
                .check(matches(isDisplayed()));
    }
    public void testFriendlistButtonIsDisplayed(){
        onView(withId(R.id.button5))
                .check(matches(isDisplayed()));
    }
    public void testQuitButtonIsDisplayed(){
        onView(withId(R.id.button4))
                .check(matches(isDisplayed()));
    }

    public void testSettingsButtonIsCorrectText() {
        onView(withId(R.id.button3))
                .check(matches(withText("Settings")));
    }

    public void testGalleryButtonIsCorrectText() {
        onView(withId(R.id.button2))
                .check(matches(withText("Gallery")));
    }

    public void testRecordIsCorrectText() {
        onView(withId(R.id.button))
                .check(matches(withText("")));
    }

    public void testFriendlistButtonIsCorrectText() {
        onView(withId(R.id.button5))
                .check(matches(withText("Friend List")));
    }

    public void testQuitButtonIsCorrectText() {
        onView(withId(R.id.button4))
                .check(matches(withText("Exit")));
    }


}
