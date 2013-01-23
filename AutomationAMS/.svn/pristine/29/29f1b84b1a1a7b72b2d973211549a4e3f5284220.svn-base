/**
 * TODO
 * Select individual content
 * Check added content
 * Upload preview image
 */
package com.webdriver.qa.automation.ams.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webdriver.qa.automation.ams.enums.PlaylistType;
import com.webdriver.qa.automation.ams.enums.SearchConfig;
import com.webdriver.qa.automation.ams.pages.edit.EditPlaylistPage;
import com.webdriver.qa.automation.framework.page.BasePage;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: 03/06/2012
 *
 * Java Page Object for the Create Playlist Page.
 * This Java class contains all identifiers available to the user in the Create
 * Playlist page along with methods to mimic user interaction.
 * Behaving as a DSL, methods return themselves, save for the actions that
 * would place the user in a different page, returning said page's object
 * instead.
 */
public class CreatePlaylistPage extends BasePage
{
  /**
   * Title #WebElement.
   */
  @FindBy(css = ".box-header")
  private WebElement playlist_header;

  /**
   * Create Dynamic Playlist #RadioButton
   */
  @FindBy(xpath = "//label[2]")
  private WebElement create_dynamic_playlist;

  /**
   * Create Manual Playlist #RadioButton
   */
  @FindBy(xpath = "//label")
  private WebElement create_manual_playlist;

  private boolean is_playlist_dynamic_flag = false;

  /**
   * Playlist Title #TextField
   */
  @FindBy(id = "Playlist_Name")
  private WebElement title_textField;

  /**
   * Save Playlist #SubmitButton
   */
  @FindBy(id = "aSavePlaylist")
  private WebElement save_playlist;

  /**
   * Search Config #Button
   */
  @FindBy(css = "button-search-config")
  private WebElement search_config_button;

  /**
   * Search Config #Option: Everything
   */
  @FindBy(id = "cb-search-everything")
  private WebElement search_option_everything;

  /**
   * Search Config #Option: Title
   */
  @FindBy(id = "cb-search-title")
  private WebElement search_option_title;

  /**
   * Search Config #Option: Description
   */
  @FindBy(id = "cb-search-description")
  private WebElement search_option_description;

  /**
   * Search Config #Option: Tags
   */
  @FindBy(id = "cb-search-tags")
  private WebElement search_option_tags;

  /**
   * Search Config #Option: Category
   */
  @FindBy(id = "cb-search-category")
  private WebElement search_option_category;

  /**
   * Search Playlist Content #TextField
   */
  @FindBy(id = "search-term-textbox")
  private WebElement search_textField;

  /**
   * Search Submit #Button
   */
  @FindBy(css = "btn submit")
  private WebElement search_submit;

  /**
   * Done Adding Content To Manual Playlist #Button
   */
  @FindBy(id = "close-content")
  private WebElement done;

  /**
   * Add All Content to Dynamic Playlist #CheckBox
   */
  @FindBy(id = "chkAllItems")
  private WebElement dynamic_all_items;

  /**
   * Include Hidden Content In Dynamic Playlist #RadioButton
   */
  @FindBy(xpath = "//div[3]/div/label[2]")
  private WebElement include_hidden;

  /**
   * Exclude Hidden Content InDynamic Playlist #RadioButton
   */
  @FindBy(xpath = "//div[3]/div/label")
  private WebElement exclude_hidden;

  /**
   * Increase Dynamic Playlist Size by 1 #Button
   */
  @FindBy(css = "a.btn.step-up")
  private WebElement dynamic_increase_size;

  /**
   * Decrease Dynamic Playlist Size by 1 #Button
   */
  @FindBy(css = "a.btn.step-down")
  private WebElement dynamic_decrease_size;

  /**
   * Indicator of how many items will be available in the Dynamic Playlist #TextField
   */
  @FindBy(id = "playlist-count")
  private WebElement playlist_count;

