package com.college.converter;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testCurrencyConversion() {
        // Input amount to be converted
        String inputAmount = "100";

        // Expected result after conversion with the given CONVERSION_RATE = 0.80F
        // The format is specified in strings.xml as "%1$.2f Euros", so for 100 dollars,expect "80.00 Euros"
        String expectedResult = "80,00 Euros";

        // Perform type action on the input field
        onView(withId(R.id.entryId))
                .perform(typeText(inputAmount), closeSoftKeyboard());

        // Perform click action on the convert button
        onView(withId(R.id.convertButton)).perform(click());

        // Check if the result view contains the expected result
        onView(withId(R.id.resultId)).check(ViewAssertions.matches(withText(expectedResult)));
    }

}
