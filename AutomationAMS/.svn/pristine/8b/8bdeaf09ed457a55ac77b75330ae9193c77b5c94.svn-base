/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.webdriver.qa.automation.ams.enums.PlayerSettings.Autoplay;
import com.webdriver.qa.automation.ams.enums.PlayerSettings.ContentType;
import com.webdriver.qa.automation.ams.enums.PlayerSettings.Size;
import com.webdriver.qa.automation.ams.objects.JWPlayerObject;
import com.webdriver.qa.automation.framework.page.BasePage;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: Jul 13, 2012
 *
 */
public class PermaLinkPage extends BasePage {

  /**
   * JWPlayer Wrapper #Object
   */
  @FindBy(id = "mediaplayer_wrapper")
  WebElement mediaPlayer_wrapper;

  /**
   * Parameters used in the creation of the jwplayer. Used for assertions in tests
   */
  @FindBy(name = "flashvars")
  WebElement player_flashvars;

  /**
   * The JWPlayer object helper
   */
  private JWPlayerObject jwplayer;

  /**
   * @param driver
   */
  public PermaLinkPage(WebDriver driver) {
    super(driver);
    jwplayer = new JWPlayerObject(driver);
  }

  /**
   * Compares expected results in parameters with actual player settings.
   *
   * @param type {@link ContentType}
   * @param autoplay {@link Autoplay}
   * @param size {@link Size}
   * @param height height when {@link Size#CUSTOM}
   * @param width width when {@link Size#CUSTOM}
   *
   * @throws Exception
   */
  public boolean validateSettings(ContentType type, Size size, Autoplay autoplay, String heigth, String width) throws Exception {
    // Validate Size & Content Type
    switch (type) {
    case AUDIO:
      validateSize(Integer.parseInt(width), Size.AUDIO.getHeight());
      break;
    case VIDEO:
      if (size == Size.CUSTOM) {
        validateSize(Integer.parseInt(width), Integer.parseInt(heigth));
      } else {
        validateSize(size.getWidth(), size.getHeight());
      }

      break;
    }

    // Validate Autoplay
    validateAutoplay(autoplay);
    return true;
  }

  /**
   * Validates autoplay function in permlink page
   *
   * @param autoplay {@link Autoplay}
   * @throws Exception
   */
  private void validateAutoplay(Autoplay autoplay) throws Exception {
    switch (autoplay) {
    case ON:
        if (!player_flashvars.getAttribute("value").contains("&autostart=true&")) {
          throw new Exception ("Could not validate Player Autoplay setting. Expected [ON] but got [OFF]");
        }
        // Player has autoplay on. State = BUFFERING || PLAYING
        jwplayer.assertStatePlaying();
      break;
    case OFF:
      if (!player_flashvars.getAttribute("value").contains("&autostart=false&")) {
        throw new Exception ("Could not validate Player Autoplay setting. Expected [OFF] but got [ON]");
      }
      // Player has autoplay on. State = IDLE
      jwplayer.assertStateIdle();
      break;
    }
  }

  /**
   * Validates size of player in permalink page
   *
   * @param size {@link Size}
   * @throws Exception
   */
  private void validateSize(int width, int height) throws Exception {
    String mediaPlayer_style = mediaPlayer_wrapper.getAttribute("style");
    if (!mediaPlayer_style.contains("width: " + width + "px; height: " + height + "px;")) {
      throw new Exception ("Could not validate Player Size. Expected \n" +
          "[width: " + width + "px; height: " + height + "px;]\nBut got\n" +
          "[" + mediaPlayer_style.substring(mediaPlayer_style.indexOf("width:")));
    }
  }

  /**
   * Verifies if user is in permalink page.
   *
   * @return
   */
  public boolean validateOnPermaLinkPage() throws Exception{
    if (!mediaPlayer_wrapper.isDisplayed()) {
      throw new Exception ("Could not validate being in the permalink page");
    }
    return true;
  }

}
