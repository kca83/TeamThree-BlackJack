package io.zipcoder.teamthree.blackjack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CardTest.class,
        PlayerTest.class,
        GameTest.class,
        ConsoleTest.class,
        DeckTest.class
})
public class AllTestSuite {
}
