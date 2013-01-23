/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.enums;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: 05/06/2012
 *
 * Hold the different settings for Player Configuration
 */
public class PlayerSettings {

  public enum ContentType {
    VIDEO,
    AUDIO;
  }

  public enum Size {
    CUSTOM(0, 0),
    AUDIO(0, 25),
    s400x325(400, 325),
    s320x265(320, 265),
    s240x205(240, 205);

    Size(int w, int h) {
      height = h;
      width = w;
    }

    private int height;
    private int width;

    public int getWidth() {
      return width;
    }

    public int getHeight() {
      return height;
    }
  }

  public enum Autoplay {
    ON,
    OFF;
  }
}
