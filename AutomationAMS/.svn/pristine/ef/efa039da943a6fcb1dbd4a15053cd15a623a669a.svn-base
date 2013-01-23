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
import com.webdriver.qa.automation.ams.pages.CreatePlaylistPage;
import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.ams.pages.edit.EditPlaylistPage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

/**
 * @author bhutton(brianhutton@cinchcast.com)<br>
 * Created on: 03/06/2012<br>
 * 
 *         Test to successfully edit a Dynamic Playlist
 */
public class TestAMSEditSuccessfullManualPlaylist extends TestCase {

  /**
   * <b>Test</b><br>
   * Test to successfully edit a Dynamic Playlist
   *
   * @throws Exception
   */
  @Test
  public void testEditSuccessfullDynamicPlaylist() throws Exception {
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
    // TODO(bhutton): Implement a HashMap with an iterator to replace the long list of "if"s.
    String category = (m_config.getValue("category"));
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

    // Edit parameters
    type = m_config.getValue("type_edit").equals("dynamic") ?
        PlaylistType.DYNAMIC : PlaylistType.MANUAL;
    //TODO(bhutton): Impleemnt content removal or addition
    //size = Integer.parseInt(m_config.getValue("size_edit"));
    title = m_config.getValue("title_edit").isEmpty() ?
        "Title" + System.currentTimeMillis() : m_config.getValue("title_edit");
    description = m_config.getValue("description");
    category = (m_config.getValue("category_edit"));
    shortDescription = m_config.getValue("shortDescription_edit");

    // Edit values
    playlistPage.setPlaylistType(type);
    //String[] content_edited = playlistPage.getManualPlaylistContent(size);
    playlistPage.inputTitle(title);
    playlistPage.inputLongDescription(description);
    playlistPage.selectCategory(category);
    playlistPage.setShortDescriptionCustom();
    playlistPage.inputShortDescription(shortDescription);

    // Save playlist
    editPlaylistPage = playlistPage.savePlaylist();
    editPlaylistPage.validateOnEditPlaylistPage();
    // Validate values for playlist after edition.
    editPlaylistPage.validateValuesForManualPlaylist(type, content, title, description, category,
        shortDescription);
  }
}
