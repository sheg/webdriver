/**
 * TODO
 * One class, one test.
 * No DSL
 * 
 */
package com.webdriver.qa.automation.ams.testcases.playlist;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.enums.PlaylistType;
import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.ams.pages.CreatePlaylistPage;
import com.webdriver.qa.automation.ams.pages.edit.EditPlaylistPage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

/**
 * @author bhutton(brianhutton@cinchcast.com)<br>
 * Created on: 03/06/2012<br>
 * 
 *         Test to successfully create a Manual Playlist
 */
public class TestAMSCreateSuccessfullManualPlaylist extends TestCase {

  /**
   * <b>Test</b><br>
   * Test to successfully create a Manual Playlist
   *
   * @throws Exception
   */
  @Test
  public void testCreateSuccessfullManualPlaylist() throws Exception {
    String username = m_config.getValue("username");
    String password = m_config.getValue("password");

    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    loginPage.inputLoginCredentials(username, password);
    DashboardPage dashboardPage = loginPage.clickSignIn();
    dashboardPage.validateLoggedIn(username);
    CreatePlaylistPage playlistPage = dashboardPage.clickNewPlaylistButton();

    // Get data from config file to create playlist
    PlaylistType type = m_config.getValue("type").equals("dynamic") ?
        PlaylistType.DYNAMIC : PlaylistType.MANUAL;
    int size = Integer.parseInt(m_config.getValue("size"));
    String title = m_config.getValue("title").isEmpty() ?
        "Title" + System.currentTimeMillis() : m_config.getValue("title");
    String description = m_config.getValue("description");
    String category = m_config.getValue("category");
    String shortDescription = m_config.getValue("shortDescription");

    // Fill form to create Playlist
    playlistPage.setPlaylistType(type);
    String[] content = playlistPage.getManualPlaylistContent(size);
    playlistPage.inputTitle(title);
    playlistPage.inputLongDescription(description);
    playlistPage.selectCategory(category);
    playlistPage.setShortDescriptionCustom();
    playlistPage.inputShortDescription(shortDescription);

    // Save playlist
    EditPlaylistPage editPlaylistPage = playlistPage.savePlaylist();
    editPlaylistPage.confirmCreationOfPlaylist();
    editPlaylistPage.validateOnEditPlaylistPage();
    // Validate values for playlist after creation.
    editPlaylistPage.validateValuesForManualPlaylist(type, content, title, description, category,
        shortDescription);
  }
}
