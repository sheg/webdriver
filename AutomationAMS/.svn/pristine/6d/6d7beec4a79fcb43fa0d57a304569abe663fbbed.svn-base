/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.testcases.playlist;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.enums.PlaylistType;
import com.webdriver.qa.automation.ams.pages.CreatePlaylistPage;
import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.ams.pages.edit.EditPlaylistPage;
import com.webdriver.qa.automation.ams.pages.manage.PlaylistContentPage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

/**
 * @author bhutton(brianhutton@cinchcast.com)<br>
 * Created on: 06/06/2012<br>
 *
 *    Test to successfully create a Dynamic Playlist
 */
public class TestAMSDeleteSuccessfullDynamicPlaylist extends TestCase {

  /**
   * <b>Test</b><br>
   * Test to successfully delete a Dynamic Playlist
   *
   * @throws Exception
   */
  @Test
  public void testSuccessfullyDeleteDynamicPlaylist() throws Exception {

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
    boolean includeHidden = Boolean.valueOf(m_config.getValue("includeHidden"));
    String title = m_config.getValue("title").isEmpty() ?
        "Title" + System.currentTimeMillis() : m_config.getValue("title");
    String description = m_config.getValue("description");
    String category = m_config.getValue("category");
    String shortDescription = m_config.getValue("shortDescription");

    // Fill form to create Playlist
    playlistPage.fillOutDynamicPlaylistForm(type, size, includeHidden, title, description, category,
        shortDescription);

    // Save playlist
    EditPlaylistPage editPlaylistPage = playlistPage.savePlaylist();
    editPlaylistPage.confirmCreationOfPlaylist();
    editPlaylistPage.validateOnEditPlaylistPage();
    // Validate values for playlist after creation.
    editPlaylistPage.validateValuesForDynamicPlaylist(type, size, includeHidden, title, description, category, shortDescription);
    // Delete playlist
    PlaylistContentPage playlistContentPage = editPlaylistPage.deletePlaylist(title);
    // Verify playlist was deleted
    playlistContentPage.verifyPlaylistHasBeenDeleted(title);
  }
}
