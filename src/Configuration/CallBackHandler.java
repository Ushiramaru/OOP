package Configuration;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CallBackHandler extends DefaultHandler {

    private Configurator configurator;
    private boolean flag = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("paint")) {
            configurator.setPaintTitle(attributes.getValue("title"));
            configurator.setPaintColor(attributes.getValue("color"));
            try {
                configurator.setPaintWidth(Integer.valueOf(attributes.getValue("width")));
                configurator.setPaintHeight(Integer.valueOf(attributes.getValue("height")));
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        } else {
            if (qName.equals("panelShape")) {
                flag = true;
                configurator.setPanelShapeColor(attributes.getValue("color"));
                try {
                    configurator.setPanelShapeHeight(Integer.valueOf(attributes.getValue("height")));
                    configurator.setPanelShapeGapX(Integer.valueOf(attributes.getValue("gapX")));
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                if (qName.equals("panelUserShape")) {
                    flag = false;
                    configurator.setPanelUserShapeColor(attributes.getValue("color"));
                    try {
                        configurator.setPanelUserShapeWidth(Integer.valueOf(attributes.getValue("width")));
                        configurator.setPanelUserShapeGapY(Integer.valueOf(attributes.getValue("gapY")));
                    } catch (NumberFormatException | NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    if (qName.equals("button")) {
                        if (flag) {
                            configurator.setButtonShapeColor(attributes.getValue("color"));
                            try {
                                configurator.setButtonShapeHeight(Integer.valueOf(attributes.getValue("height")));
                                configurator.setButtonShapeWidth(Integer.valueOf(attributes.getValue("width")));
                            } catch (NumberFormatException | NullPointerException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            configurator.setButtonUserShapeColor(attributes.getValue("color"));
                            try {
                                configurator.setButtonUserShapeHeight(Integer.valueOf(attributes.getValue("height")));
                                configurator.setButtonUserShapeWidth(Integer.valueOf(attributes.getValue("width")));
                            } catch (NumberFormatException | NullPointerException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    public void setConfigurator(Configurator configurator) {
        this.configurator = configurator;
    }

}

