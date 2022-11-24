package session;

import java.util.List;
import java.util.Map;

public class TabPage {
    private final Map<String,String> fields;
    private final List<Map<String, String>> table;
    private final String addLineButtonXpath;

    public TabPage(Map<String, String> fields, List<Map<String, String>> table, String addLineButtonXpath) {
        this.fields = fields;
        this.table = table;
        this.addLineButtonXpath = addLineButtonXpath;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public List<Map<String, String>> getTable() {
        return table;
    }

    public String getAddLineButtonXpath() {
        return addLineButtonXpath;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        StringBuilder outputBuilder = new StringBuilder(output + "fields:\n");
        for (Map.Entry<String,String> entry: fields.entrySet()) {
            outputBuilder.append("    Key Field: ").append(entry.getKey()).append(" ");
            outputBuilder.append("Value Field: ").append(entry.getValue()).append(" ");
            outputBuilder.append("\n");
        }
        output = new StringBuilder(outputBuilder.toString());
        output.append("table:\n");

        for (Map<String, String> tableLine: table) {
            for (Map.Entry<String,String> entry: tableLine.entrySet()) {
                output.append("    Key TableLine: ").append(entry.getKey()).append(" ");
                output.append("Value TableLine: ").append(entry.getValue()).append(" ");
                output.append("\n");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
