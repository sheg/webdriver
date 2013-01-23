/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: Jul 18, 2012
 *
 * Helper Class For JWPlayer. Contains methods to control the jwplayer in the page.
 */
public class JWPlayerObject {

  /**
   * JavaScript executor to fire the jwplayer methods
   */
  private JavascriptExecutor executor;

  /**
   * Constructor.
   *
   * @param driver WebDriver Element to use as executor for the JS functions
   */
  public JWPlayerObject(WebDriver driver) {
    executor = (JavascriptExecutor) driver;
  }

  /**
   * Asserts the state of the player is IDLE
   *
   * @return <code>TRUE</code> if the current state of the player matches the expected one.<br>
   *         <code>FALSE</code> if the current state of the player does not match the expected one. 
   * @throws InterruptedException 
   */
  public boolean assertStateIdle() throws InterruptedException {
    waitForPlayer();
    return executor.executeScript("return jwplayer().getState()").equals("IDLE");
  }

  /**
   * Asserts the state of the player is BUFFERING or PLAYING.
   *
   * @return <code>TRUE</code> if the current state of the player matches the expected one.<br>
   *         <code>FALSE</code> if the current state of the player does not match the expected one. 
   * @throws InterruptedException 
   */
  public boolean assertStatePlaying() throws InterruptedException {
    waitForPlayer();
    return executor.executeScript("return jwplayer().getState()").equals("BUFFERING") ||
           executor.executeScript("return jwplayer().getState()").equals("PLAYING");
  }

  /**
   * Returns the current state of the jwplayer. Can be:<br>
   * <code>IDLE</code><br>
   * <code>BUFFERING</code><br>
   * <code>PLAYING</code><br>
   * <code>PAUSED</code><br>
   *
   * @return
   * @throws InterruptedException 
   */
  public String getState() throws InterruptedException {
    waitForPlayer();
    return (String) executor.executeScript("return jwplayer().getState()");
  }

  /**
   * Wait for the jwplayer to load on the page.<br> Timeout: 30 seconds<br>Polls every 5 seconds
   *
   * @throws InterruptedException 
   */
  private boolean waitForPlayer() throws InterruptedException {
    Wait<JavascriptExecutor> wait = new FluentWait<JavascriptExecutor>(executor)
        .withTimeout(30, TimeUnit.SECONDS)
        .pollingEvery(5, TimeUnit.SECONDS)
        .ignoring(NullPointerException.class);

    boolean isPlayerLoaded = wait.until(new Function<JavascriptExecutor, Boolean>() {
      public Boolean apply(JavascriptExecutor executor) {
        return executor.executeScript("return jwplayer().getState()") != null;
      }
    }); 
    return isPlayerLoaded;
  }
}
