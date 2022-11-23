package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class Formula {
    private final WebDriver frame;

    public Formula(WebDriver frame) {
        this.frame = frame;
    }

    public void SelectTab(String tabName, String startElement) {
        List<WebElement> listTabs = frame.findElements(By.xpath("/html/body/form/div/div[1]/ul/li"));
        for (WebElement tab: listTabs) {
            // System.out.println(tab.getText());
            String tabText = tab.getText();
            if (tabText.contentEquals(tabName)) {
                tab.click();
            }
        }
        BaseFunctions.clickable(frame, startElement);
    }

    public void Save() {
        List<WebElement> listNextButtons = frame.findElements(By.name("NEXTNODE"));
        for (WebElement buttonNext: listNextButtons) {
            // System.out.println(buttonNext.getText());
            String buttonText = buttonNext.getText();
            if (buttonText.contentEquals("OK")) {
                buttonNext.click();
            }
        }
    }


    public void click(By by) {
        BaseFunctions.click(frame, by);
    }

    public void inputTextField(String name, String text) {
        BaseFunctions.type(frame, By.name(name), text);
    }

    public void inputTextFields(Map<String, String> fields) {
        for (Map.Entry<String,String> entry: fields.entrySet()) {
            inputTextField(entry.getKey(), entry.getValue());
        }
    }

    public void inputTextFieldTable(List<Map<String, String>> table, String addLineId) {
        int index = 1;
        for (Map<String,String> tableLine: table) {
            for (Map.Entry<String,String> entry: tableLine.entrySet()) {
                if (index > 1) {
                    click(By.xpath("//*[@addlineid='" + addLineId + "']"));
                }
                inputTextField(entry.getKey() + index, entry.getValue());
                index++;
            }
        }
    }
}
