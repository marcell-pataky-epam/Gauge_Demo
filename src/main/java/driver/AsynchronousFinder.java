package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Used to find elements in a page that have been loaded asynchronously using Javascript. Causes the system under test
 * to wait until required element to be loaded into the DOM.
 */
public final class AsynchronousFinder {

    public static final long SLEEPTIME_1SEC = 1;
    public static final long TIMEOUT_10SEC = 10;

    public static final long DEFAULT_TIMEOUT = Long.parseLong(System.getenv("config.defaultWaitTimeout"));

    private static final int NUM_1000 = 1000;

    /**
     * Constructor.
     */
    private AsynchronousFinder() {
    }

    /**
     * Get the count of a given element.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return the count of found {@link WebElement}
     */
    public static int getCountOfElements(WebDriver driver, By finder) {
        int count;
        try {
            count = waitForElements(driver, finder, TIMEOUT_10SEC).size();
        } catch (AssertionError e) {
            count = 0;
        }
        return count;
    }

    /**
     * Get the count of a given element.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return the count of found {@link WebElement}
     */
    public static int getCountOfElements(WebDriver driver, By finder, long timeout) {
        int count;
        try {
            count = waitForElements(driver, finder, timeout).size();
        } catch (AssertionError e) {
            count = 0;
        }
        return count;
    }

    /**
     * Wait for the given element with the given linkText to be displayed.
     * @param driver the {@link WebDriver} object
     * @param linkText the link text of the {@link WebElement}
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElementDisplayedWithLinkText(WebDriver driver, String linkText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Check if an element is displayed.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return true if displayed
     */
    public static boolean isElementDisplayed(WebDriver driver, By finder) {
        boolean isDisplayed = false;
        try {
            isDisplayed = driver.findElement(finder).isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    /**
     * Check if an element is displayed (given by its parent).
     * @param parent the parent {@link WebElement}
     * @param finder the locator {@link By}
     * @return true if displayed
     */
    public static boolean isElementDisplayed(WebElement parent, By finder) {
        boolean isDisplayed = false;
        try {
            isDisplayed = parent.findElement(finder).isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    /**
     * Check if an element is enabled.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return true if enabled
     */
    public static boolean isElementEnabled(WebDriver driver, By finder) {
        boolean isEnabled = false;
        try {
            isEnabled = driver.findElement(finder).isEnabled();
        } catch (NoSuchElementException e) {
        }
        return isEnabled;
    }

    /**
     * Check if an element is presented.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return true if presented
     */
    public static boolean isElementPresent(WebDriver driver, By finder) {
        boolean isPresent = false;
        try {
            isPresent = driver.findElement(finder) != null;
        } catch (NoSuchElementException e) {
        }
        return isPresent;
    }

    /**
     * Check if an element is presented (given by its parent).
     * @param parent the parent {@link WebElement}
     * @param finder the locator {@link By}
     * @return true if presented
     */
    public static boolean isElementPresent(WebElement parent, By finder) {
        boolean isPresent = false;
        try {
            isPresent = parent.findElement(finder) != null;
        } catch (NoSuchElementException e) {
        }
        return isPresent;
    }

    /**
     * Check the presence of an element and wait for it.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return true if the {@link WebElement} presented.
     */
    public static boolean isElementPresentWithTimeout(WebDriver driver, By finder) {
        boolean isDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(finder));
            isDisplayed = true;
        } catch (Exception e) {
        }
        return isDisplayed;
    }

    /**
     * Check the presence of an element and wait for it.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return true if the {@link WebElement} presented.
     */
    public static boolean isElementPresentWithTimeout(WebDriver driver, By finder, long timeout) {
        boolean isDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(finder));
            isDisplayed = true;
        } catch (Exception e) {
        }
        return isDisplayed;
    }