  /**
   * Long Description Rich Text Area #iFrame
   */
  @FindBy(id = "Playlist_LongDescription_ifr")
  private WebElement longDescription_frame;

  /**
   * Playlist Category DropDown #Selector
   */
  @FindBy(id = "Playlist_Category_CategoryID")
  private WebElement category_selector;

  /**
   * Playlist Tags #TextField
   */
  @FindBy(id = "text-tags")
  private WebElement tags_textField;

  /**
   * Custom Short Description #RadioButton
   */
  @FindBy(xpath = "//fieldset[@id='additional-info-tab']/blockquote[3]/div/label[2]")
  private WebElement shortDescription_custom;

  /**
   * Copy Short Description From Long Description #RadioButton
   */
  @FindBy(xpath = "//fieldset[@id='additional-info-tab']/blockquote[3]/div/label")
  private WebElement shortDescription_copyFromLongDesc;

  /**
   * Playlist Short Description #TextArea
   */
  @FindBy(id = "Playlist_ShortDescription")
  private WebElement shortDescription_textField;

  /**
   * Cancel Creation Of Playlist #Button
   */
  @FindBy(linkText = "cancel")
  private WebElement cancel;

  /**
   * Parent's constructor
   * 
   * @param driver WebDriver's driver to use as browser
   */
  public CreatePlaylistPage(WebDriver driver)
  {
    super(driver);
    is_playlist_dynamic_flag = false;
  }

  /**
   * Set the playlist as Dynamic or Manual.<br>
   * #DefaultValue is Manual<br>
   *
   * @return {@link CreatePlaylistPage}
   */
  public void setPlaylistType(PlaylistType type)
  {
    switch(type) {
    case MANUAL:
      create_manual_playlist.click();
      is_playlist_dynamic_flag = false;
      break;
    case DYNAMIC:
      create_dynamic_playlist.click();
      is_playlist_dynamic_flag = true;
      break;
    }
  }

  /**
   * Restrict the search to certain field represented by enum {@link SearchConfig}.<br>
   * #DefaultValue is Everything<br>
   * Only for Manual Playlists. See {@link #setAsManual()}
   * @param option An enum in {@link SearchConfig}
   *
   * @return {@link CreatePlaylistPage}
   */
  public void configSearch(SearchConfig option)
  {
    // Open search-config drop down
    search_config_button.click();
    switch(option)
    {
    case EVERYTHING:
      search_option_everything.click();
      break;
    case TITLE:
      search_option_title.click();
      break;
    case DESCRIPTION:
      search_option_description.click();
      break;
    case TAGS:
      search_option_tags.click();
      break;
    case CATEGORY:
      search_option_category.click();
      break;
    }
    // Close search-config drop down
    search_config_button.click();
  }

  /**
   * Searches the content displayed for the given text.<br>
   * Only for Manual Playlists. See {@link #setAsManual()}
   *
   * @param text The text to search for
   * @return {@link CreatePlaylistPage}
   */
  public void searchPlaylistContent(String text)
  {
    search_textField.sendKeys(text);
    search_submit.click();
  }

  /**
   * Adds content to Playlist.<br>
   * Only for Manual Playlists. See {@link #setAsManual()}<br>
   * <b> Missing implementation.</b>
   *
   * @return {@link CreatePlaylistPage}
   */
  public void addContentManually()
  {
    //TODO(bhutton): Add implementation
    done.click();
  }

  /**
   * Increases the size of dynamic Playlists by 1.<br>
   * #DefaultValue is 3.<br>
   * Only for Dynamic Playlists. See {@link #setPlaylistType()}
   *
   * @return {@link CreatePlaylistPage}
   */
  public void increaseDynamicPlaylistLength()
  {
    dynamic_increase_size.click();
  }

  /**
   * Decreases the size of dynamic Playlists by 1.<br>
   * #DefaultValue is 3.<br>
   * Only for Dynamic Playlists. See {@link #setPlaylistType()}
   *
   * @return {@link CreatePlaylistPage}
   */
  public void decreaseDynamicPlaylistLength()
  {
    dynamic_decrease_size.click();
  }

