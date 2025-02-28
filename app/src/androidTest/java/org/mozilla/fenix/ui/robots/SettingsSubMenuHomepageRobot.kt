package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.mozilla.fenix.R
import org.mozilla.fenix.helpers.click

/**
 * Implementation of Robot Pattern for the settings Homepage sub menu.
 */
class SettingsSubMenuHomepageRobot {

    fun verifyHomePageView() {
        assertMostVisitedTopSitesButton()
        assertJumpBackInButton()
        assertRecentBookmarksButton()
        assertRecentSearchesButton()
        assertPocketButton()
        assertOpeningScreenHeading()
        assertHomepageButton()
        assertLastTabButton()
        assertHomepageAfterFourHoursButton()
    }

    fun clickJumpBackInButton() = jumpBackInButton().click()
    fun clickRecentBookmarksButton() = recentBookmarksButton().click()
    fun clickStartOnHomepageButton() = homepageButton().click()
    fun clickStartOnLastTabButton() = lastTabButton().click()

    class Transition {

        fun goBack(interact: HomeScreenRobot.() -> Unit): HomeScreenRobot.Transition {
            goBackButton().click()

            HomeScreenRobot().interact()
            return HomeScreenRobot.Transition()
        }
    }
}

private fun mostVisitedTopSitesButton() =
    onView(allOf(withText(R.string.top_sites_toggle_top_recent_sites_3)))

private fun jumpBackInButton() =
    onView(allOf(withText(R.string.customize_toggle_jump_back_in)))

private fun recentBookmarksButton() =
    onView(allOf(withText(R.string.customize_toggle_recent_bookmarks)))

private fun recentSearchesButton() =
    onView(allOf(withText(R.string.customize_toggle_recent_searches)))

private fun pocketButton() =
    onView(allOf(withText(R.string.customize_toggle_pocket)))

private fun openingScreenHeading() = onView(withText(R.string.preferences_opening_screen))

private fun homepageButton() =
    onView(
        allOf(
            withId(R.id.title),
            withText(R.string.opening_screen_homepage),
            hasSibling(withId(R.id.radio_button))
        )
    )

private fun lastTabButton() =
    onView(
        allOf(
            withId(R.id.title),
            withText(R.string.opening_screen_last_tab),
            hasSibling(withId(R.id.radio_button))
        )
    )

private fun homepageAfterFourHoursButton() =
    onView(
        allOf(
            withId(R.id.title),
            withText(R.string.opening_screen_after_four_hours_of_inactivity),
            hasSibling(withId(R.id.radio_button))
        )
    )

private fun goBackButton() = onView(allOf(withContentDescription(R.string.action_bar_up_description)))

private fun assertMostVisitedTopSitesButton() =
    mostVisitedTopSitesButton().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertJumpBackInButton() =
    jumpBackInButton().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertRecentBookmarksButton() =
    recentBookmarksButton().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertRecentSearchesButton() =
    recentSearchesButton().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertPocketButton() =
    pocketButton().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertOpeningScreenHeading() =
    openingScreenHeading().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertHomepageButton() =
    homepageButton().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertLastTabButton() =
    lastTabButton().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertHomepageAfterFourHoursButton() =
    homepageAfterFourHoursButton().check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
