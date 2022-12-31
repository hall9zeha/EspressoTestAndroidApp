package com.barryzeha.couponsapp.mainModule.view


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.barryzeha.couponsapp.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
/*
* Esta clase de testing fue generada con el asistente pata test de android
* desde el menu. Build -> Record Expresso Test
* */
@LargeTest
@RunWith(AndroidJUnit4::class)
class TestGeneratedWithAssistant {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testGeneratedWithAssistant() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(500)

        val textInputEditText = onView(
            allOf(
                withId(R.id.edtConsult), withContentDescription("Consultar cupón"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilConsult),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(click())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.edtConsult), withContentDescription("Consultar cupón"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilConsult),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("Test01"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.btnConsult), withText("Consultar"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.edtConsult),
                withText("Test01"),
                withContentDescription("Consultar cupón"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilConsult),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(click())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.edtConsult),
                withText("Test01"),
                withContentDescription("Consultar cupón"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilConsult),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(replaceText("Cupon18"))//cambiar cada vez que se requiera probar con un nuevo cupón a guardar

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.edtConsult),
                withText("Cupon18"),//cambiar el valor de la cadena  para que sea igual al de la parte superior
                withContentDescription("Consultar cupón"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilConsult),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(closeSoftKeyboard())

        val textInputEditText6 = onView(
            allOf(
                withId(R.id.edtDescription), withContentDescription("descripción"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilDescription),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText6.perform(replaceText("Cupón test asistente"), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btnCreate), withText("Crear"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())
        //comprobamos que el mensaje de cupón guardado sea el devuelto
        val msgSnackbar = onView(withId(com.google.android.material.R.id.snackbar_text))
        msgSnackbar.check(matches(withText(R.string.save_coupon_msg)))

    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
