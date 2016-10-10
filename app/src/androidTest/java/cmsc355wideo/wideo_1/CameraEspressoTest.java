package cmsc355wideo.wideo_1;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static cmsc355wideo.wideo_1.R.drawable.record_default;
import static cmsc355wideo.wideo_1.R.drawable.recordbutton;

/**
 * Created by mantvu on 10/9/2016.
 */

public class CameraEspressoTest extends ActivityInstrumentationTestCase2<CameraActivity> {
    public CameraEspressoTest(){
        super(CameraActivity.class);
    }
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }
    public void testCameraPreviewIsDisplayed(){
        onView(withId(R.id.camera_preview))
                .check(matches(isDisplayed()));
    }
    public void testCaptureButtonIsDisplayed(){
        onView(withId(R.id.button_capture))
                .check(matches(isDisplayed()));
    }

}