  /**
   * Increases the Dynamic Playlist size to include all available content.<br>
   * #DefauktValue is off<br>
   * Only for Dynamic Playlists. See {@link #setPlaylistType()}
   *
   * @return {@link CreatePlaylistPage}
   */
  public void includeAllItemsInDynamicPlaylist()
  {
    dynamic_all_items.click();
  }

  /**
   * Determines if the Dynamic Playlist can include hidden content or not.<br>
   * #DefaultValue is <b><code>false</code></b><br>
   * Only for Dynamic Playlists. See {@link #setPlaylistType()}
   *
   * @param showHiddenContent Boolean:
   *    <ul> 
   *      <li><code>true</code> to include hidden content.
   *      <li><code>false</code> to exclude hidden content.
   *    </ul>
   * @return {@link CreatePlaylistPage}
   */
  public void includeHiddenInDynamicPlaylist(boolean showHiddenContent)
  {
    if (showHiddenContent)
    {
      include_hidden.click();
    } else 
    {
      exclude_hidden.click();
    }
  }

  /**
   * Sets a Title to the Playlist.<br>
   * <b>#mandatoryField</b>.
   *
   * @param title The text to input as title
   * @return {@link CreatePlaylistPage}
   */
  public void inputTitle(String title)
  {
    title_textField.clear();
    title_textField.sendKeys(title);
  }

  /**
   * Sets a description to the Playlist.<br>
   * <b>#mandatoryField</b>.
   *
   * @param text Text to input as description
   * @return {@link CreatePlaylistPage}
   */
  public void inputLongDescription(String text)
  {
    // LongDescription text area is a rich text area created from tinyMCE.
    // Only way for WebDriver to be able to write in field is to access
    // the iFrame of tinyMCE and writing directly to the innerHTML
    // of the body
    try
    {
      // Use the browser's driver to access the iFrame of tinyMCE
      getDriver().switchTo().frame(longDescription_frame);
      // Use JSExecuter to write to the innerHTML of the body.
      // TODO(bhutton): Need to test with other Drivers. Works for FF.
      ((JavascriptExecutor) getDriver()).executeScript("document.body.innerHTML = '" + text + "'");
    } finally
    {
      // Switch focus back to main frame to continue with test.
      getDriver().switchTo().defaultContent();
    }
  }

  /**
   * Sets a preview image to the Playlist.<br>
   * <b> Missing implementation.</b>
   *
   * @return {@link CreatePlaylistPage}
   */
  public void setPreviewImage()
  {
    //TODO(bhutton): Add implementation
  }

  /**
   * A list of comma-separated-tags to set to the playlist.<br>
   * #DefaultValue is <b>empty</b>.
   *
   * @param tags A string of tags to set to the Playlist. Comma separated.
   * @return {@link CreatePlaylistPage}
   */
  public void withTags(String tags)
  {
    tags_textField.clear();
    tags_textField.sendKeys(tags);
  }

  /**
   * Sets the category which the Playlist will be created under with an enum
   * from {@link ContentCategory}.<br>
   * #DefaultValue is <b>No Category</b>.<br>
   *
   * @param category The category to create the playlist with. See {@link ContentCategory}
   * @return {@link CreatePlaylistPage}
   */
  public void selectCategory(String category)
  {
    final Select select = new Select(category_selector);
    select.selectByVisibleText(category);
  }

  /**
   * Sets the Playlist to a Custom Short Description.<br>
   * User must enter the Short Description.<br>
   * #DefaultValue is <b>Copy from Description</b>
   *
   * @return {@link CreatePlaylistPage}
   */
  public void setShortDescriptionCustom()
  {
    shortDescription_custom.click();
  }

  /**
   * Sets the Playlist to Copy Short Description from Long Description.<br>
   * User can't enter the Short Description.<br>
   * (#DefaultValue)
   *
   * @return {@link CreatePlaylistPage}
   */
  public void setShortDescriptionFromLongDescription()
  {
    shortDescription_copyFromLongDesc.click();
  }

