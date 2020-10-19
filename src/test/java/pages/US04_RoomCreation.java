package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US04_RoomCreation {

    public US04_RoomCreation(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

   @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

    @FindBy(id = "(//span[@class='title'])[1]")
    public WebElement systemManagement;

    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagementLink;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsLink;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRommButton;

    @FindBy(className ="//a[@href='#']" )
    public WebElement listOfHoptelrooms;

    @FindBy(id = "IDHotel")
    public WebElement IDHotel;

    @FindBy(id = "Code")
    public WebElement codeBox;

    @FindBy(id = "Name")
    public WebElement nameBox;

    @FindBy(id = "Location")
    public WebElement locationBox;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement descriptionArea;


    @FindBy(id = "IDGroupRoomType")
    public WebElement roomType;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;

    @FindBy(id = "IsAvailable")
    public WebElement approved;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;
    
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public  WebElement textMessage;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;

}
