package cmsc355wideo.wideo_1;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.System.exit;


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
}
