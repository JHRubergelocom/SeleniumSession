package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Formula {
    private final WebDriver frame;

    public Formula(WebDriver frame) {
        this.frame = frame;
    }

    public void selectTab(String tabName, String startElement, AssignmentStatus assignment) {
        if (!tabName.equals("")) {
            List<WebElement> listTabs = frame.findElements(By.xpath("/html/body/form/div/div[1]/ul/li"));
            for (WebElement tab: listTabs) {
                // System.out.println(tab.getText());
                String tabText = tab.getText();
                if (tabText.contentEquals(tabName)) {
                    tab.click();
                }
            }
        }
        selectAssignment(assignment);
        BaseFunctions.clickable(frame, startElement);
        System.out.println("ZZZZ BaseFunctions.clickable(frame, startElement) " + startElement + " ZZZZ");
    }

    public void save() {
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

    private void inputCheckBox(String name, Boolean value) {
        BaseFunctions.select(frame, By.name(name), value);
    }

    public void inputTextFields(Map<String, String> fields) {
        for (Map.Entry<String,String> entry: fields.entrySet()) {
            inputTextField(entry.getKey(), entry.getValue());
        }
    }

    private void inputCheckBoxes(Map<String, Boolean> checkboxes) {
        for (Map.Entry<String,Boolean> entry: checkboxes.entrySet()) {
            inputCheckBox(entry.getKey(), entry.getValue());
        }
    }



    public void inputTextFieldTable(List<Map<String, String>> table, String addLineButtonXpath) {
        int index = 1;
        for (Map<String,String> tableLine: table) {
            if (index > 1) {
                click(By.xpath(addLineButtonXpath));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (Map.Entry<String,String> entry: tableLine.entrySet()) {
                inputTextField(entry.getKey() + index, entry.getValue());
            }
            index++;
        }
    }

    private String getStartElement(TabPage tabPage) {
        String startElement = "";

        if(tabPage.getFields().size() > 0) {
            Optional<String> firstKey = tabPage.getFields().keySet().stream().findFirst();
            if (firstKey.isPresent()) {
                startElement = firstKey.get();
            }
        } else if(tabPage.getTable().size() > 0) {
            Optional<Map<String, String>> firstElement = tabPage.getTable().stream().findFirst();
            if (firstElement.isPresent()) {
                Optional<String> firstKey = firstElement.get().keySet().stream().findFirst();
                if (firstKey.isPresent()) {
                    startElement = firstKey.get();
                    startElement = startElement + "1";
                }
            }
        } else if(tabPage.getCheckboxes().size() > 0) {
            Optional<String> firstKey = tabPage.getCheckboxes().keySet().stream().findFirst();
            if (firstKey.isPresent()) {
                startElement = firstKey.get();
            }
        }
        return startElement;
    }

    private void selectAssignment(AssignmentStatus assignment) {
        switch (assignment) {
            case MEETING -> {
                BaseFunctions.click(frame, By.xpath("//*[@id=\"part_550_toggle_assignment\"]/tr[4]/td[2]/div/input[2]"));
            }
        }
        System.out.println("selectassigment assignment" + assignment);
    }


    public void inputData(Map<String, TabPage> tabpages) {
        for (Map.Entry<String,TabPage> entry: tabpages.entrySet()) {
            // System.out.println("Key Tabpage: " + entry.getKey());
            // System.out.println("Value Tabpage: " + entry.getValue());

            String tabName = entry.getKey();
            TabPage tabPage = entry.getValue();

            String startElement = getStartElement(tabPage);
            selectTab(tabName, startElement, tabPage.getAssignment());
            inputTextFields(tabPage.getFields());
            inputTextFieldTable(tabPage.getTable(), tabPage.getAddLineButtonXpath());
            inputCheckBoxes(tabPage.getCheckboxes());

        }
    }

}