    /**
     * Wait for the given element to be presented.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElement(WebDriver driver, By finder) {
        return waitForElement(driver, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given element to be presented.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElement(WebDriver driver, By finder, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.presenceOfElementLocated(finder));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given element to be presented (given by its parent).
     * @param driver the {@link WebDriver} object
     * @param parent the parent {@link WebElement}
     * @param finder the locator {@link By}
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElement(WebDriver driver, WebElement parent, By finder) {
        return waitForElement(driver, parent, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given element to be presented (given by its parent).
     * @param driver the {@link WebDriver} object
     * @param parent the parent {@link WebElement}
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElement(WebDriver driver, WebElement parent, By finder, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(finder));
            return parent.findElement(finder);
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given element to disappear.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return true if disappeared
     */
    public static boolean waitForElementDisappeared(WebDriver driver, By finder) {
        return waitForElementDisappeared(driver, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given element to disappear.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return true if disappeared
     */
    public static boolean waitForElementDisappeared(WebDriver driver, By finder, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(finder));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given element to be displayed.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElementDisplayed(WebDriver driver, By finder) {
        return waitForElementDisplayed(driver, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given element to be displayed.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElementDisplayed(WebDriver driver, By finder, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(finder));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given element to be displayed (given by its parent).
     * @param driver the {@link WebDriver} object
     * @param parent the parent {@link WebElement}
     * @param finder the locator {@link By}
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElementDisplayed(WebDriver driver, WebElement parent, By finder) {
        return waitForElementDisplayed(driver, parent, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given element to be displayed (given by its parent).
     * @param driver the {@link WebDriver} object
     * @param parent the parent {@link WebElement}
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElementDisplayed(WebDriver driver, WebElement parent, By finder,
                                                     long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(finder));
            return parent.findElement(finder);
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given element to be enabled.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     */
    public static WebElement waitForElementEnabled(WebDriver driver, By finder) {
        return waitForElementEnabled(driver, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given element to be enabled.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return the found {@link WebElement}
     */
    public static WebElement waitForElementEnabled(WebDriver driver, By finder, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementToBeClickable(finder));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given element to become hidden.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return true if hidden
     */
    public static boolean waitForElementHidden(WebDriver driver, By finder) {
        return waitForElementHidden(driver, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given element to become hidden.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return true if hidden
     */
    public static boolean waitForElementHidden(WebDriver driver, By finder, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(finder));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given element to be presented with a given text.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param text the text
     * @return true if presented
     */
    public static boolean waitForElementPresentWithText(WebDriver driver, By finder, String text) {
        return waitForElementPresentWithText(driver, finder, text, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given element to be presented with a given text.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @param text the text
     * @param timeout the timeout (in seconds)
     * @return true if presented
     */
    public static boolean waitForElementPresentWithText(WebDriver driver, By finder, String text,
                                                        long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(finder, text));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given elements to be presented.
     * @param driver the {@link WebDriver} object
     * @param finder {@link By} the locator
     * @return the {@link List} of found {@link WebElement}
     */
    public static List<WebElement> waitForElements(WebDriver driver, By finder) {
        return waitForElements(driver, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given elements to be presented.
     * @param driver the {@link WebDriver} object
     * @param finder {@link By} the locator
     * @param timeout the timeout (in seconds)
     * @return the {@link List} of found {@link WebElement}
     */
    public static List<WebElement> waitForElements(WebDriver driver, By finder, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(finder));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given elements to be presented (given by their parent).
     * @param driver the {@link WebDriver} object
     * @param parent the parent {@link WebElement}
     * @param finder the locator {@link By}
     * @return the {@link List} of found {@link WebElement}
     */
    public static List<WebElement> waitForElements(WebDriver driver, WebElement parent, By finder) {
        return waitForElements(driver, parent, finder, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for the given elements to be presented (given by their parent).
     * @param driver the {@link WebDriver} object
     * @param parent the parent {@link WebElement}
     * @param finder the locator {@link By}
     * @param timeout the timeout (in seconds)
     * @return the {@link List} of found {@link WebElement}
     */
    public static List<WebElement> waitForElements(WebDriver driver, WebElement parent, By finder,
                                                   long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(finder));
            return parent.findElements(finder);
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait for the given elements to be displayed.
     * @param driver the {@link WebDriver} object
     * @param finder the locator {@link By}
     * @return the {@link List} of found {@link WebElement}
     */
    public static List<WebElement> waitForElementsDisplayed(WebDriver driver, By finder) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(finder));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage());
        }
    }


    /**
     * Wait for the given time elapsed.
     * @param seconds time in seconds
     */
    public static void waitForTimeElapsed(long seconds) {
        try {
            Thread.sleep(seconds * NUM_1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for the given time elapsed.
     * @param seconds time in seconds float
     */
    public static void waitForTimeElapsed(float seconds) {
        long i = (long) (seconds * NUM_1000);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
        }
    }

}
