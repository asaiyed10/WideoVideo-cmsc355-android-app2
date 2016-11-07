package cmsc355Wideo.Wideo;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cmsc355Wideo.Wideo.MainActivity;
import cmsc355Wideo.Wideo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button3), withText("Settings"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.buttonq),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.buttonf),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.buttons),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.buttonv),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(
                allOf(withId(R.id.buttona),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withText("Settings"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Settings")));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.buttonf), withText("flash"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.buttona), withText("about us"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.buttona), withText("about us"), isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.buttonv), withText("voice recognition"), isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.buttons), withText("storage"), isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.buttonq), withText("quality"), isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction button6 = onView(
                allOf(withId(R.id.button720),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(ViewGroup.class),
                                        1),
                                0),
                        isDisplayed()));
        button6.check(matches(isDisplayed()));

        ViewInteraction button7 = onView(
                allOf(withId(R.id.button1080),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(ViewGroup.class),
                                        1),
                                1),
                        isDisplayed()));
        button7.check(matches(isDisplayed()));

        ViewInteraction button8 = onView(
                allOf(withId(R.id.button4k),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(ViewGroup.class),
                                        1),
                                2),
                        isDisplayed()));
        button8.check(matches(isDisplayed()));

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.button720), withText("720"), isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.button1080), withText("1080"), isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.button4k), withText("4K"), isDisplayed()));
        appCompatButton12.perform(click());

        pressBack();

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.buttonf), withText("flash"), isDisplayed()));
        appCompatButton13.perform(click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton14.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(com.android.internal.R.id.list_container),
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0)),
                        0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withText("Choose a contact"),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(ViewGroup.class),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(FrameLayout.class),
                                                0)),
                                2),
                        isDisplayed()));
        textView2.check(matches(withText("Choose a contact")));

        ViewInteraction textView3 = onView(
                allOf(withId(com.android.contacts.R.id.menu_search), withContentDescription("Search"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(ViewGroup.class),
                                        3),
                                0),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(ViewGroup.class),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton2.check(matches(isDisplayed()));

        ViewInteraction linearLayout = onView(
                allOf(withId(com.android.documentsui.R.id.content),
                        childAtPosition(
                                allOf(withId(android.R.id.empty),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(com.android.documentsui.R.id.menu_list), withContentDescription("List view"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.android.documentsui.R.id.toolbar),
                                        2),
                                0),
                        isDisplayed()));
        textView4.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withText("Recent"),
                        childAtPosition(
                                allOf(withId(com.android.documentsui.R.id.toolbar),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(LinearLayout.class),
                                                0)),
                                1),
                        isDisplayed()));
        textView5.check(matches(withText("Recent")));

        ViewInteraction imageButton3 = onView(
                allOf(withContentDescription("Show roots"),
                        childAtPosition(
                                allOf(withId(com.android.documentsui.R.id.toolbar),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton3.check(matches(isDisplayed()));

        ViewInteraction imageButton4 = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.android.documentsui.R.id.toolbar),
                                        2),
                                2),
                        isDisplayed()));
        imageButton4.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(
                allOf(withId(android.R.id.title), withText("Gallery"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView6.check(matches(withText("Gallery")));

        ViewInteraction textView7 = onView(
                allOf(withId(android.R.id.title), withText("SDCARD"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("SDCARD")));

        ViewInteraction textView8 = onView(
                allOf(withId(android.R.id.title), withText("Downloads"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView8.check(matches(withText("Downloads")));

        ViewInteraction textView9 = onView(
                allOf(withId(android.R.id.title), withText("Recent"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView9.check(matches(withText("Recent")));

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(com.android.documentsui.R.id.roots_list),
                                childAtPosition(
                                        withId(com.android.documentsui.R.id.container_roots),
                                        0)),
                        2),
                        isDisplayed()));
        linearLayout2.check(matches(isDisplayed()));

        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(com.android.documentsui.R.id.roots_list),
                                childAtPosition(
                                        withId(com.android.documentsui.R.id.container_roots),
                                        0)),
                        3),
                        isDisplayed()));
        linearLayout3.check(matches(isDisplayed()));

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(com.android.documentsui.R.id.roots_list),
                                childAtPosition(
                                        withId(com.android.documentsui.R.id.container_roots),
                                        0)),
                        5),
                        isDisplayed()));
        linearLayout4.check(matches(isDisplayed()));

        ViewInteraction linearLayout5 = onView(
                allOf(childAtPosition(
                        allOf(withId(com.android.documentsui.R.id.roots_list),
                                childAtPosition(
                                        withId(com.android.documentsui.R.id.container_roots),
                                        0)),
                        5),
                        isDisplayed()));
        linearLayout5.check(matches(isDisplayed()));

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
}