  /**
   * Sets the short description to the provided text.<br>
   * Only for Custom Short Descriptions. See {@link #setShortDescriptionCustom()}<br>
   * <b>Mandatory field</b>
   *
   * @param text The text to input as short description.
   * @return {@link CreatePlaylistPage}
   */
  public void inputShortDescription(String text)
  {
    shortDescription_textField.clear();
    shortDescription_textField.sendKeys(text);
  }

  /**
   * Saves the playlist with current parameters.<br>
   * Returns the user to the {@link CreatePlaylistPage} in <b>Edit</b> Mode
   * if successful
   *
   * @return {@link CreatePlaylistPage}
   */
  public EditPlaylistPage savePlaylist()
  {
    save_playlist.click();
    return PageFactory.initElements(getDriver(), EditPlaylistPage.class);
  }

  /**
   * Cancels the creation of the playlist.<br>
   * A message pops up for confirmation.<br>
   * <b>Missing Implementation</b>: Missing pop up handler.
   *
   * @return redirects to ArchiveContentPage
   */
  public /*ArchiveContentPage*/void  cancelPlaylist()
  {
    cancel.click();
    // TODO(bhutton): Add "accept" or "cancel" to pop-up message after clicking cancel button.
    //return PageFactory.initElement(getDriver(), ArchiveContentPage.class);
  }

  /**
   * Validates if user is on Create Playlist Page
   *
   * @return Boolean:
   * <ul>
   *  <li><code>true</code> if Page header is "New Playlist"
   *  <li><code>false</code> otherwise
   * </ul>
   * @throws Exception When not in Create Playlist Page
   */
  public boolean validateOnCreatePlaylistPage() throws Exception
  {
    if (!playlist_header.getText().trim().equals("New Playlist"))
    {
      throw new Exception("Could not validate being on the new playlist page");
    }
    return true;
  }

  /**
   * 
   * @param type
   * @param title
   * @param description
   * @param category
   * @param shortDescription
   */
  public void fillOutDynamicPlaylistForm(PlaylistType type, int size, boolean includeHidden, String title, String description,
      String category, String shortDescription) {
    setPlaylistType(type);
    setSize(size);
    includeHiddenInDynamicPlaylist(includeHidden);
    inputTitle(title);
    inputLongDescription(description);
    selectCategory(category);
    setShortDescriptionCustom();
    inputShortDescription(shortDescription);
  }

  /**
   * 
   * @param type
   * @param title
   * @param description
   * @param category
   * @param shortDescription
   */
  public void fillOutPlaylistForm(PlaylistType type, int size, boolean includeHidden, String title, String description,
      String category) {
    setPlaylistType(type);
    setSize(size);
    includeHiddenInDynamicPlaylist(includeHidden);
    inputTitle(title);
    inputLongDescription(description);
    selectCategory(category);
    setShortDescriptionFromLongDescription();
  }

  /**
   * @param size
   */
  private void setSize(int size) {
    // Dynamic playlist. Sets the size.
    if (is_playlist_dynamic_flag) {
      int defaultSize = Integer.parseInt(playlist_count.getAttribute("value"));
      int targetSize = size - defaultSize;
      if (size == 0) {
        includeAllItemsInDynamicPlaylist();
      } else if (targetSize > 0) {
        for (int i = 0; i < targetSize; i++) {
          increaseDynamicPlaylistLength();
        }
      } else if (targetSize < 0) {
        targetSize *= (-1);
        for (int i = 0; i < targetSize; i++) {
          decreaseDynamicPlaylistLength();
        }
      }
    }
  }

  public String[] getManualPlaylistContent(int size) {
    String[] content = new String[size];
    for (int i = 1; i <= size; i++) {
      getDriver().findElement(By.xpath("//li[" + i + "]/span[6]/a")).click();
      content[i - 1] = getDriver().findElement(By.xpath("//li[" + i + "]/span[2]")).getText();
    }

    return content;
  }
}
