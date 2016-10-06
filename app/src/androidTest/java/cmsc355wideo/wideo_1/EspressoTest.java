package cmsc355wideo.wideo_1;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


public class EspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public EspressoTest() {
        super(MainActivity.class);
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void mainActivityTest() {
        testButtonsDisplay(matches(isDisplayed()), allOf(withId(R.id.button),
                childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        0),
                isDisplayed()), allOf(withId(R.id.button3),
                childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        2),
                isDisplayed()), allOf(withId(R.id.button5),
                childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        3),
                isDisplayed()), allOf(withId(R.id.button4),
                childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        4),
                isDisplayed()));


        testButtonsDisplay(doesNotExist(), allOf(withId(R.id.button3),
                childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        2),
                isDisplayed()), allOf(withId(R.id.button5),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                isDisplayed()), allOf(withId(R.id.button4),
                                childAtPosition(
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0),
                                        4),
                isDisplayed()), allOf(withId(R.id.button),
                childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        0),
                isDisplayed()));

        testTextBeingDisplayed();


        testPositioningOfGraphics();


    }

    private void testPositioningOfGraphics() {
        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.action_bar),
                        childAtPosition(
                                allOf(withId(R.id.action_bar_container),
                                        childAtPosition(
                                                withId(R.id.decor_content_parent),
                                                0)),
                                0),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction relativeLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.content),
                                childAtPosition(
                                        withId(R.id.decor_content_parent),
                                        1)),
                        0),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction relativeLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.content),
                                childAtPosition(
                                        withId(R.id.decor_content_parent),
                                        1)),
                        0),
                        isDisplayed()));
        relativeLayout2.check(doesNotExist());

        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.action_bar),
                        childAtPosition(
                                allOf(withId(R.id.action_bar_container),
                                        childAtPosition(
                                                withId(R.id.decor_content_parent),
                                                0)),
                                0),
                        isDisplayed()));
        viewGroup2.check(doesNotExist());
    }

    private void testTextBeingDisplayed() {
        ViewInteraction textView2 = onView(
                allOf(withText("Wideo-1"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Wideo-1")));

        ViewInteraction textView = onView(
                allOf(withId(R.id.my_group_name), withText("CMSC355 Wideo Group"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        textView.check(matches(withText("CMSC355 Wideo Group")));
        ViewInteraction textView3 = onView(
                allOf(withText("Wideo-1"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withText("Wideo-1"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView4.check(doesNotExist());
    }

    private void testButtonsDisplay(ViewAssertion matches, Matcher<View> viewMatcher2, Matcher<View> viewMatcher3, Matcher<View> viewMatcher4, Matcher<View> viewMatcher5) {
        ViewInteraction button = onView(
                allOf(withId(R.id.button2),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        button.check(matches);

        ViewInteraction button2 = onView(
                viewMatcher2);
        button2.check(matches);

        ViewInteraction button3 = onView(
                viewMatcher3);
        button3.check(matches);

        ViewInteraction button4 = onView(
                viewMatcher4);
        button4.check(matches);

        ViewInteraction button5 = onView(
                viewMatcher5);
        button5.check(matches);
    }
}