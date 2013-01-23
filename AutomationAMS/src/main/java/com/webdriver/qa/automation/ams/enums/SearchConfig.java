package com.webdriver.qa.automation.ams.enums;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: 04/06/2012
 *
 * Enum for representation of Search Configuration Option in drop down.
 */
public enum SearchConfig
{
  /**
   * Looks into all fields
   */
  EVERYTHING,
  /**
   * Looks for content in Title only.
   */
  TITLE,
  /**
   * Looks for content in Description only.
   */
  DESCRIPTION,
  /**
   * Looks for content in Tags only.
   */
  TAGS,
  /**
   * Looks for content in Category only.
   */
  CATEGORY;
}
